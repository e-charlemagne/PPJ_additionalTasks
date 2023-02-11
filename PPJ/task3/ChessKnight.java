package task3;

public class ChessKnight {
    public static String knightMoves(String pos) {
        int x = pos.charAt(0) - 'b';
        int y = pos.charAt(1) - '1';

        StringBuilder sb = new StringBuilder();
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i) == Math.abs(j) || i == 0 || j == 0) continue;
                int newX = x + i;
                int newY = y + j;
                if (newX < 0 || newX > 7 || newY < 0 || newY > 7) continue;
                sb.append((char)(newX + 'a'));
                sb.append((char)(newY + '1'));
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        for (String s : new String[]{"b1","d5","g6","c8"})
            System.out.println(s + " -> " + knightMoves(s));
        }
    }
