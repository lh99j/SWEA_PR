package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D2_1946 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int cnt = Integer.parseInt(br.readLine());
            ArrayList<String> strs = new ArrayList<String>();
            ArrayList<Integer> ints = new ArrayList<Integer>();


            for (int i = 0; i < cnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                strs.add(st.nextToken());
                ints.add(Integer.parseInt(st.nextToken()));
            }

            sb.append("#" + tc).append("\n");

            int limit = 0;
            for (int i = 0; i < cnt; i++) {
                for (int j = 0; j < ints.get(i); j++) {
                    if (limit == 10) {
                        sb.append("\n");
                        limit = 0;
                    }
                    sb.append(strs.get(i));
                    limit++;
                }
            }
            
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
