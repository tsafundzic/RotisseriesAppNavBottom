package com.tsafundzic.rotisseriesappnavbottom.utils;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by cobe on 22/03/2018.
 */

public class BaseFragment extends Fragment {
    public static void changeFragments(int container, android.support.v4.app.Fragment fragment, Activity activity) {
        FragmentTransaction fragmentTransaction = ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(container, fragment);
        fragmentTransaction.commit();
    }
}
