package controls;

import io.github.humbleui.jwm.Event;
import io.github.humbleui.jwm.Window;
import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import io.github.humbleui.skija.TextLine;
import misc.CoordinateSystem2i;
import panels.Panel;

import static app.Colors.LABEL_TEXT_COLOR;
import static app.Fonts.FONT12;

public class Label extends Panel {
    public String text;

    public Label(Window window, boolean drawBG, int backgroundColor, int padding, String text) {
        super(window, drawBG, backgroundColor, padding);
        this.text = text;
    }

    @Override
    public void paintImpl(Canvas canvas, CoordinateSystem2i windowCS) {
        canvas.save();
        try (TextLine line = TextLine.make(text, FONT12)) {
            int capHeight = (int) FONT12.getMetrics().getCapHeight();
            try (Paint fg = new Paint().setColor(LABEL_TEXT_COLOR)) {
                canvas.drawTextLine(line, 0, capHeight, fg);
            }
        }
        canvas.restore();
    }

    @Override
    public void accept(Event e) {

    }
}