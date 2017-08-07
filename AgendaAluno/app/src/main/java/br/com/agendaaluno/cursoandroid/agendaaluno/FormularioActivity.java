package br.com.agendaaluno.cursoandroid.agendaaluno;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.agendaaluno.cursoandroid.agendaaluno.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

         helper = new FormularioHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_ok:

                Aluno aluno = helper.pegaAluno();
                Toast.makeText(FormularioActivity.this, "Aluno"+ aluno.getNome() + "salvo", Toast.LENGTH_SHORT).show();

                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
