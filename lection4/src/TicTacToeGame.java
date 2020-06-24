import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private static char playerChip;     //фишка игрока
    private static char aIChip;         //фишка компьютера
    private static final char padChar = '-';        //символ пустого поля
    private static Scanner scanner = new Scanner(System.in);
    private static char[][] gameField = null;   //игровое поле

    public static void main(String[] args) {
        /*Предложение сыграть*/
        while (true) {
            System.out.println("Do your wanna play the game?\nEnter \"y\" for start tic tac toe");
            if((scanner.next()).equals("y")) {
                playGame();
            }
            else {
                break;
            }
        }
        scanner.close();
    }

    /**
     * Основная функция игры
     */
    public static void playGame() {
        int choose;
        boolean isBreak = false;

        /*Выбрать режим игры 3х3 или 5х5*/
        do {
            System.out.println("Choose game field:");
            System.out.println("Enter \"1\" for play 3x3:");
            System.out.println("Enter \"2\" for play 5x5:");
            choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    createField(3);
                    isBreak = true;
                    break;
                }
                case 2: {
                    createField(5);
                    isBreak = true;
                    break;
                }
                default:
                    System.out.println("Wrong choose.");
                    break;
            }
        }
        while(!isBreak);

        /*Жеребьевка*/
        boolean moveFlag = playerFirst();

        if (moveFlag) {
            playerChip = 'X';
            aIChip = 'O';
            System.out.println("Your chip is \"X\"");
            printField();
        }
        else {
            playerChip = 'O';
            aIChip = 'X';
            System.out.println("Your chip is \"O\"");
        }

        System.out.println("Welcome to the game!");

        /*Игровой процесс*/
        for (int i = 0;; i++) {
            if(endTheGameCheck((gameField.length == 3) ? 3 : 4)) {
                getWinner(moveFlag);
                break;
            }
            if (i >= gameField.length * gameField[0].length) {
                System.out.println("StandOff");
                break;
            }
            moveFlag = move(moveFlag);
            printField();
        }
    }

    /**
     * Создать массив игрового поля и инициализировать его ячейки символом '-'.
     * @param size размер игрового поля.
     */
    private static void createField(int size) {
        gameField =  new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameField[i][j] = padChar;
            }
        }
    }

    /**
     * Вывод текущего состояния игрового поля на экран
     */
    private static void printField() {
        System.out.println("Updating...");
        System.out.println("********************");
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Жеребьевка
     * @return
     */
    private static boolean playerFirst() {
         return new Random().nextBoolean();
    }

    /**
     * Проверка условий завершения игры
     * @param sequence число фишек в ряд, необходимое для выигрыша
     * @return true - есть победитель.
     */
    private static boolean endTheGameCheck(int sequence) {
        for (int i = 0; i < gameField.length; i++) {
            if (checkHorizontalLine(i, sequence)) {
                return true;
            }
        }

        for (int j = 0; j < gameField.length; j++) {
            if (checkVerticalLine(j, sequence)) {
                return true;
            }
        }
        if (gameField.length == 3) {
            if (checkDiagonalLine(sequence)) {
                return true;
            }
        }
        else {
            if (checkDiagonalLine(sequence, 0, 3, 0, 3))
                return true;
            else if (checkDiagonalLine(sequence, 1, 4, 0, 3))
                return true;
            else if (checkDiagonalLine(sequence, 0, 3, 1, 4))
                return true;
            else if (checkDiagonalLine(sequence, 1, 4, 1, 4))
                return true;
        }
        return false;
    }

    /**
     * Проверить горизонтальную линию на наличие победителя
     * @param i номер линии
     * @param sequence число фишек в ряд, необходимое для выигрыша
     * @return true - есть победитель.
     */
    private static boolean checkHorizontalLine(int i, int sequence) {
        int count = 0;
        for (int j = 1; j < gameField[i].length; j++) {
            if (gameField[i][j] != padChar && gameField[i][j - 1] == gameField[i][j]) {
                if (++count == sequence - 1) {
                    return true;
                }
            }
            else {
                count = 0;
            }
        }
        return false;
    }

    /**
     * Проверить вертикальную линию на наличие победителя
     * @param j номер линии
     * @param sequence число фишек в ряд, необходимое для выигрыша
     * @return true - есть победитель.
     */
    private static boolean checkVerticalLine(int j, int sequence) {
        int count = 0;
        for (int i = 1; i < gameField.length; i++) {
            if (gameField[i][j] != padChar && gameField[i - 1][j] == gameField[i][j]) {
                if (++count == sequence - 1) {
                    return true;
                }
            }
            else {
                count = 0;
            }
        }
        return false;
    }

    /**
     * Проверить диагонали на наличие победителя для режима 3х3
     * @param sequence число фишек в ряд, необходимое для выигрыша
     * @return true - есть победитель.
     */
    private static boolean checkDiagonalLine(int sequence) {
        int count = 0;
        for (int i = 1, j = 1; i < gameField.length; i++, j++) {
            if (gameField[i][j] != padChar && gameField[i - 1][j - 1] == gameField[i][j]) {
                if (++count == sequence - 1)
                    return true;
            }
            else {
                count = 0;
            }
        }
        count = 0;

        for (int i = 1, j = gameField.length - 2; i < gameField.length; i++, j--) {
            if (gameField[i][j] != padChar && gameField[i - 1][j + 1] == gameField[i][j]) {
                if (++count == gameField.length - 1)
                    return true;
            }
            else {
                count = 0;
            }
        }
        return false;
    }

    /**
     * Проверить диагонали на наличие победителя для режима 5х5
     * @param sequence число фишек в ряд, необходимое для выигрыша
     * @param x1 - координата малого квадрата
     * @param x2 - координата малого квадрата
     * @param y1 - координата малого квадрата
     * @param y2 - координата малого квадрата
     * @return true - есть победитель.
     */
    private static boolean checkDiagonalLine(int sequence, int x1, int x2, int y1, int y2) {
        int count = 0;
        for (int i = y1 + 1, j = x1 + 1; i <= y1 || j <= x2; i++, j++) {
            if (gameField[i][j] != padChar && gameField[i - 1][j - 1] == gameField[i][j]) {
                if (++count == sequence - 1) {
                    return true;
                }
            }
            else {
                count = 0;
            }
        }
        count = 0;

        for (int i = y1 + 1, j = x2 - 1; i <= y2 || j >= x1; i++, j--) {
            if (gameField[i][j] != padChar && gameField[i - 1][j + 1] == gameField[i][j]) {
                if (++count == sequence - 1){
                    return true;
                }
            }
            else {
                count = 0;
            }
        }
        return false;
    }

    /**
     * Сделать очередной ход
     * @param moveFlag флаг смены хода
     * @return
     */
    private static boolean move(boolean moveFlag) {
        if(moveFlag) {
            playerMove();
            return !moveFlag;
        }
        aIMove();
        return !moveFlag;
    }

    /**
     * Ход игрока
     */
    private static void playerMove() {
        boolean isBreak = false;

        do {
            System.out.println("Enter X and Y coordinates from 1 to 3:");
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (setChip(x, y)) {
                gameField[y][x] = playerChip;
                isBreak = true;
            } else {
                System.out.println("Invalid range");
            }
        }
            while (!isBreak);
    }

    /**
     * Ход компьютера
     */
    private static void aIMove() {
        /*Проверка возможности завершить игру победой*/
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (setChip(i, j)) {
                    gameField[j][i] = aIChip;
                    if (endTheGameCheck((gameField.length == 3) ? 3 : 4)) {
                        return;
                    }
                    else gameField[j][i] = '-';
                }
            }
        }

        /*Блокировать ход противника, преводящий к победе*/
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (setChip(i, j)) {
                    gameField[j][i] = playerChip;
                    if (endTheGameCheck((gameField.length == 3) ? 3 : 4)) {
                        gameField[j][i] = aIChip;
                        return;
                    }
                    else gameField[j][i] = '-';
                }
            }
        }

        /*Если есть несколько фишек подряд - продолжать ряд*/
        for (int sequence = (gameField.length == 3) ? 3 : 4; sequence != 1 ; sequence--) {
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (setChip(i, j)) {
                        gameField[j][i] = aIChip;
                        if (isLine(sequence, i, j)) {
                            return;
                        }
                        else gameField[j][i] = '-';
                    }
                }
            }
        }

        /*Поставить фишку в случайное место*/
        int i, j;
        while (true) {
            i = new Random().nextInt(gameField.length - 1);
            j = new Random().nextInt(gameField.length - 1);
            if (setChip(i, j)) {
                gameField[j][i] = aIChip;
                break;
            }
        }
    }

    /**
     * Проверка наличия ряда фишек, за которые играет компьютер
     * @param sequence длинна ряда
     * @param x координата фишки
     * @param y координата фишки
     * @return true - есть ряд длинны sequence
     */
    private static boolean isLine(int sequence, int x, int y) {
        int count = 0;
        for (int i = y; i < gameField.length; i++) {
            if (gameField[i][x] != aIChip) {
                break;
            }
            if (++count == sequence) {
                return true;
            }
        }
        count = 0;
        for (int i = y; i >= 0; i--) {
            if (gameField[i][x] != aIChip) {
                break;
            }
            if (++count == sequence) {
                return true;
            }
        }
        count = 0;
        for (int i = x; i < gameField.length; i++) {
            if (gameField[y][i] != aIChip) {
                break;
            }
            if (++count == sequence) {
                return true;
            }
        }
        count = 0;
        for (int i = x; i >= 0; i--) {
            if (gameField[y][i] != aIChip) {
                count = 0;
                break;
            }
            if (++count == sequence) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверить, возможно ли поставить фишку на клетку с координатами
     * @param x
     * @param y
     * @return true - возможно
     */
    private static boolean setChip(int x, int y) {
        if (x < 0 || x >= gameField.length || y < 0 || y >= gameField.length || gameField[y][x] != '-') {
            return false;
        }
        return true;
    }

    /**
     * Объявить победителя
     * @param moveFlag текущий игрок
     */
    private static void getWinner(boolean moveFlag) {
        if(moveFlag) {
            System.out.println("You are lose");
        }
        else {
            System.out.println("You are Win!");
        }

    }
}
