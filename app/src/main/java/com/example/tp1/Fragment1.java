package com.example.tp1;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tp1.databinding.Fragment1Binding;

public class Fragment1 extends Fragment implements View.OnClickListener {
    Button btnReturn;
    Fragment1Binding binding;

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_1, container, false);

        View rootView =  binding.getRoot();

        btnReturn = (Button) rootView.findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if(!IsFulfilled()) {
            Toast.makeText(getActivity(), "Veuillez remplir tous les champs avec des valeurs valides!", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(getActivity(), MainActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_IDENTITY, binding.getFullName());
        extras.putFloat(EXTRA_MARK1, Float.parseFloat(String.valueOf(binding.getResult1())));
        extras.putFloat(EXTRA_MARK2, Float.parseFloat(String.valueOf(binding.getResult2())));
        extras.putFloat(EXTRA_MARK3, Float.parseFloat(String.valueOf(binding.getResult3())));
        intent.putExtras(extras);

        getActivity().setResult(RESULT_OK, intent);
        getActivity().finish();
    }

    public boolean IsFulfilled(){
        if (binding.getFullName() != null && binding.getResult1() > 0 && binding.getResult2() > 0 && binding.getResult3() > 0) {
            return true;
        }
        return false;
    }
}