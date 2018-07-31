package ru.job4j.psevdo;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  +\n");
        pic.append(" +++\n");
        pic.append("+++++\n");
        return pic.toString();
    }
}
