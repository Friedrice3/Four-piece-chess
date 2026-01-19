import java.util.Scanner;

class Gametable {
    private Scanner kb = new Scanner(System.in);
    private int[][] gametable = new int[10][10];
    private boolean sswitch = true;
    private int round = 0;

    public void player() {

        while (true) {
            if (sswitch) {
                System.out.print("player 1's turn.");
            } else {
                System.out.print("player 2's turn.");
            }
            System.out.print("\nEnter row and column (e.g., 0 1):  ");
            if (!kb.hasNextInt()) {
                System.out.print("Invalid input.\n");
                kb.nextLine();
                continue;
            }
            int row = kb.nextInt();
            if (!kb.hasNextInt()) {
                System.out.print("Invalid input.\n");
                kb.nextLine();
                continue;
            }
            int vertical = kb.nextInt();
            if (GameHelperforInviadChess(row, vertical)) {
                System.out.print("Out of range! Input again.");
                continue;
            }
            if (gametable[row][vertical] != 0) {
                System.out.print("Invalid move. Try again.\n");
                continue;
            }
            if (sswitch) {
                gametable[row][vertical] = 1;
                round += 1;
            } else {
                gametable[row][vertical] = 2;
                round += 1;
            }
            sswitch = !sswitch;
            break;
        }
    }

    // ============================================================

    public void tabledisplay() {
        for (int a = 0; a < this.gametable.length; a++) {
            System.out.printf("%d|", a);
            for (int i = 0; i < this.gametable.length; i++) {
                System.out.printf("%3d", gametable[a][i]);
            }
            System.out.println();
        }
        System.out.println("+--------------------------------");
        System.out.print("  ");
        for (int a = 0; a < this.gametable.length; a++) {
            System.out.printf("%3d", a);
        }
        System.out.println();
    }

    // ============================================================
    //
    public void GameHelperforWinandDraw() {
        // -
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= 6; j++) {

                if (gametable[i][j] == 1 && gametable[i][j + 1] == 1 && gametable[i][j + 2] == 1
                        && gametable[i][j + 3] == 1) {
                    System.out.print("\nplayer 1 win !!!!");
                    System.exit(0);
                }

                if (gametable[i][j] == 2 && gametable[i][j + 1] == 2 && gametable[i][j + 2] == 2
                        && gametable[i][j + 3] == 2) {
                    System.out.print("\nplayer 2 win !!!!");
                    System.exit(0);
                }
            }
        }

        // |
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j < 10; j++) {

                if (gametable[i][j] == 1 && gametable[i + 1][j] == 1 && gametable[i + 2][j] == 1
                        && gametable[i + 3][j] == 1) {
                    System.out.print("\nplayer 1 win !!!!");
                    System.exit(0);
                }

                if (gametable[i][j] == 2 && gametable[i + 1][j] == 2 && gametable[i + 2][j] == 2
                        && gametable[i + 3][j] == 2) {
                    System.out.print("\nplayer 2 win !!!!");
                    System.exit(0);
                }
            }
        }

        // \
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                if (gametable[i][j] == 1 && gametable[i + 1][j + 1] == 1 && gametable[i + 2][j + 2] == 1
                        && gametable[i + 3][j + 3] == 1) {
                    System.out.print("\nplayer 1's win!!!!");
                    System.exit(0);
                }

                if (gametable[i][j] == 2 && gametable[i + 1][j + 1] == 2 && gametable[i + 2][j + 2] == 2
                        && gametable[i + 3][j + 3] == 2) {
                    System.out.print("\nplayer 2's win!!!!");
                    System.exit(0);
                }
            }
        }

        // ./
        for (int i = 0; i <= 6; i++) {
            for (int j = 3; j < 10; j++) {
                if (gametable[i][j] == 1 && gametable[i + 1][j - 1] == 1 && gametable[i + 2][j - 2] == 1
                        && gametable[i + 3][j - 3] == 1) {
                    System.out.print("\nplayer 1's win!!!!");
                    System.exit(0);
                }

                if (gametable[i][j] == 2 && gametable[i + 1][j - 1] == 2 && gametable[i + 2][j - 2] == 2
                        && gametable[i + 3][j - 3] == 2) {
                    System.out.print("\nplayer 2's win!!!!");
                    System.exit(0);
                }
            }
        }
        while (round == 100) {
            System.out.print("\nRound draw!!!!");
            System.exit(round);
        }

    }

    // ============================================================

    public boolean GameHelperforInviadChess(int row, int vertical) {
        return row < 0 || row >= 10 || vertical < 0 || vertical >= 10;
    }
}

public class four_piece_chess {
    public static void main(String[] args) {
        Gametable gametable = new Gametable();
        for (;;) {
            gametable.tabledisplay();
            gametable.GameHelperforWinandDraw();
            gametable.player();

        }

    }
}
