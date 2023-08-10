package Kyu6;


import java.util.ArrayList;
import java.util.Arrays;

/** Your goal in this kata is to implement a difference function,
* which subtracts one list from another and returns the result.
It should remove all values from list a, which are present in list b keeping their order.
Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
If a value is present in b, all of its occurrences must be removed from the other:
Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}*/


public class diffArr {
    public static void main(String[] args) {
        int [] arrA={1,2};
        int [] arrB={1,1,2,4,5,1};
        imprimirArr(arrDiff(arrA,arrB));


    }
    public static int[] arrDiff(int []arrA, int []arrB){

        Arrays.sort(arrA);
        Arrays.sort(arrB);
        /*  int [] arrA={1,2};
            int [] arrB={1,1,2,4,5,1}; */
        imprimirArr(arrA);
        System.out.println(" ");
        imprimirArr(arrB);
        System.out.println(" ");
        boolean encontradoA;
        ArrayList<Integer> aux = new ArrayList<>();
        for (int num : arrB) {
            encontradoA = false;
            for (int i : arrA) {
                if (num == i) {
                    encontradoA = true;
                    break;
                }

            }
            if (!encontradoA) {
                aux.add(num);
            }
        }
        int[] arr =new int[aux.size()];
       for (int i=0;i<arr.length;i++){
           arr[i]=aux.get(i);
       }
       return arr;
    }


    public static void imprimirArr(int []arr){
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
}
