package com.tsafundzic.rotisseriesappnavbottom;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by cobe on 22/03/2018.
 */

public class ChangeFragments {

    static FragmentTransaction fragmentTransaction;

    protected static void changeWorkerFragment(Fragment fragment, Activity activity){
        fragmentTransaction = ((FragmentActivity)activity).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentFrameWorkerChooser, fragment);
        fragmentTransaction.commit();
    }

    protected static void changeMainFragment(Fragment fragment, Activity activity){
        fragmentTransaction = ((FragmentActivity)activity).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentFrameHome, fragment);
        fragmentTransaction.commit();
    }

    protected static void changeCustomerFragment(Fragment fragment, Activity activity){
        fragmentTransaction = ((FragmentActivity)activity).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentFrameCustomerChooser, fragment);
        fragmentTransaction.commit();
    }
}
