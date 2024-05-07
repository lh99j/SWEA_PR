package main.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D3_2814 {
    private static int ans = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            boolean[] visited = new boolean[N + 1];
            Arrays.fill(visited, false);

            for(int i = 0; i <= N; i++){
                graph[i] = new ArrayList<Integer>();
            }

            graph[0].add(0);

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);
            }

            for(int i = 1; i <= N; i++){
                dfs(i, 1, graph, visited);
            }

            sb.append("#" + tc + " " + ans).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int node, int len, ArrayList<Integer>[] graph, boolean[] visited){
        boolean[] tv = visited.clone();
        tv[node] = true;
        ans = Math.max(ans, len);

        for(int i = 0; i < graph[node].size(); i++){
            if(!visited[graph[node].get(i)]){
                dfs(graph[node].get(i), len + 1, graph, tv);
            }
        }
    }
}
