package com.ashleymccallum.thebarkinglot;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.ashleymccallum.thebarkinglot.Fragments.SettingsFragment;
import com.ashleymccallum.thebarkinglot.HomeViewPager.HomeInfoFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.ashleymccallum.thebarkinglot.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_contact, R.id.nav_survey, R.id.nav_resources, R.id.nav_credits)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //remove text from main header
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_settings) {
            navController.navigate(R.id.nav_settings);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        if (navController.getCurrentDestination().getId() == R.id.nav_quiz_results) {
            navController.popBackStack(R.id.nav_survey, false);
            return true;
        } else {
            return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                    || super.onSupportNavigateUp();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case HomeInfoFragment.PERMISSION_WRITE_CALENDAR:
                if(grantResults.length > 0 & grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String title = "The Barking Lot - Adoption Event";

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(2021, 11, 18, 12, 0, 0);
                    long startTime = calendar.getTimeInMillis();
                    long endTime = calendar.getTimeInMillis() + 4 * 60 * 60 * 1000;

                    Intent i = new Intent(Intent.ACTION_INSERT);
                    i.setData(CalendarContract.Events.CONTENT_URI);
                    i.putExtra(CalendarContract.Events.TITLE, title);
                    i.putExtra(CalendarContract.Events.RRULE, "FREQ=MONTHLY;BYDAY=SA");
                    i.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
                    i.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);

                    try{
                        startActivity(i);
                    } catch (ActivityNotFoundException e) {
                        Snackbar.make(this.findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                    }
                }
            break;
        }
    }
}

//TODO - add permissions
//TODO - add more animations