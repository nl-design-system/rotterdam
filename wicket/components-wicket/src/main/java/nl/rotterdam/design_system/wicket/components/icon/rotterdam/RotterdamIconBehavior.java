package nl.rotterdam.design_system.wicket.components.icon.rotterdam;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceType;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class RotterdamIconBehavior extends Behavior {

    public static final RotterdamIconBehavior ADD_IMAGE = new RotterdamIconBehavior(RotterdamIconType.ADD_IMAGE);
    public static final RotterdamIconBehavior ADD_USER = new RotterdamIconBehavior(RotterdamIconType.ADD_USER);
    public static final RotterdamIconBehavior ARROW_DOWN = new RotterdamIconBehavior(RotterdamIconType.ARROW_DOWN);
    public static final RotterdamIconBehavior ARROW_LEFT = new RotterdamIconBehavior(RotterdamIconType.ARROW_LEFT);
    public static final RotterdamIconBehavior ARROW_UP = new RotterdamIconBehavior(RotterdamIconType.ARROW_UP);
    public static final RotterdamIconBehavior ARROW_RIGHT = new RotterdamIconBehavior(RotterdamIconType.ARROW_RIGHT);
    public static final RotterdamIconBehavior ATTACHMENT = new RotterdamIconBehavior(RotterdamIconType.ATTACHMENT);
    public static final RotterdamIconBehavior BADGE_ALERT_SOLID = new RotterdamIconBehavior(
        RotterdamIconType.BADGE_ALERT_SOLID
    );
    public static final RotterdamIconBehavior BADGE_ALERT = new RotterdamIconBehavior(RotterdamIconType.BADGE_ALERT);
    public static final RotterdamIconBehavior BADGE_CHECK_SOLID = new RotterdamIconBehavior(
        RotterdamIconType.BADGE_CHECK_SOLID
    );
    public static final RotterdamIconBehavior BADGE_CHECK = new RotterdamIconBehavior(RotterdamIconType.BADGE_CHECK);
    public static final RotterdamIconBehavior BADGE_CROSS = new RotterdamIconBehavior(RotterdamIconType.BADGE_CROSS);
    public static final RotterdamIconBehavior BADGE_INFO = new RotterdamIconBehavior(RotterdamIconType.BADGE_INFO);
    public static final RotterdamIconBehavior BADGE_QUESTION_SOLID = new RotterdamIconBehavior(
        RotterdamIconType.BADGE_QUESTION_SOLID
    );
    public static final RotterdamIconBehavior BADGE_QUESTION = new RotterdamIconBehavior(
        RotterdamIconType.BADGE_QUESTION
    );
    public static final RotterdamIconBehavior BOX = new RotterdamIconBehavior(RotterdamIconType.BOX);
    public static final RotterdamIconBehavior CALENDAR = new RotterdamIconBehavior(RotterdamIconType.CALENDAR);
    public static final RotterdamIconBehavior CAMERA = new RotterdamIconBehavior(RotterdamIconType.CAMERA);
    public static final RotterdamIconBehavior CANCEL = new RotterdamIconBehavior(RotterdamIconType.CANCEL);
    public static final RotterdamIconBehavior CHAT = new RotterdamIconBehavior(RotterdamIconType.CHAT);
    public static final RotterdamIconBehavior CHECK = new RotterdamIconBehavior(RotterdamIconType.CHECK);
    public static final RotterdamIconBehavior CHEVRON_LEFT = new RotterdamIconBehavior(RotterdamIconType.CHEVRON_LEFT);
    public static final RotterdamIconBehavior CHEVRON_RIGHT = new RotterdamIconBehavior(
        RotterdamIconType.CHEVRON_RIGHT
    );
    public static final RotterdamIconBehavior CHEVRON_SMALL_DOUBLE_LEFT = new RotterdamIconBehavior(
        RotterdamIconType.CHEVRON_SMALL_DOUBLE_LEFT
    );
    public static final RotterdamIconBehavior CHEVRON_SMALL_DOUBLE_RIGHT = new RotterdamIconBehavior(
        RotterdamIconType.CHEVRON_SMALL_DOUBLE_RIGHT
    );
    public static final RotterdamIconBehavior CHEVRON_SMALL_DOWN = new RotterdamIconBehavior(
        RotterdamIconType.CHEVRON_SMALL_DOWN
    );
    public static final RotterdamIconBehavior CHEVRON_SMALL_LEFT = new RotterdamIconBehavior(
        RotterdamIconType.CHEVRON_SMALL_LEFT
    );
    public static final RotterdamIconBehavior CHEVRON_SMALL_RIGHT = new RotterdamIconBehavior(
        RotterdamIconType.CHEVRON_SMALL_RIGHT
    );
    public static final RotterdamIconBehavior CHEVRON_SMALL_UP = new RotterdamIconBehavior(
        RotterdamIconType.CHEVRON_SMALL_UP
    );
    public static final RotterdamIconBehavior CLIPBOARD = new RotterdamIconBehavior(RotterdamIconType.CLIPBOARD);
    public static final RotterdamIconBehavior CLOSE = new RotterdamIconBehavior(RotterdamIconType.CLOSE);
    public static final RotterdamIconBehavior CLOUD_SOLID = new RotterdamIconBehavior(RotterdamIconType.CLOUD_SOLID);
    public static final RotterdamIconBehavior COINS = new RotterdamIconBehavior(RotterdamIconType.COINS);
    public static final RotterdamIconBehavior COMMENT_SOLID = new RotterdamIconBehavior(
        RotterdamIconType.COMMENT_SOLID
    );
    public static final RotterdamIconBehavior COMMENTS = new RotterdamIconBehavior(RotterdamIconType.COMMENTS);
    public static final RotterdamIconBehavior DOCUMENT = new RotterdamIconBehavior(RotterdamIconType.DOCUMENT);
    public static final RotterdamIconBehavior DOWNLOAD = new RotterdamIconBehavior(RotterdamIconType.DOWNLOAD);
    public static final RotterdamIconBehavior DRAGGABLE = new RotterdamIconBehavior(RotterdamIconType.DRAGGABLE);
    public static final RotterdamIconBehavior DROPDOWN = new RotterdamIconBehavior(RotterdamIconType.DROPDOWN);
    public static final RotterdamIconBehavior EDIT = new RotterdamIconBehavior(RotterdamIconType.EDIT);
    public static final RotterdamIconBehavior ENVELOPE_SOLID = new RotterdamIconBehavior(
        RotterdamIconType.ENVELOPE_SOLID
    );
    public static final RotterdamIconBehavior ENVELOPE = new RotterdamIconBehavior(RotterdamIconType.ENVELOPE);
    public static final RotterdamIconBehavior EXTERNAL = new RotterdamIconBehavior(RotterdamIconType.EXTERNAL);
    public static final RotterdamIconBehavior FACEBOOK = new RotterdamIconBehavior(RotterdamIconType.FACEBOOK);
    public static final RotterdamIconBehavior FAVORITE_SOLID = new RotterdamIconBehavior(
        RotterdamIconType.FAVORITE_SOLID
    );
    public static final RotterdamIconBehavior FAVORITE = new RotterdamIconBehavior(RotterdamIconType.FAVORITE);
    public static final RotterdamIconBehavior FILE = new RotterdamIconBehavior(RotterdamIconType.FILE);
    public static final RotterdamIconBehavior FILTER = new RotterdamIconBehavior(RotterdamIconType.FILTER);
    public static final RotterdamIconBehavior FLASH_DISABLED = new RotterdamIconBehavior(
        RotterdamIconType.FLASH_DISABLED
    );
    public static final RotterdamIconBehavior FLASH = new RotterdamIconBehavior(RotterdamIconType.FLASH);
    public static final RotterdamIconBehavior FULL_SCREEN = new RotterdamIconBehavior(RotterdamIconType.FULL_SCREEN);
    public static final RotterdamIconBehavior GLOBE = new RotterdamIconBehavior(RotterdamIconType.GLOBE);
    public static final RotterdamIconBehavior HEART = new RotterdamIconBehavior(RotterdamIconType.HEART);
    public static final RotterdamIconBehavior HIDE = new RotterdamIconBehavior(RotterdamIconType.HIDE);
    public static final RotterdamIconBehavior HISTORY = new RotterdamIconBehavior(RotterdamIconType.HISTORY);
    public static final RotterdamIconBehavior HOME = new RotterdamIconBehavior(RotterdamIconType.HOME);
    public static final RotterdamIconBehavior IDEA = new RotterdamIconBehavior(RotterdamIconType.IDEA);
    public static final RotterdamIconBehavior INBOX = new RotterdamIconBehavior(RotterdamIconType.INBOX);
    public static final RotterdamIconBehavior INSTAGRAM = new RotterdamIconBehavior(RotterdamIconType.INSTAGRAM);
    public static final RotterdamIconBehavior LAYERS = new RotterdamIconBehavior(RotterdamIconType.LAYERS);
    public static final RotterdamIconBehavior LINK = new RotterdamIconBehavior(RotterdamIconType.LINK);
    public static final RotterdamIconBehavior LINKEDIN = new RotterdamIconBehavior(RotterdamIconType.LINKEDIN);
    public static final RotterdamIconBehavior LOCATION = new RotterdamIconBehavior(RotterdamIconType.LOCATION);
    public static final RotterdamIconBehavior LOCK = new RotterdamIconBehavior(RotterdamIconType.LOCK);
    public static final RotterdamIconBehavior LOG_OUT = new RotterdamIconBehavior(RotterdamIconType.LOG_OUT);
    public static final RotterdamIconBehavior MAP = new RotterdamIconBehavior(RotterdamIconType.MAP);
    public static final RotterdamIconBehavior MEDIUM = new RotterdamIconBehavior(RotterdamIconType.MEDIUM);
    public static final RotterdamIconBehavior MENU = new RotterdamIconBehavior(RotterdamIconType.MENU);
    public static final RotterdamIconBehavior MIJN_LOKET = new RotterdamIconBehavior(RotterdamIconType.MIJN_LOKET);
    public static final RotterdamIconBehavior MINUS = new RotterdamIconBehavior(RotterdamIconType.MINUS);
    public static final RotterdamIconBehavior MONEY = new RotterdamIconBehavior(RotterdamIconType.MONEY);
    public static final RotterdamIconBehavior MONEY_2 = new RotterdamIconBehavior(RotterdamIconType.MONEY_2);
    public static final RotterdamIconBehavior MORE_OPTIONS = new RotterdamIconBehavior(RotterdamIconType.MORE_OPTIONS);
    public static final RotterdamIconBehavior NO_IMAGE = new RotterdamIconBehavior(RotterdamIconType.NO_IMAGE);
    public static final RotterdamIconBehavior NOTIFICATION_OFF = new RotterdamIconBehavior(
        RotterdamIconType.NOTIFICATION_OFF
    );
    public static final RotterdamIconBehavior NOTIFICATION = new RotterdamIconBehavior(RotterdamIconType.NOTIFICATION);
    public static final RotterdamIconBehavior OVERVIEW = new RotterdamIconBehavior(RotterdamIconType.OVERVIEW);
    public static final RotterdamIconBehavior PARKING = new RotterdamIconBehavior(RotterdamIconType.PARKING);
    public static final RotterdamIconBehavior PHONE_2 = new RotterdamIconBehavior(RotterdamIconType.PHONE_2);
    public static final RotterdamIconBehavior PHONE = new RotterdamIconBehavior(RotterdamIconType.PHONE);
    public static final RotterdamIconBehavior PIN_SOLID = new RotterdamIconBehavior(RotterdamIconType.PIN_SOLID);
    public static final RotterdamIconBehavior PIN = new RotterdamIconBehavior(RotterdamIconType.PIN);
    public static final RotterdamIconBehavior PLAY_SOLID = new RotterdamIconBehavior(RotterdamIconType.PLAY_SOLID);
    public static final RotterdamIconBehavior PLUS = new RotterdamIconBehavior(RotterdamIconType.PLUS);
    public static final RotterdamIconBehavior RENEW = new RotterdamIconBehavior(RotterdamIconType.RENEW);
    public static final RotterdamIconBehavior RING = new RotterdamIconBehavior(RotterdamIconType.RING);
    public static final RotterdamIconBehavior SEARCH = new RotterdamIconBehavior(RotterdamIconType.SEARCH);
    public static final RotterdamIconBehavior SEND = new RotterdamIconBehavior(RotterdamIconType.SEND);
    public static final RotterdamIconBehavior SETTINGS_1 = new RotterdamIconBehavior(RotterdamIconType.SETTINGS_1);
    public static final RotterdamIconBehavior SETTINGS_2 = new RotterdamIconBehavior(RotterdamIconType.SETTINGS_2);
    public static final RotterdamIconBehavior SHARE = new RotterdamIconBehavior(RotterdamIconType.SHARE);
    public static final RotterdamIconBehavior SHIELD = new RotterdamIconBehavior(RotterdamIconType.SHIELD);
    public static final RotterdamIconBehavior SHOPPING_CART = new RotterdamIconBehavior(
        RotterdamIconType.SHOPPING_CART
    );
    public static final RotterdamIconBehavior SHOW = new RotterdamIconBehavior(RotterdamIconType.SHOW);
    public static final RotterdamIconBehavior SPEAKER = new RotterdamIconBehavior(RotterdamIconType.SPEAKER);
    public static final RotterdamIconBehavior SUMMARY = new RotterdamIconBehavior(RotterdamIconType.SUMMARY);
    public static final RotterdamIconBehavior THEME = new RotterdamIconBehavior(RotterdamIconType.THEME);
    public static final RotterdamIconBehavior TIME = new RotterdamIconBehavior(RotterdamIconType.TIME);
    public static final RotterdamIconBehavior TRASH = new RotterdamIconBehavior(RotterdamIconType.TRASH);
    public static final RotterdamIconBehavior TWITTER = new RotterdamIconBehavior(RotterdamIconType.TWITTER);
    public static final RotterdamIconBehavior UPLOAD = new RotterdamIconBehavior(RotterdamIconType.UPLOAD);
    public static final RotterdamIconBehavior USER_SOLID = new RotterdamIconBehavior(RotterdamIconType.USER_SOLID);
    public static final RotterdamIconBehavior USER = new RotterdamIconBehavior(RotterdamIconType.USER);
    public static final RotterdamIconBehavior VIDEO = new RotterdamIconBehavior(RotterdamIconType.VIDEO);
    public static final RotterdamIconBehavior WHATSAPP = new RotterdamIconBehavior(RotterdamIconType.WHATSAPP);

    String icon = null;

    public RotterdamIconBehavior(RotterdamIconType icon) {
        super();
        this.icon = icon.type;
    }

    private static final JavaScriptReferenceHeaderItem ESM = JavaScriptHeaderItem.forReference(
        new JavaScriptResourceReference(RotterdamIconBehavior.class, "define-custom-elements.js")
    );

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        tag.setName("rods-icon-" + this.icon);
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        ESM.setType(JavaScriptReferenceType.MODULE);
        response.render(ESM);
    }
}
