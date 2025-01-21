import{j as e}from"./jsx-runtime-C8prxwi0.js";import{useMDXComponents as r}from"./index-BVXH1tlS.js";import{ap as o,aq as a}from"./index-DXqktkTG.js";import"./index-DkGvG02X.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-t3j7COuj.js";import"../sb-preview/runtime.js";import"./index-DmLoi2Vx.js";import"./index-CHGET4sZ.js";const d=`<!-- @license CC0-1.0 -->

# Unordered List component voor Apache Wicket

Opsomming waar de volgorde van items in de lijst niet van belang is.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/unordered_list/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/unordered_list/)

## Unordered List

Voorbeeld.


\`\`\`html
<ol wicket:id="utrechtUnorderedListWebMarkupContainer">
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
        add(List<String> namen = List.of("Binnen 5 werkdagen krijgt u een eerste bericht.", "Na uiterlijk 4 weken geeft de gemeente een inhoudelijke reactie.");
     new WebMarkupContainer("utrechtUnorderedListWebMarkupContainer") {

        @Override
        protected void onInitialize() {
            super.onInitialize();
            // TODO should be singleton
            add(new UtrechtUnorderedListBehavior());
            add(new ListView<>("listItem", namen) {

                @Override
                protected void populateItem(ListItem<String> item) {
                    // TODO: should be singleton
                    item.add(new UtrechtUnorderedListItemBehavior());
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
`,e.jsx(o,{title:"Apache Wicket/Unordered List"}),`
`,e.jsx(a,{children:d})]})}function h(n={}){const{wrapper:t}={...r(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(i,{...n})}):i()}export{h as default};
