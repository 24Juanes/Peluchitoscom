package com.example.juanes24.peluchitoscom;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Comunicador {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ArrayList<Peluches> peluchesArrayList;

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

        fragmentManager= getSupportFragmentManager();
        fragmentTransaction= fragmentManager.beginTransaction();

        AgregarFragment agregarFragment= new AgregarFragment();
        fragmentTransaction.add(R.id.frameLayout,agregarFragment).commit();

        peluchesArrayList = new ArrayList<>();
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



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        fragmentTransaction= fragmentManager.beginTransaction();

        if (id == R.id.nAgregar) {
            AgregarFragment agregarFragment= new AgregarFragment();
            fragmentTransaction.replace(R.id.frameLayout,agregarFragment).commit();

        } else if (id == R.id.nBuscar) {
            BuscarFragment buscarFragment= new BuscarFragment();
            fragmentTransaction.replace(R.id.frameLayout,buscarFragment).commit();

        } else if (id == R.id.nEliminar) {
            EliminarFragment eliminarFragment= new EliminarFragment();
            fragmentTransaction.replace(R.id.frameLayout,eliminarFragment).commit();

        } else if (id == R.id.nVer) {
            String data="";
            for (int i=0; i<peluchesArrayList.size(); i++) {
                data = data +peluchesArrayList.get(i).getNombre()+peluchesArrayList.get(i).getCantidad()+
                        peluchesArrayList.get(i).getPrecio();
            }
            Bundle info = new Bundle();
            info.putString("data",data);
            VerFragment verFragment = new VerFragment();
            verFragment.setArguments(info);
            fragmentTransaction.replace(R.id.frameLayout,verFragment).commit();



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void enviarDatos(int id, String nombre, int cantidad, int precio) {
        Peluches peluches= new Peluches(id, cantidad, precio, nombre);
        peluchesArrayList.add(peluches);
        Toast.makeText(this,"Peluche Guardado",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void enviarDatosBuscar(String s) {
        for (int i=0; i<peluchesArrayList.size(); i++){
            Bundle data = new Bundle();
            data.putInt("id", peluchesArrayList.get(i).getId());
            data.putInt("precio", peluchesArrayList.get(i).getPrecio());
            data.putInt("cantidad", peluchesArrayList.get(i).getCantidad());
            data.putString("nombre", peluchesArrayList.get(i).getNombre());
        }
    }

    @Override
    public void eliminarDatosBuscar(String s) {
        for (int i=0; i<peluchesArrayList.size(); i++) {
            if (peluchesArrayList.get(i).getNombre().equals(s)){
                peluchesArrayList.remove(i);
            }else {
                Toast.makeText(this, "No está en el inventario",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
