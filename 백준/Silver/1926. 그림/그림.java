import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n,m;
    public static int[][] map;
    public static int[] dx = {0,0,-1,1}; //상하좌우
    public static int[] dy = {1,-1,0,0};
    public static int imageSize;
    public static int imageCount;
    public static int maxImageSize;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //y축
        m = Integer.parseInt(st.nextToken()); //x축
        maxImageSize = 0; //초기 값 0으로 초기화
        map = new int[n][m];

        //2차원 배열에 입력값 채워주기
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //완전 탐색
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] != 0){
                    imageSize = 0; //그래프 탐색 수행 전 0으로 초기화
                    dfs(i,j);
                    imageCount++; //그림의 개수 세주기
                    maxImageSize = Math.max(imageSize, maxImageSize);
                }
            }
        }

        //결과 출력
        System.out.println(imageCount);
        System.out.println(maxImageSize);


    }

    public static void dfs(int y, int x){
        map[y][x] = 0; //0으로 표시해서 방문처리
        imageSize++;

        for(int k=0; k<4; k++){ //상하좌우만 탐색
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(checkMap(ny, nx) && map[ny][nx] != 0){
                dfs(ny,nx); //재귀 수행
            }

        }
    }

    public static boolean checkMap(int y, int x){
        return x>=0 && y>=0 && x<m && y<n;
    }
}