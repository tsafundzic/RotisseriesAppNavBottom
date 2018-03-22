package com.tsafundzic.rotisseriesappnavbottom.worker;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tsafundzic.rotisseriesappnavbottom.R;
import com.tsafundzic.rotisseriesappnavbottom.data.DataHolder;
import com.tsafundzic.rotisseriesappnavbottom.model.Worker;
import com.tsafundzic.rotisseriesappnavbottom.utils.ValidationUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkerAddNewWorkerFragment extends Fragment implements View.OnClickListener {

    EditText workerName;
    EditText workerSurname;
    EditText workerPassword;
    EditText workerSalary;
    TextView workerID;
    Button addNewWorker;

    public WorkerAddNewWorkerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_worker_add_new_worker, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        workerID = view.findViewById(R.id.twWorkerID);
        workerName = view.findViewById(R.id.etWorkerName);
        workerSurname = view.findViewById(R.id.etWorkerSurname);
        workerPassword = view.findViewById(R.id.etNewWorkerPassword);
        workerSalary = view.findViewById(R.id.etWorkerSalary);
        addNewWorker = view.findViewById(R.id.btnAddNewWorkerToList);

        workerID.setText(DataHolder.getInstance().getWorkerSize() + 1 + "");

        addNewWorker.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (ValidationUtils.isInputValid(workerName.getText().toString())) {
            workerName.setError(getText(R.string.you_must_input_something));
        } else if (ValidationUtils.isInputValid(workerSurname.getText().toString())) {
            workerSurname.setError(getText(R.string.you_must_input_something));
        } else if (ValidationUtils.isInputValid(workerPassword.getText().toString())) {
            workerPassword.setError(getText(R.string.you_must_input_something));
        } else if (ValidationUtils.isInputValid(workerSalary.getText().toString())) {
            workerSalary.setError(getText(R.string.you_must_input_something));
        } else {
            Worker worker = new Worker(DataHolder.getInstance().getWorkerSize() + 1, workerName.getText().toString(), workerSurname.getText().toString(), workerPassword.getText().toString(), Double.parseDouble(workerSalary.getText().toString()));
            DataHolder.getInstance().addNewWorker(worker);
            Toast.makeText(getContext(), R.string.new_worker_created, Toast.LENGTH_SHORT).show();
        }
    }
}
