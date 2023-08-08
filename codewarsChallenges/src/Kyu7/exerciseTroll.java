package Kyu7;
/*Trol exercise */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class exerciseTroll {
    public static void main(String[] args) {
        System.out.println(manera2("This website is for losers LOL!"));
        System.out.println(manera2("No offense but,\nYour writing is among the worst I've ever read"));
        System.out.println(manera2("What are you, a communist?"));
        System.out.println("------------------");
        System.out.println(maneraDeclarativa("This website is for losers LOL!"));
        System.out.println(maneraDeclarativa("No offense but,\nYour writing is among the worst I've ever read"));
        System.out.println(maneraDeclarativa("What are you, a communist?"));
        System.out.println("-----------------");
        System.out.println(manera1("This website is for losers LOL!"));
        System.out.println(manera1("No offense but,\nYour writing is among the worst I've ever read"));
        System.out.println(manera1("What are you, a communist?"));
    }



    public static String manera1(String str){
        StringBuilder aux=new StringBuilder();
        for (char letra : str.toCharArray()) {
            switch (letra) {
                case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U':
                    break;
                default:
                    aux.append(letra);
                    break;
            }
        }
        return aux.toString();
    }
    public static String manera2(String str) {
        String [] string=str.split("");
        Pattern patron=Pattern.compile("[^aeiou]",Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        StringBuilder aux=new StringBuilder();

        for (String s : string) {
            matcher = patron.matcher(s);
            if (matcher.find()) {
                aux.append(s);
            }
        }

        return aux.toString();
    }
    public static String maneraDeclarativa(String str){
        return Stream.of(str.split("")) // 1.new String[]-> 2.Stream<String[]>
                .filter(string->Pattern.compile("[^aeiou]",Pattern.CASE_INSENSITIVE)
                        .asPredicate()
                        .test(string))
                .collect(Collectors.joining());
    }

}
