package ca.javateacheer.multquiz1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  TextView mMessageView;
  TextView mProblemView;
  EditText mAnswerEdit;

  MultiplicationProblem mProblem = new MultiplicationProblem();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mMessageView = findViewById(R.id.message);
    mProblemView = findViewById(R.id.problem);
    mAnswerEdit = findViewById(R.id.answer);

    mProblemView.setText(mProblem.toString());
  }

  public void check(View view) {
    try{
      int userAnswer  = Integer.parseInt(mAnswerEdit.getText().toString());
      if(userAnswer == mProblem.getAnswer()){
        Toast.makeText(this,R.string.right_answer, Toast.LENGTH_LONG).show();
        mMessageView.setText(R.string.right_answer);
        mMessageView.setTextColor(getResources().getColor(R.color.Green500));
      }else{
        Toast.makeText(this,R.string.wrong_answer, Toast.LENGTH_LONG).show();
        mMessageView.setText(R.string.wrong_answer);
        mMessageView.setTextColor(getResources().getColor(R.color.Red500));
      }
    }catch(NumberFormatException e) {
      Toast.makeText(this, R.string.illegal_input, Toast.LENGTH_LONG).show();
    }
  }

  public void next(View view) {
    mMessageView.setText(R.string.enter_answer);
    mMessageView.setTextColor(getResources().getColor(R.color.Purple500));
    mAnswerEdit.setText("");
    mProblem.reset();
    mProblemView.setText(mProblem.toString());
  }
}
