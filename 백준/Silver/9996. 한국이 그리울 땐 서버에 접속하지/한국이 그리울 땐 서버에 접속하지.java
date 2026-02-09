import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        String[] files = new String[N];
        for(int i=0; i<N; i++) {
            files[i] = br.readLine();
        }

        // 패턴을 앞과 뒤로 파싱
        int starIdx = pattern.indexOf("*");
        String front = pattern.substring(0, starIdx);
        String back = pattern.substring(starIdx+1);

        for(String file : files) {
            // 파일 이름의 전체 길이가 파싱한 패턴의 앞,뒤 부분의 길이를 합친 것보다 짧으면 매칭 불가
            if(file.length() < front.length() + back.length()) { 
                sb.append("NE").append("\n");
                continue;
            }

            if(file.startsWith(front) && file.endsWith(back)) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }

        System.out.println(sb);
    }
}