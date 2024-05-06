package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D2_1208 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int cnt = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 100; i++){
                int nt = Integer.parseInt(st.nextToken());
                int value = tm.getOrDefault(nt, 0) + 1;
                tm.put(nt, value);
            }

            for(int i = 0; i < cnt; i++){
                int lastKey = tm.lastKey();
                tm.put(lastKey, tm.get(lastKey) - 1);
                if(tm.get(lastKey) == 0){
                    tm.remove(lastKey);
                }

                int firstKey = tm.firstKey();
                tm.put(tm.firstKey(), tm.get(tm.firstKey()) - 1);
                if(tm.get(firstKey) == 0){
                    tm.remove(firstKey);
                }

                tm.put(firstKey + 1, tm.getOrDefault(firstKey + 1, 0) + 1);
                tm.put(lastKey - 1, tm.getOrDefault(lastKey - 1, 0) + 1);
            }

            int ans = tm.lastKey() - tm.firstKey();

            sb.append("#" + tc + " " + ans).append("\n");
        }

        System.out.println(sb);
    }
}
