package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class D2_1984 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            String[] inputs = br.readLine().split(" ");
            ArrayList<Integer> arr = new ArrayList<Integer>();

            for(int i = 0; i < 10; i++){
                arr.add(Integer.parseInt(inputs[i]));
            }

            int max = Collections.max(arr);
            int min = Collections.min(arr);

            int sum = 0;
            for(int element: arr){
                sum += element;
            }
            sum -= (max + min);
            int avg = (int) Math.round(sum / 8.0);

            sb.append("#" + tc + " " + avg).append("\n");
        }

        System.out.println(sb);
    }
}
