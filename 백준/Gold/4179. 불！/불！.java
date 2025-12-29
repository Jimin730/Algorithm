import java.io.*;
import java.util.*;

class Main {
    private static int R, C;
    private static char[][] map;
    private static int[][] fireTime;
    private static int[][] jihunTime;
    private static Queue<int[]> fireQ = new LinkedList<>();
    private static Queue<int[]> jihunQ = new LinkedList<>();
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireTime = new int[R][C];
        jihunTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                fireTime[i][j] = -1;  // -1로 초기화 (방문하지 않음)
                jihunTime[i][j] = -1;

                if (map[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                    fireTime[i][j] = 0;
                } else if (map[i][j] == 'J') {
                    jihunQ.add(new int[]{i, j});
                    jihunTime[i][j] = 0;
                }
            }
        }

        fireBfs();
        jihunBfs();

    }

    private static void fireBfs() {
        while (!fireQ.isEmpty()) {
            int[] now = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (checkMap(nx, ny)) { 
                    if (map[nx][ny] != '#' && fireTime[nx][ny] == -1) {
                        fireTime[nx][ny] = fireTime[now[0]][now[1]] + 1;
                        fireQ.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private static void jihunBfs() {
        while (!jihunQ.isEmpty()) {
            int[] now = jihunQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                // 범위를 벗어나면 탈출
                if (!checkMap(nx, ny)) {
                    System.out.println(jihunTime[now[0]][now[1]] + 1);
                    return;
                }

                if (map[nx][ny] == '.' && jihunTime[nx][ny] == -1) {
                    // 불이 아예 도달하지 않거나(fireTime == -1), 
                    // 지훈이가 도착하는 시간이 불이 붙는 시간보다 빨라야 함
                    if (fireTime[nx][ny] == -1 || fireTime[nx][ny] > jihunTime[now[0]][now[1]] + 1) {
                        jihunTime[nx][ny] = jihunTime[now[0]][now[1]] + 1;
                        jihunQ.add(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static boolean checkMap(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}