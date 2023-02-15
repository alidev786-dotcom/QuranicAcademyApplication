package com.example.quranicacademyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DataDisplay extends AppCompatActivity {

    //    TextView textView;
    EditText textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        textView = findViewById(R.id.editTextTextMultiLine2);

        Intent intent = getIntent();
        int num = intent.getIntExtra("ParahNum", 0);

        QDH Qdh = new QDH();
        int ayatStart = Qdh.SSP[num];
        int count = Qdh.surahAyatCount[num];

        QuranArabicText arb = new QuranArabicText();

        String text = "";
        for(int i = ayatStart; i < ayatStart+count; i++) {
            text += arb.QuranArabicText[i] + " ";
        }

        textView.setText(text);
    }
}