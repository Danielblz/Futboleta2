package com.example.danielbustamante.futboleta2;

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

public class MainActivity extends AppCompatActivity
      implements  NavigationView.OnNavigationItemSelectedListener  {

    private FragmentManager fm;
    private FragmentTransaction ft;
    String correo, contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        Intent intent1 = getIntent();
        correo = intent1.getStringExtra("correo");
        contra = intent1.getStringExtra("pass");



       PrincipalFragment principalFragment = new PrincipalFragment();
        ft.add(R.id.frame, principalFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent1 = new Intent();
            setResult(RESULT_CANCELED, intent1);

            finish();
        }
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ft = fm.beginTransaction();
        if (id == R.id.mPrincipal) {
            PrincipalFragment principalFragment = new PrincipalFragment();
            ft.replace(R.id.frame, principalFragment ).commit();
            // Handle the camera action
        } else if (id == R.id.mPerfil) {
            Bundle args = new Bundle();
            args.putString("mail", correo);
            args.putString("pass",contra);

            PerfilFragment perfilFragment = new PerfilFragment();
            perfilFragment.setArguments(args);
            ft.replace(R.id.frame, perfilFragment).commit();

        }
        else  if (id== R.id.mCalendario){
            CalendarioFragment calendarioFragment = new CalendarioFragment();
            ft.replace(R.id.frame, calendarioFragment).commit();

        } else  if (id== R.id.mBoleta){
            BoletaFragment boletaFragment = new BoletaFragment();
            ft.replace(R.id.frame, boletaFragment).commit();
        }  else if (id == R.id.mCerrar) {
            Intent intent1 = new Intent();
            intent1.putExtra("correo", correo);
            intent1.putExtra("pass", contra);
            setResult(RESULT_OK, intent1);
            finish();
        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }








}
