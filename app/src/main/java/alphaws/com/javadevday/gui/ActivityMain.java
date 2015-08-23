package alphaws.com.javadevday.gui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import alphaws.com.javadevday.R;
import alphaws.com.javadevday.beans.Event;
import alphaws.com.javadevday.database.ControlEvent;
import alphaws.com.javadevday.database.DataBaseHandler;


public class ActivityMain extends AppCompatActivity {

    private static CustomPagerAdapter mCustomPagerAdapter;
    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout Drawer;
    private Toolbar toolbar;
    protected DataBaseHandler dh;
    protected ControlEvent controlEvent;
    private  ArrayList<Event> events;
    private FragmentEvent fragment;
    ViewPager mViewPager;
    int idPage;


    @Override
    protected void onResume() {
        super.onResume();

        Drawer.closeDrawers();

        mCustomPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), this);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        dh = DataBaseHandler.getInstance(this);
        controlEvent = new ControlEvent(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        Drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.open_drawer,R.string.close_drawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

        };
        Drawer.setDrawerListener(mDrawerToggle);
        Drawer.setFocusableInTouchMode(false);
        mDrawerToggle.syncState();



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //events = controlEvent.getEventsByIdPlace(dh, position + 1);
        fragment.notifyDataSetChanged();
    }

    class CustomPagerAdapter extends FragmentStatePagerAdapter {

        Context mContext;

        public CustomPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            idPage = position;
            // Create fragment object
            fragment = new FragmentEvent();

            // Attach some data to the fragment
            // that we'll use to populate our fragment layouts
            Bundle args = new Bundle();
            events = controlEvent.getEventsByIdPlace(dh, position+1);

            args.putParcelableArrayList("events", events);

            // Set the arguments on the fragment
            // that will be fetched in the
            // DemoFragment@onCreateView
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 1:
                    return "Android / Móviles - W107";
                case 2:
                    return "Lenguajes JVM - W108";
                case 3:
                    return "Java EE - W109";
                case 4:
                    return "Arquitectura / Metodología - W110";
                case 5:
                    return "Java SE - W105/106";
                case 6:
                    return "IoT / Big Data / Remote Session - W111";
                case 0:
                    return "Auditorio Arrupe";
                default:
                    return "No Title";
            }
        }
    }

    @Override
    public  void onBackPressed ()
    {
        Drawer.closeDrawers();
        super.onBackPressed();
    }
}
