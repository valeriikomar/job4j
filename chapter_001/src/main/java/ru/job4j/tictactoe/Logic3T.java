package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean a, b;

        boolean a1 = this.table[0][0].hasMarkX();
        boolean b1 = this.table[this.table.length - 1][0].hasMarkX();

        for (int i = 0; i < this.table.length; i++) {
            a = this.table[i][0].hasMarkX();
            b = this.table[0][i].hasMarkX();
            for (int j = 0; j < this.table.length; j++) {
                a &= this.table[i][j].hasMarkX();
                b &= this.table[j][i].hasMarkX();
            }
            if (a || b) {
                return true;
            }
            a1 &= this.table[i][i].hasMarkX();
            b1 &= this.table[this.table.length - i - 1][i].hasMarkX();
        }
        if (a1 || b1) {
            return true;
        }
        return false;
    }

    public boolean isWinnerO() {
        boolean a, b;

        boolean a1 = this.table[0][0].hasMarkO();
        boolean b1 = this.table[this.table.length - 1][0].hasMarkO();

        for (int i = 0; i < this.table.length; i++) {
            a = this.table[i][0].hasMarkO();
            b = this.table[0][i].hasMarkO();
            for (int j = 0; j < this.table.length; j++) {
                a &= this.table[i][j].hasMarkO();
                b &= this.table[j][i].hasMarkO();
            }
            if (a || b) {
                return true;
            }
            a1 &= this.table[i][i].hasMarkO();
            b1 &= this.table[this.table.length - i - 1][i].hasMarkO();
        }
        if (a1 || b1) {
            return true;
        }
        return false;
    }

    public boolean hasGap() {
        for (Figure3T[] row : table) {
            for (Figure3T colum: row) {
                if (!colum.hasMarkX() && !colum.hasMarkO()) {
                    return true;
                }
            }
        }
        return false;
    }
}

