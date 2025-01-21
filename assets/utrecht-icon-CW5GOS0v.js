import{j as n}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as i}from"./index-BVXH1tlS.js";import{ap as r,aq as c}from"./index-Fo0fc18B.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-CY0NdQld.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const a=`<!-- @license CC0-1.0 -->

# Icon component voor Apache Wicket

Toont een SVG icoon.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/icon/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/icon/)

## Icon

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtIcon">
 <svg viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg" fill="currentColor" height="1em" width="1em">
  <path fill-rule="evenodd" d="M16 3.75 29.4 13.8l-1.2 1.6-2.2-1.65V27H6V13.75L3.8 15.4l-1.2-1.6zM14 25h4v-8h-4zm6 0V15h-8v10H8V12.25l8-6 8 6V25z" clip-rule="evenodd"></path>
 </svg>
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
        add(new UtrechtIconBorder("utrechtIcon"));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(r,{title:"Apache Wicket/Icon"}),`
`,n.jsx(c,{children:a})]})}function x(e={}){const{wrapper:t}={...i(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{x as default};
