package com.tsafundzic.rotisseriesappnavbottom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WorkerChooserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_chooser);


        setTitle(R.string.worker_menu);

        setUI();
    }

    private void setUI() {

    }
}
