package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D2_1204 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int num = Integer.parseInt(br.readLine());
            int ans = 0;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                int s = Integer.parseInt(st.nextToken());
                int value = map.getOrDefault(s, 0) + 1;
                map.put(s, value);
            }

            int max = 0;
            for(int key: map.keySet()){
                int value = map.get(key);

                if(max < value){
                    ans = key;
                    max = value;
                }else if(max == value && ans < key){
                    ans = key;
                }
            }


            sb.append("#" + tc + " " + ans).append("\n");
        }

        System.out.println(sb);
    }
}
