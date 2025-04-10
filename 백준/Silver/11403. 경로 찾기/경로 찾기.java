import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11405
public class Main {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int[][] result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){

            visited = new boolean[N];
            dfs(i, visited);
            for (int j = 0; j < N; j++) {

                if(visited[j]){ //방문할 수 있으면
                    result[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void dfs(int v, boolean[] visited){

        for(int i=0; i<N; i++){
            if (map[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, visited);
            }
        }
    }
}