package com.brent.school.koreanapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.brent.school.koreanapp.Adapter.WordListAdapter;
import com.brent.school.koreanapp.Model.Translation;
import com.brent.school.koreanapp.Utility.DBHelper;
import com.brent.school.koreanapp.Utility.DataSource;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void createDB(View view){
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = new DBHelper(this).getWritableDatabase();

    }

    public void toWordAdd(View view){
        Intent intent = new Intent(this, AddWordToList.class);
        startActivity(intent);
    }

    public void toLists(View view) {
        Intent intent = new Intent(this, ListsOverviewActivity.class);
        startActivity(intent);
    }

    public void toTestList(View view){
        Intent intent = new Intent(this, ListDetailActivity.class);
        startActivity(intent);
    }


}
