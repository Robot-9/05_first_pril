package app;

import controls.Label;
import io.github.humbleui.jwm.*;
import io.github.humbleui.jwm.skija.EventFrameSkija;
import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Paint;
import io.github.humbleui.skija.RRect;
import io.github.humbleui.skija.Surface;
import misc.CoordinateSystem2i;
import misc.Misc;

import java.io.File;
import java.util.function.Consumer;

import static app.Colors.APP_BACKGROUND_COLOR;
import static app.Colors.PANEL_BACKGROUND_COLOR;


public class Application implements Consumer<Event> {
    private final Window window;
    public static final int C_RAD_IN_PX = 4;
    public static final int PANEL_PADDING = 5;
    private final Label label;

    public Application() {
        window = App.makeWindow();
        label = new Label(window, true, PANEL_BACKGROUND_COLOR, PANEL_PADDING, "Привет, мир!", true, true);
        window.setEventListener(this);

        window.setTitle("Java 2D");
        window.setWindowSize(900, 900);
        window.setWindowPosition(100, 100);

        switch (Platform.CURRENT) {
            case WINDOWS -> window.setIcon(new File("src/main/resources/windows.ico"));
            case MACOS -> window.setIcon(new File("src/main/resources/macos.icns"));
        }

        String[] layerNames = new String[]{
                "LayerGLSkija", "LayerRasterSkija"
        };

        for (String layerName : layerNames) {
            String className = "io.github.humbleui.jwm.skija." + layerName;
            try {
                Layer layer = (Layer) Class.forName(className).getDeclaredConstructor().newInstance();
                window.setLayer(layer);
                break;
            } catch (Exception e) {
                System.out.println("Ошибка создания слоя " + className);
            }
        }

        if (window._layer == null)
            throw new RuntimeException("Нет доступных слоёв для создания");

        window.setVisible(true);
    }

    @Override
    public void accept(Event e) {
        if (e instanceof EventWindowClose) {
            App.terminate();
        } else if (e instanceof EventWindowCloseRequest) {
            window.close();
        } else if (e instanceof EventFrameSkija ee) {
            Surface s = ee.getSurface();
            paint(s.getCanvas(), new CoordinateSystem2i(
                    s.getWidth() / 3, s.getHeight() / 3,
                    s.getWidth() / 3, s.getHeight() / 3));
        }
    }

    public void paint(Canvas canvas, CoordinateSystem2i windowCS) {
        canvas.save();
        canvas.clear(APP_BACKGROUND_COLOR);
        label.paint(canvas, new CoordinateSystem2i(100, 100, 200, 200));
        canvas.restore();
    }
}