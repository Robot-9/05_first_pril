package app;

import misc.Misc;

public class Colors {
    public static final int APP_BACKGROUND_COLOR = Misc.getColor(255, 38, 70, 83);

    public static final int LABEL_TEXT_COLOR = Misc.getColor(64, 255, 255, 255);

    public static final int PANEL_BACKGROUND_COLOR = Misc.getColor(32, 0, 0, 0);

    private Colors() {
        throw new AssertionError("Вызов этого конструктора запрещён");
    }
}
