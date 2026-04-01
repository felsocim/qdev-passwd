package fr.uvsq.passwd;

public class Evaluation {
  public static Strength evaluatePassword(String password) {
    if(password.isEmpty()) {
      throw new IllegalArgumentException("Password must not be an empty string!");
    }
    int length = password.length();
    if(length < 8) {
      return Strength.WEAK;
    }
    boolean hasLowercase = false;
    boolean hasUppercase = false;
    boolean hasDigit = false;
    boolean hasSpecial = false;
    for(int i = 0; i < length; i++) {
      char current = password.charAt(i);
      if(Character.isLowerCase(current)) {
        hasLowercase = true;
      } else if(Character.isUpperCase(current)) {
        hasUppercase = true;
      } else if(Character.isDigit(current)) {
        hasDigit = true;
      } else {
        hasSpecial = true;
      }
    }
    if(hasLowercase && hasUppercase && hasDigit && hasSpecial) {
      return Strength.STRONG;
    }
    return Strength.WEAK;
  }
}
