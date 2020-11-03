package com.example.myapplication.models;

import java.util.ArrayList;

public class Words {
    private ArrayList Words = new ArrayList();
    public ArrayList getWordList(int listNumber){
        switch (listNumber){
            // dyr
            case 1:
                Words.add("ged");
                Words.add("fisk");
                Words.add("hund");
                Words.add("kat");
                break;
        }
        return Words;
    }
}
