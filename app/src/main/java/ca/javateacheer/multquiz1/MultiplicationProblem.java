package ca.javateacheer.multquiz1;

/**
 * Created by Alex on 2018-02-01.
 */

public class MultiplicationProblem {
  private int a;
  private int b;
  private int answer;

  public MultiplicationProblem() {
    reset();
  }

  public final void reset(){
    a = (int) (1 + 9 * Math.random());
    b = (int) (1 + 9 * Math.random());
    answer = a * b;
  }

  public MultiplicationProblem(int a, int b) {
    this.a = a;
    this.b = b;
    answer = a * b;
  }

  public int getA() {
    return a;
  }

  public int getB() {
    return b;
  }

  public int getAnswer() {
    return answer;
  }

  @Override
  public String toString(){
    return String.format("%s x %s =", a, b);
  }

}
