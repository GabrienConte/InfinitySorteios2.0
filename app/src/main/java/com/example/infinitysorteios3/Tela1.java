package com.example.infinitysorteios3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Tela1 extends AppCompatActivity {

    private Button btnNome;
    private Button btnGp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        btnNome = findViewById(R.id.btnNome);

        btnNome.setOnClickListener(v -> {
            //Intent:
            //- recurso utilizado para criar/gerenciar Activities
            //- posso passar informações de uma activity para outra a partir da intent
            Intent vIntent = new Intent(this, TelaNomes.class);
            startActivity(vIntent);
        });

        btnGp = findViewById(R.id.btnGp);

        btnGp.setOnClickListener(v -> {
            //Intent:
            //- recurso utilizado para criar/gerenciar Activities
            //- posso passar informações de uma activity para outra a partir da intent
            Intent vIntent = new Intent(this, TelaGP.class);
            startActivity(vIntent);
        });
    }
}