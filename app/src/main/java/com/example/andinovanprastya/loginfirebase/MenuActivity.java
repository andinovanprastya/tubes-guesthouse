package com.example.andinovanprastya.loginfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.andinovanprastya.loginfirebase.fragment.InformationFragment;
import com.example.andinovanprastya.loginfirebase.fragment.KamarDetailFragment;
import com.example.andinovanprastya.loginfirebase.fragment.KamarFragment;
import com.example.andinovanprastya.loginfirebase.fragment.SignoutFragment;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,  KamarFragment.Listener {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        INI DIHAPUS KARENA KALO ADA INI HALAMAN JD GABISA LANDSCAPE
//        fm = getSupportFragmentManager();
//        fm.beginTransaction().replace(R.id.fm_pager_nav, new KamarFragment()).commit();
//        getSupportActionBar().setTitle("kamar");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_kamar) {
            fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fm_pager_nav, new KamarFragment()).commit();
            getSupportActionBar().setTitle("Guest House");

        } else if (id == R.id.nav_detail) {
            fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fm_pager_nav, new InformationFragment()).commit();
            getSupportActionBar().setTitle("Informasi");
        } else if (id == R.id.nav_send) {
            fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fm_pager_nav, new SignoutFragment()).commit();
            getSupportActionBar().setTitle("Signout");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.details_frag);
        if(fragmentContainer != null){
            KamarDetailFragment details = new KamarDetailFragment();

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setKos(id);

            ft.replace(R.id.details_frag, details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);

            ft.commit();
        }else{
            Toast.makeText(this, "Memilih kamar dengan id "+ id, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this.getApplicationContext(), DetailActivity.class);
            Bundle b = new Bundle();
            b.putLong("id", id);
            i.putExtras(b);
            startActivity(i);
        }
    }
}
