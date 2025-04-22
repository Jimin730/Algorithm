import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 5567
public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) { //2차원 배열 선언
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n+1];
        visited[1] = true; // 본인을 초대할 수 없으니까 미리 방문처리

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        dfs(1, 0);

        int result = 0;

        for (int i = 2; i < n + 1; i++) { // 초대할 수 있는 인원 세기
            if(visited[i]) result++;
        }

        System.out.println(result);


    }

    static void dfs(int num, int depth) {
        if(depth == 2) return; // 친구의 친구까지만 초대 가능

        for(int i : graph.get(num)){
            visited[i] = true;
            dfs(i, depth + 1); // 연결된 지인 초대
        }
    }
}