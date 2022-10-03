import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YandexPlagiat {
    final static int ALPHABET_LENGTH = 26;

    final static int ALPHABET_START_CODE = 65;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        // читаю строку загадку в байтовый массив
        byte[] secretWord = reader.readLine().getBytes();

        // читаю строку попытки в байтовый массив
        byte[] attemptWord = reader.readLine().getBytes();


        // массив алфавит на 26 заглавных букв A-Z, здесь буду хранить количество букв встречающихся с строке загадке
        int[] alphabet = new int[26];

        // пробегаю циклом по длинне массива загадки (строки равны по длинне согласно условию)
        for (int i = 0; i < secretWord.length; i++) {
            // если совпали юникод номера букв загадки и попытки,
            // эту ячеку массива попытки приравниваю -2, в дальнейшем это будет correct
            if (secretWord[i] == attemptWord[i]) {
                attemptWord[i] = -2;
            } else {
                // иначе в массиве алфавита увеличиваю ячейку [(номером буквы из строки загадки) - 65]
                alphabet[secretWord[i] - 65]++;
            }
        }
        // пробегаю циклом по массиву попытки
        for (int i = 0; i < attemptWord.length; i++) {
            // если в ячейке попытки есть значение -2 значит она уже отмечена как correct
            if (attemptWord[i] == -2) continue;
            // проверяю, какое значение для текущей буквы лежит в алфавите
            // если больше 0, значит эта буква где в тексте встречалась,  и она не correct,
            if (alphabet[attemptWord[i] - 65] > 0) {
                // в алфавите значение ячейки текущей буквы попытки  уменьшаю
                alphabet[attemptWord[i] - 65] -= 1;
                // текущую ячейку попытки приравниваю -1, в дальнейшем это будет present
                attemptWord[i] = -1;
            }
        }
        for (int value : attemptWord) {
            System.out.print(value == -2 ? "P" : value == -1 ? "S" : "I");
        }
        System.out.println();
    }
}