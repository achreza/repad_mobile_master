package com.splash.asus.fix;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.media.MediaPlayer;
import android.media.MediaRecorder;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.support.v4.app.ActivityCompat;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import java.io.IOException;

public class flute extends AppCompatActivity {
    private SoundPool sp;
    private int sound1;
    private int sound2;
    private int sound3;
    private int sound4;
    private int sound5;
    private int sound6;
    private int sound7;
    private int sound8;
    private int sound9;
    private int sound10;
    private int sound11;
    private int sound12;
    private int sound13;
    private int sound14;
    private int sound15;
    private int sound16;

    Button buttonStart, buttonStop, buttonPlayLastRecordAudio,
            buttonStopPlayingRecording;
    String AudioSavePathInDevice = null;
    MediaRecorder mediaRecorder;
    Random random;
    String RandomAudioFileName = "ABCDEFGHIJKLMNOP";
    public static final int RequestPermissionCode = 1;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.button);
        buttonStop = (Button) findViewById(R.id.button2);
        buttonPlayLastRecordAudio = (Button) findViewById(R.id.button3);
        buttonStopPlayingRecording = (Button) findViewById(R.id.button4);

        buttonStop.setEnabled(false);
        buttonPlayLastRecordAudio.setEnabled(false);
        buttonStopPlayingRecording.setEnabled(false);

        random = new Random();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkPermission()) {

                    AudioSavePathInDevice =
                            Environment.getExternalStorageDirectory().getAbsolutePath() + "/" +
                                    CreateRandomAudioFileName(5) + "AudioRecording.3gp";

                    MediaRecorderReady();

                    try {
                        mediaRecorder.prepare();
                        mediaRecorder.start();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    buttonStart.setEnabled(false);
                    buttonStop.setEnabled(true);

                    Toast.makeText(flute.this, "Recording started",
                            Toast.LENGTH_LONG).show();
                } else {
                    requestPermission();
                }

            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaRecorder.stop();
                buttonStop.setEnabled(false);
                buttonPlayLastRecordAudio.setEnabled(true);
                buttonStart.setEnabled(true);
                buttonStopPlayingRecording.setEnabled(false);

                Toast.makeText(flute.this, "Recording Completed",
                        Toast.LENGTH_LONG).show();
            }
        });

        buttonPlayLastRecordAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws IllegalArgumentException,
                    SecurityException, IllegalStateException {

                buttonStop.setEnabled(false);
                buttonStart.setEnabled(false);
                buttonStopPlayingRecording.setEnabled(true);

                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(AudioSavePathInDevice);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mediaPlayer.start();
                Toast.makeText(flute.this, "Recording Playing",
                        Toast.LENGTH_LONG).show();
            }
        });

        buttonStopPlayingRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonStop.setEnabled(false);
                buttonStart.setEnabled(true);
                buttonStopPlayingRecording.setEnabled(false);
                buttonPlayLastRecordAudio.setEnabled(true);

                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    MediaRecorderReady();
                }
            }
        });

        sp = new SoundPool(6, AudioManager.STREAM_MUSIC,0);
        sound1 = sp.load(getApplicationContext(),R.raw.flute1,1);
        sound2 = sp.load(getApplicationContext(),R.raw.flute2,1);
        sound3 = sp.load(getApplicationContext(),R.raw.flute3,1);
        sound4 = sp.load(getApplicationContext(),R.raw.flute4,1);
        sound5 = sp.load(getApplicationContext(),R.raw.flute5,1);
        sound6 = sp.load(getApplicationContext(),R.raw.flute6,1);
        sound7 = sp.load(getApplicationContext(),R.raw.flute7,1);
        sound8 = sp.load(getApplicationContext(),R.raw.flute8,1);
        sound9 = sp.load(getApplicationContext(),R.raw.flute9,1);
        sound10 = sp.load(getApplicationContext(),R.raw.flute10,1);
        sound11 = sp.load(getApplicationContext(),R.raw.flute11,1);
        sound12 = sp.load(getApplicationContext(),R.raw.flute12,1);
        sound13 = sp.load(getApplicationContext(),R.raw.flute13,1);
        sound14 = sp.load(getApplicationContext(),R.raw.flute14,1);
        sound15 = sp.load(getApplicationContext(),R.raw.flute15,1);
        sound16 = sp.load(getApplicationContext(),R.raw.flute16,1);


    }


    public void playsound1 (View v){
        sp.play(sound1,1,1,0,0,1);
    }
    public void playsound2 (View v){
        sp.play(sound2,1,1,0,0,1);
    }
    public void playsound3 (View v) {
        sp.play(sound3,1,1,0,0,1);
    }
    public void playsound4 (View v){
        sp.play(sound4,1,1,0,0,1);
    }
    public void playsound5 (View v){
        sp.play(sound5,1,1,0,0,1);
    }
    public void playsound6 (View v){
        sp.play(sound6,1,1,0,0,1);
    }
    public void playsound7 (View v){
        sp.play(sound7,1,1,0,0,1);
    }
    public void playsound8 (View v){
        sp.play(sound8,1,1,0,0,1);
    }
    public void playsound9 (View v){
        sp.play(sound9,1,1,0,0,1);
    }
    public void playsound10 (View v){
        sp.play(sound10,1,1,0,0,1);
    }
    public void playsound11 (View v){
        sp.play(sound11,1,1,0,0,1);
    }
    public void playsound12 (View v){
        sp.play(sound12,1,1,0,0,1);
    }
    public void playsound13 (View v){
        sp.play(sound13,1,1,0,0,1);
    }
    public void playsound14 (View v){
        sp.play(sound14,1,1,0,0,1);
    }
    public void playsound15 (View v){
        sp.play(sound15,1,1,0,0,1);
    }
    public void playsound16 (View v){
        sp.play(sound16,1,1,0,0,1);
    }

    public void MediaRecorderReady() {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(AudioSavePathInDevice);
    }

    public String CreateRandomAudioFileName(int string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        int i = 0;
        while (i < string) {
            stringBuilder.append(RandomAudioFileName.
                    charAt(random.nextInt(RandomAudioFileName.length())));

            i++;
        }
        return stringBuilder.toString();
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(flute.this, new
                String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO}, RequestPermissionCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length > 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission && RecordPermission) {
                        Toast.makeText(flute.this, "Permission Granted",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(flute.this, "Permission Denied", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(),
                WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(),
                RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED &&
                result1 == PackageManager.PERMISSION_GRANTED;
    }
}