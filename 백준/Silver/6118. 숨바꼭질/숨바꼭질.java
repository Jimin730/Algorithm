import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 6118
public class Main {

    static int N, M;
    static ArrayList<Integer>[] barn;
    static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        barn = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) barn[i] = new ArrayList<>(); //2차원 배열 생성


        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //양방향 그래프
            barn[a].add(b);
            barn[b].add(a);
        }

        bfs(1);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        distance = new int[N+1];
        Arrays.fill(distance, -1);

        q.offer(start);
        distance[start] = 0;

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int next : barn[now]) {

                if(distance[next] == -1) {
                    q.offer(next);
                    distance[next] = distance[now] + 1;
                }
            }
        }

        //헛간의 최대 거리 찾기
        int maxDis = 0;
        for (int i = 0; i <= N; i++) {
            maxDis = Math.max(maxDis, distance[i]);
        }

        // 최대 거리를 가진 헛간 & 같은 거리를 가진 헛간 개수 찾기
        int result = 0;
        int count = 0;
        for (int i = 1; i <= N; i++) {

            if(distance[i] == maxDis) {
                if(result == 0 || i < result) {
                    result = i;
                }
                count++;
            }
        }

        //결과 출력
        System.out.println(result + " " + maxDis + " " + count);

    }
}