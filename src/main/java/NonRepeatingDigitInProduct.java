import java.util.HashSet;
import java.util.Set;


public class NonRepeatingDigitInProduct {

  static Set<Character> uniqueDigits(Long n) {
    Set<Character> digits = new HashSet<>();
    for (char d : n.toString().toCharArray()) {
      digits.add(d);
    }
    return digits;
  }

  static int nonRepeatingDigitProductCount(int x, int low, int high) {

    if (low > high || x == 1)
      return 0;

    int countInValid = 0;
    for (long i = low; i <= high; i++) {

      Set<Character> set1 = uniqueDigits(i);
      Set<Character> set2 = uniqueDigits(i * x);

      int set2Size = set2.size();
      set2.addAll(set1);
      if (set1.size() + set2Size > set2.size()) {
        countInValid++;
      }
    }

    return (high - low) - countInValid + 1;
  }

  public static void main(String[] args) {
    System.out.println(nonRepeatingDigitProductCount(2, 10, 15));
  }
}
