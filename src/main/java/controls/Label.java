package controls;

import io.github.humbleui.jwm.Event;
import io.github.humbleui.jwm.Window;
import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import io.github.humbleui.skija.TextLine;
import misc.CoordinateSystem2i;
import panels.GridPanel;
import panels.Panel;

import static app.Colors.LABEL_TEXT_COLOR;
import static app.Fonts.FONT12;

public class Label extends GridPanel {
    public String text;
    protected boolean centered, vcentered;

    public Label(Window window, boolean drawBG, int backgroundColor, int padding,
                 int gridWidth, int gridHeight, int gridX, int gridY, int colspan, int rowspan,
                 String text, boolean centered, boolean vcentered) {
        super(window, drawBG, backgroundColor, padding, gridWidth, gridHeight,
                gridX, gridY, colspan, rowspan);
        this.text = text;
        this.centered = centered;
        this.vcentered = vcentered;
    }

    @Override
    public void paintImpl(Canvas canvas, CoordinateSystem2i windowCS) {
        canvas.save();
        try (TextLine line = TextLine.make(text, FONT12)) {
            int capHeight = (int) FONT12.getMetrics().getCapHeight();
            if (centered)
                canvas.translate((windowCS.getSize().x - line.getWidth()) / 2.0f, 0);
            if (vcentered)
                canvas.translate(0, (windowCS.getSize().y - capHeight) / 2.0f);
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