package aldev.pagkages;

import aldev.Package;

/**
 * Name
 */
public class Name implements Package<String, String> {

  private String fullName;

  public Name(String fullName) {
    this.fullName = fullName;
  }

  @Override
  public String process() {
    this.fullName = this.fullName.substring(0, 1).toUpperCase() + this.fullName.substring(1);
    return this.fullName;
  }

  @Override
  public Name[] split(int parts) {
    String[] words = this.fullName.split(" ");
    Name[] names = new Name[words.length];

    for (int i = 0; i < words.length; i++) {
      names[i] = new Name(words[i]);
    }

    return names;
  }

  @Override
  public String toString() {
    return this.fullName;
  }
}