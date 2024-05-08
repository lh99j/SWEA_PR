package main.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

public class D3_11315 {
    private static String[][] board;
    private static final int[] dx = {1, 0, 1, 1};
    private static final int[] dy = {0, 1, 1, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int size = Integer.parseInt(br.readLine());
            board = new String[size][size];
            boolean f = false;

            for(int i = 0; i < size; i++){
                String input = br.readLine();
                for(int j = 0; j < size; j++){
                    board[i][j] = String.valueOf(input.charAt(j));
                }
            }

            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(board[i][j].equals("o") && check(i, j)){
                        f = true;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(f ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean check(int x, int y){
        for(int i = 0; i < 4; i++){
            int cnt = 1;
            int nx = x + dx[i];
            int ny = y + dy[i];

            while (isValid(nx, ny, board.length) && board[nx][ny].equals("o")) {
                cnt++;
                nx += dx[i];
                ny += dy[i];
            }

            nx = x - dx[i];
            ny = y - dy[i];

            while (isValid(nx, ny, board.length) && board[nx][ny].equals("o")) {
                cnt++;
                nx -= dx[i];
                ny -= dy[i];
            }

            if(cnt >= 5){
                return true;
            }
        }

        return false;
    }

    private static boolean isValid(int x, int y, int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}
