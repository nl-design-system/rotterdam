# Halt the script at the first error.
$ErrorActionPreference = 'Stop'

# Make sure the build results in `target\classes` are up-to-date.
.\mvnw clean compile

$NodeModulesFullName = Join-Path ( Get-Location ) node_modules\
$PackagesFullName = Join-Path ( Get-Location ) packages\
# Find all `pom.xml` files. Ignore errors as those files are very unlikely to contain a POM (that needs processing).
Get-ChildItem pom.xml -Recurse -File -ErrorAction SilentlyContinue |
    # Remove `pom.xml` files in front-end modules.
    Where-Object {
        -not $_.FullName.StartsWith( $NodeModulesFullName ) -and -not $_.FullName.StartsWith( $PackagesFullName )
    } |
    # Pass the directory of the module and the `target\classes` directory of the `pom.xml` file down the pipeline.
    ForEach-Object {
        @{
            'ClassesPath' = ( Join-Path $_.Directory target\classes\ );
            'MainJavaSourcesPath' = ( Join-Path $_.Directory src\main\java\ )
        }
    } |
    # Only process modules that have a `target\classes` directory.
    Where-Object {
        Test-Path $_.ClassesPath
    } |
    # Determine the `opens` statements to use for each module.
    ForEach-Object {
        Push-Location $_.ClassesPath
        try {
            $PackagesToOpenForModule = @(
                # Get all Wicket and front-end resources. Add additional extensions for other types of resources when needed (for example for images and fonts).
                #
                # There are many with a path that is too long, and the errors for these are ignored. This may result in missing a package that has to be opened.
                Get-ChildItem *.html, *.css, *.js -File -Recurse -ErrorAction SilentlyContinue |
                    # Relative path to `target\classes` so it will be the package name with backslashes.
                    Resolve-Path -Relative |
                    # Remove the `.\` at the front.
                    ForEach-Object { $_.Substring( 2 ) } |
                    # Remove the filename.
                    Split-Path -Parent |
                    # Packages are only needed once instead of for each file.
                    Sort-Object -Unique |
                    # Ignore directories that are not packages (as they are not encapsulated by default, and cant be declared in `module-info.java`).
                    Where-Object { $_ -match '^[a-z][a-z0-9_]+(\\[a-z][a-z0-9_]+)+$' } |
                    # Convert it into an `opens` statement.
                    ForEach-Object { "opens $( $_.Replace('\', '.') );" }
                 ) -join "`n"

            # Write a file containing the `opens` statements that `module-info.java` should contain.
            if ( $PackagesToOpenForModule.Trim() -ne '' ) {
                Set-Content ( Join-Path $_.MainJavaSourcesPath opens-list.txt ) $PackagesToOpenForModule
            }
        } finally {
            Pop-Location
        }
    }
