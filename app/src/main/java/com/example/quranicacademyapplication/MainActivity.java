package com.example.quranicacademyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView paraNumber;
    public TextView ayatNumber;
    public Button searchButton;
    public TextView parahName;
    public TextView EnglishParahName;
    public TextView ayats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paraNumber = findViewById(R.id.parahID);
        ayatNumber = findViewById(R.id.ayatID);
        searchButton = findViewById(R.id.searchButtonID);
        parahName = findViewById(R.id.parahDisplayID);
        ayats = findViewById(R.id.AyatDisplayView);
        EnglishParahName = findViewById(R.id.englishParahID);



        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(paraNumber.getText().length() == 0 && ayatNumber.getText().length() == 0)
                {
                    ayats.setText("[+]");
                }
                else if(paraNumber.getText().length() > 0 && ayatNumber.getText().length() == 0)
                {
                    QDH QuranMetaData = new QDH();
                    int valP = Integer.parseInt(paraNumber.getText().toString());

                    if (valP < 1 || valP > 30){
                    }
                    else {
                        QuranArabicText qat = new QuranArabicText();
                        int startP = QuranMetaData.getParahStart(valP-1)-1;
                        if(valP == 30)
                        {
                            int limitEnd = 6348;

                            String AS = "";
                            for(int i = startP; i < limitEnd; i++)
                            {
                                AS += qat.QuranArabicText[i] + " ";
                            }

                            parahName.setText(QuranMetaData.ParahName[valP-1]);
                            EnglishParahName.setText(QuranMetaData.englishParahName[valP-1]);
                            ayats.setText(AS);
                        }
                        else {
                            int countOfAyatsInParah = QuranMetaData.getParahStart(valP)-QuranMetaData.getParahStart(valP-1);

                            String AS = "";
                            for(int i = startP; i < startP+countOfAyatsInParah; i++)
                            {
                                AS += qat.QuranArabicText[i] + " ";
                            }

                            parahName.setText(QuranMetaData.ParahName[valP-1]);
                            EnglishParahName.setText(QuranMetaData.englishParahName[valP-1]);
                            ayats.setText(AS);
                        }
                    }
                }
                else
                {
                    QDH QuranMetaData = new QDH();
                    int valP = Integer.parseInt(ayatNumber.getText().toString());
                    int valA = Integer.parseInt(ayatNumber.getText().toString())-1;

                    if (valP < 1 || valP > 30){

                    }
                    else {
                        QuranArabicText qat = new QuranArabicText();
                        int startP = QuranMetaData.getParahStart(valP-1)-1 + valA;
                        if(valP == 30)
                        {
                            int limitEnd = 6348;

                            String AS = "";
                            for(int i = startP; i < limitEnd; i++)
                            {
                                AS += qat.QuranArabicText[i] + " ";
                            }

                            parahName.setText(QuranMetaData.ParahName[valP-1]);
                            EnglishParahName.setText(QuranMetaData.englishParahName[valP-1]);
                            ayats.setText(AS);
                        }
                        else {
                            int countOfAyatsInParah = QuranMetaData.getParahStart(valP)-QuranMetaData.getParahStart(valP-1);

                            String AS = "";
                            for(int i = startP; i < startP+countOfAyatsInParah-valA; i++)
                            {
                                AS += qat.QuranArabicText[i] + " ";
                            }

                            parahName.setText(QuranMetaData.ParahName[valP-1]);
                            EnglishParahName.setText(QuranMetaData.englishParahName[valP-1]);
                            ayats.setText(AS);
                        }
                    }
                }
            }
        });
}}