import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as a}from"./index-DbGdhrAm.js";import{ap as r,aq as i}from"./index-DJVPeOFm.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-DzTX15XU.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const m=`<!-- @license CC0-1.0 -->

# Rotterdam Logo Image component voor Apache Wicket

Logo van gemeente Rotterdam als SVG-afbeelding.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/logo_image/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/logo_image/)

## Logo Image

Voorbeeld.


\`\`\`html
<div wicket:id="rotterdamLogoImage"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new RotterdamLogoImage("rotterdamLogoImage"));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function t(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(r,{title:"Apache Wicket/Rotterdam Logo Image"}),`
`,n.jsx(i,{children:m})]})}function b(e={}){const{wrapper:o}={...a(),...e.components};return o?n.jsx(o,{...e,children:n.jsx(t,{...e})}):t()}export{b as default};
