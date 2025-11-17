package nl.rotterdam.nl_design_system.docs.wicket.link_list;

import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesome7CssReference;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesome7IconType;
import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconBehavior;
import nl.rotterdam.nl_design_system.rotterdam_extensions.wicket.components.rotterdam_icon.RotterdamIconType;
import nl.rotterdam.nl_design_system.wicket.components.link_list.RdLinkListPanel;
import nl.rotterdam.nl_design_system.wicket.components.link_list.RdLinkListRecord;
import nl.rotterdam.nl_design_system.docs.wicket.ComponentExample;
import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.RotterdamPlaceholderPage;
import nl.rotterdam.nl_design_system.docs.wicket.mijn_loket_page.MijnLoketPage;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.component.IRequestablePage;
import org.danekja.java.util.function.serializable.SerializableSupplier;

import java.util.List;

public class LinkListExamplesPanel extends ExamplesPanel {

    private static final CssReferenceHeaderItem FONT_AWESOME_7_CSS_HEADER_ITEM = CssReferenceHeaderItem.forReference(FontAwesome7CssReference.instance());

    public LinkListExamplesPanel(String id) {
        super(id);
    }

    @Override
    public Class<?> getImplementationClass() {
        return RdLinkListPanel.class;
    }

    @ComponentExample
    private static Component exampleLinkList() {
        List<RdLinkListRecord<? extends IRequestablePage>> links = List.of(
            new RdLinkListRecord<>(null, "Overzicht", MijnLoketPage.class),
            new RdLinkListRecord<>(null, "Mijn berichten", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Mijn lopende zaken", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Zelf regelen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Belastingen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Werk & Inkomen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Parkeren", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>(null, "Mijn gegevens", RotterdamPlaceholderPage.class)
        );

        return new RdLinkListPanel("linkList", links, (SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.CHEVRON_RIGHT));
    }

    @ComponentExample
    private static Component exampleLinkListIcon() {
        List<RdLinkListRecord<? extends IRequestablePage>> links = List.of(
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.OVERVIEW), "Overzicht", MijnLoketPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.INBOX), "Mijn berichten", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.BOX), "Mijn lopende zaken", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.SUMMARY), "Zelf regelen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.COINS), "Belastingen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.MONEY_2), "Werk & Inkomen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.PARKING), "Parkeren", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.USER), "Mijn gegevens", RotterdamPlaceholderPage.class)
        );

        return new RdLinkListPanel("linkListIcon", links, (SerializableSupplier<Behavior>) () -> new RotterdamIconBehavior(RotterdamIconType.CHEVRON_RIGHT));
    }

    @ComponentExample
    private static Component exampleLinkListFontAwesome() {
        List<RdLinkListRecord<? extends IRequestablePage>> links = List.of(
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new SolidFontAwesomeBehavior(FontAwesome7IconType.border_all_s), "Overzicht", MijnLoketPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new SolidFontAwesomeBehavior(FontAwesome7IconType.inbox_s), "Mijn berichten", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new SolidFontAwesomeBehavior(FontAwesome7IconType.box_s), "Mijn lopende zaken", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new SolidFontAwesomeBehavior(FontAwesome7IconType.list_s), "Zelf regelen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new SolidFontAwesomeBehavior(FontAwesome7IconType.coins_s), "Belastingen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new SolidFontAwesomeBehavior(FontAwesome7IconType.money_bill_s), "Werk & Inkomen", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new SolidFontAwesomeBehavior(FontAwesome7IconType.parking_s), "Parkeren", RotterdamPlaceholderPage.class),
            new RdLinkListRecord<>((SerializableSupplier<Behavior>) () -> new SolidFontAwesomeBehavior(FontAwesome7IconType.user_s), "Mijn gegevens", RotterdamPlaceholderPage.class)
        );

        return new RdLinkListPanel("linkListFontAwesome", links, (SerializableSupplier<Behavior>) () -> new SolidFontAwesomeBehavior(FontAwesome7IconType.chevron_right_s));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(exampleLinkList());
        add(exampleLinkListIcon());
        add(exampleLinkListFontAwesome());
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(FONT_AWESOME_7_CSS_HEADER_ITEM);
    }

    private static class SolidFontAwesomeBehavior extends Behavior {
        private final String classes;

        public SolidFontAwesomeBehavior(FontAwesome7IconType iconType) {
            classes = "fa-solid " + iconType.cssClassName();
        }

        @Override
        public void onComponentTag(Component component, ComponentTag tag) {
            super.onComponentTag(component, tag);

            tag.setName("i");
            tag.put("class", classes);
        }
    }
}
