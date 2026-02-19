import java.io.*;
import java.util.*;

class Main {
    static char[][] seatMap = new char[5][5];
    static boolean[][] picked = new boolean[5][5];
    static int result = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            seatMap[i] = br.readLine().toCharArray();
        }

        pickSeven(0, 0, 0, 0);
        System.out.println(result);
    }

    static void pickSeven(int x, int y, int count, int sCnt) {
        if (count == 7) {
            if (sCnt >= 4 && isConnected()) result++; // 4명 이상이고 연결됐으면 결과값 + 1
            return;
        }

        // 25칸을 순차적으로 탐색 (y가 5를 넘으면 다음 줄 x로 이동)
        if (y == 5) {
            pickSeven(x + 1, 0, count, sCnt);
            return;
        }
        if (x == 5) return; // 맵 끝까지 다 봤으면 종료

        // 1. 현재 칸(x, y)을 7공주로 선택하는 경우
        picked[x][y] = true;
        pickSeven(x, y + 1, count + 1, sCnt + (seatMap[x][y] == 'S' ? 1 : 0));
        
        // 2. 현재 칸(x, y)을 선택하지 않고 넘어가는 경우 (백트래킹)
        picked[x][y] = false;
        pickSeven(x, y + 1, count, sCnt);
    }

    static boolean isConnected() {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();

        // 일단 뽑힌 애들 중 아무나 한 명 찾아서 BFS 시작점으로 잡기
        boolean found = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (picked[i][j]) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        int connectedCount = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    if (picked[nx][ny] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        connectedCount++;
                    }
                }
            }
        }
        return connectedCount == 7;
    }
}