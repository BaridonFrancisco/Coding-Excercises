import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    /*

    Crear una función anónima que nos permita calcular el promedio de un arreglo de números enteros.
    Crear una función anónima que calcule el factorial dado un número entero.
    Crear una función anónima que permita conocer si un número es par.
    Dado un arreglo de números enteros, crear una función anónima que retorne el número mayor.
    Dado un arreglo de números enteros, crear una función anónima que retorne el número menor.
    Dado un arreglo de números enteros, crear una función anónima que retorne el número que más se repite.
    Crear una función anónima que reciba como parámetro 3 numeros enteros. La función retorna el número mayor.
    Crear una función anónima que reciba dos parámetros, un string y un numero entero. La función retorna un string el cual será el resultado de multiplicar ambos parámetros.*/


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

        var re= average(intergers);
        System.out.println(re);

        floats.add(5.5f);
        floats.add(5.5f);
        floats.add(15.7f);
        System.out.println((5.5+5.5+15.7)/3.0);
        System.out.println(average(floats));

        System.out.println(factorial(5));

    }

    
    public static  double average(List<? extends Number> listnumbers){
          return listnumbers.stream()
                   .mapMultiToDouble((element, doubleConsumer) -> doubleConsumer.accept(element.doubleValue()))
                   .average()
                   .orElse(0.0);
    }

    public static int factorial(int n){
       return IntStream.range(1,n+1)
                .reduce(1,(a,b)->a*b);

    }


}