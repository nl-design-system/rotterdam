package nl.rotterdam.design_system.wicket.components.data_summary;

import nl.rotterdam.design_system.wicket.components.test_common.NldsWicketTestCase;
import org.apache.wicket.model.util.ListModel;
import org.junit.jupiter.api.Test;

import java.util.List;

class RdDataSummaryTest extends NldsWicketTestCase {


    @Test
    void rendersBasicInput() {

        // language=HTML
        var expectedHtmlFragment = """
            <dl
              class="utrecht-data-list utrecht-data-list--html-dl utrecht-data-list--rows"
            >
              <div class="utrecht-data-list__item">
                <dt class="utrecht-data-list__item-key">BSN</dt>
                <dd
                  class="utrecht-data-list__item-value utrecht-data-list__item-value--html-dd"
                translate="no">
                  111111110
                </dd>
              </div>
              <div class="utrecht-data-list__item">
                <dt class="utrecht-data-list__item-key">Voornaam</dt>
                <dd
                  class="utrecht-data-list__item-value utrecht-data-list__item-value--html-dd"
                  translate="no"
                >
                  Corné
                </dd>
            </div>
              <div class="utrecht-data-list__item">
                <dt class="utrecht-data-list__item-key">Achternaam</dt>
                <dd
                  class="utrecht-data-list__item-value utrecht-data-list__item-value--html-dd"
                  translate="no"
                >
                  de Vos
                </dd>
              </div>
              <div class="utrecht-data-list__item">
                <dt class="utrecht-data-list__item-key">Opmerkingen</dt>
                <dd
                  class="utrecht-data-list__item-value utrecht-data-list__item-value--html-dd"
                >
                  Heeft een geheim adres
                </dd>
              </div>
            </dl>
            """;


        RdDataSummary component = new RdDataSummary("component",
            new ListModel<>(
                List.of(
                    new SummaryItem("BSN", new SummaryItemValue("111111110", false)),
                    new SummaryItem("Voornaam", new SummaryItemValue("Corné", false)),
                    new SummaryItem("Achternaam", new SummaryItemValue("de Vos", false)),
                    new SummaryItem("Opmerkingen", new SummaryItemValue("Heeft een geheim adres", true))
                )
            )
        );

        String actualHtmlFragment = renderComponentInDlTestPanel(component);

        assertHtmlFragmentSame(expectedHtmlFragment, actualHtmlFragment);
        System.out.println("Actual html:");
        System.out.println(actualHtmlFragment);


    }
}