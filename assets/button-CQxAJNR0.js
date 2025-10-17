import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as i}from"./index-DbGdhrAm.js";import{ap as a,aq as r}from"./index-CVjLHMhw.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-XrOEV80q.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const u=`<!-- @license CC0-1.0 -->

# Button component voor Apache Wicket

Biedt de mogelijkheid om een actie uit te voeren.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/button/)

[Broncode van de component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/button/)

## Button

Voorbeeld.


\`\`\`html
<button wicket:id="button">Click me</button>
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
        return new RdButton("button");
    }

}
\`\`\`

## Busy Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonBusy">Click me</button>
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
        RdButton button = new RdButton("buttonBusy");
        button.setBusy(true);
        return button;
    }

}
\`\`\`

## Disabled Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonDisabled">Click me</button>
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
        RdButton button = new RdButton("buttonDisabled");
        button.setEnabled(false);
        return button;
    }

}
\`\`\`

## Button met Icon Start

Voorbeeld.


\`\`\`html
<button wicket:id="buttonIconStart">
 <svg width="32" height="32" viewBox="0 0 32 32" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M13 23V13H15V23H13Z" /> <path d="M17 23V13H19V23H17Z" /> <path fill-rule="evenodd" clip-rule="evenodd" d="M20 4H12V8H5V10H8V28H24V10H27V8H20V4ZM10 26V10H22V26H10ZM18 6H14V8H18V6Z" />
 </svg>
 Click me
</button>
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
        RdButton button = new RdButton("buttonIconStart");
        return button;
    }

}
\`\`\`

## Pressed Toggle Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonPressed">Click me</button>
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
        RdButton button = new RdButton("buttonPressed");
        button.setPressed(true);
        return button;
    }

}
\`\`\`

## Primary Action Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonPrimaryAction">Click me</button>
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
        RdButton button = new RdButton("buttonPrimaryAction");
        button.setAppearance(RdButtonAppearance.PRIMARY_ACTION);
        return button;
    }

}
\`\`\`

## Primary Action + Danger Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonPrimaryActionDanger">Click me</button>
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
        RdButton button = new RdButton("buttonPrimaryActionDanger");
        button.setAppearance(RdButtonAppearance.PRIMARY_ACTION);
        button.setHint(RdButtonHint.DANGER);
        return button;
    }

}
\`\`\`

## Secondary Action Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonSecondaryAction">Click me</button>
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
        RdButton button = new RdButton("buttonSecondaryAction");
        button.setAppearance(RdButtonAppearance.SECONDARY_ACTION);
        return button;
    }

}
\`\`\`

## Submit Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonSubmit">Submit</button>
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
        RdButton button = new RdButton("buttonSubmit") {
        };
        // TODO: Find out how this works
        return button;
    }

}
\`\`\`

## Subtle Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonSubtle">Click me</button>
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
        RdButton button = new RdButton("buttonSubtle");
        button.setAppearance(RdButtonAppearance.SUBTLE);
        return button;
    }

}
\`\`\`

## Toggle Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonToggle">Click me</button>
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
        RdButton button = new RdButton("buttonToggle");
        button.setPressed(false);
        return button;
    }

}
\`\`\`

## Ajax button. Gebruik wanneer je de submit via Ajax wilt laten verlopen.

Voorbeeld.


\`\`\`html
<form wicket:id="formOfAjaxButton">
 <button wicket:id="ajaxButton">Click me</button>
</form>
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
        return new Form<Void>("formOfAjaxButton") {
    
            @Override
            protected void onInitialize() {
                super.onInitialize();
                add(new RdAjaxButton("ajaxButton") {
    
                    @Override
                    protected void onSubmit(AjaxRequestTarget target) {
                        System.out.println("ajaxButton submitted");
                    }
                });
            }
        };
    }

}
\`\`\`
`;/*@license CC0-1.0*/function o(t){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(a,{title:"Apache Wicket/Button"}),`
`,n.jsx(r,{children:u})]})}function x(t={}){const{wrapper:e}={...i(),...t.components};return e?n.jsx(e,{...t,children:n.jsx(o,{...t})}):o()}export{x as default};
