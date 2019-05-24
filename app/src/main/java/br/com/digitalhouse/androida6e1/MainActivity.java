package br.com.digitalhouse.androida6e1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.androida6e1.fragments.Fragment1;
import br.com.digitalhouse.androida6e1.fragments.Fragment2;

public class MainActivity extends AppCompatActivity {
    private Button btnGreen;
    private Button btnRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new Fragment1());

            }
        });

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new Fragment2());

            }
        });
    }
    private void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack("FRAGMENTS");
        transaction.commit();
    }
    private void initViews() {
        btnGreen = findViewById(R.id.btnGreen);
        btnRed = findViewById(R.id.btnRed);
    }
}
