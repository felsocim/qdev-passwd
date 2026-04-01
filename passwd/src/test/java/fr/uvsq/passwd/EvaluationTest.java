package fr.uvsq.passwd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
  @Test
  public void testWeakLowercase() {
    Strength result = Evaluation.evaluatePassword("?ABCD123!");
    assertEquals(Strength.WEAK, result);
  }
  @Test
  public void testWeakUppercase() {
    Strength result = Evaluation.evaluatePassword("?abcd123!");
    assertEquals(Strength.WEAK, result);
  }
  @Test
  public void testWeakDigit() {
    Strength result = Evaluation.evaluatePassword("?AbCdeFg!");
    assertEquals(Strength.WEAK, result);
  }
  @Test
  public void testWeakSpecial() {
    Strength result = Evaluation.evaluatePassword("0AbCd1234");
    assertEquals(Strength.WEAK, result);
  }
  @Test
  public void testError() {
    assertThrows(IllegalArgumentException.class, () -> {
      Evaluation.evaluatePassword("");
    });
  }
}
