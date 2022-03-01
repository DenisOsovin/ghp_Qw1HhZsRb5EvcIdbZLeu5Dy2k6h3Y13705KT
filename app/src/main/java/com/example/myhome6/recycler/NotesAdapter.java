package com.example.myhome6.recycler;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myhome6.R;
import com.example.myhome6.data.Note;

import java.util.ArrayList;
import java.util.List;

//чтобы предварить адептер от ресайклера, нужно проэкстектендиться
public class NotesAdapter extends RecyclerView.Adapter<NoteHolder> {

    //notes-контейнер, в котором мы храним записки в отображении в recycle
    private List<Note> notes = new ArrayList<>();

    //эта функция создает новый holder
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //первое, нужно создать view
        Context context = parent.getContext();
        //теперь из контекст нужно создать LayoutInflater
        //На вход получает xml-R.layout.note_item(из числа). На выход-получает View
        LayoutInflater inflater = LayoutInflater.from(context);
        //чтобы создать inflater нужна ссылка на context
        //по ссылке мы надуваем view
        View view=inflater.inflate(R.layout.note_item, parent, false);

        return new NoteHolder(view, listener);
    }

    //эта функция говорит, что старый viewхолдер вышел из зоны видимости, и его нужно обновить (перерисовать)
    //по номеру позиции
    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        //нужно получить ноту, которая соотвествует новой позиции
        Note note=notes.get(position);
        //теперь отобразим новую ноту в холдере
        holder.bind(note);

        //можно написать так holder.bind(notes.get(position));
    }

    //этот метод возвращает количество элементов, которое нужно отобразить (сколько рисовать)
    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> all) {
        this.notes=notes;
        //теперь ресайклер должен сам себя перерисовать
        notifyDataSetChanged();
    }

    //этот интерфейс фиксирует щелчки нажатий, кому нужно получать данные
    public interface OnNoteClickListener {
        void onNoteClick(Note note);
    }
    //создадим экземпляр этого класса
    private OnNoteClickListener listener;
    //с помощью этого механизма он решиструется в адаптере
    public void setOnNoteClickListener(OnNoteClickListener listener)
    {
        this.listener=listener;
    }
}
