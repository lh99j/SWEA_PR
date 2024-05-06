package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1979 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //가로
            for(int i = 0; i < n; i++){
                int temp = 0;
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == 1){
                        temp++;
                    }else{
                        if(temp == k){
                            ans++;
                        }
                        temp = 0;
                    }

                    if(j == n - 1 && temp == k){
                        ans++;
                    }
                }
            }

            //세로
            for(int i = 0; i < n; i++){
                int temp = 0;
                for(int j = 0; j < n; j++){
                    if(arr[j][i] == 1){
                        temp++;
                    }else{
                        if(temp == k){
                            ans++;
                        }
                        temp = 0;
                    }

                    if(j == n - 1 && temp == k){
                        ans++;
                    }
                }
            }

            sb.append("#" + tc + " " + ans).append("\n");
        }

        System.out.println(sb);
    }

}
