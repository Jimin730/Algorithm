import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 10026
public class Main {

    static int N;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0,0,-1,1}; //상 하 좌 우
    static int[] dy = {-1,1,0,0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        isVisited = new boolean[N][N];
        int[] result = new int[2]; //색약0,색약x 결과 저장

        //그림 정보 저장
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j);
            }
        }

        int countArea = 0; //구역 카운트
        //색약 x
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                char color = map[i][j];

                //R인 경우
                if(color == 'R' && !isVisited[i][j]){
                    bfs(i,j,color);
                    countArea++;
                }
                //B인 경우
                if(color == 'B' && !isVisited[i][j]){
                    bfs(i,j,color);
                    countArea++;
                }
                //G인 경우
                if(color == 'G' && !isVisited[i][j]){
                    bfs(i,j,color);
                    countArea++;
                }
            }
        }
        result[0] = countArea; //색약 x 결과 저장

        isVisited = new boolean[N][N]; //방문 배열 초기화
        countArea = 0; //초기화
        //색약 o
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                char color = map[i][j];
                //R, G인 경우
                if((color == 'R' || color == 'G') && !isVisited[i][j]){
                    colorBlindnessBfs(i, j, color);
                    countArea++;
                }
                //B인 경우
                if(color == 'B' && !isVisited[i][j]){
                    colorBlindnessBfs(i, j, color);
                    countArea++;
                }
            }
        }
        result[1] = countArea; //색약 o 결과 저장

        //결과 출력
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    static void bfs(int y, int x, char color){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        isVisited[y][x] = true; //방문 처리

        while (!q.isEmpty()) {
            int[] now = q.poll();
            x = now[1];
            y = now[0];

            for(int k=0; k<4; k++){ //인접한 곳 탐색
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(checkMap(nx, ny)){
                    if(map[ny][nx] == color && !isVisited[ny][nx]){
                        q.offer(new int[] {ny,nx});
                        isVisited[ny][nx] = true; //방문 처리
                    }
                }
            }
        }
    }

    static void colorBlindnessBfs(int y, int x, char color){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        isVisited[y][x] = true; //방문 처리


        while (!q.isEmpty()) {
            int[] now = q.poll();
            x = now[1];
            y = now[0];

            for(int k=0; k<4; k++){ //인접한 곳 탐색
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(color == 'R'){
                    if(checkMap(nx, ny)){
                        if((map[ny][nx] == color || map[ny][nx] == 'G') && !isVisited[ny][nx]){
                            q.offer(new int[] {ny,nx});
                            isVisited[ny][nx] = true; //방문 처리
                        }
                    }
                } else if(color == 'G'){
                    if(checkMap(nx, ny)){
                        if((map[ny][nx] == color || map[ny][nx] == 'R') && !isVisited[ny][nx]){
                            q.offer(new int[] {ny,nx});
                            isVisited[ny][nx] = true;
                        }
                    }
                } else {
                    if(checkMap(nx, ny)){
                        if(map[ny][nx] == color && !isVisited[ny][nx]){
                            q.offer(new int[] {ny,nx});
                            isVisited[ny][nx] = true;
                        }
                    }
                }

            }
        }
    }

    static boolean checkMap(int x, int y){
        return x>=0 && y>=0 && x<N && y<N;
    }
}