package main.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class D3_2817 {
    private static int ans = 0;
    private static int[] nums;
    private static int K = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            nums = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            ans = 0;

            back(0, 0, 0);

            sb.append("#" + tc + " " + ans).append("\n");
        }

        System.out.println(sb);
    }

    private static void back(int depth, int start, int sum){
        if(sum == K){
            ans++;
        }

        if(depth == nums.length){
            return;
        }

        for(int i = start; i < nums.length; i++){
            back(depth + 1, i + 1, sum + nums[i]);
        }
    }
}
