package com.example.infinitysorteios3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class TelaCC extends AppCompatActivity {

    private Button btnVoltarTCC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cc);

        btnVoltarTCC = findViewById(R.id.btnVoltarTCC);
        btnVoltarTCC.setOnClickListener(v -> {
            finish();
        });
    }
}