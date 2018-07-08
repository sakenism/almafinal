package com.example.saken.vst;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.constraint.solver.GoalRow;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saken.vst.R;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestBus extends AppCompatActivity {

    private Button done, next, last1, last2, last3, last4;
    private boolean ok;
    //SQLiteDatabase db;
    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_bus);
        textViewMessage = (TextView) findViewById(R.id.retrieve);
        textViewMessage.setVisibility(View.GONE);
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

        last1 = (Button) findViewById(R.id.buttonLast1);
        last1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = Get(view), tmp1 = new String();

                for(int i = 0; i < tmp.length(); i++){
                    if(i == 0)
                        tmp1 += "1";
                    else
                        tmp1 += tmp.charAt(i);
                }
                Insert(tmp1);
                openAlbums();
            }
        });

        last2 = (Button) findViewById(R.id.buttonLast2);
        last2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = Get(view), tmp1 = new String();

                for(int i = 0; i < tmp.length(); i++){
                    if(i == 1)
                        tmp1 += "1";
                    else
                        tmp1 += tmp.charAt(i);
                }
                Insert(tmp1);
                openAlbums();
            }
        });

        last3 = (Button) findViewById(R.id.buttonLast3);
        last3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = Get(view), tmp1 = new String();

                for(int i = 0; i < tmp.length(); i++){
                    if(i == 2)
                        tmp1 += "1";
                    else
                        tmp1 += tmp.charAt(i);
                }
                Insert(tmp1);
                openAlbums();
            }
        });

        last4 = (Button) findViewById(R.id.buttonLast4);
        last4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = Get(view), tmp1 = new String();

                for(int i = 0; i < tmp.length(); i++){
                    if(i == 3)
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
    public void mark(){
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://2gis.kz/almaty/search/jlc?queryState=center%2F76.929188%2C43.241952%2Fzoom%2F13"));
        //ok = true;
        //onBackPressed();
        //String uri = "http://maps.google.com/maps?saddr=" + 43.1984656 + "," + 76.8816376+ "&daddr=" + 43.259581 + "," + 76.944809;
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(viewIntent);

    }
    public void goNext(){
        Intent intent = new Intent(this, com.example.saken.vst.QuestHistory.class);
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
    //String bl = "1000110";

    //db.execSQL("Insert into MyTable values(bl);");

    /*
    public void Get(){
        Cursor c;
        int tmp;
        String data;
        data = "";
        c = db.rawQuery("Select + from Mytable;", null);
        c.moveToLast();
        for(int i = 0; c.moveToPosition(i); i++){
            tmp = c.getInt(0);
            data += Integer.toString(tmp) + "\n";
        }
        ((TextView)findViewById(R.id.bus)).setText(data);

    }
    */
}
