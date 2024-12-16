

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String king;
    static String stone;
    static int N;
             //R,L,B,T,RT,LT,RB,LB
    static int[] dx = {1,-1,0,0,1,-1,1,-1};
    static int[] dy = {0,0,-1,1,1,1,-1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = st.nextToken(); //king 위치
        stone = st.nextToken(); //돌 위치
        N = Integer.parseInt(st.nextToken()); //반복할 위치 이동의 수

        //king 위치. 아스키 코드 기준으로 변환
        int kcol = king.charAt(0) - 'A' + 1;
        int krow = king.charAt(1) - '0';

        //stone 위치. 아스키 코드 기준으로 변환
        int scol = stone.charAt(0) - 'A' + 1;
        int srow = stone.charAt(1) - '0';

        //N만큼 반복하여 이동 수행
        for(int i=0; i<N; i++){
            String str = br.readLine();
            int idx = -1;
            //이동 전 king 위치 저장
            int tmpx = kcol;
            int tmpy = krow;
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
            //해당 위치로 king 이동
            tmpx += dx[idx];
            tmpy += dy[idx];

            if(isRange(tmpx, tmpy)){ //king 이동 시 범위 안에 있는지 확인
                if(tmpx == scol && tmpy == srow) { //이동한 king 위치에 돌이 있을 경우
                    if(isRange(scol+dx[idx], srow+dy[idx])){ //돌도 위치를 옮겨주어야 하니, 이동한 돌이 범위 안에 있을 경우에만 실행
                        scol += dx[idx];
                        srow += dy[idx];
                    } else continue;
                }
                //이동한 위치 값으로 변경
                kcol = tmpx;
                krow = tmpy;
            }
        }

        king = "";
        stone = "";

        //결과 출력을 위해 다시 문제 좌표로 변환
        king += Character.toString((char)(kcol+'A'-1)) + krow;
        stone += Character.toString((char)(scol+'A'-1)) + srow;

        System.out.println(king);
        System.out.println(stone);

    }

    private static boolean isRange(int r, int c){ //체스판의 범위 내에 있는 지 체크
        return r>=1 && c>=1 && r<=8 && c<=8;
    }
}