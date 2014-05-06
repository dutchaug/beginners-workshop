package org.dutchaug.workshop.beginners.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE); // Uncomment this if you want the action bar back
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
        // TODO Exercise 05.03 - Create an instance of AnimalPagerAdapter and assign it to mViewPager
    }

    public class AnimalPagerAdapter extends FragmentPagerAdapter {

        private final List<Animal> mAnimals = new ArrayList<Animal>();

        private void createData() {
            mAnimals.add(new Animal("Bear", "Mammal", R.drawable.bear_thumb, R.drawable.bear, R.raw.bear, "http://a-z-animals.com/animals/bear/"));
            mAnimals.add(new Animal("Cat", "Mammal", R.drawable.cat_thumb, R.drawable.cat, R.raw.cat, "http://a-z-animals.com/animals/cat/"));
            mAnimals.add(new Animal("Chicken", "Bird", R.drawable.chicken_thumb, R.drawable.chicken, R.raw.chicken, "http://a-z-animals.com/animals/chicken/"));
            mAnimals.add(new Animal("Chimpanzee", "Mammal", R.drawable.chimpanzee_thumb, R.drawable.chimpanzee, R.raw.chimpanzee, "http://a-z-animals.com/animals/chimpanzee/"));
            mAnimals.add(new Animal("Cow", "Mammal", R.drawable.cow_thumb, R.drawable.cow, R.raw.cow, "http://a-z-animals.com/animals/cow/"));
            mAnimals.add(new Animal("Dog", "Mammal", R.drawable.dog_thumb, R.drawable.dog, R.raw.dog, "http://a-z-animals.com/animals/dog/"));
            mAnimals.add(new Animal("Donkey", "Mammal", R.drawable.donkey_thumb, R.drawable.donkey, R.raw.donkey, "http://a-z-animals.com/animals/donkey/"));
            mAnimals.add(new Animal("Elephant", "Mammal", R.drawable.elephant_thumb, R.drawable.elephant, R.raw.elephant, "http://a-z-animals.com/animals/elephant/"));
            mAnimals.add(new Animal("Frog", "Reptile", R.drawable.frog_thumb, R.drawable.frog, R.raw.frog, "http://a-z-animals.com/animals/frog/"));
            mAnimals.add(new Animal("Goat", "Mammal", R.drawable.goat_thumb, R.drawable.goat, R.raw.goat, "http://a-z-animals.com/animals/goat/"));
            mAnimals.add(new Animal("Goose", "Bird", R.drawable.goose_thumb, R.drawable.goose, R.raw.goose, "http://a-z-animals.com/animals/goose/"));
            mAnimals.add(new Animal("Horse", "Mammal", R.drawable.horse_thumb, R.drawable.horse, R.raw.horse, "http://a-z-animals.com/animals/horse/"));
            mAnimals.add(new Animal("Kitten", "Mammal", R.drawable.kitten_thumb, R.drawable.kitten, R.raw.kitten, "http://a-z-animals.com/animals/cat/"));
            mAnimals.add(new Animal("Lion", "Mammal", R.drawable.lion_thumb, R.drawable.lion, R.raw.lion, "http://a-z-animals.com/animals/lion/"));
            mAnimals.add(new Animal("Monkey", "Mammal", R.drawable.monkey_thumb, R.drawable.monkey, R.raw.monkey, "http://a-z-animals.com/animals/monkey/"));
            mAnimals.add(new Animal("Pig", "Mammal", R.drawable.pig_thumb, R.drawable.pig, R.raw.pig, "http://a-z-animals.com/animals/pig/"));
            mAnimals.add(new Animal("Rooster", "Bird", R.drawable.rooster_thumb, R.drawable.rooster, R.raw.rooster, "http://a-z-animals.com/animals/chicken/"));
            mAnimals.add(new Animal("Seal", "Mammal", R.drawable.seal_thumb, R.drawable.seal, R.raw.seal, "http://a-z-animals.com/animals/seal/"));
            mAnimals.add(new Animal("Sheep", "Mammal", R.drawable.sheep_thumb, R.drawable.sheep, R.raw.sheep, "http://a-z-animals.com/animals/sheep/"));
            mAnimals.add(new Animal("Tiger", "Mammal", R.drawable.tiger_thumb, R.drawable.tiger, R.raw.tiger, "http://a-z-animals.com/animals/tiger/"));
            mAnimals.add(new Animal("Turkey", "Bird", R.drawable.turkey_thumb, R.drawable.turkey, R.raw.turkey, "http://a-z-animals.com/animals/turkey/"));
            mAnimals.add(new Animal("Blue Whale", "Mammal", R.drawable.blue_whale_thumb, R.drawable.blue_whale, R.raw.blue_whale, "http://a-z-animals.com/animals/blue-whale/"));
            mAnimals.add(new Animal("Wolf", "Mammal", R.drawable.wolf_thumb, R.drawable.wolf, R.raw.wolf, "http://a-z-animals.com/animals/wolf/"));
        }

        public AnimalPagerAdapter(FragmentManager fm) {
            super(fm);
            createData();
        }

        @Override
        public Fragment getItem(int position) {
            return null; // TODO Exercise 05.01 - Return a new AnimalFragment object for the given position
        }

        @Override
        public int getCount() {
            return 0; // TODO Exercise 05.02 - Return the amount of animals in our data set.
        }

    }

}