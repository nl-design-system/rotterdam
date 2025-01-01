import{j as n}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as i}from"./index-BVXH1tlS.js";import{ap as o,aq as r}from"./index-zTh-TmpC.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-BVtoE53k.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const d=`<!-- @license CC0-1.0 -->

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
        add(List<String> namen = List.of("duurzaamheid", "schoon, heel en veilig");
     new WebMarkupContainer("utrechtBadgeListWebMarkupContainer") {

        @Override
        protected void onInitialize() {
            super.onInitialize();
            // TODO should be singleton
            add(new UtrechtBadgeListBehavior());
            add(new ListView<String>("listItem", namen) {

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
    });
    }
}
\`\`\`
`;/*@license CC0-1.0*/function a(e){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(o,{title:"Apache Wicket/Badge List"}),`
`,n.jsx(r,{children:d})]})}function v(e={}){const{wrapper:t}={...i(),...e.components};return t?n.jsx(t,{...e,children:n.jsx(a,{...e})}):a()}export{v as default};
