import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    /*

    1. Crear una función anónima que nos permita calcular el promedio de un arreglo de números enteros.
    2. Crear una función anónima que calcule el factorial dado un número entero.
    3. Crear una función anónima que permita conocer si un número es par.
    4. Dado un arreglo de números enteros, crear una función anónima que retorne el número mayor.
    5. Dado un arreglo de números enteros, crear una función anónima que retorne el número menor.
    6. Dado un arreglo de números enteros, crear una función anónima que retorne el número que más se repite.
    7. Crear una función anónima que reciba como parámetro 3 numeros enteros. La función retorna el número mayor.
    8. Crear una función anónima que reciba dos parámetros, un string y un número entero. La función retorna un string el cual será el resultado de multiplicar ambos parámetros.

    */



    static final Function<Integer,String> IsPair=(number)->{
        if(number%2==0)return "pair";
        return "odd";
    };

    static final Function<List<Integer>,Integer>numberMax=(list)->list.stream()
            .max(Integer::compareTo)
            .orElse(0);

    public static void main(String[] args) {

        List<Integer>intergers=new ArrayList<>();
        List<Float>floats=new ArrayList<>();

        float sum=0.0f;
        for (int i=0;i<10;i++){
            int n= new Random().nextInt(1,50);
            intergers.add(n);
            sum+= (float)n;
        }
        System.out.println(sum/intergers.size());

        var re= average(intergers,Double.class);
        System.out.println(re);

        floats.add(5.5f);
        floats.add(5.5f);
        floats.add(15.7f);
        System.out.println((5.5+5.5+15.7)/3.0);
        System.out.println(average(floats,Double.class));

        System.out.println(factorial(5));
        System.out.println(IsPair.apply(12));

        var listNums=generateListNums(10);
        System.out.println(listNums);
        Integer max=numberMax.apply(listNums);
        System.out.println("el maximo de la lista es "+max);

       /* int [] arr=new int[]{1,5,64,21,5,0};
        System.out.println(getMax(arr));*/



    }


    public static Number average(List<? extends Number> listnumbers,Class<? extends Number>type) {
        return listnumbers.stream()
                .mapMultiToDouble((element, doubleConsumer) -> doubleConsumer.accept(element.doubleValue()))
                .average()
                .orElse(0.0);

    }

    public static int factorial(int n){
       return IntStream.range(1,n+1)
                .reduce(1,(a,b)->a*b);
    }


    private static List<Integer> generateListNums(final long size) {
        var list= Stream.iterate(1, (a) -> {
                    Integer numRandom=new Random().nextInt(1, 5);
                    System.out.println("el valor inicial de la semilla es "+ (a));
                    System.out.println("el valor ramdom es "+ (numRandom));
                    System.out.println("la suma de a + aleatorio "+ (a+numRandom));
                    return numRandom + a;
                })
                .limit(size)
                .collect(Collectors.toList());
        Collections.shuffle(list);
        return list;

    }

    public static int getMax(int [] nums){
        int max=0;
        // 20 1 5
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max=nums[i];
            }
        }
        return max;

    }




}