package br.com.rotina.cursoandroid.rotinaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button adicionarTarefa = (Button) findViewById(R.id.nova_tarefa);
        adicionarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Botão clicado", Toast.LENGTH_SHORT).show();
                Intent vaiProFormulario = new Intent(MainActivity.this, Formulario_Rotinas.class);
                startActivity(vaiProFormulario);
            }
        });


    }

}
