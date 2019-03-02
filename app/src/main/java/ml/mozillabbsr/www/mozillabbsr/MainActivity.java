package ml.mozillabbsr.www.mozillabbsr;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView upRecyclerView;
    RecyclerView psRecyclerView;
    Data upData;
    Data psData;
    ArrayList<Data> upDataList;
    ArrayList<Data> psDataList;
    Toolbar myToolbar;

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

        myToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(myToolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        upDataList = new ArrayList<Data>();
        upRecyclerView = findViewById(R.id.up_recyclerview);
        GridLayoutManager upGridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
        upRecyclerView.setLayoutManager(upGridLayoutManager);

        upData =new Data(R.drawable.hackathon,"Hackathon");
        upDataList.add(upData);
        upData =new Data(R.drawable.recuritment,"recuritment");
        upDataList.add(upData);
        upData =new Data(R.drawable.webvr,"WebVr");
        upDataList.add(upData);

        DataAdapter upAdapter=new DataAdapter(MainActivity.this, upDataList);
        upRecyclerView.setAdapter(upAdapter);

        psDataList = new ArrayList<Data>();
        psRecyclerView = findViewById(R.id.ps_recyclerview);
        GridLayoutManager psGridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
        psRecyclerView.setLayoutManager(psGridLayoutManager);

        psData =new Data(R.drawable.github,"OpenSource");
        psDataList.add(psData);
        psData =new Data(R.drawable.rust,"Rust");
        psDataList.add(psData);
        psData =new Data(R.drawable.googlemini,"Googlemini");
        psDataList.add(psData);

        DataAdapter psAdapter=new DataAdapter(MainActivity.this, psDataList);
        psRecyclerView.setAdapter(psAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
