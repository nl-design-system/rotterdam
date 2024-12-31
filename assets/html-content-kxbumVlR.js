import{j as n}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as i}from"./index-BVXH1tlS.js";import{ap as r,aq as m}from"./index-B3gJ7mz_.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-T44GE3nj.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const a=`<!-- @license CC0-1.0 -->

# Html-content component voor Apache Wicket

Toont HTML-inhoud met de opmaak van het design system.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/html_content/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/html_content/)

## HTML Content

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtHtmlContent">
 <h1>Hello world</h1>
 <p>
  <button type="submit">Submit</button></p>
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
        add(new UtrechtHtmlContentBorder("utrechtHtmlContent"));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function o(t){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(r,{title:"Apache Wicket/HTML Content"}),`
`,n.jsx(m,{children:a})]})}function v(t={}){const{wrapper:e}={...i(),...t.components};return e?n.jsx(e,{...t,children:n.jsx(o,{...t})}):o()}export{v as default};
