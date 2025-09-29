import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as i,aq as m}from"./index-Cl-lmMzQ.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-c3Dmc2oz.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const a=`<!-- @license CC0-1.0 -->

# HTML Content component voor Apache Wicket

Toont HTML-inhoud met de opmaak van het design system.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/html_content/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/html_content/)

## HTML Content

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtHtmlContent">
 <h1>Hello world</h1>
 <p>
  <button type="submit">Submit</button>
 </p>
</div>
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
        return new UtrechtHtmlContentBorder("utrechtHtmlContent");
    }

}
\`\`\`
`;/*@license CC0-1.0*/function o(t){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(i,{title:"Apache Wicket/HTML Content"}),`
`,n.jsx(m,{children:a})]})}function v(t={}){const{wrapper:e}={...r(),...t.components};return e?n.jsx(e,{...t,children:n.jsx(o,{...t})}):o()}export{v as default};
