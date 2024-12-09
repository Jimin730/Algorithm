import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0}; //dx,dy 짝지어서 보면됨
    static boolean[][] visited;
    static int[][] A;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();  //1011010101 이렇게 한줄로 공백 없이 받아진다.
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j,j+1)); //앞으로 가며 하나씩 끊어 데이터를 초기화 해준다.
            }
        }
        bfs(0,0);
        System.out.println(A[N-1][M-1]);
    }
    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int now[] = q.poll();
            for (int k = 0; k < 4; k++) { //상하좌우로 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) { //배열을 넘어가면 안되고
                    if (A[x][y] != 0 && !visited[x][y]) { //0이어서 갈 수 없거나, 이미 방문한 곳이면 안된다.
                        //이제 갈 수 있는 곳이다.
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; //핵심
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }
    }
}
