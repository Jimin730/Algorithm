import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1325
public class Main {

    static ArrayList<Integer>[] computer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        computer = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) computer[i] = new ArrayList<Integer>(); //2차원 배열 선언 및 초기화

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computer[b].add(a); // 단방향
        }

        int[] cntCom = new int[N+1]; //컴퓨터 번호 별 해킹할 수 있는 컴퓨터 개수 저장
        int maxCnt = 0;
        for(int i=1; i<=N; i++){

            visited = new boolean[N+1];
            cntCom[i] = bfs(i);
            maxCnt = Math.max(cntCom[i], maxCnt); // 가장 많이 해킹할 수 있는 컴퓨터 수 세기
        }

        // 결과 출력
        for (int i = 0; i < cntCom.length; i++) {

            if(cntCom[i] == maxCnt) {
                System.out.print(i + " ");
            }
        }

    }

    public static int bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        visited[start] = true;
        int count = 1;

        while(!q.isEmpty()) {

            int now = q.poll();

            for (int i = 0; i < computer[now].size(); i++) {

                int com = computer[now].get(i);

                if(!visited[com]) {
                    q.offer(com);
                    count++;
                    visited[com] = true;
                }
            }
        }

        return count;
    }
}