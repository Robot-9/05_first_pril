package misc;

public class Misc {
    public static int getColor(int a, int r, int g, int b) {
        return ((a * 256 + r) * 256 + g) * 256 + b;
    }

    private Misc() {
        throw new AssertionError("Вызов этого конструктора запрещён");
    }
}
