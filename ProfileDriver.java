import java.util.List;

/**
 * Tests speed on each sort.
 */
public class ProfileDriver {
  /**
   * Runs the speed tests.
   */
  public static void main(String[] args) {

    // Create a SortProfiler object.
    // See the JavaDoc for an explanation of the parameters.
    /*SortProfiler sp2 = new SortProfiler(List.of(IntrospectiveSort::introspectiveSort),
        List.of("Introspective Sort"),
        1000, 1000, 10000, 500,
        Generators::generateEvil);
    SortProfiler sp = new SortProfiler(List.of(QuickSort::quickSort),
        List.of("Quick sort"),
        1000, 1000, 10000, 500,
        Generators::generateEvil);
        */
    SortProfiler sp = new SortProfiler(List.of(IntrospectiveSort::introspectiveSort),
        List.of("Quick sort"),
        1000, 1000, 10000, 100,
        Generators::generateEvil);

    // Run the profiler and send the output to stdout.
    sp.run(System.out);
  }

}