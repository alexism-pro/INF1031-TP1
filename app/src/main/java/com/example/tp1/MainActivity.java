package com.example.tp1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGetAverage, btnViewPictures;
    ActivityMainBinding binding;

    ActivityResultLauncher<Intent> activityLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {

                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result != null && result.getResultCode() == RESULT_OK) {
                                Intent intent = result.getData();

                                Bundle extras = intent.getExtras();
                                String identity = extras.getString(Fragment1.EXTRA_IDENTITY);
                                float mark1 = Math.abs(extras.getFloat(Fragment1.EXTRA_MARK1));
                                float mark2 = Math.abs(extras.getFloat(Fragment1.EXTRA_MARK2));
                                float mark3 = Math.abs(extras.getFloat(Fragment1.EXTRA_MARK3));

                                binding.setAverage(identity + " a obtenu une moyenne de " + String.format("%.2f", (mark1 + mark2 + mark3) / 3));
                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setAverage("Aucun resultat n'est disponible.");

        btnGetAverage = (Button) findViewById(R.id.btnGetAverage);
        btnViewPictures = (Button) findViewById(R.id.btnViewPictures);

        btnGetAverage.setOnClickListener(this);
        btnViewPictures.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetAverage:
                Intent intentAverage = new Intent(this, Activity2.class);
                activityLauncher.launch(intentAverage);
                break;

            case R.id.btnViewPictures:
                Intent intentPictures = new Intent(this, Activity3.class);
                activityLauncher.launch(intentPictures);
                break;
        }
    }
}