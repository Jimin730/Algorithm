import java.io.*;
import java.util.*;

class Main {

    private static int M, N; // 가로, 세로
    private static int[][] box; // 토마토 상자
    private static int[][] day; // 최수 일 수 기록
    private static int minDays = 0; // 최수 일 수
    private static Queue<int[]> q = new LinkedList<>();

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        box = new int[N][M]; // 행,열 기준으로 배열 크기 초기화
        day = new int[N][M];

        int count = 0; // 익지 않은 토마토(0) 개수 파악

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++) {
                int tomatoStatus = Integer.parseInt(st.nextToken());

                if(tomatoStatus == 1) {
                    q.add(new int[] {i,j});
                } else if(tomatoStatus == 0) {
                    count++;
                }

                box[i][j] = tomatoStatus;
            }
        }

        if(count == 0) { // 익지 않은 토마토가 없어 모두 익은 상태
            System.out.println(0);
            return;
        } 

        bfs(); 

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                minDays = Math.max(minDays, day[i][j]);
            }
        }

        System.out.println(minDays);
    }

    private static void bfs() {
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            for(int i=0; i<4; i++) {
                int nextRow = nowRow + dy[i];
                int nextCol = nowCol + dx[i];
                
                if(checkBox(nextRow, nextCol)){
                    if(box[nextRow][nextCol] == 0) { 
                        day[nextRow][nextCol] = day[nowRow][nowCol] + 1; // 익는데 걸리는 일 수 기록
                        box[nextRow][nextCol] = 1; 
                        q.add(new int[] {nextRow, nextCol});
                    }
                }
            }
        }
    }

    private static boolean checkBox(int row, int col) {
        return row >= 0 && col >= 0 && row < N && col < M;
    }
}