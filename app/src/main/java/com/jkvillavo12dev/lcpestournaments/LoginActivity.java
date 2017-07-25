package com.jkvillavo12dev.lcpestournaments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jkvillavo12dev.lcpestournaments.utils.ActivityUtils;

public class LoginActivity extends AppCompatActivity {

    private ImageView imageViewBackground;
    private TextInputLayout textInputLayoutCorreo, textInputLayoutPassword;
    private EditText editTextCorreo, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
        textInputLayoutCorreo = (TextInputLayout) findViewById(R.id.login_textInputLayoutCorreo);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.login_textInputLayoutPassword);
        editTextCorreo = (EditText) findViewById(R.id.login_editTextCorreo);
        editTextPassword = (EditText) findViewById(R.id.login_editTextPassword);

    }

    public void ingresarComoInvitado(View view) {

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void loguearse(View view) {

        if (validarDatos()) {

        } else {

        }


    }

    private boolean validarDatos() {

        int errores = 0;
        errores += ActivityUtils.validarEditTextWithInputLayout(getApplicationContext(), editTextCorreo, textInputLayoutCorreo);
        errores += ActivityUtils.validarEditTextWithInputLayout(getApplicationContext(), editTextPassword, textInputLayoutPassword);
        if (errores == 0)
            errores += ActivityUtils.isValidEmail(getApplicationContext(), editTextCorreo, textInputLayoutCorreo);
        if (errores == 0) return true;
        return false;

    }

    public void registro(View view) {

        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public void restaurarPassword(View view) {
    }
}
