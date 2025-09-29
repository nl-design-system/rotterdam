import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as i}from"./index-DbGdhrAm.js";import{ap as r,aq as a}from"./index-Cl-lmMzQ.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-c3Dmc2oz.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const d=`<!-- @license CC0-1.0 -->

# Heading Group component voor Apache Wicket

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
        add(createComponent());
    }
    
    private Component createComponent() {
        return new UtrechtHeadingGroupBorder("utrechtHeadingGroup");
    }

}
\`\`\`
`;/*@license CC0-1.0*/function o(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(r,{title:"Apache Wicket/Heading Group"}),`
`,n.jsx(a,{children:d})]})}function b(e={}){const{wrapper:t}={...i(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(o,{...e})}):o()}export{b as default};
