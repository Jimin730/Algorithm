import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static int[] origin;
    private static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        origin = new int[N];
        sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        // 중복 제거 + 순위 매기기
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for(int value : sorted) {
            if(!rankMap.containsKey(value)) { // 중복된 값이 들어있지 않을 때만
                rankMap.put(value, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int value : origin) {
            sb.append(rankMap.get(value)).append(" ");
        }

        System.out.println(sb.toString());
    }
}