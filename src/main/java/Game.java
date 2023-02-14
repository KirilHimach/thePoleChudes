import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Game {
    private static final String[] words = {"Apple", "Banana", "Chess", "Field", "Ball", "Tennis",
            "Minsk", "Pen", "Eraser", "Laptop"};
    private static final String[] prizes = {"Bentley", "Iphone 14 pro max", "Vacuum cleaner", "Cup", "Beer"};
    private static String randomWord;
    private static String[] randomWordToArray;
    private static String[] inputFigures;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("����� ���������� � ���� ���� �����!");
        System.out.println("��� ���������� ���� ������� \"exit\"");
        System.out.print("������� ���� ���: ");
        String namePlayer = scanner.nextLine();
        System.out.printf("%s, � ������� �����! �� ������ �������� ��� ��������� ��� �� ������. " +
                "������ ����� ��� � �������. �������!\n", namePlayer);
        System.out.println("����� ������� ������ �� ���� ���������� ��������!");
        randomWord = words[getRandomNumberFromWords()].toLowerCase(Locale.ROOT);
        randomWordToArray = randomWord.split("");
        inputFigures = initializationArray();
        while (true) {
            System.out.print("����: ");
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
            }
        }

    }
    private static int getRandomNumberFromWords() {
        return (int) (Math.random() * words.length);
    }

    private static int getRandomNumberFromPrizes() {
        return  (int) (Math.random() * prizes.length);
    }

    private static String[] initializationArray() {
        String[] array = new String[randomWordToArray.length];
        Arrays.fill(array, "_");
        return array;
    }

    private static void printMessageExit() {
        System.out.println("� ��������� ����� - " + randomWord);
        System.out.println("���� ��������");
    }

    private static void printMessageWinAllWord() {
        System.out.println("����������! �� ������� " + prizes[getRandomNumberFromPrizes()]);
        System.out.println("������� ������ ������� �� �����)");
    }

    private static void printMessageSpell(String box) {
        for (int i = 0; i < inputFigures.length; i++) {
            if (inputFigures[i].equals("_") && randomWordToArray[i].equalsIgnoreCase(box)) {
                inputFigures[i] = box;
                System.out.println("��� ������ �����!");
                System.out.println(Arrays.toString(inputFigures));
                return;
            }
        }
        System.out.println("����� ����� ���");
    }

}
