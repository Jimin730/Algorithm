import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//백준 2606번
public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //컴퓨터 수와 연결된 선의 개수를 입력 받음
        int com = sc.nextInt();
        int line = sc.nextInt();

        //탐색에 사용할 배열을 생성
        visited = new boolean[com+1];
        //그래프는 2차원 배열로 사용
        graph = new ArrayList[com+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < line; i++) {
            int idx1 = sc.nextInt();
            int idx2 = sc.nextInt();

            graph[idx1].add(idx2);
            graph[idx2].add(idx1);
        }

        for (int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        //웜 바이러스는 1번 컴퓨터를 통해 걸리기 때문에 1번부터 시작
        dfs(1);

        //바이러스에 이미 걸린 1번 컴퓨터는 제외한 나머지 컴퓨터 수를 출력
        System.out.println(count-1);
    }

    static void dfs(int nodeIdx){
        visited[nodeIdx] = true;
        count++;

        for (int node : graph[nodeIdx]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}
