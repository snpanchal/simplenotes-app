package com.example.simplenotes;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Shyam Panchal.
 */

public class NotesCursorAdapter extends CursorAdapter {
    NotesCursorAdapter(Context context) {
        super(context, null, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.note_list_item, parent,
                false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String noteText = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NOTE_TEXT));
        int position = noteText.indexOf(10); // position for line feed (10 is ASCII value for line feed

        if (position != -1) {
            noteText = noteText.substring(0, position) + "...";
        }

        TextView tv = view.findViewById(R.id.tvNote);
        tv.setText(noteText);
    }
}
