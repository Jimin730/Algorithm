import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//백준 1251
public class Main {

    public static String str;
    public static ArrayList<String> arr;

    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine(); //단어 입력 받기
        arr = new ArrayList<>(); //모든 경우의 문자열을 받기 위한 배열

        for (int i = 1; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                //세 개로 나눈 단어를 넣을 변수
                StringBuilder front = new StringBuilder(str.substring(0,i));
                StringBuilder center = new StringBuilder(str.substring(i,j));
                StringBuilder back = new StringBuilder(str.substring(j));
                StringBuilder word = new StringBuilder(); //합친 문자열을 넣을 변수
                word.append(front.reverse()).append(center.reverse()).append(back.reverse()); //각각 뒤집어서 합쳐준다.

                arr.add(word.toString()); //만들어진 단어를 배열에 저장
            }
        }

        Collections.sort(arr); //오름차순 정렬
        System.out.println(arr.get(0)); //사전 순으로 가장 앞에 있는 단어 출력
    }

}