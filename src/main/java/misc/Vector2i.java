package misc;

import io.github.humbleui.jwm.Event;
import io.github.humbleui.jwm.EventMouseMove;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Vector2i {
    public int x, y;

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2i(Event e) {
        if (e instanceof EventMouseMove ee) {
            this.x = ee.getX();
            this.y = ee.getY();
        }
    }

    public static Vector2i sum(Vector2i a, Vector2i b) {
        return new Vector2i(a.x + b.x, a.y + b.y);
    }

    public void add(Vector2i v) {
        this.x = this.x + v.x;
        this.y = this.y + v.y;
    }

    public static Vector2i subtract(Vector2i a, Vector2i b) {
        return new Vector2i(a.x - b.x, a.y - b.y);
    }

    public static Vector2i rand(Vector2i min, Vector2i max) {
        return new Vector2i(
                ThreadLocalRandom.current().nextInt(min.x, max.x),
                ThreadLocalRandom.current().nextInt(min.y, max.y)
        );
    }

    public void inc() {
        this.x++;
        this.y++;
    }

    public void dec() {
        this.x--;
        this.y--;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2i vector2i = (Vector2i) o;
        return x == vector2i.x && y == vector2i.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
