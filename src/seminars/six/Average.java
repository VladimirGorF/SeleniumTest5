package seminars.six;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Average {


    public String averageList(double[] list1, double[] list2) {
        if(list1.length == 0 || list2.length == 0){
            throw new RuntimeException("Ошибка");
        }
        double sum1 = 0;
        for (double num : list1
        ) {
            sum1 += num;
        }
        double avg1 = sum1 / list1.length;

        double sum2 = 0;
        for (double num : list2
        ) {
            sum2 += num;
        }
        double avg2 = sum2 / list2.length;
        if (avg1 > avg2){
            return "Первый список имеет большее среднее значение";
        } else if (avg2 > avg1){
            return "Второй список имеет большее среднее значение";
        }
        return "Средние значения равны";
    }

}
