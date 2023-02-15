import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final String[] wordsArray = {"Apple", "Banana", "Chess", "Field", "Ball", "Tennis",
            "Minsk", "Pen", "Eraser", "Laptop"};
    private static final String[] prizes = {"Bentley", "Iphone 14 pro max", "Vacuum cleaner", "Cup", "Beer"};
    private static String randomWord;
    private static String[] randomWordToArray;
    private static String[] inputFigures;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру Поле чудес!");
        System.out.println("Для завершения игры введите \"exit\"");
        System.out.print("Введите Ваше имя: ");
        String namePlayer = scanner.nextLine();
        System.out.printf("%s, я загадал слово! Ты можешь отгадать его полностью или по буквам. " +
                "Просто вводи его в консоль. Поехали!\n", namePlayer);
        System.out.println("Слово состоит только из букв латинского алфавита!");
        randomWord = wordsArray[getRandomNumberFromWords()];
        randomWordToArray = randomWord.toLowerCase(Locale.ROOT).split("");
        inputFigures = initializationArray();
        while (true) {
            System.out.print("Ввод: ");
            String box = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (box.equals("exit")) {
                printMessageExit();
                return;
            } else if (box.equalsIgnoreCase(randomWord)) {
                printMessageWinAllWord();
                return;
            } else if (box.length() == 1) {
                printMessageSpell(box);
                if (Arrays.equals(randomWordToArray, inputFigures)) {
                    printMessageWinAllWord();
                    return;
                }
            } else {
                System.out.println("Нет, это не " + box);
                System.out.println();
            }
        }

    }
    private static int getRandomNumberFromWords() {
        return new Random().nextInt(wordsArray.length);
    }

    private static int getRandomNumberFromPrizes() {
        return  new Random().nextInt(prizes.length);
    }

    private static String[] initializationArray() {
        String[] array = new String[randomWordToArray.length];
        Arrays.fill(array, "_");
        return array;
    }

    private static void printMessageExit() {
        System.out.println();
        System.out.println("Я загадывал слово - " + randomWord);
        System.out.println("Игра окончена");
    }

    private static void printMessageWinAllWord() {
        System.out.println();
        System.out.println("Верно! Это слово - " + randomWord);
        System.out.println("Поздравляю! Ты выиграл " + prizes[getRandomNumberFromPrizes()]);
        System.out.println("Подарок можешь забрать на почте)");
    }

    private static void printMessageSpell(String box) {
        for (int i = 0; i < inputFigures.length; i++) {
            if (inputFigures[i].equals("_") && randomWordToArray[i].equalsIgnoreCase(box)) {
                inputFigures[i] = box;
                System.out.println("Это верная буква!");
                System.out.println(Arrays.toString(inputFigures));
                System.out.println();
                return;
            }
        }
        System.out.println("Такой буквы нет");
        System.out.println();
    }

}
