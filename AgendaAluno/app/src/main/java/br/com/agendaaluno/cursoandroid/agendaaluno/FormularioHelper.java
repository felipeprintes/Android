package br.com.agendaaluno.cursoandroid.agendaaluno;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.agendaaluno.cursoandroid.agendaaluno.modelo.Aluno;

/**
 * Created by Printes1 on 07/08/2017.
 */

public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoSite;
    private final RatingBar campoNota;

    public FormularioHelper(FormularioActivity activity){
        campoNome = (EditText) activity.findViewById(R.id.form_nome);
        campoEndereco = (EditText) activity.findViewById(R.id.form_endereco);
        campoSite = (EditText) activity.findViewById(R.id.form_site);
        campoNota = (RatingBar) activity.findViewById(R.id.form_nota);



    }

    public Aluno pegaAluno() {

        Aluno aluno = new Aluno();
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }
}
