import java.util.Arrays;

/**
 * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
 * 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
 * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
 * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
 */

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("\n***********Solution 1**************");
        int[] array1 = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        solutionOne(array1);
        printArray(array1);

        System.out.println("\n***********Solution 2**************");
        int[] array2 = new int[8];
        for (int i = 0, j = 0; i < array2.length; i++, j+=3) {
            array2[i] = j;
        }
        printArray(array2);

        System.out.println("\n***********Solution 3**************");
        int[] array3 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        solutionThree(array3);
        printArray(array3);

        System.out.println("\n***********Solution 4**************");
        int size = 5;
        int[][] array4 = new int[size][size];
        solutionFour(array4);


        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                System.out.print(array4[i][j] + " ");
                }
            System.out.println();
            }
        System.out.println("\n***********Solution 5**************");
        int[] array5 = MyArray.createArray(10);
        int[] array6 = new int[] {2,2,2,1,2,2,10,1};
        System.out.println(Arrays.toString(array5));
        System.out.println("Minimum element is: " + MyArray.findMin(array5));
        System.out.println("Maximum element is: " + MyArray.findMax(array5));
        System.out.println("\n***********Solution 6**************");
        System.out.println(MyArray.checkBalance(array6));
        System.out.println(MyArray.checkBalance(array5));
        System.out.println("\n***********Solution 7**************");
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(MyArray.shift(array5, 12)));
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("a[%d] = %d; ", i, array[i]);
        }
        System.out.println();
    }

    public static void solutionOne(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                array[i] = 1;
            }
            else {
                array[i] = 0;
            }
        }
    }

    public static void solutionThree(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    public static void solutionFour(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(i == j || i == array.length - 1 - j) {
                    array[i][j] = 1;
                }
            }
        }
    }

    public static class MyArray {
        /**
         * Создает массив интов
         * @param size размер создаваемого массива
         * @return созданный массив
         */
        public static int[] createArray(int size) {
            int[] array = new int[size];

            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * (201) - 100);
            }
            return array;
        }

        /**
         * Поиск минимального элемента в массиве
         * @param array массив, в котором осуществляется поиск
         * @return значение минимального элемента
         */
        public static int findMin(int[] array) {
            int min = array[0];

            for (int i = 0; i < array.length; i++) {
                if(array[i] < min) {
                    min = array[i];
                }
            }
            return min;
        }
        /**
         * Поиск максимального элемента в массиве
         * @param array массив, в котором осуществляется поиск
         * @return значение максимального элемента
         */
        public static int findMax(int[] array) {
            int max = array[0];

            for (int i = 0; i < array.length; i++) {
                if(array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }

        /**
         * Определяет, есть ли в массиве место, в котором сумма левой и правой части массива равны
         * @param array массив, в котором осуществляется поиск
         * @return true, если в массиве есть место, в котором сумма левой и правой части массива равны.
         * Иначе false
         */
        public static boolean checkBalance(int[] array) {
            if(array.length <= 1){
                return false; //или true, тут хз
            }
            for (int i = 0; i < array.length - 1; i++) {
                if(leftSum(array, i) == rightSum(array, i)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Вспомогательный метод, для метода checkBalance.
         * Вычисляет сумму элементов массива, левее индекса border (включительно)
         * @param array исходный массив
         * @param border граница
         * @return сумма элементов
         */
        private static int leftSum(int[] array, int border) {
            int sum = 0;
            for (int i = 0; i <= border ; i++) {
                sum += array[i];
            }
            return sum;
        }

        /**
         * Вспомогательный метод, для метода checkBalance.
         * Вычисляет сумму элементов массива, правее индекса border
         * @param array исходный массив
         * @param border граница
         * @return сумма элементов
         */
        private static int rightSum(int[] array, int border) {
            int sum = 0;
            for (int i = array.length - 1; i > border ; i--) {
                sum += array[i];
            }
            return sum;
        }

        /**
         * Циклический сдвиг массива
         * @param array исходный массив
         * @param offset на сколько элементов сдвигаем
         * @return массив после сдвига
         */
        public static int[] shift(int[] array, int offset) {
            offset %= array.length;
            for (int i = 0; i < Math.abs(offset); i++) {
                if(offset > 0) {
                    rightPop(array);
                }
                else {
                    leftPop(array);
                }
            }
            return array;
        }

        /**
         * Вспомогательный метод для метода shift
         * Сдвигает массив на 1 элемент вправо
         * @param array исходный массив
         */
        private static void rightPop(int[] array) {
            int buf = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = buf;
        }

        /**
         * Вспомогательный метод для метода shift
         * Сдвигает массив на 1 элемент влево
         * @param array исходный массив
         */
        private static void leftPop(int[] array) {
            int buf = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = buf;
        }
    }

}