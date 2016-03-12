package com.brunodevesa.mycrimeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by bruno.devesa on 11/03/2016.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        Fragment fragmentOne = fm.findFragmentById(R.id.main_layout_id);

        if (fragmentOne == null) {
            fragmentOne = createFragment();
            fm.beginTransaction().add(R.id.main_layout_id, fragmentOne).commit();
        }

    }

}
