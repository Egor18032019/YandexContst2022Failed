import java.util.Scanner;

public class Main {
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char[] punctuation = ",.!?-".toCharArray();

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\.");
        StringBuilder response = new StringBuilder();
            for (int q = 0; q < line.length; q++) {
                String[] point = line[q].split(" ");
                for (int i = 0; i < point.length - 1; i++) {
                    String word = point[i];
                    if (word.equals("Мистера")) {
                        System.out.println(word);
                    }
                    if (!word.toLowerCase().equals(word) && isRussian(word)) {
                        String nextWord = point[i + 1];
                        if (!nextWord.toLowerCase().equals(nextWord) && isRussian(nextWord)) {
                            word = cleanWord(word);
                            nextWord = cleanWord(nextWord);
                            if (q == 0) {
                                response.append(word);
                                response.append(" ");
                                response.append(nextWord);
                            } else {
                                response.append(", ");
                                response.append(word);
                                response.append(" ");
                                response.append(nextWord);
                            }
                            i = i + 1;
                        }
                    }

                }
            }
            System.out.println(response);
        }

    }

    public static boolean isRussian(String word) {
        char[] array = word.toCharArray();
        for (char letter : array) {
            for (char type : alphabet) {
                if (letter == type) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String cleanWord(String word) {
        return word.replaceAll("[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]", "");
    }
}