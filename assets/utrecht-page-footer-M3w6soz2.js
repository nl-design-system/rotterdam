import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as a,aq as i}from"./index-DkF4sKev.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-CVbUGdOT.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const c=`<!-- @license CC0-1.0 -->

# Page Footer component voor Apache Wicket

Informatie en links onder de pagina.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/page_footer/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/page_footer/)

## Page Footer

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtPageFooter"></div>
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
        return new UtrechtPageFooterBorder("utrechtPageFooter");
    }

}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(a,{title:"Apache Wicket/Page Footer"}),`
`,n.jsx(i,{children:c})]})}function v(e={}){const{wrapper:t}={...r(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{v as default};
