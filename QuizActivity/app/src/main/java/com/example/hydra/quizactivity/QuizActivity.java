package com.example.hydra.quizactivity;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hydra.quizactivity.utils.LogUtil;

//AppcompatActivity作为activity的子类保证旧版本兼容
public class QuizActivity extends AppCompatActivity {

    private static final String KEY_INDEX = "index";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mLastButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;
    private int mCount;
    private int mRightCount;

    private Question [] mQuestionBank = new Question[] {
            new Question(R.string.question_anyang, true, true),
            new Question(R.string.question_zhengzhou, true, true),
            new Question(R.string.question_beijing, true, true),
            new Question(R.string.question_handong, false, true),
            new Question(R.string.question_tangyin, false, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initView();
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX);
        }
        updataQuestion();
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(QuizActivity.this, "点击了正确按钮", Toast.LENGTH_SHORT).show();

                checkAnswer(true);
                mQuestionBank[mCurrentIndex].setmEnter(false);
                LogUtil.e("mCurrentIndex:", mCurrentIndex + "");
                mTrueButton.setEnabled(mQuestionBank[mCurrentIndex].ismEnter());
                mFalseButton.setEnabled(mQuestionBank[mCurrentIndex].ismEnter());
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(QuizActivity.this, "点击了错误按钮", Toast.LENGTH_SHORT).show();
                /*Toast toast = Toast.makeText(QuizActivity.this, "d点击了错误按钮", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setText("点击了错误按钮");
                toast.show();*/
                mQuestionBank[mCurrentIndex].setmEnter(false);
                LogUtil.e("mCurrentIndex:", mCurrentIndex + "");
                checkAnswer(false);
                mTrueButton.setEnabled(mQuestionBank[mCurrentIndex].ismEnter());
                mFalseButton.setEnabled(mQuestionBank[mCurrentIndex].ismEnter());
            }
        });

        mNextButton.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1)%mQuestionBank.length;
                updataQuestion();
            }
        });

        mLastButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(mCurrentIndex == 0){
                    mCurrentIndex = mCurrentIndex + mQuestionBank.length;
                }
                mCurrentIndex = (mCurrentIndex -1) % mQuestionBank.length;
                updataQuestion();
            }
        });
    }

    private void updataQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        mTrueButton.setEnabled(mQuestionBank[mCurrentIndex].ismEnter());
        mFalseButton.setEnabled(mQuestionBank[mCurrentIndex].ismEnter());
    }

    private void checkAnswer(boolean userPerssedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userPerssedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
            mRightCount++;
        }else {
            messageResId = R.string.incorrect_toast;
        }
        mCount++;
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
        if (mCount >= mQuestionBank.length){
            Toast.makeText(this, (float)mRightCount/mQuestionBank.length*100 + "%", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mNextButton = findViewById(R.id.next_button);
        mLastButton = findViewById(R.id.last_button);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX, mCurrentIndex);
    }
}
