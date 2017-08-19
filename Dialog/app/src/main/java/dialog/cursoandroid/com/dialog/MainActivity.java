package dialog.cursoandroid.com.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.butaoId);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Criar alert dialog
                dialog = new AlertDialog.Builder( MainActivity.this );

                //Criar título
                dialog.setTitle("Título Dialog");

                //Configurar Mensagem
                dialog.setMessage("Mensagem da dialog");

                //Botao Negativo
                dialog.setNegativeButton("Não",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Toast.makeText(MainActivity.this, "Pressionado botão não", Toast.LENGTH_SHORT).show();

                            }
                        });

                //Botão Positivo
                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Toast.makeText(MainActivity.this, "Pressionado botão sim", Toast.LENGTH_SHORT).show();

                            }
                        }
                );

                dialog.create();
                dialog.show();

            }
        });

    }
}
