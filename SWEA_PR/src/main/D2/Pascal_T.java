package main.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Pascal_T {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int size = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] arr = new ArrayList[size];

            for(int j = 0; j < size; j++){
                arr[j] = new ArrayList<Integer>();
            }

            arr[0].add(1);

            for(int i = 1; i < size; i++){
                for(int j = 0; j < i + 1; j++){
                    if(j == 0){
                        arr[i].add(1);
                    }else if(j == i){
                        arr[i].add(1);
                    }else{
                        int num = 0;

                        num = arr[i - 1].get(j - 1) + arr[i - 1].get(j);

                        arr[i].add(num);
                    }
                }
            }

            System.out.println("#"+ tc);
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[i].size(); j++){
                    System.out.print(arr[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
