package br.com.rotina.cursoandroid.rotinaapp;

import android.widget.EditText;

/**
 * Created by Printes1 on 13/08/2017.
 */

public class Formulario_Helper {

    private final EditText campo_rotina;

    public Formulario_Helper(Formulario_Rotinas activity){

        campo_rotina = (EditText) activity.findViewById(R.id.texto_rotina);
    }

    public Texto pegaTexto() {
        Texto texto = new Texto();
        texto.setMinhaRotina(campo_rotina.getText().toString());

        return null;
    }
}
