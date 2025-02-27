
import java.io.*;
import java.util.*;

//백준 2583
public class Main {

    static int M, N, K;
    static int[][] map;
    static int[] dx = {0,0,-1,1}; //상하좌우 이동
    static int[] dy = {-1,1,0,0};
    static int size;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //y축
        N = Integer.parseInt(st.nextToken()); //x축
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        answer = new ArrayList<>();

        for(int i=0; i<map.length; i++){
            Arrays.fill(map[i], 0); //초기값 0으로 초기화
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2= Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1; y<y2; y++){
                for(int x=x1; x<x2; x++){
                    map[y][x] = 1; //직사각형 영역의 칸 1로 칠해주기
                }
            }
        }

        //완전 탐색
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] != 1){ //칠해지지 않은 영역만 돌아준다.
                    size = 0; //dfs 한번 수행 전 영역 크기 초기화
                    dfs(i,j);
                    answer.add(size); //dfs 수행 후 영역 크기 저장
                }
            }
        }

        //오름차순 정렬
        Collections.sort(answer);

        //결과 출력
        System.out.println(answer.size());
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i) + " ");
        }


    }

    public static void dfs(int y, int x){
        map[y][x] = 1; //방문 처리
        size++;

        for(int k=0; k<4; k++){ //상하좌우 탐색
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(checkMap(ny,nx) && map[ny][nx] != 1){
                dfs(ny,nx);
            }
        }
    }

    public static boolean checkMap(int y, int x){ //map 안에 있는지 체크
        return x>=0 && y>=0 && x<N && y<M;
    }
}