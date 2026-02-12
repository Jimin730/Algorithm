import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean isCpp = false;
        boolean isJava = false;
        StringBuilder word = new StringBuilder();

        if(str.startsWith("_") || str.endsWith("_") || Character.isUpperCase(str.charAt(0)) || str.contains("__")) {
            System.out.println("Error!");
            return;
        }

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '_') isCpp = true;
            if(Character.isUpperCase(str.charAt(i))) isJava = true;
        }

        if(isCpp && isJava) {
            System.out.println("Error!");
            return;
        }

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            if(c == '_') { 
                i++;
                word.append(Character.toUpperCase(str.charAt(i)));
                continue;
            }

            if(Character.isUpperCase(c)) { // java 가능성 있음
                word.append("_").append(Character.toLowerCase(c));
                continue;
            }

            word.append(c);
        }

        System.out.println(word);
    }
}