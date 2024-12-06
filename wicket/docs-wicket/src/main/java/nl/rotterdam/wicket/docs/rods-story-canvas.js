const stylesheet = new CSSStyleSheet();

stylesheet.replace(`
.rods-story-canvas {
  background-color: white;
  border-color: rgb(0 0 0 / 10%);
  border-radius: 4px;
  border-style: solid;
  border-width: 1px;
  box-shadow: rgb(0 0 0 / 10%) 0 1px 3px 0;
  margin-block-end: 40px;
  margin-block-start: 25px;
  padding-block-end: 30px;
  padding-block-start: 30px;
  padding-inline-end: 20px;
  padding-inline-start: 20px;
  position: relative;
}`);

class RodsStoryElement extends HTMLElement {
  static name = 'rods-story-canvas';

  static define = (registry = customElements) => registry.define(RodsStoryElement.name, RodsStoryElement);

  constructor() {
    super();
  }

  connectedCallback() {
    const shadow = this.attachShadow({ mode: 'closed' });
    shadow.adoptedStyleSheets = [stylesheet];
    const template = this.querySelector('template');
    const div = this.ownerDocument.createElement('div');
    div.classList.add('rods-story-canvas');
    shadow.appendChild(div);
    if (template) {
      div.appendChild(template.content.cloneNode(true));
    }
  }
}

RodsStoryElement.define();
