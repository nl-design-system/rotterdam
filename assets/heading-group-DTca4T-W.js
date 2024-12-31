import{j as n}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as i}from"./index-BVXH1tlS.js";import{ap as r,aq as a}from"./index-B3gJ7mz_.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-T44GE3nj.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const d=`<!-- @license CC0-1.0 -->

# Heading-group component voor Apache Wicket

Toont een combinatie van een titel en ondersteunende tekst.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/heading_group/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/heading_group/)

## Heading Group

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtHeadingGroup">
 <h2>Heading in a heading group</h2>
 <p>Sub-heading</p>
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
        add(new UtrechtHeadingGroupBorder("utrechtHeadingGroup"));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(r,{title:"Apache Wicket/Heading Group"}),`
`,n.jsx(a,{children:d})]})}function k(e={}){const{wrapper:t}={...i(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{k as default};
