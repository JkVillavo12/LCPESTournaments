package com.jkvillavo12dev.lcpestournaments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.jkvillavo12dev.lcpestournaments.custom.viewpager.ViewPagerAdapterRegistro;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroDocumentoFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroMailFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroNickFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroNombreFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroPasswordFragment;

public class RegistroActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapterRegistro viewPagerAdapterRegistro;
    private ProgressBar progressBar;
    private Button buttonBack, buttonNext;

    @Override
    public void onBackPressed() {
        backAndDestroyRegistro();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getViews();

    }

    @Override
    public boolean onSupportNavigateUp() {

        backAndDestroyRegistro();
        return super.onSupportNavigateUp();
    }

    private void backAndDestroyRegistro() {

        RegistroMailFragment.destroyInstance();
        RegistroDocumentoFragment.destroyInstance();
        RegistroNombreFragment.destroyInstance();
        RegistroNickFragment.destroyInstance();
        RegistroPasswordFragment.destroyInstance();
        finish();

    }

    public void backQuestion(View view) {

        if (viewPager.getCurrentItem() != 0) {
            progressBar.setProgress(viewPager.getCurrentItem() - 1);
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }

    }

    private void configurarToolBar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    private void configurarViewPager() {

        viewPagerAdapterRegistro = new ViewPagerAdapterRegistro(getSupportFragmentManager(), getApplicationContext());

        viewPager = (ViewPager) findViewById(R.id.registro_viewPager);
        viewPager.setAdapter(viewPagerAdapterRegistro);
        viewPager.beginFakeDrag();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == 0) {
                    showAnterior(false);
                } else {
                    showAnterior(true);
                }

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    showAnterior(false);
                } else {
                    showAnterior(true);
                }
                if (position != 4) {
                    buttonNext.setText(getString(R.string.common_next));
                } else {
                    buttonNext.setText(getString(R.string.common_finish));
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void getViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        configurarToolBar();
        configurarViewPager();
        progressBar = (ProgressBar) findViewById(R.id.registro_progressBar);
        progressBar.setProgress(0);
        buttonBack = (Button) findViewById(R.id.registro_buttonBack);
        buttonNext = (Button) findViewById(R.id.registro_buttonNext);

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
                isValid = RegistroNickFragment.getInstance().validate();
                break;
            case 4:
                isValid = RegistroPasswordFragment.getInstance().validate();
                break;
        }

        if (isValid) {
            progressBar.setProgress(viewPager.getCurrentItem() + 1);
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }

    }

    private void showAnterior(boolean b) {

        if (b) buttonBack.setVisibility(View.VISIBLE);
        else buttonBack.setVisibility(View.INVISIBLE);

    }
}
