package com.tsafundzic.rotisseriesappnavbottom.worker;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tsafundzic.rotisseriesappnavbottom.R;
import com.tsafundzic.rotisseriesappnavbottom.WorkerChooserActivity;
import com.tsafundzic.rotisseriesappnavbottom.data.DataHolder;
import com.tsafundzic.rotisseriesappnavbottom.model.Worker;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkerLoginFragment extends Fragment implements View.OnClickListener {

    EditText workerID;
    EditText workerPassword;
    Button workerLogin;
    List<Worker> workers = DataHolder.getInstance().getWorkers();

    public WorkerLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_worker_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        workerID = view.findViewById(R.id.etWorkerID);
        workerPassword = view.findViewById(R.id.etWorkerPassword);
        workerLogin = view.findViewById(R.id.btnWorkerLogin);

        workerLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (workerID.getText().toString().isEmpty()) {
            workerID.setError(getText(R.string.you_must_input_something));
        } else if (workerPassword.getText().toString().isEmpty()) {
            workerPassword.setError(getText(R.string.you_must_input_something));
        } else {

            int inputedWorkedId = Integer.parseInt(workerID.getText().toString());
            String inputedWorkerPassword = workerPassword.getText().toString();

            for (Worker worker : workers) {
                if (inputedWorkedId == worker.getId() && inputedWorkerPassword.equals(worker.getPassword())) {
                    Toast.makeText(getContext(), R.string.logged_as_worker, Toast.LENGTH_SHORT).show();

                    Intent startWorkerChooseActivity = new Intent(getActivity(), WorkerChooserActivity.class);
                    startActivity(startWorkerChooseActivity);
                }
            }
        }
    }
}
