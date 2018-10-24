package com.example.administrator.mynoelmedia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mynoelmedia.databinding.ItemRecyclerBinding;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private ISong iSong;

    public SongAdapter(ISong iSong) {
        this.iSong = iSong;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRecyclerBinding binding = ItemRecyclerBinding.inflate(inflater, parent, false);
        return new SongViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = iSong.getSong(position);
        holder.binding.tvSong.setText(song.getName());
    }

    @Override
    public int getItemCount() {
        return iSong.getCount();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        ItemRecyclerBinding binding;
        public SongViewHolder(ItemRecyclerBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }

    public interface ISong{
        int getCount();

        Song getSong(int position);
    }
}
