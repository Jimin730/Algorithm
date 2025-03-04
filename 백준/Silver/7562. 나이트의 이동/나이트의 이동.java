import java.io.*;
import java.util.*;

//백준 7562
public class Main {

    public static int T; //테스트 케이스
    public static int I; //체스판 한 변의 길이
    public static int[] dx = {1,2,2,1,-1,-2,-2,-1}; //나이트가 이동할 수 있는 방향 8곳
    public static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    public static int[][] chessBoard; //체스판
    public static int[] answer; //테스트 케이스 별 결과 저장 배열
    public static int knightX; //나이트 시작 위치
    public static int knightY;
    public static int goalX; //목표 칸 좌표
    public static int goalY;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine().trim());
        answer = new int[T];

        for(int i=0; i<T; i++){ //테스트 케이스만큼 반복
            //첫 번째 줄 입력
            I = Integer.parseInt(br.readLine().trim());
            chessBoard = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine().trim()); //두 번째 줄 입력
            knightY = Integer.parseInt(st.nextToken());
            knightX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine().trim()); //세 번째 줄 입력
            goalY = Integer.parseInt(st.nextToken());
            goalX = Integer.parseInt(st.nextToken());

            answer[i] = bfs(knightY, knightX, goalY, goalX); //리턴 값을 결과 배열에 저장
        }

        //결과 출력
        for (int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }

    }

    public static int bfs(int ky, int kx, int gy, int gx){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {ky,kx}); //나이트의 현재 위치 넣기
        chessBoard[ky][kx] = 0;

        while (!q.isEmpty()){
            int[] now = q.poll();

            if(now[1] == gx && now[0] == gy){ //목표한 칸에 도달했다면
                return chessBoard[goalY][goalX];
            }

            for(int k=0; k<dx.length; k++){ //나이트가 이동할 수 있는 8방향 탐색
                int nx = now[1] + dx[k];
                int ny = now[0] + dy[k];

                if(checkMove(ny,nx) && chessBoard[ny][nx] == 0){ //체스판 범위 내에 있고 아직 방문하지 않은 곳이라면
                    chessBoard[ny][nx] = chessBoard[now[0]][now[1]] + 1; //최소 몇 번 걸리는지 확인하기 위해 이전 칸에서 +1
                    q.offer(new int[] {ny,nx});
                }
            }
        }

        return -1; //이동할 수 없는 경우
    }

    public static boolean checkMove(int y, int x){
        return x>=0 && y>=0 && x<I && y<I;
    }
}