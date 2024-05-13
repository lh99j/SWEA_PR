package main.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class D3_3282 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());


            int[][] dp = new int[N + 1][K + 1];

            for(int i = 0; i < N + 1; i++){
                Arrays.fill(dp[i], 0);
            }

            int[] v = new int[N]; //부피
            int[] k = new int[N]; //가치

            Arrays.fill(v, 0);
            Arrays.fill(k, 0);

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                k[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i < N + 1; i++){
                for(int j = 0; j < K + 1; j++){
                    if(j < v[i - 1]){
                        dp[i][j] = dp[i - 1][j];
                    }else{
                        dp[i][j] = Math.max(dp[i - 1][j - v[i - 1]] + k[i - 1], dp[i - 1][j]);
                    }
                }
            }

            sb.append("#" + tc + " " + dp[N][K]).append("\n");
        }

        System.out.println(sb);
    }
}
