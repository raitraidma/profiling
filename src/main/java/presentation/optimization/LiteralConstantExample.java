package presentation.optimization;

public class LiteralConstantExample {
  public static void main(String[] args) {
    int age = 3 * 7 + 1;

    final String firstName = "Jon";
    final String lastName = "Snow";
    String fullName = firstName + " " + lastName;

    String firstName2 = "Daenerys";
    String lastName2 = "Targaryen";
    String fullName2 = firstName2 + " " + lastName2;

    System.out.println(fullName + " is " + age + " years old");
    System.out.println(fullName2 + " is also " + age + " years old");
  }
}

