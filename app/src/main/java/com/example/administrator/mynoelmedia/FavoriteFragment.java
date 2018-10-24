package com.example.administrator.mynoelmedia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mynoelmedia.databinding.FragmentListSongBinding;

public class FavoriteFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentListSongBinding binding = FragmentListSongBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
