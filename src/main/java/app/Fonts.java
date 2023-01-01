package app;

import io.github.humbleui.skija.Font;
import io.github.humbleui.skija.FontMgr;
import io.github.humbleui.skija.FontStyle;

public class Fonts {
    public static final Font FONT12 = new Font(FontMgr.getDefault().matchFamilyStyleCharacter(null, FontStyle.NORMAL, null, "↑".codePointAt(0)), 12);

    public static final Font FONT18 = new Font(FontMgr.getDefault().matchFamilyStyle(null, FontStyle.NORMAL), 18);

    public static final Font FONT24 = new Font(FontMgr.getDefault().matchFamilyStyle(null, FontStyle.NORMAL), 24);

    private Fonts() {
        throw new AssertionError("Этот конструктор нельзя вызывать");
    }
}
