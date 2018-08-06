package ru.job4j.psevdo;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  +").append(System.lineSeparator());
        pic.append(" +++").append(System.lineSeparator());
        pic.append("+++++");
        return pic.toString();
    }
}
