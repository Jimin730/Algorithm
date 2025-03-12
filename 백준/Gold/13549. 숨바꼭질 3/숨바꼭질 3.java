import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//백준 13549
public class Main {

    static final int MAX_NUM = 100001;
    static int N, K;
    static int[] dir = {-1, 1};
    static boolean[] visited = new boolean[MAX_NUM];
    static int[] count = new int[MAX_NUM];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N, K);

    }

    public static void bfs(int start, int end){
        Deque<Integer> dq = new LinkedList<>(); //순간이동을 한 경우를 우선으로 처리
        visited[start] = true; //방문처리
        dq.offer(start);

        while(!dq.isEmpty()){
            int now = dq.pollFirst();

            if(now == end){
                System.out.println(count[now]); //걸린 최소 시간 출력
                return;
            }

            //순간이동의 경우를 먼저 고려
            int next = now * 2;

            if(next >= 0 && next < MAX_NUM){ //먼저 계산된 위치가 범위를 벗어나지 않는지 체크
                if(!visited[next]){
                    dq.addFirst(next); //큐 앞에 추가
                    visited[next] = true; //방문처리
                    count[next] = count[now]; //0초
                }
            }

            for(int i=0; i<2; i++){ //걸어서 가는 경우의 수 탐색
                next = now + dir[i];
                if(next >= 0 && next < MAX_NUM){
                    if(!visited[next]){
                        dq.addLast(next); //큐 뒤에 추가
                        visited[next] = true;
                        count[next] = count[now] + 1; //걸린 시간 저장
                    }
                }

            }
        }
    }
}