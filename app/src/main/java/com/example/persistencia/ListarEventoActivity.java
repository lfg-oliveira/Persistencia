package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

public class ListarEventoActivity extends AppCompatActivity {

      //essa classe só possui um recyclerview, então
    // precisa gerenciá-lo

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_evento);
        //configuração do componente visual
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //Colocando os dados a serem mostrados no recycler
        List<Evento> eventos;
        EventoHelper evt;
        EventoAdapter adaptador;

        //consultar a lista de eventos que está no banco de dados
        evt = new EventoHelper(ListarEventoActivity.this);
        eventos = evt.listaTodos();

         //avaliar se há dados a serem mostrados
        if(eventos.size()>0){
            //colocar os objetos de dados no adaptador para ele poder
            //ser usado para criar os objetos visuais
            adaptador = new EventoAdapter(eventos,
                    ListarEventoActivity.this);

            //vincular o adaptador com o recycler
            recyclerView.setAdapter(adaptador);
        }
        else{
            Toast.makeText(ListarEventoActivity.this,
                    "Não há eventos cadastrados", Toast.LENGTH_SHORT).show();
        }

    }
}