package com.example.tp1;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment1 extends Fragment implements View.OnClickListener {
    Button btnReturn;

    public static final String EXTRA_IDENTITY ="com.example.project1.Activity2.EXTRA_IDENTITY";
    public static final String EXTRA_MARK1 ="com.example.project1.Activity2.EXTRA_MARK1";
    public static final String EXTRA_MARK2 ="com.example.project1.Activity2.EXTRA_MARK2";
    public static final String EXTRA_MARK3 ="com.example.project1.Activity2.EXTRA_MARK3";

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_1, container, false);

        btnReturn = (Button) rootView.findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if(!IsFulfilled()) {
            Toast.makeText(getActivity(), "Veuillez remplir tous les champs!", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(getActivity(), MainActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_IDENTITY, ((EditText)getActivity().findViewById(R.id.editTextIdentity)).getText().toString());
        extras.putFloat(EXTRA_MARK1, Float.parseFloat(((EditText)getActivity().findViewById(R.id.editTextMark1)).getText().toString()));
        extras.putFloat(EXTRA_MARK2, Float.parseFloat(((EditText)getActivity().findViewById(R.id.editTextMark2)).getText().toString()));
        extras.putFloat(EXTRA_MARK3, Float.parseFloat(((EditText)getActivity().findViewById(R.id.editTextMark3)).getText().toString()));
        intent.putExtras(extras);

        getActivity().setResult(RESULT_OK, intent);
        getActivity().finish();
    }

    private boolean IsFulfilled(){
        if (((EditText)getActivity().findViewById(R.id.editTextIdentity)).getText().toString().length() < 1 ||
            ((EditText)getActivity().findViewById(R.id.editTextMark1)).getText().toString().length() < 1 ||
            ((EditText)getActivity().findViewById(R.id.editTextMark2)).getText().toString().length() < 1 ||
            ((EditText)getActivity().findViewById(R.id.editTextMark3)).getText().toString().length() < 1) {
            return false;
        }
        return true;
    }
}