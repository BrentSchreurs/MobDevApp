package com.brent.school.koreanapp;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.brent.school.koreanapp.Adapter.WordListAdapter;
import com.brent.school.koreanapp.Model.Translation;
import com.brent.school.koreanapp.Utility.DataSource;

import java.util.List;

public class RemoveWordsActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_remove);

        deleteButton = (Button) findViewById(R.id.deleteButton);
        translation = (Translation) getIntent().getSerializableExtra("selectedTranslation");
        id = getIntent().getIntExtra("translationId", 1);
        dataSource = new DataSource(this);
        korean = (TextView) findViewById(R.id.textKoreanRemove);
        english = (TextView) findViewById(R.id.textEnglishRemove);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //dataSource.deleteTranslation(id);
                dataSource.deleteTranslation(translation.getKorean());
                showGameDeletedToast();
            }
        });

        korean.setText(translation.getKorean());
        english.setText(translation.getEnglish());
    }

    private Translation translation;
    private Button deleteButton;
    private DataSource dataSource;
    private TextView korean;
    private TextView english;
    private int id;



    public void deleteTranslation(View view){
        DataSource dataSource = new DataSource(this);
        dataSource.deleteTranslation(translation.getId());
    }

    private void showGameDeletedToast() {

        Context context = getApplicationContext();

        String text = "Deleted";

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);

        toast.show();

    }
}
