package fr.uvsq.passwd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EvaluationTest {
  @Test
  public void testStrong() {
    Strength result = Evaluation.evaluatePassword("?AbCd123!");
    assertEquals(Strength.STRONG, result);
  }
  @Test
  public void testWeakLength() {
    Strength result = Evaluation.evaluatePassword("?AbCd1!");
    assertEquals(Strength.WEAK, result);
  }
}
