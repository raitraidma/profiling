package presentation.memory;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeakExample {
  private Map<Long, LeakingClass> leakingMap = new HashMap<>();
  private Map<Long, NonLeakingClass> nonLeakingMap = new HashMap<>();

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Start leaking");

    MemoryLeakExample memoryLeakExample = new MemoryLeakExample();

    while (true) {
      memoryLeakExample.letsTakeALeak();
      Thread.sleep(2000);
      System.gc();
      Thread.sleep(3000);
    }
  }

  private void letsTakeALeak() {
    for (int i = 0; i < 100_000; i++) {
      nonLeakingMap.put(System.nanoTime(), new NonLeakingClass());
      leakingMap.put(System.nanoTime(), new LeakingClass());
    }
    nonLeakingMap.clear();
  }
}

class LeakingClass {}

class NonLeakingClass {}
