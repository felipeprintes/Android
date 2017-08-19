package mediaplayer.cursoandroid.com.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoTocar;
    public static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTocar = (Button) findViewById(R.id.botaoId);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.musica);

        botaoTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(mediaPlayer.isPlaying()){
                pausarMusica();
            }else{
                tocarMusica();
            }

            }
        });

        public void  tocarMusica() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            botaoTocar.setText("Pausar");
        }
        }


        private void pausarMusica(){
            if(mediaPlayer!=null){
                mediaPlayer.pause();
                botaoTocar.setText("Tocar");
            }

        }

    }
}
