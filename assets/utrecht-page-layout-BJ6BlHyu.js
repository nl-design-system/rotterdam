import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as a}from"./index-DbGdhrAm.js";import{ap as r,aq as i}from"./index-CKhHj84B.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-zyKUXn25.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const c=`<!-- @license CC0-1.0 -->

# Page Layout component voor Apache Wicket

Layout van de paginainhoud, en de informatie en links boven en onder de pagina.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/page_layout/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/page_layout/)

## Page Layout

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtPageLayout"></div>
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
        return new UtrechtPageLayoutBorder("utrechtPageLayout");
    }

}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(r,{title:"Apache Wicket/Page Layout"}),`
`,n.jsx(i,{children:c})]})}function k(e={}){const{wrapper:t}={...a(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{k as default};
