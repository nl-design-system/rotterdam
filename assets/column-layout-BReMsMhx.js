import{j as e}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as o}from"./index-DbGdhrAm.js";import{ap as a,aq as s}from"./index-DJVPeOFm.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-DzTX15XU.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const u=`<!-- @license CC0-1.0 -->

# Column Layout component voor Apache Wicket

Layout van één of meerdere kolommen.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/column_layout/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/column_layout/)

## Column Layout

Voorbeeld.


\`\`\`html
<div wicket:id="utrechtColumnLayout">
 <p>Nam quod exercitationem vero et. Sapiente alias occaecati voluptas est. Ullam sed quis hic est nisi. Et saepe expedita est sunt sed vitae exercitationem et.</p>
 <p>Eos provident at quaerat sed. Et adipisci corporis iste. Praesentium ut aut sit dolores distinctio.</p>
 <p>Alias officiis et sint. Autem fuga praesentium omnis velit sit id sunt suscipit. Nihil vel minus cumque. At mollitia inventore ut quia enim. Ut cupiditate explicabo porro ab vel vel. Velit nostrum doloribus et.</p>
 <p>Natus eos veniam voluptas. Ea modi est dolores doloribus delectus amet nemo. Ea vel nihil et eos et perspiciatis iure commodi. Vel dolores exercitationem facilis quisquam. Voluptas modi quo consequatur quos.</p>
 <p>Aut consequuntur sed qui. Ea id molestiae similique sequi facere deserunt sunt fugiat. Molestiae beatae consectetur perferendis. Qui earum velit sed vel non officiis odit. Deleniti nesciunt nemo ut delectus nemo at sunt. Maiores numquam natus aut adipisci ipsum fuga aliquam consequatur.</p>
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
        add(new UtrechtColumnLayoutBorder("utrechtColumnLayout"));
    }
}
\`\`\`
`;/*@license CC0-1.0*/function i(t){return e.jsxs(e.Fragment,{children:[`
`,`
`,e.jsx(a,{title:"Apache Wicket/Column Layout"}),`
`,e.jsx(s,{children:u})]})}function x(t={}){const{wrapper:n}={...o(),...t.components};return n?e.jsx(n,{...t,children:e.jsx(i,{...t})}):i()}export{x as default};
