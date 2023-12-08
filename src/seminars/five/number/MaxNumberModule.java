package seminars.five.number;

import java.util.ArrayList;

import static java.util.Collections.max;

public class MaxNumberModule {


    public int getMax(ArrayList<Integer> array) {
        int max = 0;
        for (int num:array
             ) {
            if(num > max) max = num;
        }
        return max;
    }
}
