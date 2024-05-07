package main.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D3_2806 {
    private static int ans = 0;
    private static int[][] board;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            sb.append("#" + tc + " " + solution(Integer.parseInt(br.readLine()))).append("\n");
        }

        System.out.println(sb);
    }

    private static int solution(int size){
        board = new int[size][size];
        ans = 0;

        for(int i = 0; i < size; i++){
            Arrays.fill(board[i], 0);
        }

        back(board.length - 1);

        return ans;
    }

    private static void back(int depth){
        if (depth < 0){
            ans++;
            return;
        }

        for(int i = 0; i < board.length; i++){
            if(check(depth, i)){
                board[depth][i] = 1;
                back(depth - 1);
                board[depth][i] = 0;
            }
        }
    }

    private static boolean check(int x, int y){
        int tx = x;
        int ty = y;

        while(tx < board.length && ty < board.length){
            if(board[tx][ty] == 1){
                return false;
            }
            tx++;
            ty++;
        }

        tx = x;
        ty = y;

        while(tx < board.length && ty >= 0){
            if(board[tx][ty] == 1){
                return false;
            }
            tx++;
            ty--;
        }

        for(int i = x; i < board.length; i++){
            if(board[i][y] == 1){
                return false;
            }
        }

        return true;
    }
}
