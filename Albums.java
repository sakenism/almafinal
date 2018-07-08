package com.example.saken.vst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


import com.example.saken.vst.R;

public class Albums extends AppCompatActivity {
    private Button buttonTakePhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        buttonTakePhoto = (Button) findViewById(R.id.button_image);
        buttonTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMakePhoto();
            }
        });
    }

    public void openMakePhoto(){
        Intent intent = new Intent(this, com.example.saken.vst.CameraPictureActivity.class);
        startActivity(intent);
    }
}
