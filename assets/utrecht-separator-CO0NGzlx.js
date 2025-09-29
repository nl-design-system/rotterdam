import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as o}from"./index-DbGdhrAm.js";import{ap as a,aq as i}from"./index-Cl-lmMzQ.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-c3Dmc2oz.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const c=`<!-- @license CC0-1.0 -->

# Separator component voor Apache Wicket

Markering van de plek waar de tekst op een nieuwe manier verdergaat, zoals een nieuwe scène of een ander onderwerp.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/separator/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/separator/)

## Separator

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtSeparator"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(createComponent());
    }
    
    private Component createComponent() {
        return new UtrechtSeparator("utrechtSeparator");
    }

}
\`\`\`
`;/*@license CC0-1.0*/function r(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(a,{title:"Apache Wicket/Separator"}),`
`,n.jsx(i,{children:c})]})}function h(e={}){const{wrapper:t}={...o(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(r,{...e})}):r()}export{h as default};
