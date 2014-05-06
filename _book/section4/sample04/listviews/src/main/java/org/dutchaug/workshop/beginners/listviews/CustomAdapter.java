package org.dutchaug.workshop.beginners.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private final Context mContext;

    private final List<Animal> mData = new ArrayList<Animal>();

    public CustomAdapter(Context context) {
        this.mContext = context;
        createData();
    }

    private void createData() {
        mData.add(new Animal("Bear", "Mammal", R.drawable.bear_thumb, R.drawable.bear, "http://a-z-animals.com/animals/bear/"));
        mData.add(new Animal("Cat", "Mammal", R.drawable.cat_thumb, R.drawable.cat, "http://a-z-animals.com/animals/cat/"));
        mData.add(new Animal("Chicken", "Bird", R.drawable.chicken_thumb, R.drawable.chicken, "http://a-z-animals.com/animals/chicken/"));
        mData.add(new Animal("Chimpanzee", "Mammal", R.drawable.chimpanzee_thumb, R.drawable.chimpanzee, "http://a-z-animals.com/animals/chimpanzee/"));
        mData.add(new Animal("Cow", "Mammal", R.drawable.cow_thumb, R.drawable.cow, "http://a-z-animals.com/animals/cow/"));
        mData.add(new Animal("Dog", "Mammal", R.drawable.dog_thumb, R.drawable.dog, "http://a-z-animals.com/animals/dog/"));
        mData.add(new Animal("Donkey", "Mammal", R.drawable.donkey_thumb, R.drawable.donkey, "http://a-z-animals.com/animals/donkey/"));
        mData.add(new Animal("Elephant", "Mammal", R.drawable.elephant_thumb, R.drawable.elephant, "http://a-z-animals.com/animals/elephant/"));
        mData.add(new Animal("Frog", "Reptile", R.drawable.frog_thumb, R.drawable.frog, "http://a-z-animals.com/animals/frog/"));
        mData.add(new Animal("Goat", "Mammal", R.drawable.goat_thumb, R.drawable.goat, "http://a-z-animals.com/animals/goat/"));
        mData.add(new Animal("Goose", "Bird", R.drawable.goose_thumb, R.drawable.goose, "http://a-z-animals.com/animals/goose/"));
        mData.add(new Animal("Horse", "Mammal", R.drawable.horse_thumb, R.drawable.horse, "http://a-z-animals.com/animals/horse/"));
        mData.add(new Animal("Kitten", "Mammal", R.drawable.kitten_thumb, R.drawable.kitten, "http://a-z-animals.com/animals/cat/"));
        mData.add(new Animal("Lion", "Mammal", R.drawable.lion_thumb, R.drawable.lion, "http://a-z-animals.com/animals/lion/"));
        mData.add(new Animal("Monkey", "Mammal", R.drawable.monkey_thumb, R.drawable.monkey, "http://a-z-animals.com/animals/monkey/"));
        mData.add(new Animal("Pig", "Mammal", R.drawable.pig_thumb, R.drawable.pig, "http://a-z-animals.com/animals/pig/"));
        mData.add(new Animal("Rooster", "Bird", R.drawable.rooster_thumb, R.drawable.rooster, "http://a-z-animals.com/animals/chicken/"));
        mData.add(new Animal("Seal", "Mammal", R.drawable.seal_thumb, R.drawable.seal, "http://a-z-animals.com/animals/seal/"));
        mData.add(new Animal("Sheep", "Mammal", R.drawable.sheep_thumb, R.drawable.sheep, "http://a-z-animals.com/animals/sheep/"));
        mData.add(new Animal("Tiger", "Mammal", R.drawable.tiger_thumb, R.drawable.tiger, "http://a-z-animals.com/animals/tiger/"));
        mData.add(new Animal("Turkey", "Bird", R.drawable.turkey_thumb, R.drawable.turkey, "http://a-z-animals.com/animals/turkey/"));
        mData.add(new Animal("Blue Whale", "Mammal", R.drawable.blue_whale_thumb, R.drawable.blue_whale, "http://a-z-animals.com/animals/blue-whale/"));
        mData.add(new Animal("Wolf", "Mammal", R.drawable.wolf_thumb, R.drawable.wolf, "http://a-z-animals.com/animals/wolf/"));
    }

    // TODO Exercise 04.03
    @Override
    public int getCount() {
        return 0; // TODO Return the number of items in our adapter
    }

    @Override
    public Object getItem(int position) {
        return null; // TODO Retrieve the correct animal and return it
    }

    @Override
    public long getItemId(int position) {
        return 0; // TODO What would be a good value to return here?
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Animal animal = mData.get(position);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // If you have created your own custom layout you can replace it here
            convertView = layoutInflater.inflate(R.layout.custom_layout, null, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.thumbnail_image);
        imageView.setImageResource(animal.thumbnailResource);

        TextView textView = (TextView) convertView.findViewById(R.id.animal_name);
        textView.setText(animal.name);

        textView = (TextView) convertView.findViewById(R.id.animal_type);
        textView.setText(animal.type);

        return convertView;
    }

}