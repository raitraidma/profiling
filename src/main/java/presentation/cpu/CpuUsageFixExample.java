package presentation.cpu;

public class CpuUsageFixExample {
  public static void main(String[] args) {
    new CpuUsageFixExample().runDemo();
  }

  private void runDemo() {
    long start = System.currentTimeMillis();

    System.out.printf("Method 1 returned: %s", method1());
    System.out.printf("Method 2 returned: %s", method2());
    System.out.printf("Method 3 returned: %s", method3());

    long end = System.currentTimeMillis();

    System.out.printf("Execution took %d ms", end - start);
  }

  private String method1() {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < 100_000; i++) {
      result.append(i);
    }

    return result.toString();
  }

  private String method2() {
    String result = "";

    for (int i = 0; i < 10_000; i++) {
      result += i;
    }

    return result;
  }

  private String method3() {
    String result = "";

    for (int i = 0; i < 1000; i++) {
      result += i;
    }

    return result;
  }
}
