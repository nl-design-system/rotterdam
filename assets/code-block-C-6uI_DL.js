import{j as n}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as r}from"./index-BVXH1tlS.js";import{ap as i,aq as c}from"./index-B3gJ7mz_.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-T44GE3nj.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const d=`<!-- @license CC0-1.0 -->

# Code-block component voor Apache Wicket

Toont één of meerdere regels computercode en behoudt de opmaak van deze code.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/code_block/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/code_block/)

## Code Block

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtCodeBlock"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtCodeBlock("utrechtCodeBlock", Model.of("""
        <!DOCTYPE html>
        <html lang="nl" dir="ltr">
          <head>
            <title>NL Design System</title>
            <meta charset="utf-8"/>
          </head>
          <body>
            <h1>NL Design System</h1>
          </body>
        </html>
        """)));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(i,{title:"Apache Wicket/Code Block"}),`
`,n.jsx(c,{children:d})]})}function v(e={}){const{wrapper:t}={...r(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{v as default};
