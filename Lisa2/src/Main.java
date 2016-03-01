import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';

    }

    static int priority(char oper) {
        if (oper == '^') {
            return 2;
        }
        if (oper == '*' || oper == '/') {
            return 1;
        }
        else if (oper == '+' || oper == '-') {
            return 0;
        }
        else {
            return -1;
        }
    }

    static void make(LinkedList<Double> st, char oper) {
        double one = st.removeLast();
        double two = st.removeLast();
        switch (oper) {
            case '+':
                st.add(two + one);
                break;
            case '-':
                st.add(two - one);
                break;
            case '*':
                st.add(two * one);
                break;
            case '/':
                st.add(two / one);
                break;
            case '^':
                st.add((double) Math.pow((double) two, (double) one));
                break;
            default:
                System.out.println("Operator not found!");
        }
    }

    public static void main(String[] args) {
        String a = "0123456789^*/+-()";

        while(true) {
            int i = 0;
            System.out.println("Enter your expression:");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            while (i < s.length()) {
                char c = s.charAt(i);
                if (s.contains("close")) {
                    System.exit(0);
                }
                if (a.indexOf(c) != -1)
                    i++;
                else {
                    System.out.println("WRONG! Try again:");
                    scanner = new Scanner(System.in);
                    s = scanner.nextLine();
                    i = 0;
                }
            }

            LinkedList<Double> number = new LinkedList<>();
            LinkedList<Character> operators = new LinkedList<>();

            for (i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    operators.add('(');
                }
                else if (c == ')') {
                    while (operators.getLast() != '(') {
                        make(number, operators.removeLast());
                    }
                    operators.removeLast();
                }
                else if (isOperator(c)) {
                    while (!operators.isEmpty() && priority(operators.getLast()) >= priority(c)) {
                        make(number, operators.removeLast());
                    }
                    operators.add(c);
                }
                else {
                    String operand = "";
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        operand += s.charAt(i++);
                    }
                    --i;
                    number.add(Double.parseDouble(operand));
                }
            }

            while (!operators.isEmpty()) {
                make(number, operators.removeLast());
            }

            System.out.println(number.get(0));
        }
    }
}