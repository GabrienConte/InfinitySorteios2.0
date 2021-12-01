package com.example.infinitysorteios3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class TelaNomes extends AppCompatActivity {

    private Button btnVoltarTNAM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_nomes);

        btnVoltarTNAM = findViewById(R.id.btnVoltarTNAM);
        btnVoltarTNAM.setOnClickListener(v -> {
            finish();
        });
    }
}