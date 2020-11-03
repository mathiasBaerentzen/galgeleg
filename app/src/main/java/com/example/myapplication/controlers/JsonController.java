package com.example.myapplication.controlers;
import android.content.Context;

import com.google.gson.*;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonController {
    public void JsonCotroller(){

    }
    public void SaveJsonObject(Context context, String playerName, String word, int attemps) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("playerName", playerName);
        jsonObject.addProperty("word", word);
        jsonObject.addProperty("attemps", attemps);
        String userString = jsonObject.toString();

        File file = new File(context.getFilesDir(),"HighScore.json");
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(userString).append("\n");
        bufferedWriter.close();
    }
    public ArrayList<String> LoadJsonFile(Context context) throws IOException {
        File file = new File(context.getFilesDir(),"HighScore.json");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> highScore = new ArrayList<String>();
        String line = bufferedReader.readLine();
        while (line != null){
            highScore.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();


        return highScore;
    }

}
