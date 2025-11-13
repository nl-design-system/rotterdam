# How to release the Java packages

1. Start a new branch to initialize the release from.
2. Update pom.xml version:
   `mvn versions:set -DnewVersion=0.0.2-alpha -DgenerateBackupPoms=false`
3. Commit and pushy version bump.
4. Open PR, get it merged to main.
5. From latest main, create tag java-0.0.1-alpha.
6. Push tag → GitHub Actions publishes to Maven Central.
