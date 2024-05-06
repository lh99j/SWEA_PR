package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class D2_1244 {
    private static int max = 0;
    private static ArrayList<String> nums = new ArrayList<>();

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            max = 0;
            nums.clear();

            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            for(int i = 0; i < str.length(); i++){
                nums.add(String.valueOf(str.charAt(i)));
            }

            if(str.length() < cnt) {
                cnt = str.length();
            }

            back(0, cnt);

            sb.append("#" + tc + " " + max).append("\n");
        }

        System.out.println(sb);
    }

    private static void back(int depth, int size){
        if(depth == size){
            String str = String.join("", nums);
            int value = Integer.parseInt(str);

            max = Math.max(max, value);
            return;
        }

        for(int i = 0; i < nums.size() - 1; i++){
            for(int j = i + 1; j < nums.size(); j++){
                swap(i, j);
                back(depth + 1, size);
                swap(i, j);
            }
        }
    }

    private static void swap(int f1, int f2){
        String temp = nums.get(f1);
        nums.set(f1, nums.get(f2));
        nums.set(f2, temp);
    }
}
