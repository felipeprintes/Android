package autenticacaousuario.cursoandroid.com.autentucacaousuario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        /*firebaseAuth.createUserWithEmailAndPassword("fulano@gmail.com", "12345").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    //Sucesso ao cadastrar
                }else{

                    Log.i("creatUser", "Erro ao cadastrar usuario!");

                }


            }
        });*/

       /* //Login do usuário
        firebaseAuth.signInWithEmailAndPassword("fulano@gmail.com", "2345").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {  //senha posta de formar incorreta de forma proposital
                if(task.isSuccessful()){
                    //sucesso ao cadastrar
                    Log.i("signIn", "Sucesso ao fazer login do usuario");
                }else{
                    Log.i("signIn","Erro ao fazer cadastro di usuarui");
                }
            }
        });*/

    }
}
