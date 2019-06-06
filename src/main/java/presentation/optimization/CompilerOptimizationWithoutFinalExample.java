package presentation.optimization;

/**
 * javap CompilerOptimizationWithoutFinalExample.class
 */
public class CompilerOptimizationWithoutFinalExample {
  private static boolean IS_PRINTING = false;

  public static void main(String[] args) {
    for (int i = 0; i < 100_000_000; i++) {
      if (IS_PRINTING) {
        System.out.println("i = " + i);
      }
    }
  }
}

