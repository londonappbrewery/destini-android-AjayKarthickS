package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mAnswer1Button, mAnswer2Button;
    private int mStoryIndex = 1;
    private Story[] mStoryBook = {
            new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T2_Ans1),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new Story(R.string.T4_End, 0,0),
            new Story(R.string.T5_End, 0,0),
            new Story(R.string.T6_End, 0,0)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mAnswer1Button = findViewById(R.id.buttonTop);
        mAnswer2Button = findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mAnswer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNextStory(1);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mAnswer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNextStory(2);
            }
        });

    }

    private void updateNextStory(int i) {
        mStoryIndex = mStoryBook[mStoryIndex-1].getNextStoryIndex(i,mStoryIndex);
        mStoryTextView.setText(mStoryBook[mStoryIndex-1].getStoryID());
        int mAnswer1ID = mStoryBook[mStoryIndex-1].getAnswer1ID();
        int mAnswer2ID = mStoryBook[mStoryIndex-1].getAnswer2ID();
        if(mAnswer1ID != 0) {
            mAnswer1Button.setText(mAnswer1ID);
        } else {
            mAnswer1Button.setVisibility(View.GONE);
        }
        if (mAnswer2ID != 0) {
            mAnswer2Button.setText(mAnswer2ID);
        }else {
            mAnswer2Button.setVisibility(View.GONE);
        }
    }
}
