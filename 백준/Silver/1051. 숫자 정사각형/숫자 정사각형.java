import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); //*

        //n,m, map 입력 받아주기
        n = Integer.parseInt(st.nextToken()); //*
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j) - '0'; //*
            }
        }

        //탐색할 정사각형의 최대 크기는 n과 m 중 작은 것이 됨
        int len = Math.min(n,m);

        while(len > 1){ //탐색할 정사각형을 가능한 가장 큰 크기부터 수행
            for(int i=0; i<=n-len; i++){ //탐색할 때 정사각형의 크기별로 탐색 가능한 map 범위를 제한.
                for(int j=0; j<=m-len; j++){
                    int num = map[i][j];

                    //정사각형의 꼭짓점에 있는 값이 모두 같다면
                    if (num == map[i][j + len - 1] && num == map[i + len - 1][j] && num == map[i + len - 1][j + len - 1]) {
                        System.out.println(len*len); //현재 정사각형 크기를 출력
                        return;
                    }

                }
            }
            len--; //조건에 해당하는 정사각형이 없다면 len 길이 줄이기
        }

        System.out.println(len*len);
    }

}
