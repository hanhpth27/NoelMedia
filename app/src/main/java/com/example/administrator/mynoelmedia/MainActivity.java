package com.example.administrator.mynoelmedia;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.mynoelmedia.databinding.ActivityMainBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;
    private FragmentManager manager;
    private DatabaseReference mDatabase;
    private List<Song> songList;
    private SQLiteDatabase database;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main );
        manager = getSupportFragmentManager();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        songList = new ArrayList<>();
        db = new Database(this);
        database = db.open();

        getDataFromFirebaseToSQLite();
        addFragmentTrangChu();


    }

    private void addFragmentTrangChu() {
        FragmentTransaction transaction = manager.beginTransaction();
        TrangChuFragment trangchu = new TrangChuFragment();
        transaction.add(R.id.fl_content, trangchu, TrangChuFragment.class.getName());
        transaction.commit();
    }

    private void getDataFromFirebaseToSQLite(){


        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Song song = dataSnapshot.getValue(Song.class);
                songList.add(song);
                Log.d("Song", songList.get(0).getName());
                insertListSong(songList);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d(TAG, "onChildChanged...");
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                Log.d(TAG, "onChildRemoved...");
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d(TAG, "onChildMoved...");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "onCancelled...");
            }
        });
    }

    private void insertListSong(List<Song> songs){
        ContentValues contentValues = new ContentValues();
        if(songs!=null){
            for (int i=0; i<songs.size(); i++){
                Song song = songs.get(i);
                contentValues.put(Database.ID, song.getId());
                contentValues.put(Database.NAME, song.getName());
                contentValues.put(Database.PATH, song.getPath());
                contentValues.put(Database.DURATION, song.getDuration());

                database.insert(Database.TABLE_NAME, null, contentValues);
            }
        }
    }
}
