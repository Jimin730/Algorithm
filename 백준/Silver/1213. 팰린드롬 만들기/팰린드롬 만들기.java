import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 1213
public class Main {

    public static String name;

    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        name = br.readLine(); //영어 이름 입력 받기
        int[] alphabet = new int[26]; //26개의 알파벳 개수를 세기 위한 배열

        //알파벳 개수 세어주기
        for (int i = 0; i < name.length(); i++) {
            int idx = name.charAt(i) - 'A'; //알파벳 순서를 위한 인덱스
            alphabet[idx]++; //개수를 세어줌
        }

        int odd = 0;
        int center = 0;

        //문자 개수가 홀수인 것 체크
        for (int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] % 2 != 0){ //문자 개수가 홀수이면
                odd++;
                center = i; //센터가 될 문자 인덱스 저장
            }

            if(odd >= 2) { //홀수의 개수가 2개 이상이면 팰린드롬 불가
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        //알파벳 팰린드롬 문자열로 만들기 (앞부분)
        for (int i = 0; i < alphabet.length; i++) {
            for(int j=0; j < alphabet[i]/2; j++){ //알파벳 개수의 반만
                sb.append((char)(i+'A')); //문자 형식으로 sb에 추가
            }
        }

        String result = sb.toString();
        
        if(odd == 1) { //홀수개의 문자가 한개면
            result += (char) (center + 'A'); //가운데에 넣어준다.
        }
        result += sb.reverse().toString(); //sb에 있는 문자를 뒤집어서 추가
        System.out.println(result);
    }
}