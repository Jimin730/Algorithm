
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1012번
public class Main {

    public static int T;
    public static int M,N,K;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1}; //상하좌우 이동
    public static int[] dy = {-1,1,0,0};
    public static int[] result;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        result = new int[T]; //테스트케이스 별로 결과를 저장

        //테스트 케이스만큼 탐색 반복
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int[] m : map) {
                Arrays.fill(m, 0); //0으로 배열 채워주기
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1; //배추 위치 표시
            }

            int worm = 0;

            for (int j = 0; j < N; j++) {
                for (int r = 0; r < M; r++) {
                    if(map[j][r] != 0 && !visited[j][r]){
                        dfs(j, r); //dfs 탐색 수행
                        worm++; //필요한 벌레 개수 count
                    }
                }
            }

            result[i] = worm; //필요한 벌레 개수 저장
        }

        //결과 출력
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true; //방문 처리

        for (int i = 0; i < 4; i++) {//상하좌우 탐색
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(checkMap(nextX, nextY)){ //범위 안에 있고
                if(map[nextX][nextY] != 0 && !visited[nextX][nextY]) //배추가 있는 곳이며, 아직 방문하지 않은 곳일 경우
                    dfs(nextX,nextY); //dfs 재귀 수행
            }
        }

    }

    public static boolean checkMap(int x, int y) { //범위 안에 있는지 체크하는 메서드
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}