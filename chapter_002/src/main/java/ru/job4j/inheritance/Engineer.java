package ru.job4j.inheritance;

public class Engineer extends Profession{
    private boolean isbuild;

    public void build(House house){
        house.setBuild(isbuild);
    }

    public boolean isIsbuild(House house) {
        return house.isBuild();
    }
}
