package baseball.enums;

public enum RestartType {
  START("1");

  private String value;

  RestartType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
