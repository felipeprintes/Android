package preferenciascorusuario.cursoandroid.com.preferenciascorusuario;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionado;
    private Button botaoSalvar;
    private RelativeLayout layout;
    private static final String ARQUIVO_PREFERENCIA = " ArqPreferencia ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        botaoSalvar = (Button) findViewById(R.id.botaoId);
        layout = (RelativeLayout) findViewById(R.id.layoutId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idRadioGroupEscolhido = radioGroup.getCheckedRadioButtonId();

                if (idRadioGroupEscolhido > 0){
                    radioButtonSelecionado = (RadioButton) findViewById(idRadioGroupEscolhido);

                    SharedPreferences sharedePreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

                    SharedPreferences.Editor editor = sharedePreferences.edit();
                    String corEscolhida = radioButtonSelecionado.getText().toString();
                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();


                    setBackground(corEscolhida);


                }

            }
        });

        //Recuperar a cor salva
        SharedPreferences sharedePreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sharedePreferences.contains("corEscolhida")){
            String corRecuperada = sharedePreferences.getString("corEscolhida", "Laranja");
            setBackground(corRecuperada);
        }


    }

    private void setBackground(String cor){

        if (cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#005aff"));
        }else if(cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#00ff25"));
        }else if(cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#ffa500"));
        }

    }
}
