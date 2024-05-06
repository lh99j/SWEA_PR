package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1976 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            int sum = first + second;

            int hour = sum / 60;
            int minute = sum % 60;

            if(hour > 12){
                hour -= 12;
            }
            sb.append("#" + tc + " " + hour + " " + minute).append("\n");
        }

        System.out.println(sb);
    }
}
