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
    private final EditText campoTelefone;

    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity){
        campoNome = (EditText) activity.findViewById(R.id.form_nome);
        campoEndereco = (EditText) activity.findViewById(R.id.form_endereco);
        campoTelefone = (EditText) activity.findViewById(R.id.form_telefone);
        campoSite = (EditText) activity.findViewById(R.id.form_site);
        campoNota = (RatingBar) activity.findViewById(R.id.form_nota);
        aluno = new Aluno();
    }

    public Aluno pegaAluno() {
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {

        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereco());
        campoTelefone.setText(aluno.getTelefone());
        campoSite.setText(aluno.getSite());
        campoNota.setProgress(aluno.getNota().intValue());
        this.aluno = aluno;
    }
}
