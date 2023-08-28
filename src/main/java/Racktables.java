import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Racktables {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int z = 0; z < N; z++) {
            String[] firstLine = br.readLine().split(" "); // {foo} or {bar}
            /**
             * ( and )
             */
            int c = 0; //( and )
            /**
             * { and }
             */
            int b = 0; //{ and }
            /**
             * [ and ]
             */
            int a = 0; // [ and ]
            boolean answer = true;
            for (int i = 0; i < firstLine.length; i++) {
                String line = firstLine[i]; // {foo}
                boolean isHaveTextB = false;
                boolean isHaveTextA = false;
                String[] symbols = line.split(""); // {,f,o,o,}
                String prevSkobka = "";
                for (int x = 0; x < symbols.length; x++) {

                    String symbol = symbols[x]; // {

                    if (symbol.equals("(")) {
                        c++;
                        prevSkobka = "(";
                        continue;
                    }
                    if (symbol.equals(")")) {
                        c--;
//                        String prev = symbols[x - 1];
//                        boolean isHavePrevSkobku = prev.equals("}") || prev.equals("]") || prev.equals(")");
                        boolean isHavePrevSkobku = symbols.length == 1;
                        if (isHavePrevSkobku) {
                            answer = false;
                            break;
                        }
                        prevSkobka = ")";

                        continue;
                    }
                    //{ }
                    if (symbol.equals("{")) {
                        b++;
                        prevSkobka = "{";
                        continue;
                    }
                    if (symbol.equals("}")) {
                        if (isHaveTextB) {
                            b--;
                            prevSkobka = "}";
                            continue;
                        } else {
                            answer = false;
                            break;
                        }
                    }
                    // [ ]
                    if (symbol.equals("[")) {
                        a++;
                        prevSkobka = "[";
                        continue;
                    }
                    if (symbol.equals("]")) {
                        if (isHaveTextA) {
                            a--;
                            prevSkobka = "]";
                            continue;
                        } else {
                            answer = false;
                            break;
                        }
                    }
//                    (({tag} or [predicate]) and (not {tag-2} or {tag-3}))

                    if (Objects.equals(prevSkobka, "{")) {
                        isHaveTextB = true;
                    }
                    if (Objects.equals(prevSkobka, "[")) {
                        isHaveTextA = true;
                    }
                    if (Objects.equals(prevSkobka, "(")) {
                        if(i==firstLine.length-1)
                        answer = false;
                    }


                }


                if (!answer) {
                    break;
                }

            }

            if (!answer) {
                System.out.println("invalid");
            } else {
                answer = c == 0 && b == 0 && a == 0;
                if (answer) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            }

        }
    }
}
/*
Пример
Ввод

8
{foo]
{foo}
[bar]
[bar] and {}
[bar] or {foo}
not {foo}
not {foo} and ({foo}  or )
not {foo} and ([bar] or {foo-2})

Вывод

invalid
valid
valid
invalid
valid
valid
invalid
valid


/////
1
({tag} or [predicate]) and {tag-2}
 */