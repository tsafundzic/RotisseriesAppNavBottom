package com.tsafundzic.rotisseriesappnavbottom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.tsafundzic.rotisseriesappnavbottom.utils.BaseActivity;
import com.tsafundzic.rotisseriesappnavbottom.worker.WorkerAddNewProductFragment;
import com.tsafundzic.rotisseriesappnavbottom.worker.WorkerAddNewWorkerFragment;
import com.tsafundzic.rotisseriesappnavbottom.worker.WorkerDeleteProductFragment;

public class WorkerChooserActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_chooser);

        setUI();
    }

    private void setUI() {
        setTitle(R.string.worker_menu);

        changeFragments(R.id.fragmentFrameWorkerChooser, new WorkerAddNewProductFragment(), this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.workerChooserNavigationBottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuAddNewProduct:
                        setTitle(R.string.add_new_product);
                        changeFragments(R.id.fragmentFrameWorkerChooser, new WorkerAddNewProductFragment(), WorkerChooserActivity.this);
                        break;
                    case R.id.menuDeleteProduct:
                        setTitle(R.string.delete_product);
                        changeFragments(R.id.fragmentFrameWorkerChooser, new WorkerDeleteProductFragment(), WorkerChooserActivity.this);
                        break;
                    case R.id.menuAddNewWorker:
                        setTitle(R.string.add_new_worker);
                        changeFragments(R.id.fragmentFrameWorkerChooser, new WorkerAddNewWorkerFragment(), WorkerChooserActivity.this);
                        break;
                }
                return true;
            }
        });

    }
}
