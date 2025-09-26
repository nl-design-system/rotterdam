import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as i}from"./index-DbGdhrAm.js";import{ap as o,aq as r}from"./index-CI_nkyZx.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-9fEvi_N8.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const d=`<!-- @license CC0-1.0 -->

# Badge List component voor Apache Wicket

Lijst van labels met extra informatie, zoals een categorie of een eigenschap.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/badge_list/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/badge_list/)

## Badge List



\`\`\`html
<div class="utrecht-badge-list">
 <data class="utrecht-data-badge">duurzaamheid</data><data class="utrecht-data-badge">schoon, heel en veilig</data>
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
        List<String> namen = List.of("duurzaamheid", "schoon, heel en veilig");
        return new WebMarkupContainer("utrechtBadgeListWebMarkupContainer") {
    
            @Override
            protected void onInitialize() {
                super.onInitialize();
                // TODO should be singleton
                add(new UtrechtBadgeListBehavior());
                add(new ListView<>("listItem", namen) {
    
                    @Override
                    protected void populateItem(ListItem<String> item) {
                        // TODO: should be singleton
                        item.add(new UtrechtDataBadgeBehavior());
                        String naam = item.getModelObject();
                        // item.add(naam);
                        item.add(new Label("label", naam));
                    }
                });
            }
        };
    }

}
\`\`\`
`;/*@license CC0-1.0*/function a(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(o,{title:"Apache Wicket/Badge List"}),`
`,n.jsx(r,{children:d})]})}function v(e={}){const{wrapper:t}={...i(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(a,{...e})}):a()}export{v as default};
