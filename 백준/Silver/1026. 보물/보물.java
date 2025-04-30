import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 1026번
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            A.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(A, Collections.reverseOrder()); // A는 내림차순 정렬

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            B.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(B); //B는 오름차순 정렬

        int S = 0;
        for (int i = 0; i < N; i++) {

            S += (A.get(i) * B.get(i));
        }

        System.out.println(S);

    }
}