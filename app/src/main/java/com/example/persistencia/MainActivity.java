package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.persistencia.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para chamar a execução de outra tela
        Intent intent =
                new Intent(this,
                        CadastrarEventoActivity.class);
        startActivity(intent);
    }
}