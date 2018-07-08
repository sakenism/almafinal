package com.example.saken.vst;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.saken.vst.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.Boolean.*;

public class MainActivity extends AppCompatActivity {

    private Button buttonQuests, buttonAchive, buttonAlbums;
    String filename = "myfile";
    String fileContents = "Hello world!";
    FileOutputStream outputStream;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonQuests = (Button) findViewById(R.id.buttonQuests);
        buttonQuests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuests();
            }
        });
        buttonAchive = (Button) findViewById(R.id.buttonAchive);
        buttonAchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAchivements();
            }
        });
        buttonAlbums = (Button) findViewById(R.id.buttonAlbums);
        buttonAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbums();
            }
        });

    }

    public void openQuests(){
        Intent intent = new Intent(this, Quests.class);
        startActivity(intent);
    }
    public void openAchivements(){
        Intent intent = new Intent(this, Achivements.class);
        startActivity(intent);
    }

    public void openAlbums(){
        Intent intent = new Intent(this, Albums.class);
        startActivity(intent);
    }
}
