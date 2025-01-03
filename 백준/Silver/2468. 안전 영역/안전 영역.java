import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2468
public class Main {

    public static int N;
    public static boolean[][] visited;
    public static int[][] map;
    public static int[] dx = {0, 0, -1, 1}; //상하좌우
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //N 입력 받기

        map = new int[N][N];


        //높이 입력 받기
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]); //최대 높이 찾기
            }
        }

        //물이 잠길 수 있는 최대 높이까지 반복문을 돌며 최대로 나오는 안전지대 개수를 구한다.
        int maxSafeZone = 0;
        for (int h = 0; h <= maxH; h++) {
            visited = new boolean[N][N];
            int countSafeZone = 0;

            for(int i=0; i<N; i++){
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j] > h){ //아직 방문하지 않았고, 물이 차는 높이보다 높은 곳만 수행
                        dfs(i,j,h);
                        countSafeZone++;
                    }
                }
            }

            //최대로 많은 안전지대 갱신
            maxSafeZone = Math.max(maxSafeZone, countSafeZone);

        }

        //결과 출력
        System.out.println(maxSafeZone);

    }

    public static void dfs(int i, int j, int h){
        visited[i][j] = true;

        for(int k=0; k<4; k++){
            int x = i + dx[k];
            int y = j + dy[k];

            if(checkMap(x,y)){
                if(map[x][y] > h && !visited[x][y]) //물에 잠기는 높이보다 높고, 아직 방문하지 않은 곳만 재귀 방문
                    dfs(x,y,h);
            }
        }
    }

    //범위 밖을 나가지 않는지 체크
    public static boolean checkMap(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}