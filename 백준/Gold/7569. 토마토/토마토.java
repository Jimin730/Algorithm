import java.io.*;
import java.util.*;

//백준 7569
public class Main {
    static int M, N, H; //가로, 세로, 높이(박스 개수)
    static int[] dx = {0,0,-1,1}; //상,하,좌,우
    static int[] dy = {1,-1,0,0};
    static int[] dz = {1,-1}; //위,아래
    static int day = 0;
    static Queue<int[]> q = new LinkedList<>();
    static TomatoBox[] tbArray; //박스를 저장할 객체 배열

    static class TomatoBox { //토마토 박스 생성
        private int[][] box;

        public TomatoBox(int row, int col){
            box = new int[row][col];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); //세로
        H = Integer.parseInt(st.nextToken()); //높이

        tbArray = new TomatoBox[H];

        //토마토 상태 값 입력 받기
        for(int h=0; h<H; h++){
            TomatoBox tb = new TomatoBox(N, M);

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    tb.box[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            tbArray[h] = tb; //객체 배열에 넣기
        }

        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(tbArray[h].box[i][j] == 1){ //익은 토마토가 있는 경우에만
                        q.offer(new int[] {i,j,h}); //큐에 넣기
                    }
                }
            }
        }

        System.out.println(bfs());

    }

    public static int bfs(){
        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[1];
            int y = now[0];
            int h = now[2];

            for(int r=0; r<2; r++){ //위 아래 이동
                int nh = now[2] + dz[r]; 
                if(checkMove(y,x,nh) && tbArray[nh].box[y][x] == 0){
                    q.offer(new int[]{y,x,nh});
                    tbArray[nh].box[y][x] = tbArray[h].box[y][x] + 1; //다음 칸에 그 전까지 이동 횟수 +1 초기화
                }
            }

            for(int k=0; k<4; k++){ //상하좌우
                int nx = now[1] + dx[k];
                int ny = now[0] + dy[k];

                if(checkMove(ny,nx,h) && tbArray[h].box[ny][nx] == 0){
                    q.offer(new int[] {ny,nx,h});
                    tbArray[h].box[ny][nx] = tbArray[h].box[y][x] + 1;
                }
            }
        }

        for(int r=0; r<H; r++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(tbArray[r].box[i][j] == 0){ //탐색 모두 수행 후 0이 있다면
                        return -1; //더 이상 익을 수 없는 상태
                    } else {
                        day = Math.max(day, tbArray[r].box[i][j]); //최소 일 수 구해주기
                    }
                }
            }
        }

        if(day == 1){ //이미 모두 익은 상태
            return 0;
        } else {
            return day-1 ; //모두 익는데 걸리는 최소 일 수
        }
    }

    public static boolean checkMove(int y, int x, int h){ //갈 수 있는 곳인지 체크
        return x>=0 && y>=0 && h>=0 && x<M && y<N && h<H;
    }

}
