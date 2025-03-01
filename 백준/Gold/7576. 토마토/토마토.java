import java.io.*;
import java.util.*;

//백준 7576
public class Main {

    public static int M, N;
    public static int[][] box;
    public static int day = 0;
    public static int[] dx = {0,0,-1,1}; //상하좌우 이동
    public static int[] dy = {1,-1,0,0};
    public static Queue<int []> q = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); //세로
        box = new int[N][M];

        //토마토 정보 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j] == 1){ //익은 토마토만 큐에 넣기
                    q.offer(new int[]{i,j});
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[1];
            int y = now[0];

            for(int k=0; k<4; k++){ //상하좌우만 탐색
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(checkMove(nx,ny) && box[ny][nx] == 0){
                    q.offer(new int[]{ny, nx});
                    box[ny][nx] = box[y][x] + 1; //최소 일 수를 구하기 위해 그 다음 위치로 이동하는 경우 그 전의 위치에서 + 1
                }

            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j] == 0){ //박스 칸을 모두 돌 때 0이 존재하면 -1 (더 이상 익지 못하는 상황으로 판단)
                    return -1;
                }
                else{
                    day = Math.max(day, box[i][j]); //다 익는데 걸리는 최소 일 수
                }
            }
        }

        if(day == 1){ //이미 모두 익은 상태라면
            return 0;
        } else {
            return day-1; //모두 다 익는데 걸리는 최소 일 수는 day -1.
        }

    }

    public static boolean checkMove(int x, int y){
        return x>=0 && y>=0 && x<M && y<N;
    }
}