package com.brent.school.koreanapp.Adapter;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brent.school.koreanapp.Model.Translation;
import com.brent.school.koreanapp.R;
import com.brent.school.koreanapp.RemoveWordsActivity;
import com.brent.school.koreanapp.Utility.ConfirmDeleteDialog;

import java.util.List;

/**
 * Created by Brent on 10-10-2017.
 */

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {

    final Context context;
    private final List<Translation> wordList;
    public boolean delete;

    public WordListAdapter(List<Translation> list, Context context) {
        wordList = list;
        this.context = context;
        delete = false;
    }

    @Override

    public int getItemCount() {

        return wordList.size();

    }


    private Translation getItem(int position) {

        return wordList.get(position);

    }

    @Override

    public long getItemId(int position) {

        return wordList.get(position).getId();

    }

    public void updateList(List<Translation> newlist) {

        // Set new updated list

        wordList.clear();

        wordList.addAll(newlist);

    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_translation, parent, false);

        return new ViewHolder(itemView);

    }

    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {

        //Populate the row

        holder.populateRow(getItem(position));
       // holder.

    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView korean;

        private final TextView english;


        //initialize the variables

        public ViewHolder(View view) {

            super(view);

            korean = (TextView) view.findViewById(R.id.textKorean);

            english = (TextView) view.findViewById(R.id.textEnglish);


            view.setOnClickListener(this);

        }

        @Override

        public void onClick(View view) {

            Intent intent = new Intent(context, RemoveWordsActivity.class);

// Get the correct game based on which listitem got clicked, and put it as parameter in the intent

            intent.putExtra("selectedTranslation", getItem(getAdapterPosition()));
            intent.putExtra("translationId", getItem(getAdapterPosition()).getId());
            //intent.putExtra("blas", getItem())
// Open GameDetailsActivity

            context.startActivity(intent);


        }

        public void populateRow(Translation translation) {


            korean.setText(translation.getKorean());

            english.setText(translation.getEnglish());

            int b = wordList.size();
            int z;

        }

    }
}
