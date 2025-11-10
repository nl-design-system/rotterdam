# How to release the Java packages

1. Update pom.xml version:
   `mvn versions:set -DnewVersion=0.0.1-alpha && mvn versions:commit`
2. Commit version bump + changelog.
3. Open PR, get it merged to main.
4. From latest main, create tag java-0.0.1-alpha.
5. Push tag → GitHub Actions publishes to Maven Central.
