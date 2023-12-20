package Kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MeanSquareError {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        int[] a2 = {4, 5, 6};
        // 9
        System.out.println(solution(a1,a2));


        int[] b1 = {10, 20, 10, 2};
        int[] b2 = {10, 25, 5, -2};

        System.out.println(solution(b1,b2));

        int[] c1 = {0, -1};
        int[] c2 = {-1, 0};

        System.out.println(solution(c1,c2));


        int[] d1 = {10, 10};
        int[] d2 = {10, 10};

        System.out.println(solution(d1,d2));
    }

    //Imperativo
    /*1-aplicar valor absoluto
    * 2-sacar aplicar la diferencia entre los vectores
    * 3-almacenarlo en una lista
    * 4- promediar*/
    public static double solution(int[] arr1, int[] arr2) {
        List<Integer>aux=new ArrayList<>();
        if(arr1.length!=arr2.length){
            throw new IllegalArgumentException("la longitud es incorrecta");
        }

        for(int i=0;i<arr1.length;i++){
            Integer val=Math.abs(arr1[i]-arr2[i]);
            aux.add((val*val));
        }
       int total= aux.stream()
                .reduce(0, Integer::sum);
        //System.out.println(re);
        return (double) total /arr1.length;
    }
}
