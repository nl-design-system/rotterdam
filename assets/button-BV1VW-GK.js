import{j as n}from"./jsx-runtime-B7cIiniC.js";import{useMDXComponents as u}from"./index-DbGdhrAm.js";import{ap as i,aq as r}from"./index-t743zj_r.js";import"./index-DCEVbkbO.js";import"./_commonjsHelpers-CqkleIqs.js";import"./iframe-Ca3Vp78R.js";import"../sb-preview/runtime.js";import"./index-DYTvpxhr.js";import"./index-CXQShRbs.js";const a=`<!-- @license CC0-1.0 -->

# Button component voor Apache Wicket

Biedt de mogelijkheid om een actie uit te voeren.


[Broncode van dit voorbeeld](https://github.com/nl-design-system/rotterdam/blob/main/wicket/docs-wicket//src/main/java/nl/rotterdam/wicket/docs/button/)

[Broncode van het component](https://github.com/nl-design-system/rotterdam/blob/main/wicket/components-wicket//src/main/java/nl/rotterdam/wicket/docs/button/)

## Button

Voorbeeld.


\`\`\`html
<button wicket:id="button">Click me</button>
\`\`\`

\`\`\`java
RdButton component = new RdButton("button");
\`\`\`

## Busy Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonBusy">Click me</button>
\`\`\`

\`\`\`java
RdButton component = new RdButton("buttonBusy");
component.setBusy(true);
\`\`\`

## Disabled Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonDisabled">Click me</button>
\`\`\`

\`\`\`java
RdButton component = new RdButton("buttonDisabled");
component.setEnabled(false);
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
RdButton component = new RdButton("buttonIconStart");
\`\`\`

## Pressed Toggle Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonPressed">Click me</button>
\`\`\`

\`\`\`java
RdButton component = new RdButton("buttonPressed");
component.setPressed(true);
\`\`\`

## Primary Action Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonPrimaryAction">Click me</button>
\`\`\`

\`\`\`java
RdButton component = new RdButton("buttonPrimaryAction");
component.setAppearance(RdButtonAppearance.PRIMARY_ACTION);
\`\`\`

## Primary Action + Danger Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonPrimaryActionDanger">Click me</button>
\`\`\`

\`\`\`java
RdButton component = new RdButton("buttonPrimaryActionDanger");
component.setAppearance(RdButtonAppearance.PRIMARY_ACTION);
component.setHint(RdButtonHint.DANGER);
\`\`\`

## Secondary Action Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonSecondaryAction">Click me</button>
\`\`\`

\`\`\`java
RdButton component = new RdButton("buttonSecondaryAction");
component.setAppearance(RdButtonAppearance.SECONDARY_ACTION);
\`\`\`

## Submit Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonSubmit">Submit</button>
\`\`\`

\`\`\`java
RdButton component = new RdButton("buttonSubmit") {
};
// TODO: Find out how this works
return component;
\`\`\`

## Subtle Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonSubtle">Click me</button>
\`\`\`

\`\`\`java
RdButton component = new RdButton("buttonSubtle");
component.setAppearance(RdButtonAppearance.SUBTLE);
\`\`\`

## Toggle Button

Voorbeeld.


\`\`\`html
<button wicket:id="buttonToggle">Click me</button>
\`\`\`

\`\`\`java
RdButton component = new RdButton("buttonToggle");
component.setPressed(false);
\`\`\`

## Ajax button. Gebruik wanneer je de submit via Ajax wilt laten verlopen.

Voorbeeld.


\`\`\`html
<form wicket:id="formOfAjaxButton">
 <button wicket:id="ajaxButton">Click me</button>
</form>
\`\`\`

\`\`\`java
Form<Void> component = new Form<>("formOfAjaxButton") {

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
\`\`\`
`;/*@license CC0-1.0*/function e(t){return n.jsxs(n.Fragment,{children:[`
`,`
`,n.jsx(i,{title:"Apache Wicket/Button"}),`
`,n.jsx(r,{children:a})]})}function k(t={}){const{wrapper:o}={...u(),...t.components};return o?n.jsx(o,{...t,children:n.jsx(e,{...t})}):e()}export{k as default};
