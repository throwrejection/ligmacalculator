package com.example.ligmacalculator;

import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

// This was a pain in the behind to make, Oh my god. First project :)

public class main_ligma extends AppCompatActivity {


    private EditText editTextNumber;
    VideoView vidLigma2;
    MediaController mediaLigma;
    Button buttonStart;
    View relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();



    }

    public void onBackPressed() {
        vidLigma2.stopPlayback();

        relativeLayout.setVisibility(View.GONE);
    }


    private boolean randomizeR(int number) {
        String numberText = editTextNumber.getText().toString();
        number = Integer.parseInt(numberText);

        Random myRandomizer = new Random();
        int solution = myRandomizer.nextInt(69 - 1) + 1;

        if (number == solution) {
            return true;
        } else {
            return false;
        }



    }

    private void findViews() {
        editTextNumber = findViewById(R.id.edit_text_number);
        vidLigma2 = findViewById(R.id.video_view);
        buttonStart = findViewById(R.id.button_start);
        relativeLayout = findViewById(R.id.relative_video);



    }

    private void setupButtonClickListener() {
        // buttonStart = new Button(this);

        buttonStart.setOnClickListener(v -> {


            if (randomizeR(69)) {
                playVideo(R.raw.congratulations);

                Toast.makeText(this.getApplicationContext(), "Congratulations! You don't have Ligma!", Toast.LENGTH_LONG).show();
            } else {
                playVideo(R.raw.ligmavideo);

                Toast.makeText(this.getApplicationContext(), "Unfortunately you have Ligma!", Toast.LENGTH_LONG).show();
            }

        });

    }


    private void playVideo(int src) {
        mediaLigma = new MediaController(this);
        String path = "android.resource://" + getPackageName() + "/" + src;
        mediaLigma.setAnchorView(vidLigma2);
        mediaLigma.setMediaPlayer(vidLigma2);
        Uri u = Uri.parse(path);
        vidLigma2.setMediaController(mediaLigma);
        vidLigma2.setVideoURI(u);
        vidLigma2.start();

        relativeLayout.setVisibility(View.VISIBLE);
    }

}


