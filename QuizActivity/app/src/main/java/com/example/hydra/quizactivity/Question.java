package com.example.hydra.quizactivity;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hydra on 2018/3/5.
 */

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int question_anyang, boolean b) {
        mAnswerTrue = b;
        mTextResId = question_anyang;
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
}
