package seminars.six;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AverageTest {

    @Test
        // Данный сценарий проверяет, что в случае если среднее значение массива 1 больше
        // чем в массиве 2, то мы получим сообщение "Первый список имеет большее среднее
        // значение"
    void avgList1MoreThanList2() {
        double[] list1 = {2, 2, 3, 4, 5};
        double[] list2 = {1, 2, 3, 4, 5};
        Average average = new Average();
        String res = average.averageList(list1, list2);
        assertEquals(res, "Первый список имеет большее среднее значение");
    }

    @Test
        // Данный сценарий проверяет, что в случае если среднее значение массива 2 больше
        // чем в массиве 1, то мы получим сообщение "Второй список имеет большее среднее
        // значение"
    void avgList2MoreThanList1() {
        double[] list1 = {1, 2, 3, 4, 5};
        double[] list2 = {2, 2, 3, 4, 5};
        Average average = new Average();
        String res = average.averageList(list1, list2);
        assertEquals(res, "Второй список имеет большее среднее значение");
    }

    @Test
        // Данный сценарий проверяет, что в случае если среднее значение массива 1 равно
        // среднему массива 2, то мы получим сообщение "Средние значения равны"
    void avgList1EqualsList2() {
        double[] list1 = {1, 2, 3, 4, 5};
        double[] list2 = {1, 2, 3, 4, 5};
        Average average = new Average();
        String res = average.averageList(list1, list2);
        assertEquals(res, "Средние значения равны");
    }

    @Test
        // Данный сценарий проверяет, что в случае если один из массивов пуст, то мы
        // получим выброс ошибки RuntimeException"
    void nullLists() {
        double[] list1 = {};
        double[] list2 = {1, 2, 3, 4, 5};
        Average average = new Average();
        assertThatThrownBy(() -> average.averageList(list1, list2)).isInstanceOf(RuntimeException.class);
    }
}