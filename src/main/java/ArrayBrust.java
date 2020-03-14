import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ArrayBrust {

  public static List<String> getShrunkArray(List<String> inputLines, int burstLength) {

    Stack<Pair> stack = new Stack<>();

    for (int i = 0; i < inputLines.size(); ++i) {
      char ch = inputLines.get(i).charAt(0); // line is single char

      if (!stack.isEmpty()) {
        Pair top = stack.peek();
        if (top.ch == ch) {
          Pair p = stack.pop();
          ++p.count;
          stack.push(p);
          continue;
        } else if (top.count >= burstLength) {
          stack.pop();
          --i;
          continue;
        }
      }

      stack.push(new Pair(ch, 1));
    }

    List<String> result = new ArrayList<>();
    while (!stack.isEmpty()) {
      Pair p = stack.pop();
      if (p.count >= burstLength) continue;
      for (int i = 0; i < p.count; i++) {
        result.add(Character.toString(p.ch));
      }
    }

    Collections.reverse(result);
    return result;
  }

  static class Pair {
    char ch;
    int count;

    Pair(char ch, int count) {
      this.ch = ch;
      this.count = count;
    }

    @Override
    public String toString() {
      return "" + ch + " " + count;
    }
  }

  public static void main(String[] args) {

    String input = "abcdeeeeddccbfgfff";
    List<String> inputLines = Arrays.asList(input.split(""));
    int burstLength = 3;
    System.out.println(getShrunkArray(inputLines, burstLength));
  }
}
