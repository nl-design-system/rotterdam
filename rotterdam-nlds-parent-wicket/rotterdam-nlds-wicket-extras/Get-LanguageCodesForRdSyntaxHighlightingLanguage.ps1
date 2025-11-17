(
Get-ChildItem -Path node_modules\prismjs\components *.min.js |
        Where-Object { $_.Name -ne 'prism-core.min.js' } |
        ForEach-Object {
            $_.Name.
                    Substring(6).
                    Replace('.min.js', '').
                    Replace('-', '_').
                    ToUpperInvariant()
        } |
        Sort-Object
) -join ",`n"
