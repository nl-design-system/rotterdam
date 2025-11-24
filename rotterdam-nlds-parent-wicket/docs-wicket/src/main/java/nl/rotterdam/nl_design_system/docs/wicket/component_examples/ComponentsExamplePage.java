package nl.rotterdam.nl_design_system.docs.wicket.component_examples;

import nl.rotterdam.nl_design_system.docs.wicket.RotterdamBasePage;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavPanel;
import nl.rotterdam.nl_design_system.wicket.components.side_nav.RdSideNavRecord;
import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.List;
import java.util.stream.Collectors;

public class ComponentsExamplePage extends RotterdamBasePage {
    public ComponentsExamplePage() {
        super("Componenten voorbeelden");
    }


    @Override
    protected void onInitialize() {
        super.onInitialize();
        pageBody.add(createComponentSelectionSidebar());
    }

    private Component createComponentSelectionSidebar() {
        List<RdSideNavRecord> records =
            ComponentExamplePanels
                .classes
                .stream().map(clazz ->
                    new RdSideNavRecord(
                        // TODO Ability to set icon on component or example panel
                        null,
                        clazz.getSimpleName(),
                        ComponentsExamplePage.class,
                        new PageParameters(getPageParameters()).set("component", clazz.getSimpleName()),
                        null,
                        null
                    )
                )
                .collect(Collectors.toList());

        return new RdSideNavPanel("component-selection", records);
    }


}
