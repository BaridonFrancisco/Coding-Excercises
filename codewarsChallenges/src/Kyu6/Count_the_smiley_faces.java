package Kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Count_the_smiley_faces {
    public static void main(String[] args) {
        List<String> smileys=new ArrayList<>();
        loadSmileys(smileys,":)",":D",":-}",":-()");
        System.out.println(countSmileys(smileys));
        List<String> smileys2=new ArrayList<>();
        loadSmileys(smileys2,":)","XD",":0}","x:-","):-","D:");
        System.out.println(countSmileys(smileys2));
        List<String> smileys3=new ArrayList<>();
        loadSmileys(smileys3,":)",":D","X-}","xo)",":X",":-3",":3");
        System.out.println(countSmileys(smileys3));
        List<String> smileys4=new ArrayList<>();
        loadSmileys(smileys4,":)",":)","x-]",":ox",";-(",";-)",";~(",":~D");
        System.out.println(countSmileys(smileys4));

    }
    public static int countSmileys(List<String>arr){
        if(arr.size()==0){
            return 0;
        }
        int count=0;
        String aux;
        boolean condicion;
        for(int i=0;i<arr.size();i++){
            aux= arr.get(i);
            condicion=(aux.startsWith(":")||aux.startsWith(";"))
                    && (aux.endsWith("D") || aux.endsWith(")"));
            if(aux.length()>=2 && aux.length()<4){
                if(aux.length()==2){
                    if(condicion){
                        count++;
                    }
                }else{
                    if(condicion && ((aux.charAt(1) == '~') || (aux.charAt(1)=='-'))){
                        count++;
                    }
                }

            }
        }
        return count;
    }
    public static void loadSmileys(List<String>arr,String... smileys){
        arr.addAll(Arrays.asList(smileys));
    }
}
//Exercises
/*Given an array (arr) as an argument complete the function countSmileys
 that should return the total number of smiling faces
 rules:
 ->Each smiley face must contain a valid pair of eyes.Eyes can be marked as : or ;
 ->A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
 ->Every smiling face must have a smiling mouth that should be marked with either ) or D*/