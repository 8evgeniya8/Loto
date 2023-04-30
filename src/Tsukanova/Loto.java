package Tsukanova;

import com.sun.source.util.SourcePositions;

import java.util.Arrays;
import java.util.Random;

// Зробити два масиви з 7 цифр, заповнених випадковими цифрами (від 0 до 9).
// Перший масив - це числа, які загадані фірмою-організатором лотереї.
//Другий масив - це числа, які вгадав гравець.
// Після того, як обидва масиви заповнені цифрами, потрібно відсортувати їх за зростанням будь-яким способом.
//У відсортованих масивах визначити кількість збігів, тобто чисел у двох масивах з однаковим індексом; Наприклад:
// first[3] повинен дорівнювати second[3], як показано нижче.
// Приклад виведення в консоль (збіглися 1й, 4й та 6й елементи):
//[0, 1, 4, 5, 5, 8, 9]
//[1, 1, 2, 3, 5, 6, 9]
//Кількість збігів: 3
public class Loto {
    public static void main(String[] args) {

        int[] array1 = new int[7];
        int[] array2 = new int[7];

        for (int i = 0; i < 7; i++) {
            array1[i] = (int) (Math.random() * 10);
            array2[i] = (int) (Math.random() * 10);
        }
        System.out.println("Рандом Array 1: " + Arrays.toString(array1));
        System.out.println("Рандом Array 2: " + Arrays.toString(array2));

        boolean boo = true;
        int start = 0;
        int start2 = 0;
        int end = array1.length;
        int end2 = array1.length;
        while (boo == true) {
            boo = false;
            for (int i = start; i < end - 1; ++i) {
                if (array1[i] > array1[i + 1]) {
                    int temp = array1[i];
                    array1[i] = array1[i + 1];
                    array1[i + 1] = temp;
                    boo = true;
                }
            }
            if (boo == false) {
                break;
            }
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (array1[i] > array1[i + 1]) {
                    int temp = array1[i];
                    array1[i] = array1[i + 1];
                    array1[i + 1] = temp;
                }
            }
            start = start + 1;
            boo = false;
            for (int i = start2; i < end2 - 1; ++i) {
                if (array2[i] > array2[i + 1]) {
                    int temp2 = array2[i];
                    array2[i] = array2[i + 1];
                    array2[i + 1] = temp2;
                    boo = true;
                }
            }
            if (boo == false) {
                break;
            }
            boo = false;
            end2 = end2 - 1;
            for (int i = end2 - 1; i >= start2; i--) {
                if (array2[i] > array2[i + 1]) {
                    int temp2 = array2[i];
                    array2[i] = array2[i + 1];
                    array2[i + 1] = temp2;
                    boo = true;
                }
            }
            start2 = start2 + 1;
        }
        System.out.println("Відсортована Array 1: " + Arrays.toString(array1));
        System.out.println("Відсортована Array 2: " + Arrays.toString(array2));

        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (i == j) {
                if (array1[i] == array2[j]) {
                    System.out.println("Збіг знайдено в індексі: " + i + " ; " + "Число: " + array2[j]);
                }
                i++;
                j++;
            } else if (array1[i] > array2[j]) {
                j++;
            } else {
                i++;
            }
        }
    }
}
