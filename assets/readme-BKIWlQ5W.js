import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as s}from"./index-DbGdhrAm.js";import{ap as a,aq as i}from"./index-DkF4sKev.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-CVbUGdOT.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const r=`<!-- @license CC0-1.0 -->

# Rotterdam Design System

**This project is very much WORK IN PROGRESS and all components are released as _alpha_ version. Always define the exact version you want to use, and test for breaking changes before upgrading to a newer alpha release.**

This project is part of a community indicative to use NL Design System components for projects that need to adhere to the Rotterdam Design System. Teams from the central Municipality of Rotterdam, as well as those who are contracted by them to develop websites and apps, are able to collaborate via this project.

Applying design elements from this project is strictly prohibited for organisations that are not part of the Municipality of Rotterdam. These excluded elements can be found in the \`/proprietary\` directory.

## How to use Rotterdam Design System

Rotterdam is using components from the NL Design System community, candidate and hall-of-fame. This means multiple npm packages might need to be installed to have access to all components in your application. Read the [developer getting started documentation](https://nldesignsystem.nl/handboek/developer/aan-de-slag/) on the NL Design System website to learn more.

The [Rotterdam Storybook](https://nl-design-system.github.io/rotterdam/) gives guidance on which components to use and which packages to include.

### In HTML

This example is using the [unpkg.com CDN](https://unpkg.com/) for prototyping. This is a bit slower as the latest version is automatically chosen. For production, you shouldn't use this CDN.

Include the Design Token CSS variables:

\`\`\`html
<link rel="stylesheet" type="text/css" href="https://unpkg.com/@gemeente-rotterdam/design-tokens/dist/index.css" />
\`\`\`

Combine it with the CSS packages from the NL Design System community:

\`\`\`html
<!-- Utrecht CSS as Rotterdam is using them -->
<link rel="stylesheet" type="text/css" href="https://unpkg.com/browse/@utrecht/component-library-css/dist/index.css" />

<!-- Den Haag CSS components if Rotterdam is using them -->
<link
  rel="stylesheet"
  type="text/css"
  href="https://unpkg.com/browse/@gemeente-denhaag/components-css/dist/index.css"
/>

<!-- and Rotterdam CSS if extra components are needed -->
\`\`\`

And use the [code snippet provided in Storybook](?path=/docs/css-utrecht-button--docs) to get the identical component in code:

\`\`\`html
<!-- Set the rods-theme to include Rotterdam styling for all NL Design System components -->
<body class="rods-theme">
  <!-- Include component from Utrecht, Den Haag, Rotterdam or other community library -->
  <button class="utrecht-button" type="button">Label</button>
</body>
\`\`\`

Here's a complete example:

\`\`\`html
<!doctype html>
<html class="rods-theme">
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://unpkg.com/@utrecht/component-library-css/dist/index.css" />
    <link rel="stylesheet" href="https://unpkg.com/@gemeente-rotterdam/design-tokens/dist/index.css" />
  </head>
  <body class="utrecht-document">
    <h1 class="utrecht-heading-1">Hello world</h1>
  </body>
</html>
\`\`\`

## Contributing

### Getting started

#### 1. Ensure \`pnpm\`\` is installed

To check if \`pnpm\` is installed use

\`\`\`zsh
pnpm -v
\`\`\`

This repository uses \`pnpm\` to install packages and to manage the workflows in this monorepo. Installation of this tool is a prerequisite for developing in the packages. Follow the most recent guide on [https://pnpm.io/installation](https://pnpm.io/installation).

#### 2. Install dependencies

In the workspace root the installation script will ensure all dependencies for \`packages\` and \`proprietary\`-packages are installed

\`\`\`zsh
pnpm install
\`\`\`

#### 3. Build all packages

Before getting started we recommend building all packages. This ensures are design tokens are available and components are available to include in storybook.

\`\`\`zsh
pnpm run build
\`\`\`

#### 4. Start storybook

To start the storybook locally run the storybook script in the workspace root. This will also start a watcher for the design tokens package in \`proprietary/design-tokens\`.

If somehow this doesn't work you can always try starting the storybook from \`packages/storybook\`, but any changes to components or design-tokens will need a manual build before they show up in Storybook.

\`\`\`zsh
pnpm run storybook
\`\`\`

### Available scripts

| script                  | description                                                                                                                                                                                                        |
| ----------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| \`pnpm run storybook\`    | Start HTML/CSS Components Storybook [localhost:6006](http://localhost:6006/)                                                                                                                                       |
| \`pnpm run lint-fix\`     | Check code formatting and automatically fix some types of issues                                                                                                                                                   |
| \`pnpm run lint\`         | Check code formatting etcetera without automatic fixes                                                                                                                                                             |
| \`pnpm run update-patch\` | Install patch updates for all packages in the repository. Packages might be excluded from this command when they are added to \`.ncurc.patch.js\`                                                                    |
| \`pnpm run update-minor\` | Install minor updates for all packages in the repository. Packages might be excluded from this command when they are added to \`.ncurc.minor.js\`                                                                    |
| \`pnpm run update-major\` | Install major updates for all packages in the repository. Packages might be excluded from this command when they are added to \`.ncurc.major.js\`                                                                    |
| \`pnpm run test-update\`  | Run after one of the \`update-*\` scripts to do a smoke-test and see if everything seems to work after updating. We recommend running scripts like \`pnpm run storybook\` manually too after the smoke-test is passed. |

### Packages

The Rotterdam Design System has multiple packages:

#### Storybook

To document all components available in the Rotterdam Design System. These can be from the NL Design System ecosystem or from the \`components-*\` in this repository.

##### Debugging Storybook

First check the logs in the terminal if any error is displayed, if something doesn't work as expected.

Secondly check the JavaScript logs in your browsers developer tools if there are errors or warnings.

You can run the code checks with \`pnpm run lint\` to see if any code errors can be detected.

You can also check the build logs of the design tokens for errors, if you have changed Style Dictionary JSON files, by building those separately:

1. \`cd proprietary/design-tokens/\`
2. \`pnpm run build\`

#### Components-css

For all components Rotterdam needs custom code for as they do not yet exist in the NL Design System ecosystem. These CSS components are the basis for framework specific components.

#### Components-react

For all components Rotterdam needs a React component for Rotterdam Design System. When a React component does not already exist in the NL Design System ecosystem a component can be build using an existing CSS component from the community or \`components-css\`.

#### Web-components-stencil

To generate web-components for all components Rotterdam would like to use a webcomponent and when an accessible webcomponent is possible. Use when a webcomponent does not already exist in the NL Design System ecosystem a component can be build using an existing CSS component from the community or \`components-css\`.

Icons can also be found in this package as they are made available as a webcomponent using a build step.

#### Web-components-react

For all components a React component rendering a webcomponent is convenient for Rotterdam Design System. Use when a React-webcomponent does not already exist in the NL Design System ecosystem a wrapper can be built around an existing CSS component from the community or \`web-components-stencil\`.

### Proprietary packages

The open source license does NOT apply to files in this directory. These are proprietary assets to Rotterdam and can only be used by people who have permission to do so.

#### Design-tokens

Design tokens are used to separate design or brand choices from the components, this ensures reuse is possible between all different organisations contributing to the NL Design System ecosystem.

Read more about design-tokens for NL Design System on the website [https://nldesignsystem.nl/meedoen/design-tokens/](https://nldesignsystem.nl/meedoen/design-tokens/)

Design tokens are made available in different formats, like CSS, JavaScript and more.

Build design tokens and these files can be found in \`proprietary/design-tokens/dist\`

\`\`\`zsh
cd proprietary/design-tokens;
pnpm run build;
\`\`\`

#### Font

Rotterdam uses a custom font. This font is not available by default on devices of our users. To ensure the brand of Rotterdam is represented well the font-files are added to the repository for use in the applications and websites of Rotterdam.

\`\`\`zsh
pnpm install @gemeente-rotterdam/font;
\`\`\`

#### Assets

Logo and favicon files are made available for all applications and websites of Rotterdam via this convenient package.

\`\`\`zsh
pnpm install @gemeente-rotterdam/assets
\`\`\`

## Code of Conduct

We pledge to act and interact in ways that contribute to an open, welcoming, diverse, inclusive, and healthy community. Read [our Code of Conduct](CODE_OF_CONDUCT.md) if you haven't already.

## License

This project is free and open-source software licensed under the [European Union Public License (EUPL) v1.2](LICENSE.md). The documentation is licensed as [Creative Commons Zero 1.0 Universal (\`CC0-1.0\`)](https://creativecommons.org/publicdomain/zero/1.0/legalcode).

For information about proprietary assets in this repository, please carefully read the [NOTICE file](NOTICE.md).

## Special thanks

[Chromatic](https://www.chromatic.com) supports us with a free starter plan for open source.
`;function o(n){return e.jsxs(e.Fragment,{children:[e.jsx(a,{title:"Rotterdam/Rotterdam Design System"}),`
`,e.jsx(i,{children:r.replaceAll("(CODE_OF_CONDUCT.md)","(?path=/docs/rotterdam-code-of-conduct--docs)").replaceAll("(LICENSE.md)","(?path=/docs/rotterdam-open-source-license--docs)").replaceAll("(NOTICE.md)","(?path=/docs/rotterdam-toestemming-gebruik-huisstijl--docs)")})]})}function f(n={}){const{wrapper:t}={...s(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(o,{...n})}):o()}export{f as default};
