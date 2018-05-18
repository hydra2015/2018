package com.example.hydra.quizactivity;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hydra on 2018/3/5.
 */

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mEnter;

    public Question(int mTextResId, boolean mAnswerTrue, boolean mEnter) {
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
        this.mEnter = mEnter;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public boolean ismEnter() {
        return mEnter;
    }

    public void setmEnter(boolean mEnter) {
        this.mEnter = mEnter;
    }
}
