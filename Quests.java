package com.example.saken.vst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.saken.vst.R;

public class Quests extends AppCompatActivity {
    private Button buttonQuestsShop, buttonQuestsBus, buttonQuestsHistory;
    //private static boolean ok[] = new boolean[123];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quests);
        buttonQuestsShop = (Button) findViewById(R.id.buttonQuestsShop);
        buttonQuestsShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuestsShop();
            }
        });
        buttonQuestsBus = (Button) findViewById(R.id.buttonQuestsBus);
        buttonQuestsBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuestsBus();
            }
        });
        buttonQuestsHistory= (Button) findViewById(R.id.buttonQuestsHistory);
        buttonQuestsHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuestsHistory();
            }
        });
    }
    public void openQuestsShop(){
        Intent intent = new Intent(this, com.example.saken.vst.QuestShop.class);
        startActivity(intent);
    }

    public void openQuestsBus(){
        Intent intent = new Intent(this, com.example.saken.vst.QuestBus.class);
        startActivity(intent);
    }
    public void openQuestsHistory(){
        Intent intent = new Intent(this, com.example.saken.vst.QuestHistory.class);
        startActivity(intent);
    }
}
