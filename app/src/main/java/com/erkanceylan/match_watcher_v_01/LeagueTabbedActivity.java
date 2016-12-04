package com.erkanceylan.match_watcher_v_01;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.erkanceylan.match_watcher_v_01.Fragments.MatchResultsTab;
import com.erkanceylan.match_watcher_v_01.Fragments.StandingsTab;
import com.erkanceylan.match_watcher_v_01.Fragments.TahministTab;

public class LeagueTabbedActivity extends AppCompatActivity
{
    public static Bundle bundle;
    private void mainInit()
    {
        bundle=getIntent().getExtras();
    }

    /* -------------------------------------------------------- */

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_league_tabbed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),3);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mainInit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_league_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment
    {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";




        public PlaceholderFragment()
        {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber)
        {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {
                return null;
        }
    }

    /**
     * A {@link FragmentStatePagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter
    {
        int mNumOfTabs;
        public SectionsPagerAdapter(FragmentManager fm, int NumOfTabs)
        {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position)
        {
            switch (position)
            {
                case 0:
                    MatchResultsTab matchResultsTab = new MatchResultsTab();
                    return matchResultsTab;
                case 1:
                    StandingsTab standingsTab = new StandingsTab();
                    return standingsTab;
                case 2:
                    TahministTab tahminkolikTab= new TahministTab();
                    return tahminkolikTab;
                default:
                    return null;
            }
        }

        @Override
        public int getCount()
        {
            return mNumOfTabs;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:
                    return getResources().getString(R.string.match_results);
                case 1:
                    return getResources().getString(R.string.standings);
                case 2:
                    return getResources().getString(R.string.tahminist);
            }
            return null;
        }
    }
}
