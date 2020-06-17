import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] array = MyArray.createArray(10);
        int[] array2 = new int[] {2,2,2,1,2,2,10,1};
        System.out.println(Arrays.toString(array));
        System.out.println("Minimum element is: " + MyArray.findMin(array));
        System.out.println("Maximum element is: " + MyArray.findMax(array));
        System.out.println(MyArray.checkBalance(array2));
        System.out.println(MyArray.checkBalance(array));
        System.out.println(Arrays.toString(MyArray.shift(array, 12)));
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