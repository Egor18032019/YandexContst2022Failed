import java.util.Scanner;

public class Rebuce {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int lengthWord = console.nextInt();
        int prev = 0;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
        // строчные буквы латинского алфавита или пробел
        for (int i = 0; i < lengthWord; i++) {
            int next = console.nextInt();
            int index = (int) (Math.log(
                    Math.abs(next - prev)
            ) / Math.log(2)
            );
            System.out.print(alphabet[index]);
            prev = next;
        }
    }
}
// 1 2049 2305 2309 2325  alice
/*
a = 1 [0]
l = 2049 - 1     = 2048 [11]
i = 2305 - 2049  = 256  [8]
c = 2309 - 2305  = 4    [2]
e = 2325 - 2309  = 16   [4]
По человечески нельзя что ли было написать !!!
 */