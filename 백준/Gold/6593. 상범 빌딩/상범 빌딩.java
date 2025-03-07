import java.io.*;
import java.util.*;

//백준 6593
public class Main {

    static int L,R,C; //층 수, 행, 열
    static String[][][] floor;
    static boolean[][][] visited;
    static int[] dx = {1,-1,0,0,0,0}; //동 서 남 북 상 하
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static int startX, startY, startZ;
    static StringBuilder sb = new StringBuilder(); //테스트 케이스별 결과 저장

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); //층 수
            R = Integer.parseInt(st.nextToken()); //행
            C = Integer.parseInt(st.nextToken()); //열

            if(L == 0 && R == 0 && C == 0){
                System.out.print(sb.toString()); //결과 출력 후 종료
                break;
            }

            floor = new String[L][R][C]; //3차원 배열 초기화
            visited = new boolean[L][R][C];

            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String line = br.readLine(); //한 줄씩 입력 받기
                    for(int k=0; k<C; k++){
                        String s = String.valueOf(line.charAt(k));
                        if(s.equals("S")){ //시작위치가 주어지면 해당 좌표 기록
                            startX = k; //열
                            startY = j; //행
                            startZ = i; //층
                        }

                        floor[i][j][k] = s;
                    }
                }
                br.readLine(); //빈 줄 읽기
            }

            //탐색 수행
            bfs();

        }


    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startZ,startY,startX,0}); //0은 칸까지 이동하는데 걸린 시간
        visited[startZ][startY][startX] = true; //방문처리

        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[2];
            int y = now[1];
            int z = now[0];
            int countTime = now[3];

            if(floor[z][y][x].equals("E")){ //탈출 위치에 오면
                sb.append("Escaped in " +countTime+ " minute(s).").append("\n");
                return;
            }

            for(int i=0; i<6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(checkMove(nz,ny,nx) && !visited[nz][ny][nx]){
                    if(floor[nz][ny][nx].equals(".") || floor[nz][ny][nx].equals("E")){
                        q.offer(new int[] {nz, ny, nx, countTime + 1});
                        visited[nz][ny][nx] = true; //방문처리
                    }
                }
            }
        }

        sb.append("Trapped!").append("\n");
    }

    public static boolean checkMove(int z, int y, int x){
        return x>=0 && y>=0 && z>=0 && x<C && y<R && z<L;
    }
}