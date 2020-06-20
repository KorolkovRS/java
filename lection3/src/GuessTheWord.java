import java.util.Random;
import java.util.Scanner;

/**
 * 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
 * "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
 * "potato"};
 * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
 * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые
 * стоят на своих местах.
 * apple – загаданное
 * apricot - ответ игрока
 * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 * Для сравнения двух слов посимвольно, можно пользоваться:
 * String str = "apple";
 * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
 * Играем до тех пор, пока игрок не отгадает слово
 * Используем только маленькие буквы
 */

public class GuessTheWord {
    private static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
	// write your code here
        String answer;
        String word = makeWord();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Попробуйте угадать слово, или введите exit, чтобы закончить");
            answer = scanner.nextLine();
            if(answer.equals("exit")) {
                System.out.println("Игра окончена!");
                break;
            }
            else if(answer.equals(word)) {
                System.out.printf("Загаданное слово - %s. Вы победили!\nИгра окончена\n", word);
                break;
            }
            else {
                System.out.println("Неверно");
                openLetters(answer, word);
            }
        }
        scanner.close();
    }

    public static String makeWord() {
        return words[new Random().nextInt(words.length)];
    }

    public static void openLetters(String answer, String word) {
        for (int i = 0; i < 15; i++) {
            if(i < word.length() && i < answer.length()) {
                if(word.charAt(i) == answer.charAt(i)) {
                    System.out.print(word.charAt(i));
                }
                else {
                    System.out.print('#');
                }
            }
            else {
                System.out.print('#');
            }
        }
        System.out.println();
    }
}
