import{j as e}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as r}from"./index-BVXH1tlS.js";import{ap as o,aq as a}from"./index-zTh-TmpC.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-BVtoE53k.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const d=`<!-- @license CC0-1.0 -->

# Ordered List component voor Apache Wicket

Lijst waarvan de volgorde van items betekenis heeft.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/ordered_list/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/ordered_list/)

## Ordered List

Voorbeeld.


\`\`\`html
<ol wicket:id="utrechtOrderedListWebMarkupContainer">
 <li wicket:id="listItem"><wicket:container wicket:id="label"></wicket:container></li>
</ol>
\`\`\`

\`\`\`java
public class ExamplePanel extends Panel {

    public ExamplePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(List<String> namen = List.of("Adam", "Noah", "Mohammed", "Zayn", "James");
     new WebMarkupContainer("utrechtOrderedListWebMarkupContainer") {

        @Override
        protected void onInitialize() {
            super.onInitialize();
            // TODO should be singleton
            add(new UtrechtOrderedListBehavior());
            add(new ListView<String>("listItem", namen) {

                @Override
                protected void populateItem(ListItem<String> item) {
                    // TODO: should be singleton
                    item.add(new UtrechtOrderedListItemBehavior());
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
`;/*@license CC0-1.0*/function i(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(o,{title:"Apache Wicket/Ordered List"}),`
`,e.jsx(a,{children:d})]})}function k(n={}){const{wrapper:t}={...r(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(i,{...n})}):i()}export{k as default};
