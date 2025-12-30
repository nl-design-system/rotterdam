package nl.rotterdam.nl_design_system.wicket.html;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;

import java.util.function.BiFunction;

/**
 * <p>
 * Add an instance of a {@link org.apache.wicket.markup.html.panel.Panel Panel} or
 * {@link org.apache.wicket.markup.html.border.Border Border} that has slots to customize its appearance. That is, the
 * panel or border is a template. This is an implementation of the preferred solution in <a
 * href="https://issues.apache.org/jira/browse/WICKET-1134">WICKET-1134 - Multiple abstract/implement tags instead of
 * child/extend</a> (specifically
 * <a href="https://issues.apache.org/jira/browse/WICKET-1134?focusedCommentId=12896734&page=com.atlassian.jira.plugin.system.issuetabpanels%3Acomment-tabpanel#comment-12896734">the
 * comment of Igor Vaynberg on August 9, 2010</a>).
 * </p>
 * <p>
 * The component to use for a slot can be created by (for required slots) implementing or (for optional slots)
 * overriding a method from the panel or border. These methods are usually prefixed with <code>new</code>. Which
 * component types are allowed depends on the element type to which the template component will add the slot component. 
 * </p>
 * <h2>Template Component Markup</h2>
 * <p>
 * A template component is free to structure its markup as needed. However, a good structure for the markup of slots is
 * an HTML element for the slot. This HTML element should contain <code>&lt;wicket:container&gt;</code> to which the
 * slot component will be attached. This way the template component keeps control over the structure, and gives the
 * template user full control over what appears in a slot:
 * </p>
 * <pre>
 * <code><![CDATA[<element><wicket:container wicket:id="..."></wicket:container></element>]]></code></pre>
 * <p>
 * For example, for the title of a dialog. The title content can range from a simple
 * {@link org.apache.wicket.markup.html.basic.Label Label} to a {@link org.apache.wicket.markup.html.panel.Fragment
 * Fragment} or panel containing more complex markup with HTML elements, images, etc.:
 * </p>
 * <pre>
 * <code><![CDATA[<div><wicket:container wicket:id="title"></wicket:container></div>]]></code></pre>
 * <h2>Template Instance Markup</h2>
 * <p>
 * The markup for a template instance must be as follows. This keeps the element for the template component and the slot
 * fragments together.
 * </p>
 * <p>
 * The container of the template instance (<code>[Wicket ID]Instance</code>) is {@link TransparentWebMarkupContainer
 * transparent}.
 * </p>
 * <p>
 * For the element type to use for the template component, see the documentation of that component. In case of a border,
 * this element may also contain markup.
 * </p>
 * <p>
 * Fragments can be placed above and/or below the element for the template component, whatever seems logical. For
 * clarity, it is best to use the Wicket IDs of the slots for the Wicket IDs of the fragments, but this is not a
 * requirement:
 * </p>
 * <pre>
 * <code><![CDATA[<wicket:container wicket:id="[Wicket ID]Instance">
 *   <!-- Zero or more fragments -->
 *   <wicket:fragment wicket:id="[fragment Wicket ID]">...</wicket:fragment>
 *   <element wicket:id="[Wicket ID]"></element>
 *   <!-- Zero or more fragments -->
 *   <wicket:fragment wicket:id="[fragment Wicket ID]">...</wicket:fragment>
 * </wicket:container>]]></code></pre>
 * <p>
 * Here is an example for a dialog that ask the users if they want to save a file before closing. Although the markup
 * does not match the final HTML, it provides a reasonable approximation of what will be produced:
 * </p>
 * <pre>
 * <code><![CDATA[<wicket:container wicket:id="confirmCloseInstance">
 *   <wicket:fragment wicket:id="title">
 *     <h1><wicket:link><img src="save.png"></wicket:link> Save before closing?</h1>
 *   </wicket:fragment>
 *   <dialog wicket:id="confirmClose">
 *     Do you want to save '<span wicket:ID="filename"></span>'?
 *   </dialog>
 *   <wicket:fragment wicket:id="footer">
 *     <form wicket:id="confirmCloseForm">
 *       <button wicket:id="saveAndClose"><wicket:message key="saveAndClose"></wicket:message></button>
 *       <button wicket:id="discard"><wicket:message key="discard"></wicket:message></button>
 *       <button wicket:id="cancel"><wicket:message key="cancel"></wicket:message></button>
 *     </form>
 *   </wicket:fragment>
 * </wicket:container>]]></code></pre>
 * <h2>Instantiating a Template</h2>
 * <p>
 * Invoke {@link #add(MarkupContainer, String, BiFunction)} from the component containing the template instance with the
 * following arguments:
 * </p>
 * <ol>
 *     <li>The parent: the component containing the template instance.</li>
 *     <li>The Wicket ID for the template component.</li>
 *     <li>
 *         <p>The factory that creates the template component, taking the following parameters:</p>
 *         <ol>
 *             <li>The Wicket ID for the template component. This is the value above.</li>
 *             <li>The template instance container (<code>[Wicket ID]Instance</code>) that contains the fragments used
 *             to fill the slots of the template component.</li>
 *         </ol>
 *     </li>
 * </ol>
 * <p>
 * For example, for creating the template instance for the example dialog above: 
 * </p>
 * <pre>
 * <code>var confirmCloseDialog = TemplateInstance.add(this, "confirmClose", (id, fragmentContainer) ->
 *         new TheDialog(id) {
 *             &#64;Override
 *             protected Component newTitle(String id, IModel&lt;?&gt; model) {
 *                 return new Fragment(id, "title", fragmentContainer);
 *             }
 *
 *             &#64;Override
 *             protected Component newFooter(String id, IModel&lt;?&gt; model) {
 *                 var fragment = new Fragment(id, "footer", fragmentContainer);
 *                 // Add the form and the buttons to the fragment here.
 *                 return fragment;
 *             }
 *         });</code></pre>
 */
public class TemplateInstance {
    /**
     * <p>
     * Add a template instance to a container.
     * </p>
     *
     * @param parent     the container.
     * @param templateId the Wicket ID for the template component.
     * @param factory    the factory that creates the template component, taking the following parameters: the Wicket ID
     *                   for the template component and the container that contains the fragments used to fill the slots
     *                   of the template component.
     * @param <T>        the type of the template component.
     * @return the template component.
     */
    public static <T extends Component> T add(
            MarkupContainer parent,
            String templateId,
            BiFunction<String, MarkupContainer, T> factory) {
        var instanceWrapper = new TransparentWebMarkupContainer(templateId + "Instance");
        parent.add(instanceWrapper);

        var instance = factory.apply(templateId, instanceWrapper);
        parent.add(instance);

        return instance;
    }
}
