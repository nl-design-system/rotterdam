import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as r}from"./index-DbGdhrAm.js";import{ap as o,aq as a}from"./index-BE1n2rhj.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Cz0NGX47.js";import"../sb-preview/runtime.js";import"./index-BoT5fo8s.js";import"./index-CuKMG6aU.js";const d=`<!-- @license CC0-1.0 -->

# Unordered List component voor Apache Wicket

Opsomming waar de volgorde van items in de lijst niet van belang is.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/unordered_list/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/rotterdam-nlds-parent-wicket/rotterdam-nlds-wicket//src/main/java/nl/rotterdam/wicket/docs/unordered_list/)

## Unordered List

Voorbeeld.


\`\`\`html
<ol wicket:id="unorderedListWebMarkupContainer">
 <li wicket:id="listItem"><wicket:container wicket:id="label"></wicket:container></li>
</ol>
\`\`\`

\`\`\`java
List<String> namen = List.of("Binnen 5 werkdagen krijgt u een eerste bericht.", "Na uiterlijk 4 weken geeft de gemeente een inhoudelijke reactie.");
WebMarkupContainer component = new WebMarkupContainer("unorderedListWebMarkupContainer") {

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
};
\`\`\`
`;/*@license CC0-1.0*/function i(n){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(o,{title:"Apache Wicket/Unordered List"}),`
`,e.jsx(a,{children:d})]})}function h(n={}){const{wrapper:t}={...r(),...n.components};return t?e.jsx(t,{...n,children:e.jsx(i,{...n})}):i()}export{h as default};
