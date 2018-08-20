package com.example.android.deutsch;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Милла on 16.04.2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color for this list of words */
     private int mColorResourceId;

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param Word A List of Words objects to display in a list
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Activity context, ArrayList<Word> Word,int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Word);
        mColorResourceId = colorResourceId;
    }


        @NonNull
        @Override
        public View getView ( int position, @Nullable View convertView, @NonNull ViewGroup parent){
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if(listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
            }
     // Get the {@link Word} object located at this position in the list
            Word currentWord = getItem(position);
            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView nameTextView = (TextView) listItemView.findViewById(R.id.deutsch_text_view);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            nameTextView.setText(currentWord.getDeutschTranslation());

            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView

            defaultTextView.setText(currentWord.getDefaultTranslation());
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            if (currentWord.hasImage()) {
                // If an image is available, display the provided image based on the resource ID
                imageView.setImageResource(currentWord.getImageResourceId());
                // Make sure the view is visible
                imageView.setVisibility(View.VISIBLE);
            }
                else {
                    // Otherwise hide the ImageView (set visibility to GONE)
                    imageView.setVisibility(View.GONE);
            }

            View textContainer = listItemView.findViewById(R.id.text_container);
            int color = ContextCompat.getColor(getContext(), mColorResourceId);
            textContainer.setBackgroundColor(color);
            // Return the whole list item layout (containing 2 TextViews)
            // so that it can be shown in the ListView
            return listItemView;
        }


    }
