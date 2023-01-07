package panels;

import io.github.humbleui.jwm.*;
import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import misc.CoordinateSystem2i;

import java.util.function.Consumer;

import static app.Application.C_RAD_IN_PX;


public abstract class Panel implements Consumer<Event> {
    protected int padding;
    protected final Window window;
    private final boolean drawBG;
    protected final int backgroundColor;


    public Panel(Window window, boolean drawBG, int backgroundColor, int padding) {
        this.window = window;
        this.drawBG = drawBG;
        this.backgroundColor = backgroundColor;
        this.padding = padding;
    }

    public void paint(Canvas canvas, CoordinateSystem2i windowCS) {
        canvas.save();
        canvas.clipRect(windowCS.getRect());
        if (drawBG) {
            try (var paint = new Paint()) {
                paint.setColor(backgroundColor);
                canvas.drawRRect(windowCS.getRRect(C_RAD_IN_PX), paint);
            }
        }
        canvas.translate(windowCS.getMin().x, windowCS.getMin().y);
        paintImpl(canvas, windowCS);
        canvas.restore();
    }

    public abstract void paintImpl(Canvas canvas, CoordinateSystem2i windowCS);
}
