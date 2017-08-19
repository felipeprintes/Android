package br.com.rotina.cursoandroid.rotinaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Formulario_Rotinas extends AppCompatActivity {

    //cria-se para que outros métodos possa ver
    private Formulario_Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__rotinas);


        helper = new Formulario_Helper(this);
    }


    //Criando um icone na barra de menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Recuperando um Item selecionado na barra de menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Toast.makeText(Formulario_Rotinas.this, "botao clicado", Toast.LENGTH_SHORT).show();
                Texto texto = helper.pegaTexto();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
