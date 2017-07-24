package com.jkvillavo12dev.lcpestournaments.custom.viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jkvillavo12dev.lcpestournaments.fragments.onboarding.InicialPage1Fragment;
import com.jkvillavo12dev.lcpestournaments.fragments.onboarding.InicialPage2Fragment;
import com.jkvillavo12dev.lcpestournaments.fragments.onboarding.InicialPage3Fragment;
import com.jkvillavo12dev.lcpestournaments.fragments.onboarding.InicialPage4Fragment;

public class ViewPagerAdapterInicial extends FragmentPagerAdapter {

    Context context;

    public ViewPagerAdapterInicial(FragmentManager fm, Context applicationContext) {

        super(fm);
        context = applicationContext;
    }

    @Override
    public int getCount() {

        return 4;
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
                fragment = InicialPage1Fragment.getInstance();
                break;
            case 1:
                fragment = InicialPage2Fragment.getInstance();
                break;
            case 2:
                fragment = InicialPage3Fragment.getInstance();
                break;
            case 3:
                fragment = InicialPage4Fragment.getInstance();
                break;
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return null;
    }

}
