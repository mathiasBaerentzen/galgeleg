package com.example.myapplication.controlers;

import com.example.myapplication.StringTole;

public class GameController {
    StringTole stringTole = new StringTole();
    public String runGame(String word, String choosenletter, String headerWord, int attemps) {



        for (int j = 0; j < word.length(); j++) {
            if (word.charAt(j) == choosenletter.charAt(0)) {
                headerWord = stringTole.changeCharInPosition(j, choosenletter.charAt(0), headerWord);
            }
        }
        if (winConditions(word, choosenletter, headerWord) == true) {
            return "true";
        }
        if(lostCondition(attemps) == false){
            return "false";
        }
        return headerWord;
    }
    public boolean winConditions(String Word, String choosenletter,String headerWord){
        if(Word.equals(choosenletter)){
            System.out.println("test");
            return true;
        }
        System.out.println(headerWord);
        if(!headerWord.contains("*")){

            return true;
        }
        // incase none of the conditions are met
        return false;
    }
    private boolean lostCondition(int i){
        //TXT_Attemps.setText("Forsøg: " + i);
        if(i == 0){
            return false;
        }
        // incase none of the condition are not met
        return true;
    }
}
