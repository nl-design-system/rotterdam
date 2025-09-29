import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as c,aq as i}from"./index-Cl-lmMzQ.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-c3Dmc2oz.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const a=`<!-- @license CC0-1.0 -->

# Code Block component voor Apache Wicket

Toont één of meerdere regels computercode en behoudt de opmaak van deze code.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/code_block/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/code_block/)

## Code Block

Voorbeeld.


\`\`\`html
<pre wicket:id="utrechtCodeBlock"></pre>
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
        return new UtrechtCodeBlock("utrechtCodeBlock", Model.of("""
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
            """));
    }

}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(c,{title:"Apache Wicket/Code Block"}),`
`,n.jsx(i,{children:a})]})}function C(e={}){const{wrapper:t}={...r(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{C as default};
