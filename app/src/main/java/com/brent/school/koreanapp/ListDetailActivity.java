package com.brent.school.koreanapp;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.brent.school.koreanapp.Adapter.WordListAdapter;
import com.brent.school.koreanapp.Model.Translation;
import com.brent.school.koreanapp.Utility.ConfirmDeleteDialog;
import com.brent.school.koreanapp.Utility.DataSource;

import java.util.List;

public class ListDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        translationListView = (RecyclerView) findViewById(R.id.words);
    }

    private RecyclerView translationListView ;
    private WordListAdapter mAdapter;
    private List<Translation> mTranslations;


    private void updateUI(){

        DataSource dataSource = new DataSource(this);
        mTranslations = dataSource.getTranslations();
        if(mAdapter == null){
            mAdapter = new WordListAdapter(mTranslations,this);
            translationListView.setAdapter(mAdapter);
           // mAdapter.delete = false;
            translationListView.setLayoutManager(new LinearLayoutManager(this));
            //mAdapter.updateList(mTranslations);
        } else{
            mAdapter.updateList(mTranslations);
            //mAdapter.delete = false;
            mAdapter.notifyDataSetChanged();
        }
    }

    public void onResume() {

        super.onResume();  // Always call the superclass method first

        updateUI();

    }
}
