package com.brent.school.koreanapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;

import com.brent.school.koreanapp.Model.Translation;
import com.brent.school.koreanapp.Utility.DataSource;

import static com.brent.school.koreanapp.R.id.inputKorean;


/**
 * Created by Brent on 12-10-2017.
 */

public class AddWordToList extends MainActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        FloatingActionButton saveTranslation = (FloatingActionButton) findViewById(R.id.saveTranslation);

        saveTranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClicks(view);
            }
        });

        inputEnglish =  (EditText)findViewById(R.id.inputEnglish);
        inputKorean = (EditText)findViewById(R.id.inputKorean);
    }

    public EditText inputKorean ;
    public EditText inputEnglish ;


    public void onClicks(View v){
        saveWord();
    }



    public void saveWord() {



        String korean = inputKorean.getText().toString();
        String english = inputEnglish.getText().toString();

        DataSource dataSource = new DataSource(this);
        Translation translation = new Translation(-1,korean,english);
        dataSource.SaveTranslation(translation);
        finish();

    }
}
