package com.example.myhome6.recycler;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhome6.R;
import com.example.myhome6.data.Note;

public class NoteHolder extends RecyclerView.ViewHolder {

    //внутри холдера будут 2 TextView, создадим на них ссылку
    private TextView title;
    private TextView description;

    //сделаем ссылку на note, которую холдер будет отображать
    private Note note; //тут нужно записать заголовок

    public NoteHolder(@NonNull View itemView, NotesAdapter.OnNoteClickListener listener) {
        super(itemView);
        //в конструкторе может находить ссылки и переопрелять их
        title=itemView.findViewById(R.id.note_tittle);
        description=itemView.findViewById(R.id.note_description);

        //отработка нажатия
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNoteClick(note);

            }
        });
    }

    //нечто, что содержит в себе view, а также ссылки на view
    //view не переуничтожаются, а используются повторно
    //holder-это класс, который на входит принимает view, также хранятся ссылки на все элементы управления

    //когда приходит новая нота, переопределяем её содержимое
    void bind(Note note)
    {
        this.note=note;
        title.setText(note.getTitle());
        description.setText(note.getDescription());
    }
}
