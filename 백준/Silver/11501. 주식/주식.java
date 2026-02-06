import java.io.*;
import java.util.*;

class Main {

    private static int T, N;
    private static int[] stock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            stock = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
            }

            long totalPrice = 0;
            int maxPrice = 0;

            for(int i=N-1; i>=0; i--) {
                if(stock[i] > maxPrice) { // 현재 가격이 최고가보다 높으면 갱신
                    maxPrice = stock[i];
                }
                else { // 현재 가격이 최고가보다 낮으면 차익만큼 수익 합
                    totalPrice += (maxPrice - stock[i]);
                }
            }
            sb.append(totalPrice).append("\n");
        }
        System.out.println(sb);
    }
}