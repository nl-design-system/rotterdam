<!-- @license CC-0.0 -->

# NL Design System componenten voor Apache Wicket

Deze componenten worden in opdracht van gemeente Rotterdam ontwikkeld door
[Frameless](https://frameless.io) en [Squins](https://www.squins.com).

## Aan de slag als developer

### JDK en Maven zelf installeren

Installeer Java 21 en Maven 3.x

### Documentatie starten

```shell
../mvnw install  && ../mvnw exec:java@runDocs -pl :docs-wicket
```

### Storybook documentatie genereren

```shell
../mvnw install && ../mvnw exec:java@generateStoryBook -pl :docs-wicket
```

### Maven uitvoeren met pnpm

We hebben de volgende scripts beschikbaar:

- `pnpm run -w wicket:install`: installeer alle Maven dependencies
- `pnpm run -w wicket:build`: build alle Maven projecten
- `pnpm run -w wicket:dev`: start de development server op [localhost:8945](http://localhost:8945).

### Maven uitvoeren in Docker

Je hoeft niet precies de goeie versie van Java en Maven te installeren op je
computer, je kunt ook [Docker installeren](https://docs.docker.com/engine/install/) en gebruiken.

Start de server met:

```shell
docker compose up --build --remove-orphans
```

Open de server op [localhost:8080](http://localhost:8080/).

## Meer leren over Wicket

- [Wicket 10.x Reference Guide](https://nightlies.apache.org/wicket/guide/10.x/single.html)

## Componenten maken

Een beknopte stappenlijst voor het maken van een nieuw component.

- Leer eerst hoe het NL Design System werkt. Dat kost even tijd.
- Zorg dat je voorbeeld HTML, CSS hebt van het component.
- Maak het bijbehorende component in [rotterdam-nlds-wicket](rotterdam-nlds-wicket)
- Maak een voorbeeld panel in [docs-wicket](docs-wicket). Kijk bij
  `HeadingExamplesPanel` voor een voorbeeld.
- Voeg de storybook en markdown codegenerator toe aan
  `GenerateMarkdownAndStorybookExamples`

### Regels

- Geef geen componenten door aan andere Wicket componenten (via constructors).
- Voor methodes die componenten maken: prefix met new. Net als Wicket, zie bijvoorbeeld AjaxPagingNavigation

## PNPM Workspace dependencies resolven

NL Design System gebruikt pnpm voor nodejs projecten. Pnpm ondersteunt meerdere npm projecten binnen een repository.

De Maven build bouwt ook de benodigde pnpm modules, zodat je in Maven de binaries krijgt van NPM sources in
de repository.

Voer de Maven build vanuit de root van het project uit om de laatste wijzigingen van pnpm modules te verkrijgen:

```shell
cd nl-design-system-rotterdam
./mvnw install
```
