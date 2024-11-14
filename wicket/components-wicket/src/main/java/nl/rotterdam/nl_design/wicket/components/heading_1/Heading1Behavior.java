package nl.rotterdam.nl_design.wicket.components.heading_1;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.behavior.Behavior;

public class Heading1Behavior {

  public static Behavior heading1() {
    return new Behavior() {
      private static final MetaDataKey<Boolean> behaviorAddedKey =
        new MetaDataKey<>() {};

      @Override
      public void onConfigure(Component component) {
        super.onConfigure(component);

        Boolean metaData = component.getMetaData(behaviorAddedKey);
        if (metaData == null) {
          component.add(AttributeModifier.append("class", "utrecht-heading-1"));
          component.setMetaData(behaviorAddedKey, true);
        }
      }
    };
  }
}
