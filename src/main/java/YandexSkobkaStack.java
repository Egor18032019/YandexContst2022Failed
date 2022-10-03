import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class YandexSkobkaStack {
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

// }{}{}
    private static void run() throws IOException {
        String first = bufferedReader.readLine();
        String foo = first.trim();
        Stack<Integer> stack = new Stack<>();
        // завожу счетчик-нумерации символов строки ,
        int count = 0;
        char[] firstLine = foo.toCharArray();
        bufferedReader.close();
        for (int i = 0; i < firstLine.length; i++) {
            {
                char iter = firstLine[i];
                count++;
                // при парности скобок (см. ниже условие заполнения верхнего значения) удаляю из стека верхнее значение
                if (iter == '}' && stack.size() > 0 && stack.peek() > 0) {
//                    System.out.println(stack.peek());
                    stack.pop();
                    continue;
                }
                // при остутствии пары, добавляю в стек счеткик с + либо -
                if (iter == '}') stack.add((count) * -1);
                if (iter == '{') stack.add((count));

            }

            // если в стеке один элемент - последовательность почти правильная
            // вывожу модуль count(номер символа в строке формулы)
            // В остальных случаях -1 согласно условию задачи
        }
        System.out.println(stack.size() == 1 ? Math.abs(stack.pop()) : -1);
    }
}
// }{}}}{{