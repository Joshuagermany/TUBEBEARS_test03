package com.example.tubebears_test03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavi);

        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new Fragment_1_Home()).commit();
        //FrameLayout에 fragment.xml 띄우기

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu1_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment_1_Home()).commit();
                        break;
                    case R.id.menu2_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment_2_Advertisement()).commit();
                        break;
                    case R.id.menu3_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment_3_Hire()).commit();
                        break;
                    case R.id.menu4_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment_4_Analyze()).commit();
                        break;
                    case R.id.menu5_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment_5_Talk()).commit();
                        break;
                }
                return true;
            }
        });


    getSupportActionBar().setIcon(R.drawable.main_logo);
    getSupportActionBar().setDisplayUseLogoEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)    {
        getMenuInflater().inflate(R.menu.activity_setting, (Menu) menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.setting_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment_setting()).commit();
                break;

                //Toast.makeText(getApplicationContext(), "Search Action", Toast.LENGTH_SHORT).show();
                //return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

}