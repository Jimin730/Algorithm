import java.io.*;

class Main {

    private static int N;
    private static int[][][][] memo = new int[3][3][3][3];
    private static long result = 0;
    private static int T, G, F, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = 0;
        G = 0; 
        F = 0;
        P = 0;

        memo[T][G][F][P] = 1; // 초기 상태값 기록 (0,0,0,0)
        String line = br.readLine();
        for(int i=0; i<N; i++) {
            updateCount(line.charAt(i));
            
            result += memo[T][G][F][P]; // 현재 상태와 같은 이전 상태 개수를 결과에 더함

            memo[T][G][F][P]++;
        }

        System.out.println(result);
    }

    private static void updateCount(char c) {
        if(c == 'T') T = (T + 1) % 3;
        else if(c == 'G') G = (G + 1) % 3;
        else if(c == 'F') F = (F + 1) % 3;
        else if(c == 'P') P = (P + 1) % 3;
        return;
    }
}