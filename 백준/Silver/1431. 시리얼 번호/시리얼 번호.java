import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<String> serials = new ArrayList<>();

        for(int i=0; i<N; i++) {
            serials.add(br.readLine());
        }

        serials.sort((s1, s2) -> {
            if(s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }

            int sum1 = getSum(s1);
            int sum2 = getSum(s2);
            if(sum1 != sum2) {
                return Integer.compare(sum1, sum2);
            }

            return s1.compareTo(s2);
        });

        serials.forEach(System.out::println);
    }

    private static int getSum(String s) {
        return s.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .sum();
    }
}