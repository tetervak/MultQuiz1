package ca.javateacheer.multquiz1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private static final String PROBLEM = "problem";
  private TextView mMessageView;
  private TextView mProblemView;
  private EditText mAnswerEdit;

  private MultiplicationProblem mProblem;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mMessageView = findViewById(R.id.message);
    mProblemView = findViewById(R.id.problem);
    mAnswerEdit = findViewById(R.id.answer);

    if(savedInstanceState != null){
      mProblem = (MultiplicationProblem) savedInstanceState.getSerializable(PROBLEM);
    }else{
      mProblem = new MultiplicationProblem();
    }

    assert mProblem != null;
    mProblemView.setText(mProblem.getText());
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
    mProblemView.setText(mProblem.getText());
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putSerializable(PROBLEM, mProblem);

  }
}
