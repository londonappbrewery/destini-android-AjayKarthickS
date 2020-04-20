package com.londonappbrewery.destini;

public class Story {
    private int mStoryID, mAnswer1ID, mAnswer2ID;

    public Story(int storyID, int answer1ID, int answer2ID) {
        mStoryID = storyID;
        mAnswer1ID = answer1ID;
        mAnswer2ID = answer2ID;
    }

    public int getStoryID() {
        return mStoryID;
    }

    public void setStoryID(int storyID) {
        mStoryID = storyID;
    }

    public int getAnswer1ID() {
        return mAnswer1ID;
    }

    public void setAnswer1ID(int answer1ID) {
        mAnswer1ID = answer1ID;
    }

    public int getAnswer2ID() {
        return mAnswer2ID;
    }

    public void setAnswer2ID(int answer2ID) {
        mAnswer2ID = answer2ID;
    }

    public int getNextStoryIndex(int i, int storyIndex) {
        if (storyIndex  ==  1) {
            if (i == 1) {
                storyIndex = 3;
            } else if (i == 2) {
                storyIndex = 2;
            }
        }else if (storyIndex == 2) {
            if (i == 1) {
                storyIndex = 3;
            } else if (i == 2) {
                storyIndex = 4;
            }
        }else if (storyIndex == 3) {
            if(i == 1) {
                storyIndex = 6;
            } else if (i == 2) {
                storyIndex = 5;
            }
        }
        return storyIndex;
    }
}
