package org.dutchaug.workshop.beginners.viewpager;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
	
    private ViewPager mViewPager;
	
	private ArrayList<Animal> mAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mai);
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		
    }
	
    public class AnimalPagerAdapter extends FragmentPagerAdapter {

        public AnimalPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return AnimalFragment.newInstance(mMeetings.get(position), mMeetingGroupTitle);
        }

        @Override
        public int getCount() {
            return mMeetings.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mMeetings.get(position).subject;
        }

    }

}