package com.jkvillavo12dev.lcpestournaments.custom.viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroDocumentoFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroFinishFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroMailFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroNickFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroNombreFragment;
import com.jkvillavo12dev.lcpestournaments.fragments.registro.RegistroPasswordFragment;

/**
 * Created by juancamartinezor on 7/24/17.
 */

public class ViewPagerAdapterRegistro extends FragmentPagerAdapter {

    Context context;

    public ViewPagerAdapterRegistro(FragmentManager fm, Context applicationContext) {

        super(fm);
        context = applicationContext;
    }

    @Override
    public int getCount() {

        return 5;
    }

    /**
     * Nos entrega un fragment según su ubicacion
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {

            case 0:
                fragment = RegistroMailFragment.getInstance();
                break;
            case 1:
                fragment = RegistroDocumentoFragment.getInstance();
                break;
            case 2:
                fragment = RegistroNombreFragment.getInstance();
                break;
            case 3:
                fragment = RegistroNickFragment.getInstance();
                break;
            case 4:
                fragment = RegistroPasswordFragment.getInstance();
                break;
//            case 5:
//                fragment = RegistroFinishFragment.getInstance();
//                break;

        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return null;
    }
}
