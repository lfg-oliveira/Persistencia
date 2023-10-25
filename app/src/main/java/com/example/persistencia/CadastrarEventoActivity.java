package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.persistencia.R;

public class CadastrarEventoActivity extends AppCompatActivity {

     //Aqui deve-se colocar as instruções para realizar o cadastro

    private EditText  descricao;
    private EditText  curso;
    private EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_evento);

        descricao = findViewById(R.id.editTextDesc);
        curso = findViewById(R.id.editTextCurso);
        url = findViewById(R.id.editTextURL);

        //ação de cadastrar
        Button cadastrar = findViewById(R.id.buttonCadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Evento evento = new Evento(descricao.getText().toString(),
                         curso.getText().toString(), url.getText().toString());

                 //chamar a função do banco para poder inserir
                EventoHelper db = new EventoHelper(CadastrarEventoActivity.this);
                db.insere(evento);
                Toast.makeText(CadastrarEventoActivity.this,
                        "evento cadastrado!", Toast.LENGTH_SHORT).show();
            }
        });
        Button buttonListar = findViewById(R.id.buttonListar);
        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //chamar a tela de listar evento
                Intent intent  = new Intent(
                        CadastrarEventoActivity.this,
                        ListarEventoActivity.class);
                startActivity(intent);
            }
        });
    }
}