package com.example.myhome6.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.myhome6.R;
import com.example.myhome6.data.Note;

public class EditNoteActivity extends AppCompatActivity {

    private Note note;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);

        //получение из интента нота
        note=(Note)getIntent().getSerializableExtra(Note.Note);

        //TODO создать внешний вид для редактирования заметки
        setContentView(R.layout.activity_edit_note);
    }

    //TODO написать возвращение отредактированной заметки в NoteListActivity
    //для возвращения в вызывающую активность
    //нужна какая-то кнопка для возвращения SaveNote
    void saveNote()
    {
        //нужно создать пустой интент
        Intent result=new Intent();
        result.putExtra(Note.Note, note);
        //когда отредактируем ноту, мы возвратим её в качестве результата
        setResult(RESULT_OK, result);
        finish();

    }
}
