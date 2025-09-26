import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as i,aq as a}from"./index-BWtC5L88.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-1qIRjLkf.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const c=`<!-- @license CC0-1.0 -->

# Root component voor Apache Wicket

Eerste component van de pagina, op het niveau van het \`html\`-element.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/root/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/root/)

## Root

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtRoot"></div>
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
        return new UtrechtRootBorder("utrechtRoot");
    }

}
\`\`\`
`;/*@license CC0-1.0*/function o(t){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(i,{title:"Apache Wicket/Root"}),`
`,n.jsx(a,{children:c})]})}function k(t={}){const{wrapper:e}={...r(),...t.components};return e?n.jsx(e,{...t,children:n.jsx(o,{...t})}):o()}export{k as default};
