package com.example.administrator.mynoelmedia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mynoelmedia.databinding.FragmentListSongBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListSongFragment extends Fragment implements SongAdapter.ISong {
    private List<Song> songList;
    private SongAdapter adapter;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("1");
    FragmentListSongBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListSongBinding.inflate(inflater, container, false);
        songList = new ArrayList<>();
        showListSong();
        return binding.getRoot();
    }

    @Override
    public int getCount() {
        if (songList==null) return 0;
        return songList.size();
    }

    @Override
    public Song getSong(int position) {
        return songList.get(position);
    }

    private void showListSong(){
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Song song = dataSnapshot.getValue(Song.class);
                songList.add(song);
                adapter = new SongAdapter(ListSongFragment.this);
                binding.rvSongs.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvSongs.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
