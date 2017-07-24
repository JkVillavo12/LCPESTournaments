package com.jkvillavo12dev.lcpestournaments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.jkvillavo12dev.lcpestournaments.custom.viewpager.ViewPagerAdapterInicial;
import com.jkvillavo12dev.lcpestournaments.utils.sharedprefs.SharedPrefs;
import com.jkvillavo12dev.lcpestournaments.utils.sharedprefs.SharedPrefsKeys;

import java.util.HashMap;

public class OnBoardingActivity extends AppCompatActivity {

    private ViewPagerAdapterInicial mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private ImageView imageViewFrag1, imageViewFrag2, imageViewFrag3, imageViewFrag4;
    private int positionInViewFragmentAdapter = 0;
    private static final int INDEX_FRAGMENT_TORNEOSONLINE = 0;
    private static final int INDEX_FRAGMENT_TORNEOSPRESENCIALES = 1;
    private static final int INDEX_FRAGMENT_RETOS = 2;
    private static final int INDEX_FRAGMENT_MODALIDADES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        mSectionsPagerAdapter = new ViewPagerAdapterInicial(getSupportFragmentManager(), getApplicationContext());

        mViewPager = (ViewPager) findViewById(R.id.fullscreenInicio_viewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    @Override
    protected void onStart() {

        super.onStart();
        getComponentes();
        setListenerViewPager();
    }

    /**
     * Setea el listener del viewPager
     * Creado el 26/08/2016 a las 4:14 PM <br>
     */
    private void setListenerViewPager() {

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

                positionInViewFragmentAdapter = mViewPager.getCurrentItem();
                if (state == 2) {
                    changeOpacityCircles(positionInViewFragmentAdapter);
                }

            }
        });

    }


    /**
     * Cambia la opacidad de los circulos que indican en que fragment esta
     * Creado el 26/08/2016 a las 4:16 PM <br>
     *
     * @param positionInViewFragmentAdapter
     */
    private void changeOpacityCircles(int positionInViewFragmentAdapter) {

        imageViewFrag1.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.primary_dark));
        imageViewFrag2.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.primary_dark));
        imageViewFrag3.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.primary_dark));
        imageViewFrag4.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.primary_dark));

        switch (positionInViewFragmentAdapter) {
            case INDEX_FRAGMENT_TORNEOSONLINE:
                imageViewFrag1.setColorFilter(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
                break;
            case INDEX_FRAGMENT_TORNEOSPRESENCIALES:
                imageViewFrag2.setColorFilter(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
                break;
            case INDEX_FRAGMENT_RETOS:
                imageViewFrag3.setColorFilter(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
                break;
            case INDEX_FRAGMENT_MODALIDADES:
                imageViewFrag4.setColorFilter(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
                break;
            default:
                break;
        }


    }

    /**
     * Obtiene los componentes de la actividad
     * Creado el 26/08/2016 a las 4:12 PM <br>
     */
    private void getComponentes() {

        imageViewFrag1 = (ImageView) findViewById(R.id.activityInicio_imageViewFrag1);
        imageViewFrag2 = (ImageView) findViewById(R.id.activityInicio_imageViewFrag2);
        imageViewFrag3 = (ImageView) findViewById(R.id.activityInicio_imageViewFrag3);
        imageViewFrag4 = (ImageView) findViewById(R.id.activityInicio_imageViewFrag4);

    }

    /**
     * Guarda las preferencias del logueo
     * Creado el 1/09/16 a las 7:25 PM <br>
     *
     * @author <a href="https://plus.google.com/u/1/+JuanCarlosMart%C3%ADnezOrjuela/">JkVillavo12COL</a></br>
     */
    private void guardarPreferenciasLogueo() {

        HashMap<String, Object> mapDatos = new HashMap<>();
        mapDatos.put(SharedPrefsKeys.Loggin.IS_LOGGIN, false);
        mapDatos.put(SharedPrefsKeys.Loggin.IS_INVITADO, true);
        SharedPrefs.guardarPreferencia(this, SharedPrefsKeys.Loggin.PREFS, mapDatos);

    }

    public void ingresar(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    public void nextFragment(View view) {
        if (positionInViewFragmentAdapter < mSectionsPagerAdapter.getCount()) {
            positionInViewFragmentAdapter++;
            mViewPager.setCurrentItem(positionInViewFragmentAdapter);
        }
    }

    public void backFragment(View view) {
        if (positionInViewFragmentAdapter > 0) {
            positionInViewFragmentAdapter--;
            mViewPager.setCurrentItem(positionInViewFragmentAdapter);
        }
    }

}
