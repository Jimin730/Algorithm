import java.util.*;

public class Main {

    static int N;
    static int M;
    static int R;
    static int cnt = 0;
    static int[] v;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        visited = new boolean[N+1];
        v = new int[N+1];
        for (int i = 0; i < N + 1; i++) {
            v[i] = 0;
        }

        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            int idx1 = sc.nextInt();
            int idx2 = sc.nextInt();

            graph[idx1].add(idx2);
            graph[idx2].add(idx1);
        }

        for(int i=1; i<graph.length; i++){
            Collections.sort(graph[i]);
        }

        dfs(R);

        for (int i = 1; i < v.length; i++) {
            System.out.println(v[i]);
        }

    }

    static void dfs(int nodeIndex){
        visited[nodeIndex] = true;
        cnt++;
        v[nodeIndex] = cnt;

        for (int node : graph[nodeIndex]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}