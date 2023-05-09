package excersice.libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) VideoView mivdeo=findViewById(R.id.video1);

        String videop="android.resource://"+getPackageName()+"/"+R.raw.uno;
        Uri uri=Uri.parse(videop);
        mivdeo.setVideoURI(uri);

        MediaController mediaController=new MediaController(this);
        mivdeo.setMediaController(mediaController);
        mediaController.setAnchorView(mivdeo);

    }
}