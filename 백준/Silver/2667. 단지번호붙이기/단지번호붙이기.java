import java.io.*;
import java.util.*;

//백준 2667
public class Main {

    public static int N;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0,0,-1,1}; //상하좌우
    public static int[] dy = {-1,1,0,0};
    public static int apartCount = 0; //단지 수
    public static int homeCount = 0; //집의 수


    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //지도 크기를 위한 N 입력 받기
        map = new int[N][N];
        visited = new boolean[N][N];

        //지도 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }

        ArrayList<Integer> countList = new ArrayList<>(); //단지마다 집의 수를 카운트한 것을 넣어준다.

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0 && !visited[i][j]){
                    homeCount = 0; //집의 수 초기화
                    bfs(i,j);
                    apartCount++; //단지 수 체크
                    countList.add(homeCount);
                }
            }
        }

        Collections.sort(countList); //오름차순 배열

        //결과 출력
        System.out.println(apartCount);
        for (int i = 0; i < countList.size(); i++) {
            System.out.println(countList.get(i));
        }

    }

    public static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>(); //좌표 입력을 할 것이기 때문에 int[]형으로 큐 생성
        q.offer(new int[]{i,j});

        visited[i][j] = true; //방문 처리
        homeCount++;

        while(!q.isEmpty()){
            int now[] = q.poll(); //큐에서 좌표 하나 꺼냄
            for (int k = 0; k < 4; k++) { //상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if(checkMap(x,y)){ //지도 범위 내 인지 체크
                    if(map[x][y] != 0 && !visited[x][y]){ //집이 없는 곳이 아니고, 이미 방문한 곳이 아니라면
                        visited[x][y] = true; //방문 처리
                        homeCount++;
                        q.offer(new int[]{x,y}); //다음으로 이동할 위치 큐에 삽입
                    }
                }
            }
        }

    }

    public static boolean checkMap(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }

}