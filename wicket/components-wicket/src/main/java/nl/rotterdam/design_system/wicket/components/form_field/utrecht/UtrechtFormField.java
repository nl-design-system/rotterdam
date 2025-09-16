package nl.rotterdam.design_system.wicket.components.form_field.utrecht;

/**
 * A container for Utrecht form field elements.
 * <p><a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-form-field--docs">Read more</a>
 * </p>
 *
 * Typically has the following nested components:
 * <dl>
 *     <dt>Label (required)</dt>
 *     <dd>A label for the form field.</dd>
 *
 *     <dt>input (required)</dt>
 *     <dd>the input control, such as text field, textarea, checkbox</dd>
 *
 *     <dt>description (required)</dt>
 *     <dd>An additional description for form field. Although a component must support it, it can be invisible if
 *     the description text is not supplied by the form.</dd>
 *
 *     <dt>error message (required)</dt>
 *     <dd>one validation message per field. Although a component must support it, it can be invisible if there
 *     is no error message</dd>
 *
 *     <dt>status (optional)</dt>
 *     <dd>a status of the field. For example, for a license plate field when RDW check failed or for a textarea field
 *     with a maximum number of characters, the number of characters remaining</dd>
 * </dl>
 *
 * <p>We use the suffix 'component' for the nested elements to make it explicit we're referring to NLDS components.</p>
 * <p>All of those elements have a BEM nested style class as defined in {@link UtrechtFormFieldCssClasses}.</p>
 *
 * <p>All CSS class names must be defined as constants in Java code. Don't specify them in HTML files</p>
 **
 *
 */
public interface UtrechtFormField {

}
