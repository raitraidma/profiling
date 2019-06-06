package presentation.optimization;

/**
 * javap CompilerOptimizationWithFinalExample.class
 */
public class CompilerOptimizationWithFinalExample {
  private static final boolean IS_PRINTING = false;

  public static void main(String[] args) {
    for (int i = 0; i < 100_000_000; i++) {
      if (IS_PRINTING) {
        System.out.println("i = " + i);
      }
    }
  }
}

