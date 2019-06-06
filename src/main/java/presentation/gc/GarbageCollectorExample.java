package presentation.gc;

public class GarbageCollectorExample {
  public static void main(String[] args) {
    Long count = 0L;

    for (int i = 0; i < 100_000_000; i++) {
      count++;
    }
  }
}

