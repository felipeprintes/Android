package listview.cursoandroid.com.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ListView listaItens;
    private String[] itens = {
            "Angra dos Reis", "Caldas Novas", "Campos do Jordão", "Costa do Sauípe", "Ilhéis",
            "Porto Seguro", "Rio de Janeiro", "Tiradentes", "kkkkkkk", "hhhhhhhhhhh",
            "dddddddddddd", "rrrrrrrrr", "jjjjjjjjjj", "ccccccccc", "gssssss", "ttttttt"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItens = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
            getApplicationContext(),
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
                itens
        );

        listaItens.setAdapter( adaptador );

       listaItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               int codigoPosicao = i;
               String valorClicado =  listaItens.getItemAtPosition(codigoPosicao).toString();
               Toast.makeText(getApplicationContext(), valorClicado, Toast.LENGTH_SHORT).show();

           }
       });
    }
}
