package com.jkvillavo12dev.lcpestournaments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LoginActivity extends AppCompatActivity {

    private ImageView imageViewBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide(); //<< this

        setContentView(R.layout.activity_login);
        getViews();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Glide.with(this)
                .load(R.drawable.indigo_pentagonal_background)
                .into(imageViewBackground);
    }

    private void getViews() {

        imageViewBackground = (ImageView) findViewById(R.id.login_imageViewBackground);

    }

    public void ingresarComoInvitado(View view) {
    }

    public void loguearse(View view) {
    }

    public void registro(View view) {

        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void restaurarPassword(View view) {
    }
}
