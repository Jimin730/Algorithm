import java.io.*;
import java.util.*;

class Main {

    private static int L, C;
    private static char[] result;
    private static char[] alphabet;
    private static StringBuilder sb = new StringBuilder();
    private static final List<Character> vowel = Arrays.asList('a','e','i','o','u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        result = new char[L];
        alphabet = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet); // 오름차순 정렬

        backTracking(0, 0, 0, 0);
       
        System.out.println(sb);
    }

    private static void backTracking(
        int index, 
        int start,
        int vowelCnt, 
        int consonantCnt
    ){
        if(index == L) {
            if(vowelCnt >= 1 && consonantCnt >= 2) { // 모음, 자음 포함 최소치 포함 여부 확인
                for(int i=0; i<L; i++) {
                    sb.append(result[i]);
                }   
                sb.append("\n");
            }
            return;
        }

        for(int i=start; i<C; i++) {
            result[index] = alphabet[i];
            
            if(vowel.contains(alphabet[i])) { // 현재 값이 모음인지 자음인지 판단
                backTracking(index+1, i+1, vowelCnt+1, consonantCnt);
            } else {
                backTracking(index+1, i+1, vowelCnt, consonantCnt+1);
            }
        }
    }
}