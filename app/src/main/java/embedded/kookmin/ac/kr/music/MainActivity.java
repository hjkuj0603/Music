package embedded.kookmin.ac.kr.music;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btStart;
    Button btStop;
    MediaPlayer mMplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMplayer = new MediaPlayer();

        try {
            AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.boysandgirls);
            mMplayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        } catch(Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        btStart = (Button) findViewById(R.id.bt_2);
        btStop = (Button) findViewById(R.id.bt_1);



        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mMplayer.prepare();
                    mMplayer.start();
                } catch(Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMplayer.stop();
            }
        });

    }
}
