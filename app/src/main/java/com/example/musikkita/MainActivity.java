package com.example.musikkita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bv_musikKita;
    private ActionBar ab_judulBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ab_judulBar = getSupportActionBar();
        ab_judulBar.setTitle("Musik");

        bukaFragment(new MusicFragment());

        bv_musikKita = findViewById(R.id.bn_musikKita);
        bv_musikKita.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment FR;
                switch (item.getItemId())
                {
                    case R.id.menu_musik:
                        bukaFragment(new MusicFragment());
                        ab_judulBar.setTitle("Musik");
                        return true;
                    case R.id.menu_album:
                        bukaFragment(new AlbumFragment());
                        ab_judulBar.setTitle("Album");
                        return true;
                    case R.id.menu_artis:
                        bukaFragment(new ArtisFragment());
                        ab_judulBar.setTitle("Artis");
                        return true;
                }
                return false;
            }
        });
    }

    private void bukaFragment (Fragment FR)
    {
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.fl_container, FR);
        FT.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_atas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_about)
        {
            startActivity(new Intent(MainActivity.this, About.class));
        }
        else if (item.getItemId() == R.id.menu_help)
        {
            startActivity(new Intent(MainActivity.this, Help.class));
        }
        return super.onOptionsItemSelected(item);
    }
}