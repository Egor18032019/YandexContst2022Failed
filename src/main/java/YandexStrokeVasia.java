import java.util.*;
import java.util.stream.Collectors;

public class YandexStrokeVasia {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String richStroke = in.next();
        String stroke = in.next();
//        System.out.println(richStroke + " " + stroke);
        // d b l r
        LinkedList<Character> result = new LinkedList<>();
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < stroke.length(); i++) {
            char point = stroke.charAt(i);
            if (point == '<') {
// берем следующее
                flag = false;
// взяли следующее и поняли что за команда
                char pointNext = stroke.charAt(i + 1);
                //перепрыгнули дальше
                i = i + 4;
                if (pointNext == 'd') {
                    if (index < result.size()) {
                        result.remove(index);
                    }
                    continue;
                }
                if (pointNext == 'b') { //bspace
                    if (index - 1 >= 0) {
                        index = index - 1;
                        result.remove(index);
                    }
                    continue;
                }
                if (pointNext == 'l') {
                    if (index - 1 >= 0) {
                        index = index - 1;
                    }
                    continue;
                }
                if (pointNext == 'r') {
                    if (index +1<=result.size()) {
                        index = index + 1;
                    }
                    continue;
                }
            }
            if (point == '>') {
// убираем флаг
                flag = true;
                continue;
            }
            if (flag) {
                result.add(index, point);
                index++;
            }
        }

        String result1 = result.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining());


        if (result1.equals(richStroke)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
/*
hellochild
helto<left><bspace>l<delete>ochilds<bspace>
hellochild

 */