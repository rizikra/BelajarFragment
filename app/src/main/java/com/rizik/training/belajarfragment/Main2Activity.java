package com.rizik.training.belajarfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button btnChange, btnToBelajarFrag;

    private BelajarFragment belajarFragment;
    private BlankFragment blankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnChange = findViewById(R.id.btn_blank_fragment);
        btnToBelajarFrag = findViewById(R.id.btn_belajar_fragment);

        belajarFragment = new BelajarFragment();
        blankFragment = new BlankFragment();

        //Buat Fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Buat object Fragment Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //Tambahkan object BelajarFragment (object) ke Frame Layout frame_fragmeent
        fragmentTransaction.add(R.id.frame_fragment, blankFragment);
        fragmentTransaction.hide(blankFragment);
        fragmentTransaction.add(R.id.frame_fragment, belajarFragment);
        //Kemudian commit ();
        fragmentTransaction.commit();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ketika button go to another fragment di klik, akan pindah ke fragment lain
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if(blankFragment.isAdded()){
                    fragmentTransaction.show(blankFragment);
                    fragmentTransaction.remove(belajarFragment);
                    Toast.makeText(getApplicationContext(), "Fragment sudah ditambahkan sebelumnya", Toast.LENGTH_SHORT).show();
                }
                else {
                    fragmentTransaction.replace(R.id.frame_fragment, blankFragment);
                }
                fragmentTransaction.addToBackStack("Belajar Fragment");
                fragmentTransaction.commit();

                btnToBelajarFrag.setVisibility(View.VISIBLE);
                btnChange.setVisibility(View.GONE);
            }
        });
        btnToBelajarFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ketika button to belajar fragment di klik, akan pindah ke belajar fragment
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_fragment, belajarFragment);
                //fragmentTransaction.add(R.id.frame_fragment, belajarFragment);
                fragmentTransaction.commit();

                btnToBelajarFrag.setVisibility(View.GONE);
                btnChange.setVisibility(View.VISIBLE);
            }
        });
    }
}
