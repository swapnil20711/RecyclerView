package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.WordlistItemBinding;

import java.util.List;


public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private Context context;
    private List<String> mWords;
    WordlistItemBinding binding;

    public WordListAdapter(Context context, List<String> mWords) {
        this.context = context;
        this.mWords = mWords;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordlistItemBinding b = WordlistItemBinding.inflate(LayoutInflater.from(context), parent, false);

        return new WordViewHolder(b, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String wordItem = mWords.get(position);

        holder.b.word.setText(wordItem);
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        WordListAdapter adapter;
        WordlistItemBinding b;

        public WordViewHolder(WordlistItemBinding b, WordListAdapter adapter) {
            super(b.getRoot());
            this.adapter = adapter;
            this.b = b;

            b.word.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position=getLayoutPosition();
            String element=mWords.get(position);
            mWords.set(position,"Clicked! "+element);
            adapter.notifyDataSetChanged();

        }
    }
}
