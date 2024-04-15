package com.example.qarzdaftar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.qarzdaftar.databinding.ActivityDashboardBinding;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);

        // Initialize the binding
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] name = {"Komron Raximov", "Og'abek Xusinov", "Ziyodulla Abdukarimov", "Elomon Jumanazarov"};
        String[] date = {"12.04.2024", "10.04.2024", "14.04.2024", "03.04.2024"};
        String[] debt = {"12000", "100000", "150000", "10000000"};


        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            User user = new User(name[i], date[i], debt[i]);
            userArrayList.add(user);
        }
        // Set the initial fragment
        replaceFragment(new DebtFragment());

        // Set the BottomNavigationView listener
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.debt) {
                replaceFragment(new DebtFragment());
            } else if (item.getItemId() == R.id.client) {
                replaceFragment(new ClientFragment());
            } else if (item.getItemId() == R.id.sms) {
                replaceFragment(new SmsFragment());
            } else if (item.getItemId() == R.id.profile) {
                replaceFragment(new ProfileFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Use the correct container ID (R.id.frame_layout)
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
