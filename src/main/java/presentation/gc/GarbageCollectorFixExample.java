package presentation.gc;

public class GarbageCollectorFixExample {
  public static void main(String[] args) {
    long count = 0L;

    for (int i = 0; i < 100_000_000; i++) {
      count++;
    }
  }
}

