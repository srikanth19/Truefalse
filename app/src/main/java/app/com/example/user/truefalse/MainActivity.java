package app.com.example.user.truefalse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mtruebutton;
    private Button mfalsebutton;
    private TextView qustnview;
    private Button nxt;
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };
    private int mCurrentIndex = 0;
    private void updatequstn()
    {
        final int question=mQuestionBank[mCurrentIndex].getTextResId();
        qustnview.setText(question);
    }
    private void checkanser(boolean userpressed)
    {
        boolean answeristrue=mQuestionBank[mCurrentIndex].isAnswerTrue();
        int msgresid=0;
        if(userpressed==answeristrue)
        {
            msgresid=R.string.crrct_txt;
        }
        else
        {
            msgresid=R.string.wrng_txt;
        }
        Toast.makeText(this,msgresid,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qustnview=(TextView)findViewById(R.id.txt);



         mtruebutton=(Button) findViewById(R.id.trbttn);
        mtruebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanser(true);

            }
        });
        mfalsebutton=(Button) findViewById(R.id.flsbttn);
        mfalsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanser(false);
                            }
        });
        nxt=(Button) findViewById(R.id.nxt);
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updatequstn();
            }
        });
        updatequstn();

    }
}
