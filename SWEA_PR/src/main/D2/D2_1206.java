package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D2_1206 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 10; tc++){
            int ans = 0;
            int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> heights = new ArrayList<Integer>();

            for(int i = 0; i < size; i++){
                heights.add(Integer.parseInt(st.nextToken()));
            }

            for(int i = 2; i < size - 2; i++){
                int max = Math.max(Math.max(heights.get(i - 1), heights.get(i - 2)), Math.max(heights.get(i + 1), heights.get(i + 2)));
                int value = heights.get(i) - max;
                if(value > 0){
                    ans += value;
                }
            }


            sb.append("#" + tc + " " + ans).append("\n");
        }

        System.out.println(sb);
    }
}
