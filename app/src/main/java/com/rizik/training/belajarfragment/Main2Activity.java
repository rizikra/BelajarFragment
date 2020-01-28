package com.rizik.training.belajarfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    private View btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnChange = findViewById(R.id.btn_another_fragment);

        //Buat Fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Buat object Fragment Transaction
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //Tambahkan object BelajarFragment (object) ke Frame Layout frame_fragmeent
        fragmentTransaction.add(R.id.frame_fragment, new BelajarFragment());
        //Kemudian commit ();
        fragmentTransaction.commit();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ketika button go to another fragment di klik, akan pindah ke fragment lain
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                //fragmentTransaction.replace(R.id.frame_fragment, new AnotherFragment());
                fragmentTransaction.replace(R.id.frame_fragment, new AnotherFragment());
                fragmentTransaction.commit();
            }
        });
    }
}
