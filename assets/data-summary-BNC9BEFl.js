import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as m}from"./index-DbGdhrAm.js";import{ap as r,aq as o}from"./index-CVjLHMhw.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-XrOEV80q.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const i=`<!-- @license CC0-1.0 -->

# Data Summary component voor Apache Wicket

Geeft een lijst van items met hun label en hun waarde.

Het Wicket component verbergt zichzelf als de lijst leeg is.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/data_summary/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/data_summary/)

## Basis voorbeeld

lijstje met burgerservicenummer, voornaam en achternaam.


\`\`\`html
<dl wicket:id="basic">key - value items</dl>
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
    
    public RdDataSummary createComponent() {
        return new RdDataSummary("basic", new ListModel<>(List.of(new SummaryItem("BSN", new SummaryItemValue("111111110", false)), new SummaryItem("Voornaam", new SummaryItemValue("Corné", false)), new SummaryItem("Achternaam", new SummaryItemValue("de Vos", false)))));
    }

}
\`\`\`
`;/*@license CC0-1.0*/function a(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(r,{title:"Apache Wicket/Data Summary"}),`
`,e.jsx(o,{children:i})]})}function h(n={}){const{wrapper:t}={...m(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(a,{...n})}):a()}export{h as default};
