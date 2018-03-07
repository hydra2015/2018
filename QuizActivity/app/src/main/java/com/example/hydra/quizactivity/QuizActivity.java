package com.example.hydra.quizactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//AppcompatActivity作为activity的子类保证旧版本兼容
public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mLastButton;
    private TextView mQuestionTextView;

    private int mCurrentIndex = 0;

    private Question [] mQuestionBank = new Question[] {
            new Question(R.string.question_anyang, true),
            new Question(R.string.question_zhengzhou, true),
            new Question(R.string.question_beijing, true),
            new Question(R.string.question_handong, false),
            new Question(R.string.question_tangyin, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initView();
        updataQuestion();
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(QuizActivity.this, "点击了正确按钮", Toast.LENGTH_SHORT).show();
                checkAnswer(true);
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
                checkAnswer(false);
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
    }

    private void checkAnswer(boolean userPerssedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userPerssedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mNextButton = findViewById(R.id.next_button);
        mLastButton = findViewById(R.id.last_button);
    }
}
