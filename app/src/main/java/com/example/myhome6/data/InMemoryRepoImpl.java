package com.example.myhome6.data;

import java.util.ArrayList;
import java.util.List;

//реализуем репозиторий в памяти
//заметки пропадают, когда приложение закрывают

public class InMemoryRepoImpl implements Repo {

    //SingleTon-шаблон. Этот механизм позволяем иметь 1 копию репо
    //на весь цикл жизник приложение
    private static InMemoryRepoImpl repo;//статическая ссылка

    private InMemoryRepoImpl()//конструктор
    {

        //нужно инициализировать заметки, чтобы они были
        init();
    }

    //погода на 7 дней недели

    private void init() {
        //создаём несколько заметок
        create(new Note("Title 1", "Description 1"));
        create(new Note("Title 2", "Description 2"));
        create(new Note("Title 3", "Description 3"));
        create(new Note("Title 4", "Description 4"));
        create(new Note("Title 5", "Description 5"));
        create(new Note("Title 6", "Description 6"));
        create(new Note("Title 7", "Description 7"));

    }

    //сначала эта функция проверяет, есть такое repo или нет
    public static InMemoryRepoImpl getInstance(){
        //есть такое репо или нет.
        if(repo==null)
        {
            repo=new InMemoryRepoImpl();
        }
        //если репозиторий есть, то её возвратим
        //если его нет, что repo создаётся первый и ед.раз
        return repo;
    }

    //теперь нужно сделать контейнер, где хранятся заметки
    private ArrayList<Note> notes= new ArrayList<>();
    //создание каунтера, который хранит текущий идентификатов заметки
    private int counter=0;
    //функиция, которая создаёт заметку

    @Override
    //в эту функцию передаётся заметка
    public int create(Note note) {
        //теперь нужно создать новый идентификатор
        int id=counter++;
        //потом его присвоить,
        note.setId(id);
        // заметку записать в notes (список заметок)
        notes.add(note);
        //потом этот идентификатор вернуть
        return id;
    }

    @Override
    //эта функция ищет заметку по идентификатору
    public Note read(int id) {
        //нужно перебрать все заметки в списке
        for (int i=0; i< notes.size(); i++){
            //если id совпадает, что возвратить
            if (notes.get(i).getId()==id)
                return notes.get(i);
        }
        //если не нашли id, возвращаем ноль
        return null;
    }

    //эта функиця позволяет обновить заметку
    //если id заметки совпадает, то просто записать её
    @Override
    public void update(Note note) {
        //мы должны понять, какой id соотвествует заметке
        for (int i=0; i< notes.size(); i++){
            //если id в цикле в заметке равен заметке в нашем id
            if (notes.get(i).getId()== note.getId()) {
                //то обновляем заметку
                notes.set(i, note);
                //break выводит из цикла
                break;
            }
        }
    }

    //эта функция удаляет заметку
    @Override
    public void delete(int id) {
        //мы должны понять, какой id соотвествует заметке
        for (int i=0; i< notes.size(); i++){
            //если id в цикле в заметке равен нашему id
            if (notes.get(i).getId()== id) {
                //то удаляем заметку
                notes.remove(i);
                //break выводит из цикла
                break;
            }
        }

    }

    //эта функция возвращает заметки
    @Override
    public List<Note> getAll() {
        return notes;
    }



}
