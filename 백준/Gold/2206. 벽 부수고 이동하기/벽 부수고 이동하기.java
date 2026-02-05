import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static int[][] map;
    private static boolean[][][] isVisited;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0}; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M][2];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int minDist = bfs(0,0);
        System.out.println(minDist);
    }

    private static int bfs(int x, int y) {
        // 시작점이 목적지인 경우 
        if(x == N-1 && y == M-1) return 1;


        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y, 1, 0}); // x, y, 해당 칸까지 거리, 벽 부숨 여부(0,1)
        isVisited[x][y][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int dist = now[2];
            int broken = now[3];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(!checkMap(nextX, nextY)) continue;

                if(nextX == N-1 && nextY == M-1) return now[2] + 1; // 다음 칸이 목적지라면 최단 거리 리턴

                if(map[nextX][nextY] == 0 && !isVisited[nextX][nextY][broken]) {
                    q.add(new int[] {nextX, nextY, dist+1, broken});
                    isVisited[nextX][nextY][broken] = true;
                }

                if(map[nextX][nextY] == 1 && broken == 0 && !isVisited[nextX][nextY][broken]) {
                    isVisited[nextX][nextY][1] = true;
                    q.add(new int[] {nextX, nextY, dist+1, 1});
                }
            }
        }

        return -1;
    }

    private static boolean checkMap(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}