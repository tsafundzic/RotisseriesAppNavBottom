package com.tsafundzic.rotisseriesappnavbottom;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.tsafundzic.rotisseriesappnavbottom.worker.WorkerAddNewProductFragment;
import com.tsafundzic.rotisseriesappnavbottom.worker.WorkerAddNewWorkerFragment;
import com.tsafundzic.rotisseriesappnavbottom.worker.WorkerDeleteProductFragment;

public class WorkerChooserActivity extends AppCompatActivity {

    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_chooser);

        setUI();
    }

    private void setUI() {
        setTitle(R.string.worker_menu);

        fragment = new WorkerAddNewProductFragment();
        ChangeFragments.changeWorkerFragment(fragment, WorkerChooserActivity.this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.workerChooserNavigationBottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuAddNewProduct:
                        setTitle(R.string.add_new_product);
                        fragment = new WorkerAddNewProductFragment();
                        ChangeFragments.changeWorkerFragment(fragment, WorkerChooserActivity.this);
                        break;
                    case R.id.menuDeleteProduct:
                        setTitle(R.string.delete_product);
                        fragment = new WorkerDeleteProductFragment();
                        ChangeFragments.changeWorkerFragment(fragment, WorkerChooserActivity.this);
                        break;
                    case R.id.menuAddNewWorker:
                        setTitle(R.string.add_new_worker);
                        fragment = new WorkerAddNewWorkerFragment();
                        ChangeFragments.changeWorkerFragment(fragment, WorkerChooserActivity.this);
                        break;
                }
                return true;
            }
        });

    }
}
