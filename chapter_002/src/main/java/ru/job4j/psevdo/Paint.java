package ru.job4j.psevdo;
/**
 * @author Valerii Komar (mailto:val1988x@gmail.com)
 * @version 29.07.18
 * @since 0.1
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
    public static void main(String[] args) {
        Paint paint = new Paint();
        Shape[] shape = new Shape[2];
        shape[0] = new Square();
        shape[1] = new Triangle();
        for (int i = 0; i < shape.length; i++) {
            paint.draw(shape[i]);
        }
    }
}
