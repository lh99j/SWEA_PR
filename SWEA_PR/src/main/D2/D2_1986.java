package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D2_1986 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int ans = 0;
            int input = Integer.parseInt(br.readLine());

            for(int i = 1; i <= input; i++){
                if(i % 2 != 0){
                    ans += i;
                }else{
                    ans -= i;
                }
            }

            sb.append("#" + tc + " " + ans).append("\n");
        }

        System.out.println(sb);
    }
}
