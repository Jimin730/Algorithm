
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static String king;
    public static String stone;
    public static int N;
    public static int[] dx = {1,-1,0,0,1,-1,1,-1}; //R,L,B,T,RT,LT,RB,LB
    public static int[] dy = {0,0,-1,1,1,1,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = st.nextToken();
        stone = st.nextToken();
        N = Integer.parseInt(st.nextToken());

        int kx = king.charAt(0);
        int ky = king.charAt(1) - '0';

        int sx = stone.charAt(0);
        int sy = stone.charAt(1) - '0';

        for (int i = 0; i < N; i++) {
            String str = br.readLine().trim();
            int idx = -1; //초기값

            switch (str){
                case "R": idx = 0; break;
                case "L": idx = 1; break;
                case "B": idx = 2; break;
                case "T": idx = 3; break;
                case "RT": idx = 4; break;
                case "LT": idx = 5; break;
                case "RB": idx = 6; break;
                case "LB": idx = 7; break;
            }

            if(check(kx+dx[idx], ky+dy[idx])){ //k이 움직일 위치가 범위 안에 있으면
                if(sx == kx+dx[idx] && sy == ky+dy[idx]){ //k가 움직일 위치에 돌이 있으면
                    if(check(sx+dx[idx], sy+dy[idx])){ //돌도 같이 움직여 줘야 하며, 그 위치가 범위 안에 있으면
                        kx += dx[idx];
                        ky += dy[idx];
                        sx += dx[idx];
                        sy += dy[idx];
                    }
                } else { //왕이 움직일 위치에 돌이 없으면 그냥 왕만 움직여준다.
                    kx += dx[idx];
                    ky += dy[idx];
                }
            }
        }

        king = (char)kx+String.valueOf(ky);
        stone = (char)sx+String.valueOf(sy);

        System.out.println(king);
        System.out.println(stone);
    }

    public static boolean check(int x1, int y1){ //범위 안에 있는지 체크
        return x1 >= 65 && y1 >= 1 && x1 <=72 && y1 <=8;
    }
}