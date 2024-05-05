package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D2_1983 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] credit = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int ans = 0;
            String s = "";
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            ArrayList<Double> scores = new ArrayList<Double>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                scores.add(Integer.parseInt(st.nextToken()) * 0.35 + Integer.parseInt(st.nextToken()) * 0.45 + Integer.parseInt(st.nextToken()) * 0.2);
            }

            for(int i = 0; i < N; i++){
                if(i == K - 1){
                    continue;
                }

                if(scores.get(i) > scores.get(K - 1)){
                    ans++;
                }
            }

            ans = ans / (N / 10);

            sb.append("#" + tc + " " + credit[ans]).append("\n");
        }

        System.out.println(sb);
    }
}
