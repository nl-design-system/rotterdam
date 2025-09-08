# Changeset sjabloon

Kopieer en plak het onderstaande sjabloon. Je kunt hiervoor de kopieer knop linksboven in het template gebruiken.

```markdown
---
"@gemeente-rotterdam/<package-name>": major
---

Beschrijving
```

Vul tussen de twee sets `---` in voor welke packages je allemaal veranderingen hebt doorgevoerd. Zet elk package tussen
dubbele aanhalingstekens op een nieuwe regel.

Gebruik:

- `"@gemeente-rotterdam/<package-name>": major` voor breaking changes
- `"@gemeente-rotterdam/<package-name>": minor` voor nieuwe features
- `"@gemeente-rotterdam/<package-name>": patch` voor bug fixes

Beschrijf na de tweede set `---` welke veranderingen je hebt doorgevoerd.

Geef bij breaking changes aan **wat** er veranderd is, **waarom** de verandering nodig was en **hoe** gebruikers van het
package hun code moeten aanpassen.
