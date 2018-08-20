/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.deutsch;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
 @Override
 public void onCompletion(MediaPlayer mediaPlayer) {
  // Now that the sound file has finished playing, release the media player resources.
  releaseMediaPlayer();
    }
 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<Word>();
        // word.add(0, "one");
        words.add(new Word("one", "Ein", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "Zwei", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "Drei", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "Vier", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "Fünf", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "Sechs", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "Sieben", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "Acht", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "Neun", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "Zehn", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);

                /**
                 * Clean up the media player by releasing its resources.
                 */

            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}

