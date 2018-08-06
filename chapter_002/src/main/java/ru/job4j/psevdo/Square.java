package ru.job4j.psevdo;
/**
 *@author Valerii Komar (mailto:val1988x@gmail.com)
 *@version 29.07.18
 *@since 0.1
 *
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++").append(System.lineSeparator());
        pic.append("+  +").append(System.lineSeparator());
        pic.append("+  +").append(System.lineSeparator());
        pic.append("++++");
        return pic.toString();
    }
}
