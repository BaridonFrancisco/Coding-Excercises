package Kyu6;

public class Count_the_smiley_faces {
    public static void main(String[] args) {

    }
    public static int countSmileys(String [] arr){
        String obligatoriosNarizBoca=":;D)";
        for (String s:arr){
            if(s.startsWith(":")||s.startsWith(";")){

            }
        }
        return 0;
    }
}
//Exercises
/*Given an array (arr) as an argument complete the function countSmileys
 that should return the total number of smiling faces
 rules:
 ->Each smiley face must contain a valid pair of eyes.Eyes can be marked as : or ;
 ->A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
 ->Every smiling face must have a smiling mouth that should be marked with either ) or D*/