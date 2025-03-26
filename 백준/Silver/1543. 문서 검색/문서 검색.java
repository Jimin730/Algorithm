import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 1543
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String docs = br.readLine(); //문서 읽어오기
        String str = br.readLine(); //비교할 문자열 읽어오기

        int i = 0;
        int count = 0;
        while (i <= docs.length() - str.length()) { // 범위 체크
            String docsStr = docs.substring(i, i + str.length());
            if (str.equals(docsStr)) {
                count++;
                i += str.length(); // 일치할 경우 문자열의 길이만큼 이동
            } else {
                i++; // 일치하지 않을 경우 한 글자씩 이동
            }
        }

        System.out.println(count);

    }
}
