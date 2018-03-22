package com.tsafundzic.rotisseriesappnavbottom.utils;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by cobe on 22/03/2018.
 */

public class BaseActivity extends AppCompatActivity {

    protected static void changeFragments(int container, Fragment fragment, Activity activity) {
        FragmentTransaction fragmentTransaction = ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(container, fragment);
        fragmentTransaction.commit();
    }
}
