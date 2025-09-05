import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as i,aq as c}from"./index-DJVPeOFm.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-DzTX15XU.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const d=`<!-- @license CC0-1.0 -->

# Form Field Checkbox component voor Apache Wicket

Formulierveld om te kiezen tussen "wel" of "niet".


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_checkbox/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/form_field_checkbox/)

## Form Field Checkbox

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtFormFieldCheckbox"></div>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new UtrechtFormFieldCheckbox("utrechtFormFieldCheckbox", Model.of(false), Model.of("I agree"), Model.of("Description"), Model.of("error")));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function t(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(i,{title:"Apache Wicket/Form Field Checkbox"}),`
`,e.jsx(c,{children:d})]})}function u(n={}){const{wrapper:o}={...r(),...n.components};return o?e.jsx(o,{...n,children:e.jsx(t,{...n})}):t()}export{u as default};
