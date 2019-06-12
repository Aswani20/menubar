package com.example.menubar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.menubar.adapters.NotesAdapter;
import com.example.menubar.model.Note;

import java.util.ArrayList;
import java.util.Date;

public class notebad extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Note> notes;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebad);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // init recyclerView
        recyclerView = findViewById(R.id.notes_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // init fab Button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 13/05/2018 add new note
                onAddNewNote();
            }
        });
    }

    private void loadNotes() {
        this.notes=new ArrayList<>();
        for (int i=0; i< 12;i++){
            notes.add(new Note("student at fculty of science helwan university ",new Date().getTime()));
        }
        adapter=new NotesAdapter(this,notes);
        recyclerView.setAdapter(adapter);
       // adapter.notifyDataSetChanged();
    }

    private void onAddNewNote() {
        if(notes != null)
            notes.add(new Note("this is new note",new Date().getTime()));
        if(adapter != null)
            adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotes();
    }
}
