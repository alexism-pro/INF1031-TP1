package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.tp1.databinding.Activity3Binding;
import com.example.tp1.databinding.Activity3BindingImpl;

public class Activity3 extends AppCompatActivity {

    FragmentManager fragManager;
    private FrameLayout fragContainer;
    private Fragment currentFrag;
    private int currentFragNumber;
    private Button btnSwap;
    private Button btnRetour;
    private Activity3Binding binding;
    private String txtImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // Get binding object
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_3);
        this.txtImage = getString(R.string.txt_image_activity);

        init();
        setFragment(new FragmentImage1(), false);
    }

    // Init variables and fragment manager
    private void init() {
        btnSwap = (Button) findViewById(R.id.swap);
        btnSwap.setOnClickListener(this::swapPicture);

        btnRetour = (Button) findViewById(R.id.retour);
        btnRetour.setOnClickListener(this::back);

        fragContainer = (FrameLayout) findViewById(R.id.fragmentContainer);
        fragManager = getSupportFragmentManager();
    }

    // Replaces current fragment with desired fragment
    private void setFragment(Fragment frag, boolean addToBackStack) {
        // Begin fragment transaction
        FragmentTransaction fragTrans = fragManager.beginTransaction();
        fragTrans.replace(R.id.fragmentContainer, frag);

        if(addToBackStack) fragTrans.addToBackStack(null);

        fragTrans.commit();
        // End

        currentFrag = frag;
        if(currentFrag instanceof FragmentImage1)
            this.binding.setTxtImageVisible(String.format(this.txtImage, 1));
        else if (currentFrag instanceof FragmentImage2)
            this.binding.setTxtImageVisible(String.format(this.txtImage, 2));
    }

    // Swaps the picture on the click of the button
    public void swapPicture(View v) {
        if(currentFrag instanceof FragmentImage1)
            setFragment(new FragmentImage2(), true);
        else if (currentFrag instanceof FragmentImage2)
            setFragment(new FragmentImage1(), true);
    }

    // Brings back to main activity
    private void back(View view) {
        finish();
    }
}