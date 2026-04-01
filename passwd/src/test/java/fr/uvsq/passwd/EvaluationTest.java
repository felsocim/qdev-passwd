package fr.uvsq.passwd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EvaluationTest {
  @Test
  public void testStrong() {
    Strength result = Evaluation.evaluatePassword("?AbCd123!");
    assertEquals(Strength.STRONG, result);
  }
}
