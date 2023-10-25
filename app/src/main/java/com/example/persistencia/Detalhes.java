package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Detalhes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        // Declaração.
        EventoHelper evt;
        int idEvento = -1;
        Evento e;

        // Instânciação EventHelper.
        evt = new EventoHelper(Detalhes.this);

        // Recupera ID selecionado do Bundle via Intent.
        Bundle bundle = getIntent().getExtras();
        idEvento = bundle.getInt("ID");

        // Busca o Evento.
        e = evt.obterPorID(idEvento);

        EditText edtId = findViewById(R.id.edtID);
        EditText edtDesc = findViewById(R.id.edtDescricao);
        EditText edtCurso = findViewById(R.id.edtCurso);
        EditText edtURL = findViewById(R.id.edtURL);

        edtId.setText(String.valueOf(e.getId()));
        edtDesc.setText(e.getDescricao());
        edtCurso.setText(e.getCurso());
        edtURL.setText(e.getUrl());
    }
}