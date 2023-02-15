package com.example.quranicacademyapplication;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView paraNUm;
    public TextView ayatNum;
    public Button btnSearch;
    public TextView parahName;
    public TextView EnglishParahName;
    public TextView ayats;
    Button github;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paraNUm = findViewById(R.id.ParahNum);
        ayatNum = findViewById(R.id.AyatNum);
        btnSearch = findViewById(R.id.btnSearch);
        parahName = findViewById(R.id.ParahDisplayView);
        ayats = findViewById(R.id.AyatDisplayView);
        EnglishParahName = findViewById(R.id.englishParahName);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(paraNUm.getText().length() == 0 && ayatNum.getText().length() == 0)
                {
                    ayats.setText("[+]");
                }
                else if(paraNUm.getText().length() > 0 && ayatNum.getText().length() == 0)
                {
                    QDH QuranMetaData = new QDH();
                    int valP = Integer.parseInt(paraNUm.getText().toString());

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
                    int valP = Integer.parseInt(paraNUm.getText().toString());
                    int valA = Integer.parseInt(ayatNum.getText().toString())-1;

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

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String url = "https://github.com/ghufran2508/QuraniAcademy/commits/master";
                Uri webpage = Uri.parse(url);

                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });
    }
}