package nl.rotterdam.nl_design_system.wicket.components.dialog;

/**
 * <p>
 * The heading level to use in the header of the dialog. The heading level is applied to the heading element of the
 * title and the icon button.
 * </p>
 *
 * @see RdDialogBorder
 */
public enum RdDialogHeadingLevel {
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3),
    LEVEL_4(4),
    LEVEL_5(5),
    LEVEL_6(6);

    private final int level;

    RdDialogHeadingLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
