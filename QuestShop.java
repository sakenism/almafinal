package com.example.saken.vst;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.saken.vst.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestShop extends AppCompatActivity{

    private boolean ok;
    private Button done, next, last1, last2, last3, last4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_shop);
        done = (Button) findViewById(R.id.buttonClick);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuests();
            }
        });
        next = (Button) findViewById(R.id.buttonNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goNext();
            }
        });

        last1 = (Button) findViewById(R.id.buttonLast5);
        last1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = Get(view), tmp1 = new String();

                for(int i = 0; i < tmp.length(); i++){
                    if(i == 4)
                        tmp1 += "1";
                    else
                        tmp1 += tmp.charAt(i);
                }
                Insert(tmp1);
                openAlbums();
            }
        });

        last2 = (Button) findViewById(R.id.buttonLast6);
        last2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = Get(view), tmp1 = new String();

                for(int i = 0; i < tmp.length(); i++){
                    if(i == 5)
                        tmp1 += "1";
                    else
                        tmp1 += tmp.charAt(i);
                }
                Insert(tmp1);
                openAlbums();
            }
        });

        last3 = (Button) findViewById(R.id.buttonLast7);
        last3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = Get(view), tmp1 = new String();

                for(int i = 0; i < tmp.length(); i++){
                    if(i == 6)
                        tmp1 += "1";
                    else
                        tmp1 += tmp.charAt(i);
                }
                Insert(tmp1);
                openAlbums();
            }
        });

        last4 = (Button) findViewById(R.id.buttonLast8);
        last4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = Get(view), tmp1 = new String();

                for(int i = 0; i < tmp.length(); i++){
                    if(i == 7)
                        tmp1 += "1";
                    else
                        tmp1 += tmp.charAt(i);
                }
                Insert(tmp1);
                openAlbums();
            }
        });
    }


    public void openQuests(){
        Intent intent = new Intent(this, com.example.saken.vst.Quests.class);
        startActivity(intent);
    }
    public void openAlbums(){
        Intent intent = new Intent(this, com.example.saken.vst.Albums.class);
        startActivity(intent);
    }

    public void Insert(String fileContents){
        String filename = "myfile";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
            //Toast.makeText(QuestBus.this, "SUCCESS", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String Get(View view){
        String Message;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            FileInputStream FS = openFileInput("myfile");
            InputStreamReader inputStreamReader = new InputStreamReader(FS);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while((Message = bufferedReader.readLine()) != null){

                stringBuffer.append(Message + "\n");
            }
            //textViewMessage.setText(stringBuffer.toString());
            //textViewMessage.setVisibility(View.VISIBLE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
    public void mark(){
        ok = true;
        onBackPressed();
    }

    public void goNext(){
        Intent intent = new Intent(this, com.example.saken.vst.QuestBus.class);
        startActivity(intent);
    }

}
