package misc;

import io.github.humbleui.skija.RRect;
import io.github.humbleui.skija.Rect;

import java.util.Objects;

public class CoordinateSystem2i {
    private final Vector2i max, min, size;

    public CoordinateSystem2i(int minX, int minY, int sizeX, int sizeY) {
        min = new Vector2i(minX, minY);
        size = new Vector2i(sizeX, sizeY);
        max = Vector2i.sum(size, min);
        max.dec();
    }

    public CoordinateSystem2i(int sizeX, int sizeY) {
        this(0, 0, sizeX, sizeY);
    }

    public Vector2i getRandomCoords() {
        return Vector2i.rand(min, max);
    }

    public Vector2i getRelativePos(Vector2i pos) {
        return Vector2i.subtract(pos, min);
    }

    public Rect getRect() {
        return Rect.makeXYWH(min.x, min.y, size.x, size.y);
    }

    public RRect getRRect(float rad) {
        return RRect.makeXYWH(min.x, min.y, size.x, size.y, rad);
    }

    public boolean checkCoords(Vector2i coords) {
        return checkCoords(coords.x, coords.y);
    }

    public boolean checkCoords(int x, int y) {
        return x > min.x && y > min.y && x < max.x && y < max.y;
    }

    public Vector2i getMax() {
        return max;
    }

    public Vector2i getMin() {
        return min;
    }

    public Vector2i getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "CoordinateSystem2i{" + min + ", " + max + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoordinateSystem2i that = (CoordinateSystem2i) o;

        if (!Objects.equals(max, that.max)) return false;
        return Objects.equals(min, that.min);
    }

    @Override
    public int hashCode() {
        int result = max != null ? max.hashCode() : 0;
        result = 31 * result + (min != null ? min.hashCode() : 0);
        return result;
    }
}
