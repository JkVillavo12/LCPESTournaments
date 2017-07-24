package com.jkvillavo12dev.lcpestournaments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jkvillavo12dev.lcpestournaments.custom.viewpager.ViewPagerAdapterRegistro;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroDocumentoFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroMailFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroNombreFragment;

public class RegistroActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapterRegistro viewPagerAdapterRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getViews();

    }

    private void getViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        configurarToolBar();

        viewPagerAdapterRegistro = new ViewPagerAdapterRegistro(getSupportFragmentManager(), getApplicationContext());

        viewPager = (ViewPager) findViewById(R.id.registro_viewPager);
        viewPager.setAdapter(viewPagerAdapterRegistro);
        viewPager.beginFakeDrag();

    }

    private void configurarToolBar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    public void nextQuestion(View view) {

        boolean isValid = false;
        switch (viewPager.getCurrentItem()) {
            case 0:
                isValid = RegistroMailFragment.getInstance().validate();
                break;
            case 1:
                isValid = RegistroDocumentoFragment.getInstance().validate();
                break;
            case 2:
                isValid = RegistroNombreFragment.getInstance().validate();
                break;
            case 3:
                break;
            case 4:
                break;

        }

        if (isValid) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }

    }

    public void backQuestion(View view) {

        if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }

    }
}
