package com.example.myhome6.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.example.myhome6.R;
import com.example.myhome6.data.InMemoryRepoImpl;
import com.example.myhome6.data.Note;
import com.example.myhome6.data.Repo;
import com.example.myhome6.recycler.NotesAdapter;

public class NotesActivityList extends AppCompatActivity implements NotesAdapter.OnNoteClickListener {

    //приватная ссылка на ресайклер
    private RecyclerView list;
    //теперь нужна ссылка на репо
    private Repo repo= InMemoryRepoImpl.getInstance();
    //теперь нужна ссылка на адаптер
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*setContentView(R.layout.activity_main);*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        //теперь найдём этот лист (создаём)
        list= findViewById(R.id.list);
        //показываем новый адаптер
        adapter=new NotesAdapter();

        //получение данных о том, какие произошли клики, регистрация активности
        adapter.setOnNoteClickListener(this);

        adapter.setNotes(repo.getAll());

        //создание декораций между элементами
        list.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //присваимваем листу адаптер
        list.setAdapter(adapter);

        //вертикальный менеджер вверх и вниз
        list.setLayoutManager(new LinearLayoutManager(this));

    }

    public static final int EDIT_NOTE_REQUEST=66;

    @Override
    public void onNoteClick(Note note) {
        //понимание, что мы получается на щелчки
        Log.d("happy", note.getDescription());

        //вызов активности из основной
        Intent editNoteIntent= new Intent(this, EditNoteActivity.class);
        editNoteIntent.putExtra(Note.Note, note);
        //теперь стартуем активность
        startActivityForResult(editNoteIntent, EDIT_NOTE_REQUEST);
    }

    //TODO в рамках дз написать функцию обработки возвращаемой заметки
    //добавить её в репо и обновить адаптер данными из репо
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}