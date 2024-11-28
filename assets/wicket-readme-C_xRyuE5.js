import{j as e}from"./jsx-runtime-BlAj40OV.js";import{useMDXComponents as r}from"./index-BI1Biiay.js";import{aj as a,ak as i}from"./index-BhjGnros.js";import"./index-Cs7sjTYM.js";import"./_commonjsHelpers-BosuxZz1.js";import"./iframe-CMlNZcm0.js";import"../sb-preview/runtime.js";import"./index-BU4L-DQy.js";import"./extends-CF3RwP-h.js";import"./index-DSgSp0X8.js";const s=`<!-- @license CC-0.0 -->

# NL Design System componenten voor Apache Wicket

Deze componenten worden in opdracht van gemeente Rotterdam ontwikkeld door
[Frameless](https://frameless.io) en [Squins](https://www.squins.com).

## Aan de slag als developer

### JDK en Maven zelf installeren

Installeer Java 21 en Maven 3.x

### Documentatie starten

\`\`\`shell
mvn install
mvn exec:java -pl :docs-wicket
\`\`\`

### Storybook documentatie genereren

\`\`\`shell
mvn install
mvn exec:java@generateStoryBook -pl :docs-wicket
\`\`\`

### Maven uitvoeren met pnpm

We hebben de volgende scripts beschikbaar:

- \`pnpm run -w wicket:install\`: installeer alle Maven dependencies
- \`pnpm run -w wicket:build\`: build alle Maven projecten
- \`pnpm run -w wicket:dev\`: start de development server op [localhost:8945](http://localhost:8945).

### Maven uitvoeren in Docker

Je hoeft niet precies de goeie versie van Java en Maven te installeren op je
computer, je kunt ook [Docker installeren](https://docs.docker.com/engine/install/) en gebruiken.

Start de server met:

\`\`\`shell
docker compose up --build --remove-orphans
\`\`\`

Open de server op [localhost:8080](http://localhost:8080/).

## Learning more about Apache Wicket

- [Wicket 10.x Reference Guide](https://nightlies.apache.org/wicket/guide/10.x/single.html)

## Componenten maken

Een beknopte stappenlijst voor het maken van een nieuw component.

- Leer eerst hoe het NL Design System werkt. Dat kost even tijd.
- Zorg dat je voorbeeld HTML, CSS hebt van het component.
- Maak het bijbehorende component in [components-wicket](components-wicket)
- Maak een voorbeeld panel in [docs-wicket](docs-wicket). Kijk bij
  \`HeadingExamplesPanel\` voor een voorbeeld.
- Voeg de storybook en markdown codegenerator toe aan
  \`GenerateMarkdownAndStorybookExamples\`
`;function o(n){return e.jsxs(e.Fragment,{children:[e.jsx(a,{title:"Apache Wicket/Readme"}),`
`,e.jsx(i,{children:s})]})}function b(n={}){const{wrapper:t}={...r(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(o,{...n})}):o()}export{b as default};
