package Kyu5;




/*Move the first letter of each word to the end of it,
 then add "ay" to the end of the word. Leave punctuation marks untouched.*/
public class SimplePigLatin {
    public static void main(String[] args) {

        System.out.println(pigLatin("Pig latin is cool"));
        System.out.println(pigLatin("Hello world !"));
        System.out.println(pigLatin("This is my string"));
        System.out.println(pigLatin("Oqe[]"));
    }
    public static String pigLatin(String str){
        var arr=str.split(" ");
        StringBuilder aux=new StringBuilder("");
        String first;
        int distancia=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].matches("^[A-Za-z ]+$")){
                if(i!=0){
                    distancia=aux.length()-1;
                    aux.append(arr[i]);
                    aux.deleteCharAt(distancia+1);
                    first=arr[i].substring(0,1);
                    aux.append(first).append("ay");
                    if (i != arr.length - 1) {
                        aux.append(" ");
                    }

                }else{
                    aux.append(arr[i]);
                    first=arr[i].substring(0,1);
                    aux.deleteCharAt(distancia);
                    aux.append(first).append("ay ");
                }

            }else{
                aux.append(arr[i]);
            }

        }
        return String.valueOf(aux).trim();
    }

    public static String solucion2(String str){

        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.matches("\\w+")) {
                String transformedWord = word.replaceFirst("(\\w)(\\w*)", "$2$1ay");
                result.append(transformedWord).append(" ");
            } else {
                result.append(word);
            }
        }

        return result.toString().trim();

    }


}
