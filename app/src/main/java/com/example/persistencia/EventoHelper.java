package com.example.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.wifi.aware.PublishConfig;
import android.widget.Toast;
import java.util.List;
import java.util.ArrayList;

public class EventoHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    //descrever quais tabelas e nome do banco de dados
    //que será criado
    private static final String DATABASE_NAME =
            "eventos.db"; //pode ser qualquer coisa

    private static final String TABLE_NAME = "eventos";

    //colunas das tabelas
    private static final String ID_COL ="id_eventos";
    private static final String DESC_COL ="descricao";
    private static final String CURSO_COL ="curso";
    private static final String URL_COL ="url_evento";

    private String sql = "create table "+TABLE_NAME+
            "("+ ID_COL+" integer primary key " +
            "autoincrement," +DESC_COL + " text not null," +
            CURSO_COL+ " text not null,"+
            URL_COL+" text);";

    private SQLiteDatabase database;

    public EventoHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //operações a serem realizadas sobre
    // o banco de dados
    public void insere(Evento evento){

        //agora use o SQLiteDataBase que sua aplicação
        //controla
        database = getWritableDatabase();

        //Colocar os parametros a serem inseridos
        ContentValues valores = new ContentValues();
        valores.put(DESC_COL,evento.getDescricao());
        valores.put(CURSO_COL,evento.getCurso());
        valores.put(URL_COL,evento.getUrl());

        //chamar o método de inserção

        database.insert(TABLE_NAME,
                null,valores);

    }

    public List<Evento> listaTodos(){

        database = getReadableDatabase();
        String sql = "select * from "+TABLE_NAME;

        //para andar nas tuplas retornadas
        Cursor cursor = database.rawQuery(sql,null);

        List<Evento> eventos = new ArrayList<>();

        //verificar se há tuplas devolvidas na consulta
        if(cursor.moveToFirst()){
            //se conseguir andar para a primeira, então há algo retornado
            do{
                //obter os dados da tupla
                int id = Integer.parseInt(cursor.getString(0));
                String desc = cursor.getString(1);
                String curso = cursor.getString(2);
                String url = cursor.getString(3);

                //construir o objeto a ser mostrado
                Evento evento = new Evento( id, desc, curso, url);

                //montar a lista
                eventos.add(evento);


            }while(cursor.moveToNext()); //após processar os dados
                                         //de uma tupla, mova para a proxima

        }
        cursor.close();// se não houver mais tuplas, desaloque o
                         //recurso
        return eventos;
    }
}
