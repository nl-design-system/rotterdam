package nl.rotterdam.nl_design_system.docs.wicket.component_examples;

import nl.rotterdam.nl_design_system.docs.wicket.ExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.action_group.ActionGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.alert.AlertExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.badge_list.BadgeListExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.body.BodyExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.button.ButtonExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.checkbox.CheckboxExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.code_block.CodeBlockExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.column_layout.ColumnLayoutExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.data_summary.DataSummaryExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.dialog.DialogExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_checkbox.FormFieldCheckboxExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_label.FormFieldLabelExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.form_field_text_input.FormFieldTextInputExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.heading.HeadingExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.heading_group.HeadingGroupExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.icon.IconExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.icon.RodsIconExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.icon_button.IconButtonExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.link.LinkExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.link_list.LinkListExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.logo.LogoExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.logo_image.RotterdamLogoImageExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.number_badge.NumberBadgeExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.ordered_list.OrderedListExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.page_body.PageBodyExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.page_footer.PageFooterExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.page_layout.PageLayoutExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.paragraph.ParagraphExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.preserve_data.PreserveDataExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.root.RootExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.separator.SeparatorExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.side_nav.SideNavExamplesPanel;
import nl.rotterdam.nl_design_system.docs.wicket.unordered_list.UnorderedListExamplesPanel;

import java.util.List;

public class ComponentExamplePanels {

    // TODO add all classes, for now just a subset.
    public static final List<Class<? extends ExamplesPanel>> classes = List.of(
        SideNavExamplesPanel.class,
        AlertExamplesPanel.class,
        BadgeListExamplesPanel.class,
        BodyExamplesPanel.class,
        ButtonExamplesPanel.class,
        IconButtonExamplesPanel.class,
        ActionGroupExamplesPanel.class,
        CodeBlockExamplesPanel.class,
        ColumnLayoutExamplesPanel.class,
        CheckboxExamplesPanel.class,
        FormFieldCheckboxExamplesPanel.class,
        FormFieldLabelExamplesPanel.class,
        FormFieldTextInputExamplesPanel.class,
        DataSummaryExamplesPanel.class,
        HeadingExamplesPanel.class,
        HeadingGroupExamplesPanel.class,
        IconExamplesPanel.class,
        RodsIconExamplesPanel.class,
        RotterdamLogoImageExamplesPanel.class,
        LinkExamplesPanel.class,
        LinkListExamplesPanel.class,
        LogoExamplesPanel.class,
        DialogExamplesPanel.class,
        NumberBadgeExamplesPanel.class,
        OrderedListExamplesPanel.class,
        PageBodyExamplesPanel.class,
        PageFooterExamplesPanel.class,
        PageLayoutExamplesPanel.class,
        ParagraphExamplesPanel.class,
        PreserveDataExamplesPanel.class,
        RootExamplesPanel.class,
        SeparatorExamplesPanel.class,
        UnorderedListExamplesPanel.class
    );

}
