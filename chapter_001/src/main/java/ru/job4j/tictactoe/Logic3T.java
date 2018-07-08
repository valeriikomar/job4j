package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }
    public boolean line(int i, int startX, int startY, int incX, int incY) {
        boolean result = false;
        int posX = incX;
        int posY = incY;
        switch (i) {
            case 1:
                boolean a = this.table[startX][startY].hasMarkX();
                if (!a) {
                    break;
                }
                for (int j = 1; j < this.table.length; j++) {
                    if (a != this.table[startX + posX][startY + posY].hasMarkX()) {
                        break;
                    }
                    if (j == this.table.length - 1) {
                        result = true;
                    }
                    posX += incX;
                    posY += incY;
                }
                break;

            case 2:
                boolean a1 = this.table[startX][startY].hasMarkO();
                if (!a1) {
                    break;
                }
                for (int j = 1; j < this.table.length; j++) {
                    if (a1 != this.table[startX + posX][startY + posY].hasMarkO()) {
                        break;
                    }
                    if (j == this.table.length - 1) {
                        result = true;
                    }
                    posX += incX;
                    posY += incY;
                }
                break;


            default: result = false;
        }
        return result;
    }

    public boolean isWinnerX() {
        return line(1, 0, 0, 0, 1)
               || line(1, 1, 0, 0, 1)
               || line(1, 2, 0, 0, 1)
               || line(1, 0, 0, 1, 0)
               || line(1, 0, 1, 1, 0)
               || line(1, 0, 2, 1, 0)
               || line(1, 0, 0, 1, 1)
               || line(1, 2, 0, -1, 1);

/*      boolean result = false;
        for (int i = 0; i < this.table.length - 1; i++) {
            for (int j = 0; j < this.table.length - 1; j++) {
                if (!this.table[i][j].hasMarkX()) {
                    result = false;
                    break;
                }
                if (j == this.table.length - 1) {
                    result = true;
                }
            }
            if (result) {
                break;
            }
            for (int k = 0; k < this.table.length - 1; k++) {
                if (!this.table[k][i].hasMarkX()) {
                    result = false;
                    break;
                }
                if (k == this.table.length - 1) {
                    result = true;
                }
            }
            for (int p = 0; p < this.table.length - 1; p++) {
                if (!this.table[p][p].hasMarkX()) {
                    result = false;
                    break;
                }
                if (p == this.table.length - 1) {
                    result = true;
                }
            }
            for (int t = 0; t < this.table.length - 1; t++) {
                if (!this.table[this.table.length - t][t].hasMarkX()) {
                    result = false;
                    break;
                }
                if (t == this.table.length - 1) {
                    result = true;
                }
            }
        }
*/

/*      boolean a, b;
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
*/  }

    public boolean isWinnerO() {
        return line(2, 0, 0, 0, 1)
                || line(2, 1, 0, 0, 1)
                || line(2, 2, 0, 0, 1)
                || line(2, 0, 0, 1, 0)
                || line(2, 0, 1, 1, 0)
                || line(2, 0, 2, 1, 0)
                || line(2, 0, 0, 1, 1)
                || line(2, 2, 0, -1, 1);

/*      boolean a, b;
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
*/

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

