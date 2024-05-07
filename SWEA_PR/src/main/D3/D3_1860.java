package main.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class D3_1860 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String ans = "Possible";

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ArrayList<Integer> times = new ArrayList<Integer>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                times.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(times);

            for(int i = 0; i < times.size(); i++){
                int total = (times.get(i) / M) * K;

                if(total - i - 1 < 0){
                    ans = "Impossible";
                    break;
                }
            }

            sb.append("#" + tc + " " + ans).append("\n");
        }

        System.out.println(sb);
    }
}
