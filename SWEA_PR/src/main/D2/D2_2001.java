package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class D2_2001 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];


            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            for(int i = 0; i <= N - M; i++){
                for(int j = 0; j <= N - M; j++){
                    int temp = 0;
                    for(int k = 0; k < M; k++){
                        for(int p = 0; p < M; p++){
                            temp += arr[i + k][j + p];
                        }
                    }

                    if(temp > max){
                        max = temp;
                    }
                }
            }

            System.out.println("#"+tc+" "+max);
        }
    }
}
