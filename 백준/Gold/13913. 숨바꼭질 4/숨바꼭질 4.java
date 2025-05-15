import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 13913
public class Main {

    protected static int N, K;
    protected static boolean[] visited = new boolean[100001];
    protected static int[] parent = new int[100001]; // 이전 위치를 저장하는 배열
    protected static int[] dx = {-1, 1, 2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int time = bfs(N);

        System.out.println(time);

        // 경로 역추적하여 출력
        StringBuilder path = new StringBuilder();
        int idx = K;
        while (idx != N) {
            path.insert(0, idx + " ");
            idx = parent[idx];
        }
        path.insert(0, N + " ");

        System.out.println(path);
    }

    protected static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0}); // {위치, 시간}
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int pos = now[0];
            int time = now[1];

            if (pos == K) return time;

            for (int i = 0; i < dx.length; i++) {
                int next;
                if (dx[i] == 2) {
                    next = pos * dx[i];
                } else {
                    next = pos + dx[i];
                }

                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = pos; // 이전 위치 저장
                    q.add(new int[]{next, time + 1});
                }
            }
        }
        return -1;
    }
}