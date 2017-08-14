package br.com.agendaaluno.cursoandroid.agendaaluno;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.jar.Manifest;

import br.com.agendaaluno.cursoandroid.agendaaluno.dao.AlunoDAO;
import br.com.agendaaluno.cursoandroid.agendaaluno.modelo.Aluno;

public class MainActivity extends AppCompatActivity {

    private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaAlunos  = (ListView) findViewById(R.id.lista_alunos);

        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long l) {
                Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(position);
                Intent vaiProFormulario = new Intent(MainActivity.this, FormularioActivity.class);
                vaiProFormulario.putExtra("aluno", aluno);
                startActivity(vaiProFormulario);
            }
        });

        Button novoAluno = (Button) findViewById(R.id.novo_aluno);
        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vaiProFormulario = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(vaiProFormulario);
            }
        });

        registerForContextMenu(listaAlunos);

    }

    private void carregaLista() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();


        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(info.position);

        String site = aluno.getEndereco();
        if (!site.startsWith("http://")){
            site = "http://" + aluno.getSite();
        }
        MenuItem itemSite = menu.add("Visitar site");
        Intent intentSite = new Intent(Intent.ACTION_VIEW);
        intentSite.setData(Uri.parse(site));
        itemSite.setIntent(intentSite);

        MenuItem itemLigar = menu.add("Ligar");
        itemLigar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){


                    ActivityCompat.requestPermissions(MainActivity.this, Manifest.permission.CALL_PHONE, new String[]{Manifest.permisison.CALL_PHONE}, 123);

                }else{
                    Intent intentLigar = new Intent(Intent.ACTION_CALL);
                    intentLigar.setData(Uri.parse("tel: " + aluno.getTelefone()));
                    startActivity(intentLigar);
                }

                return false;
            }
        });



        MenuItem itemSms = menu.add("Enviar mensagem");
        Intent intentSms = new Intent(Intent.ACTION_VIEW);
        intentSms.setData(Uri.parse("sms" + aluno.getTelefone()));
        itemSms.setIntent(intentSms);


        MenuItem itemMapa = menu.add("Achar endereço");
        Intent itentMapa = new Intent(Intent.ACTION_VIEW);
        itentMapa.setData(Uri.parse("geo:0,0?q=" + aluno.getEndereco()));
        itemMapa.setIntent(itentMapa);

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {




                AlunoDAO dao = new AlunoDAO(MainActivity.this);
                dao.deleta(aluno);
                dao.close();

                carregaLista();
                return false;
            }
        });



    }
}
