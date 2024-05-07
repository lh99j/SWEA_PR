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

            int[] timeTable = new int[times.get(times.size() - 1) + 1];

            Arrays.fill(timeTable, 0);

            for(int i = 1; i < timeTable.length; i++){
                timeTable[i] = (i / M) * K;
            }

            for(int i = 0; i < times.size(); i++){
                int value = times.get(i);

                for(int j = value; j < timeTable.length; j++){
                    timeTable[j]--;
                }

                if(timeTable[value] < 0){
                    ans = "Impossible";
                    break;
                }
            }

            sb.append("#" + tc + " " + ans).append("\n");
        }

        System.out.println(sb);
    }
}
