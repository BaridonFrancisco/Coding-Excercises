import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
interface MaxVal{
    int getMax2(int a,int b,int c);
}


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


    static final Function<Integer, String> IsPair = (number) -> {
        if (number % 2 == 0) return "pair";
        return "odd";
    };

    static final Function<List<Integer>, Integer> numberMax = (list) -> list.stream()
            .max(Integer::compareTo)
            .orElse(0);

    static Function<List<Integer>, Integer> numberMin = list -> list
            .stream()
            .sorted(Integer::compareTo)
            .min(Comparator.naturalOrder())
            .orElse(0);

    public static void main(String[] args) {

        List<Integer> intergers = new ArrayList<>();
        List<Float> floats = new ArrayList<>();

        float sum = 0.0f;
        for (int i = 0; i < 10; i++) {
            int n = new Random().nextInt(1, 50);
            intergers.add(n);
            sum += (float) n;
        }
        System.out.println(sum / intergers.size());

        var re = average(intergers, Double.class);
        System.out.println(re);

        floats.add(5.5f);
        floats.add(5.5f);
        floats.add(15.7f);
        System.out.println((5.5 + 5.5 + 15.7) / 3.0);
        System.out.println(average(floats, Double.class));

        System.out.println(factorial(5));
        System.out.println(IsPair.apply(12));

        var listNums = generateListNums(10);
        System.out.println(listNums);


        Integer max = numberMax.apply(listNums);
        System.out.println("el maximo de la lista es " + max);

        Integer min = numberMin.apply(listNums);
        System.out.println("el minimo es " + min);

        List<Integer> listaNums = new ArrayList<>();
        listaNums.add(232);
        listaNums.add(21);
        listaNums.add(900);
        listaNums.add(121);
        listaNums.add(4);
        listaNums.add(1220);
        System.out.println(numberMin.apply(listaNums));


        int[] arr = new int[]{1, 5, 64, 21, -5, 0};
        System.out.println(getMax(arr));
        System.out.println(getMin(arr));

        int [] arr2=new int[]{2,3,41,61,2,3,4,3,3,5,2,5,5,5,5,3};

       var result= countNumbers(arr2);
        result.forEach(entry-> {

            if(result.size()==1){
                System.out.println("El numero que mas se repite es el "+entry.getKey()+" y se repite "+entry.getValue()+" veces");
                return;
            }
            System.out.println("El numero "+entry.getKey()+"  se repite "+entry.getValue()+" veces");
        });
        System.out.println("---");
        var result2=countNumbers2(arr2);
        result2.forEach(entry-> {

            if(result2.size()==1){
                System.out.println("El numero que mas se repite es el "+entry.getKey()+" y se repite "+entry.getValue()+" veces");
                return;
            }
            System.out.println("El numero "+entry.getKey()+"  se repite "+entry.getValue()+" veces");
        });

       int comparationVal=getMax(1,10,1);
        System.out.println(comparationVal);

      MaxVal maxVal=(a,b,c)-> Stream.of(a,b,c)
                .max(Integer::compareTo)
                .orElse(0);
      int valorMax=maxVal.getMax2(14,233,-24);
        System.out.println(valorMax);


    }


    public static Number average(List<? extends Number> listnumbers, Class<? extends Number> type) {
        return listnumbers.stream()
                .mapMultiToDouble((element, doubleConsumer) -> doubleConsumer.accept(element.doubleValue()))
                .average()
                .orElse(0.0);

    }

    public static int factorial(int n) {
        return IntStream.range(1, n + 1)
                .reduce(1, (a, b) -> a * b);
    }


    private static List<Integer> generateListNums(final long size) {
        var list = Stream.iterate(1, (a) -> {
                    Integer numRandom = new Random().nextInt(1, 24);
                    System.out.println("el valor inicial de la semilla es " + (a));
                    System.out.println("el valor ramdom es " + (numRandom));
                    System.out.println("la suma de a + aleatorio " + (a + numRandom));
                    return numRandom + a;
                })
                .limit(size)
                .collect(Collectors.toList());
        Collections.shuffle(list);
        return list;

    }

    public static List<Map.Entry<Integer,Long>> countNumbers(int[] arr) {
        var res = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()),
                        map -> map.entrySet()
                                .stream()
                                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))))
                .toList();
        return res.stream()
                .filter(entry ->
                        Objects.equals(res.stream().findFirst().orElse(null).getValue(), entry.getValue()))
                .toList();
    }
    // otra manera similar pero mas concisa y legible
    public static List<Map.Entry<Integer,Long>> countNumbers2(int[]arr){

       Map<Integer,Long>mapNumbers= Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

       long maxFrequency=mapNumbers.values().stream()
               .mapToLong(Long::valueOf)
               .max()
               .orElse(0L);

        return mapNumbers.entrySet().stream()
               .filter(entry->entry.getValue().equals(maxFrequency))
               .toList();
    }

    public static int getMax(Integer a,Integer b,Integer c){
      return Stream.of(a,b,c)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public static int getMax(int[] nums) {
        int max = 0;
        // 20 1 5
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        return max;

    }

    public static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int j : arr) {
            if (min > j) {
                min = j;
            }
        }
        return arr.length == 0 ? 0 : min;
    }


}