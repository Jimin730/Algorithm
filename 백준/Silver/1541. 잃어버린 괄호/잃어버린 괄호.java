import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1541번
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        String[] parts = expression.split("-"); // '-' 를 기준으로 나누기

        int result = 0;

        // 첫 번쨰 부분의 숫자 모두 더하기
        String[] firstNums = parts[0].split("\\+");
        for (String s : firstNums) {
            result += Integer.parseInt(s); // 정수 변환 후 더해준다.
        }

        // 나머지 부분 숫자 더해서 빼주기 (처음에 '-'를 기준으로 나누었으니까)
        for (int i = 1; i < parts.length; i++) {

            String[] subNums = parts[i].split("\\+");
            int sum = 0;
            for (String s : subNums) {
                sum += Integer.parseInt(s);
            }
            result -= sum; // 해당 부분의 합을 빼준다.
        }

        System.out.println(result);

    }
}