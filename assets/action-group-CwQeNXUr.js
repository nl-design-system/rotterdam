import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as i,aq as a}from"./index-CVjLHMhw.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-XrOEV80q.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const c=`<!-- @license CC0-1.0 -->

# Action Group component voor Apache Wicket

Groepeert één of meer gerelateerde acties en verzorgt de lay-out van de content.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/action_group/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/action_group/)

## Button Group

Voorbeeld Action Group met één button.


\`\`\`html
<div wicket:id="actionGroup">
 <button wicket:id="button">voorbeeld knop</button>
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
        return new RdActionGroup("actionGroup").add(new RdButton("button") {
    
            @Override
            public void onSubmit() {
                super.onSubmit();
                System.out.println("ActionGroupExamplesPanel.onSubmit called");
            }
        });
    }

}
\`\`\`
`;/*@license CC0-1.0*/function o(t){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(i,{title:"Apache Wicket/Action Group"}),`
`,n.jsx(a,{children:c})]})}function w(t={}){const{wrapper:e}={...r(),...t.components};return e?n.jsx(e,{...t,children:n.jsx(o,{...t})}):o()}export{w as default};
