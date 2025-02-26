import java.util.*;
 
public class BalancedBrackets {
    public static void checkBalanced(String s) {
        Map<Character, Integer> bracketCount = new HashMap<>();
        bracketCount.put('(', 0);
        bracketCount.put('{', 0);
        bracketCount.put('[', 0);
        
        for (char ch : s.toCharArray()) {
            if (bracketCount.containsKey(ch)) { // If it's an opening bracket
                bracketCount.put(ch, bracketCount.get(ch) + 1);
            } else if (ch == ')' || ch == '}' || ch == ']') { // If it's a closing bracket
                char openBracket = getOpeningBracket(ch);
                if (bracketCount.get(openBracket) == 0) {
                    System.out.println("Not Balanced");
                    return; // Closing bracket appears before any opening
                }
                bracketCount.put(openBracket, bracketCount.get(openBracket) - 1);
            }
        }
 
        // Check if all bracket counts are zero
        if (bracketCount.get('(') == 0 && bracketCount.get('{') == 0 && bracketCount.get('[') == 0) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
 
    private static char getOpeningBracket(char closing) {
        return switch (closing) {
            case ')' -> '(';
            case '}' -> '{';
            case ']' -> '[';
            default -> ' ';
        };
    }
 
    public static void main(String[] args) {
        checkBalanced("({[]})");  // Balanced
        checkBalanced("([)]");    // Balanced (Order ignored)
        checkBalanced("(()");     // Not Balanced (Extra opening bracket)
        checkBalanced(")(");      // Not Balanced (Closing before opening)
        checkBalanced("{[()]}");  // Balanced
        checkBalanced("){[]}(");  // Not Balanced (Closing before opening)
        checkBalanced("([]{})");  // Balanced (Mixed order, counts match)
    }
}
