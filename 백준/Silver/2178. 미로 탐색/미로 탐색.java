import java.io.*;
import java.util.*;

class Main {
    
    private static int N,M;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            
            for(int j=0; j<M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        visited[x][y] = true;
        q.offer(new int[] {x,y});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
               if (checkMap(nextX, nextY)) {
                    if(map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        map[nextX][nextY] = map[now[0]][now[1]] + 1;
    
                        visited[nextX][nextY] = true;
                        q.offer(new int[] {nextX, nextY});
                    }
                }
            }
        }
    }

    private static boolean checkMap(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}