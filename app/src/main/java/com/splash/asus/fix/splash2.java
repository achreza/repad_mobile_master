package com.splash.asus.fix;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class splash2 extends AppCompatActivity {

    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent intent = new Intent(SplashActivity.this, CategoriaNoticiasActivity.class);
                //Intent intent = new Intent(SplashActivity.this, DetalleNoticiaActivity.class);
                Intent intent = new Intent(splash2.this, Gamemenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }, 3000);

        printHash();

    }

    private void printHash() {
        try {

            PackageInfo info;
            info = getPackageManager().getPackageInfo(getApplicationContext().getPackageName(),
                    PackageManager.GET_SIGNATURES);

            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.v("MY KEY HASH:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
