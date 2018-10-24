package com.example.administrator.mynoelmedia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mynoelmedia.databinding.FragmentTrangchuBinding;

public class TrangChuFragment extends Fragment {
    private FragmentTrangchuBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTrangchuBinding.inflate(inflater, container, false);
        FragmentAdapter adapter = new FragmentAdapter(getChildFragmentManager());
        binding.vp.setAdapter(adapter);

        binding.tbTrangchu.setupWithViewPager(binding.vp);

        LayoutInflater inflater1 = LayoutInflater.from(getActivity());
        for(int i=0; i<adapter.getCount(); i++){
            View v = inflater.inflate(R.layout.item_tab, binding.tbTrangchu, false);
            if(i==0) {
                ((TextView)v.findViewById(R.id.tv_tab)).setText("My Tones");
            }else{
                ((TextView)v.findViewById(R.id.tv_tab)).setText("Favorite Song");
            }

            binding.tbTrangchu.getTabAt(i).setCustomView(v);
        }
        return binding.getRoot();
    }
}
