package sqlite.cursoandroid.com.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
            //tabela
            bancoDados.execSQL("CREAT TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT (3) )");
            //inserir dados
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('MARCOS', 30)");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Ana', 20)");

            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas WHERE nome like '%ar%' ", null);

            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade= cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while(cursor!=null){
                Log.i("RESULTADO  - nome: " , cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaIdade));
                cursor.moveToNext();
            }

        }catch(Exception e){

            e.printStackTrace();

        }

    }
}
