package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D2_1989 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            String str = br.readLine();
            Boolean same = true;

            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                    same = false;
                    break;
                }
            }

            int ans = 0;
            if(same) ans = 1;

            sb.append("#" + tc +" " + ans).append("\n");
        }

        System.out.println(sb);
    }
}
