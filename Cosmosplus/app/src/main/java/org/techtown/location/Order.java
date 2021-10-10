package org.techtown.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Order extends AppCompatActivity implements View.OnClickListener {

    //Toolbar toolbar;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    ChildFragment1 childFragment1;
    ChildFragment2 childFragment2;
    ChildFragment3 childFragment3;

    /*
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        setTitle("ORDER");

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayShowTitleEnabled(false);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        childFragment1 = new ChildFragment1();
        childFragment2 = new ChildFragment2();
        childFragment3 = new ChildFragment3();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("맛"));
        tabs.addTab(tabs.newTab().setText("기분"));
        tabs.addTab(tabs.newTab().setText("조합"));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("Order", "선택된 탭 : " + position);

                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                } else if (position == 1) {
                    selected = fragment2;
                } else if (position == 2) {
                    selected = fragment3;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();

                /*
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragment1.newInstance());
                ft.commit();
                */
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        /*
        mRecyclerView = findViewById(R.id.sweet_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<SweetInfo> sweetInfoArrayList = new ArrayList<>();
        sweetInfoArrayList.add(new SweetInfo(R.drawable.moka, "카페모카", "4,800원"));
        sweetInfoArrayList.add(new SweetInfo(R.drawable.caramel, "카라멜 마끼아또", "5,300원"));
        sweetInfoArrayList.add(new SweetInfo(R.drawable.banila, "바닐라 라떼", "4,600원"));

        MyAdapter myAdapter = new MyAdapter(sweetInfoArrayList);

        mRecyclerView.setAdapter(myAdapter);
        */
    }

    @Override
    public void onClick(View v) {

    }
    //홈버튼
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent homeIntent = new Intent(this, MenuActivity.class);
            startActivity(homeIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}