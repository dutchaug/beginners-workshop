package org.dutchaug.workshop.beginners.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.widget.ImageView;

public class ImageFragment extends Fragment {
	
	private static final String ARG_IMAGE_RESOURCE = "image_resource";

	private int imageResource

    public ImageFragment() {
    }

    public static ImageFragment newInstance(int imageResource) {

        ImageFragment fragment = new ImageFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_RESOURCE, imageResource);
        fragment.setArguments(args);

        return fragment;
    }
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            imageResource = savedInstanceState.getLong(ARG_IMAGE_RESOURCE);
        } else {
            imageResource = getArguments() != null ? getArguments().getLong(ARG_IMAGE_RESOURCE) : -1;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(ARG_IMAGE_RESOURCE, imageResource);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView imageView = inflater.inflate(R.layout.fragment_image, container, false);
		imageView.setImageResource(imageResource);
        return imageView;
    }

}