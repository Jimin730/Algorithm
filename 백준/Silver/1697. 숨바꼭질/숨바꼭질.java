import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1697번
public class Main {

    public static int MAX_NUM = 100001;
    public static int N,K;
    public static int[] dir = {-1,1,2}; //이동할 수 있는 경우의 수 3가지
    public static boolean[] visited = new boolean[MAX_NUM]; //방문 여부 확인 배열
    public static int[] count = new int[MAX_NUM]; //몇 초 걸리는지 체크할 배열

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //수빈이의 위치에서부터 시작
        bfs(N);

    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        count[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == K){ //동생의 위치에 도달했다면
                System.out.println(count[now]); //최소 몇 초가 걸리는지 출력
                return;
            }

            for(int i=0; i<3; i++){
                if(i == 2){ //순간이동을 할 경우
                    int next = now * dir[i];

                    if(next >= 0 && next < MAX_NUM && !visited[next]){ //움직일 다음 위치가 범위 안이고 아직 방문하지 않은 곳인지 체크
                        q.add(next);
                        visited[next] = true;
                        count[next] = count[now] + 1;
                    }
                }
                else{ //걸어서 갈 경우
                    int next = now + dir[i];

                    if(next >= 0 && next < MAX_NUM && !visited[next]){ //움직일 다음 위치가 범위 안이고 아직 방문하지 않은 곳인지 체크
                        q.add(next);
                        visited[next] = true;
                        count[next] = count[now] + 1;
                    }
                }
            }
        }
    }
}