package com.example.menubar.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.menubar.R;
import com.example.menubar.Utils.NoteUtils;
import com.example.menubar.model.Note;

import java.util.ArrayList;

public class NotesAdapter  extends RecyclerView.Adapter<NotesAdapter.NoteHolder> {
    private Context context;
    private ArrayList<Note> notes;

    public NotesAdapter(Context context, ArrayList<Note> notes) {
        this.context = context;
        this.notes = notes;
    }


    @Override
    public NoteHolder onCreateViewHolder( ViewGroup parent, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.note_layout,parent,false);
        return new NoteHolder(v);
    }

    @Override
    public void onBindViewHolder( NoteHolder noteHolder, int position) {
        Note note = getNote(position);
        if (note != null){
            noteHolder.noteText.setText(note.getNoteText());
            noteHolder.noteDate.setText(NoteUtils.dateFromLong(note.getNoteDate()));
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    private Note getNote(int position){
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        TextView noteText, noteDate;

        public NoteHolder(View itemView){
            super(itemView);
            noteDate = itemView.findViewById(R.id.note_data);
            noteText = itemView.findViewById(R.id.note_text);
        }

    }
}
