<!-- @license CC-0.0 -->

# NL Design System componenten voor Apache Wicket

Deze componenten worden in opdracht van gemeente Rotterdam ontwikkeld door
[Frameless](https://frameless.io) en [Squins](https://www.squins.com).

## Aan de slag als developer

### JDK en Maven zelf installeren

Installeer Java 21 en Maven 3.x

```shell
mvn install
mvn exec:java -pl :docs-wicket
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

## Learning more about Apache Wicket

- [Wicket 10.x Reference Guide](https://nightlies.apache.org/wicket/guide/10.x/single.html)
