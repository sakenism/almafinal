package com.example.saken.vst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.saken.vst.R;

public class QuestHistory extends AppCompatActivity {

    private Button done, next;
    private boolean ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_history);
        done = (Button) findViewById(R.id.buttonClick);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mark();
            }
        });
        next = (Button) findViewById(R.id.buttonNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goNext();
            }
        });
    }
    public void mark(){
        ok = true;
        onBackPressed();
    }

    public void goNext(){
        System.out.print("Congratulations on passing all Quests, now you know the city better than its citizens!!!");
        /*try {
            Thread.sleep(3000);
        }
        catch (InterruptedException ex){
            android.util.Log.d("YourApplicationName", ex.toString());
        }*/
        Intent intent = new Intent(this, com.example.saken.vst.MainActivity.class);
        startActivity(intent);
    }

}
