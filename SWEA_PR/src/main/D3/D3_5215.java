package main.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class D3_5215 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            int[] cals = new int[cnt];
            int[] tastes = new int[cnt];

            int[][] dp = new int[cnt + 1][limit + 1];

            for(int i = 0; i < cnt; i++){
                st = new StringTokenizer(br.readLine());

                tastes[i] = Integer.parseInt(st.nextToken());
                cals[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i <= cnt; i++){
                Arrays.fill(dp[i], 0);
            }

            for(int i = 1; i <= cnt; i++){
                for(int j = 1; j <=limit; j++){
                    if(j < cals[i - 1]){
                        dp[i][j] = dp[i - 1][j];
                    }else{
                        dp[i][j] = Math.max(dp[i - 1][j - cals[i - 1]] + tastes[i - 1], dp[i - 1][j]);
                    }
                }
            }

            sb.append("#" + tc + " " + dp[cnt][limit]).append("\n");
        }

        System.out.println(sb);
    }
}
