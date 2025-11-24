import java.util.*;
public class Main {
    static final char PX = 'X';  
    static final char PC = 'O'; 
    static final char EMP = ' ';
    static char[][] brd = {
            {EMP, EMP, EMP},
            {EMP, EMP, EMP},
            {EMP, EMP, EMP}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tic Tac Toe AI game (You = X, Computer = O)\n");
        draw();
        while (true) {
            playerMove(sc);
            draw();
            if (over()) 
                break;
            System.out.println("\nComputer is planning...\n");
            Move mv = aiMove();
            brd[mv.r][mv.c] = PC;
            draw();
            if (over()) 
                break;
        }
    }
    static void playerMove(Scanner sc) {
        while (true) {
            System.out.print("Pick a spot (1-9): ");
            int p = sc.nextInt();
            if (p < 1 || p > 9) {
                System.out.println("Wrong input. Try again.");
                continue;
            }
            int r = (p - 1) / 3;
            int c = (p - 1) % 3;
            if (brd[r][c] == EMP) {
                brd[r][c] = PX;
                break;
            } else {
                System.out.println("Used already.");
            }
        }
    }
    static Move aiMove() {
        Move winM = findSpot(PC);
        if (winM != null) 
            return winM;
        Move blk = findSpot(PX);
        if (blk != null) 
            return blk;
        if (brd[1][1] == EMP) 
            return new Move(1, 1);
        int[][] corners = { {0,0}, {0,2}, {2,0}, {2,2} };
        for (int[] cc : corners) {
            if (brd[cc[0]][cc[1]] == EMP) 
                return new Move(cc[0], cc[1]);
        }
        int[][] sides = { {0,1}, {1,0}, {1,2}, {2,1} };
        for (int[] s : sides) {
            if (brd[s[0]][s[1]] == EMP) 
                return new Move(s[0], s[1]);
        }
        return new Move(0,0);
    }
    static Move findSpot(char sym) {
        for (int r = 0; r < 3; r++) {
            int ct = 0, empty = -1;
            for (int c = 0; c < 3; c++) {
                if (brd[r][c] == sym) 
                    ct++;
                else if (brd[r][c] == EMP) 
                    empty = c;
            }
            if (ct == 2 && empty != -1) 
                return new Move(r, empty);
        }
        for (int c = 0; c < 3; c++) {
            int ct = 0, empty = -1;
            for (int r = 0; r < 3; r++) {
                if (brd[r][c] == sym) ct++;
                else if (brd[r][c] == EMP) empty = r;
            }
            if (ct == 2 && empty != -1) 
                return new Move(empty, c);
        }
        int c1 = 0, e1 = -1;
        for (int i = 0; i < 3; i++) {
            if (brd[i][i] == sym) 
                c1++;
            else if (brd[i][i] == EMP) 
                e1 = i;
        }
        if (c1 == 2 && e1 != -1) 
            return new Move(e1, e1);
        int c2 = 0, e2 = -1;
        for (int i = 0; i < 3; i++) {
            if (brd[i][2 - i] == sym) 
                c2++;
            else if (brd[i][2 - i] == EMP) 
                e2 = i;
        }
        if (c2 == 2 && e2 != -1) 
            return new Move(e2, 2 - e2);

        return null;
    }
    static boolean over() {
        Integer r = check();
        if (r == null) 
            return false;
        if (r == 1) 
            System.out.println("\nComputer Wins!");
        else if (r == -1) 
            System.out.println("\nYou Win!");
        else 
            System.out.println("\nDraw!");
        return true;
    }
    static Integer check() {
        for (int r = 0; r < 3; r++)
            if (brd[r][0] != EMP && brd[r][0] == brd[r][1] && brd[r][1] == brd[r][2])
                return brd[r][0] == PC ? 1 : -1;
        for (int c = 0; c < 3; c++)
            if (brd[0][c] != EMP && brd[0][c] == brd[1][c] && brd[1][c] == brd[2][c])
                return brd[0][c] == PC ? 1 : -1;
        if (brd[1][1] != EMP) {
            if (brd[0][0] == brd[1][1] && brd[1][1] == brd[2][2])
                return brd[1][1] == PC ? 1 : -1;
            if (brd[0][2] == brd[1][1] && brd[1][1] == brd[2][0])
                return brd[1][1] == PC ? 1 : -1;
        }
        if (full()) 
            return 0;
        return null;
    }
    static boolean full() {
        for (char[] r : brd)
            for (char c : r)
                if (c == EMP) 
                    return false;
        return true;
    }
    static void draw() {
        System.out.println("-------------");
        for (int r = 0; r < 3; r++) {
            System.out.print("| ");
            for (int c = 0; c < 3; c++) {
                System.out.print(brd[r][c] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    static class Move {
        int r, c;
        Move(int rr, int cc) { r = rr; c = cc; }
    }
}
