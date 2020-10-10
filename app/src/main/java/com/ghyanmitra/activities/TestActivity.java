package com.ghyanmitra.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ghyanmitra.R;
import com.ghyanmitra.fragments.CartFragment;
import com.ghyanmitra.fragments.DashBoardFragment;
import com.ghyanmitra.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TestActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();

        onMenuItemSelect(R.id.action_home);
    }

    private void initViews() {

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TestActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        onMenuItemSelect(item.getItemId());

        return false;
    }

    private void onMenuItemSelect(int id) {

        Fragment fragment = null;
        Bundle bundle = new Bundle();

        switch (id) {

            case R.id.action_home:

                fragment = new HomeFragment();
                bundle.putString("titel", "Home Page");
                fragment.setArguments(bundle);

                break;

            case R.id.action_dashboard:

                fragment = new DashBoardFragment();
                bundle.putString("titel", "Score");
                fragment.setArguments(bundle);
                break;

            case R.id.action_cart:

                fragment = new CartFragment();
                bundle.putString("titel", "Dashborad");
                fragment.setArguments(bundle);
                break;


            default:
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

    }
}