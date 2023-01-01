package app;

import io.github.humbleui.jwm.*;

import java.io.File;
import java.util.function.Consumer;

public class Application implements Consumer<Event> {
    private final Window window;

    public Application() {
        window = App.makeWindow();
        window.setEventListener(this);
        window.setVisible(true);

        window.setTitle("Java 2D");
        window.setWindowSize(900, 900);
        window.setWindowPosition(100, 100);

        switch (Platform.CURRENT) {
            case WINDOWS -> window.setIcon(new File("src/main/resources/windows.ico"));
            case MACOS -> window.setIcon(new File("src/main/resources/macos.icns"));
        }

        String[] layerNames = new String[] {
                "LayerGLSkija", "LayerRasterSkija"
        };
    }

    @Override
    public void accept(Event e) {
        if (e instanceof EventWindowClose) {
            App.terminate();
        } else if (e instanceof EventWindowCloseRequest) {
            window.close();
        }
    }
}