package main.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_4615 {
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            int[][] board = new int[size][size];
            for(int i = 0; i < size; i++){
                Arrays.fill(board[i], 0);
            }

            init(board);

            //1 : B(흑), 2 : W(백)
            for(int i = 0; i < cnt; i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());

                board[x][y] = c;

                change(x, y, board);
            }

            int bc = 0;
            int wc = 0;

            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(board[i][j] == 1){
                        bc++;
                    }else if(board[i][j] == 2){
                        wc++;
                    }
                }
            }


            sb.append("#" + tc + " " + bc + " " + wc).append("\n");
        }

        System.out.println(sb);
    }

    private static void init(int[][] board){
        if(board.length == 4){
            board[1][1] = 2;
            board[2][2] = 2;

            board[1][2] = 1;
            board[2][1] = 1;
        }

        if(board.length == 6){
            board[2][2] = 2;
            board[3][3] = 2;

            board[2][3] = 1;
            board[3][2] = 1;
        }

        if(board.length == 8){
            board[3][3] = 2;
            board[4][4] = 2;

            board[3][4] = 1;
            board[4][3] = 1;
        }
    }

    private static boolean validPoint(int x, int y, int size){
        if(x >= 0 && y >= 0 && x < size && y < size){
            return true;
        }

        return false;
    }

    private static void change(int x, int y, int[][] board){
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            while(validPoint(nx, ny, board.length) && board[nx][ny] != board[x][y] && board[nx][ny] != 0){
                nx += dx[i];
                ny += dy[i];
            }

            if(validPoint(nx, ny, board.length) && board[nx][ny] == board[x][y] && !(nx == x + dx[i] && ny == y + dy[i])){
                int tx = x + dx[i];
                int ty = y + dy[i];

                board[tx][ty] = board[x][y];

                while(!(tx == nx && ty == ny)){
                    board[tx][ty] = board[x][y];

                    tx += dx[i];
                    ty += dy[i];
                }
            }
        }
    }
}
