import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as o}from"./index-DbGdhrAm.js";import{ap as a,aq as i}from"./index-CKhHj84B.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-zyKUXn25.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const s=`<!-- @license CC0-1.0 -->

# Preserve Data component voor Apache Wicket

Toont data zoals de is ingevoerd.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/preserve_data/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/preserve_data/)

## Preserve Data

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtPreserveData"></div>
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
        return new UtrechtPreserveDataLabel("utrechtPreserveData", Model.of("Mees de Vos"));
    }

}
\`\`\`
`;/*@license CC0-1.0*/function r(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(a,{title:"Apache Wicket/Preserve Data"}),`
`,e.jsx(i,{children:s})]})}function b(n={}){const{wrapper:t}={...o(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(r,{...n})}):r()}export{b as default};
