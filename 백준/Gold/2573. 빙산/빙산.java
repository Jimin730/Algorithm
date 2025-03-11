import java.io.*;
import java.util.*;

//백준 2573
public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {1,-1,0,0}; //동서남북
    static int[] dy = {0,0,1,-1};
    static int countTime = 0; //걸린 시간

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        //빙산 정보 입력
        for(int i = 0; i < N; i++){ //y
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){ //x
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true){
            int countMountain = 0; //빙산 덩어리 개수
            isVisited = new boolean[N][M]; //방문 여부 초기화

            //빙산 덩어리 개수 세기
            for(int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if(map[i][j] != 0 && !isVisited[i][j]){
                        cntBfs(i, j);
                        countMountain++;
                    }
                }
            }

            //빙산이 두 덩어리 이상으로 분리 됐을 경우
            if(countMountain >= 2){
                System.out.println(countTime);
                return;
            }

            //빙산 덩어리가 나누어지지 않고 모두 녹아버린 경우
            if(countMountain == 0){
                System.out.println(0);
                return;
            }

            meltBfs(); //한꺼번에 빙산 녹이기
            countTime++;
        }

    }

    //빙산 덩어리 개수 세어주기
    public static void cntBfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        isVisited[y][x] = true; //방문 처리

        while(!q.isEmpty()){
            int[] now = q.poll();
            x = now[1];
            y = now[0];

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(checkMap(ny, nx) && !isVisited[ny][nx] && map[ny][nx] != 0){
                    q.offer(new int[]{ny,nx});
                    isVisited[ny][nx] = true; //방문처리
                }
            }
        }
    }

    public static void meltBfs(){
        int[][] meltMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) { //빙산이 있는 곳이면

                    int count = 0; //바다 개수 카운트

                    for (int k = 0; k < 4; k++) { //주변 바다 개수 세어주기
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (checkMap(ny, nx) && map[ny][nx] == 0) {
                            count++;
                        }
                    }
                    meltMap[i][j] = Math.max(map[i][j] - count, 0);
                }
            }
        }

        map = meltMap; //녹인 빙산 정보로 업데이트
    }

    public static boolean checkMap(int y, int x){ //범위 안에 있는지 체크
        return x>=0 && x<M && y>=0 && y<N;
    }

}