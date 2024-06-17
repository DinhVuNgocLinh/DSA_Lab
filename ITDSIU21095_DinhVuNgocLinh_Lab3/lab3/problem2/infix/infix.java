package problem2.infix;

// infix.java
// converts infix arithmetic expressions to postfix
// to run this program: C>java InfixApp
import java.io.*; // for I/O
import java.util.Scanner;

class StackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int s) // constructor
    {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) // put item on top of stack
    {
        stackArray[++top] = j;
    }

    public char pop() // take item from top of stack
    {
        return stackArray[top--];
    }

    public char peek() // peek at top of stack
    {
        return stackArray[top];
    }

    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }

    public int size() // return size
    {
        return top + 1;
    }

    public char peekN(int n) // return item at index n
    {
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println("");
    }
} // end class StackX
  ////////////////////////////////////////////////////////////////

class InToPost // infix to postfix conversion
{
    private StackX theStack;
    private String input;
    private String output = "";

    public InToPost(String in) // constructor
    {
        input = in;
        int stackSize = input.length();
        theStack = new StackX(stackSize);
    }

    public String doTrans() // do translation to postfix
    {
        Scanner scan = new Scanner(System.in);

        String enter;

        while (true) {
            System.out.print("Your input is ?Numbers(enter 'n') or Variables(enter 'v'): ");
            enter = scan.next();

            if (!enter.equals("n") && !enter.equals("v")) {
                System.out.println("Error!!! Invalid selection. PLEASE!!! ENTER 'n' for NUMBERS and 'v' for VARIABLES");
            } else {
                break;
            }
        }

        if (enter.equals("n")) {
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                // check if user input right type or not? and return error messages
                if (Character.isLetter(ch)) {
                    System.out.println("Error!!! You has entered a variable but selected 'n' for numbers");
                    return "";
                }
                // check the number is multi-digit-number
                if (Character.isDigit(ch)) {
                    String multiNum = "";
                    while (j < input.length() && Character.isDigit(input.charAt(j))) {
                        multiNum += input.charAt(j++);
                    }
                    j--;
                    output += multiNum;
                    theStack.displayStack("For " + multiNum + " "); // *diagnostic*
                } else {
                    switch (ch) {
                        case '+': // it’s + or
                        case '-':
                            gotOper(ch, 1); // go pop operators
                            break; // (precedence 1)
                        case '*': // it’s * or /
                        case '/':
                            gotOper(ch, 2); // go pop operators
                            break; // (precedence 2)
                        case '(': // it’s a left paren
                            theStack.push(ch); // push it
                            break;
                        case ')': // it’s a right paren
                            gotParen(ch); // go pop operators
                            break;
                    } // end switch
                }
            }
        } else if (enter.equals("v")) {
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                // check that user input right type or not? and return error messages
                if (Character.isDigit(ch)) {
                    System.out.println("Error!!! You has entered a numbers but selected 'v' for variables");
                    return "";
                }
                // check is variables
                if (Character.isLetter(ch)) {
                    String multiLetter = "";
                    while (j < input.length() && Character.isLetter(input.charAt(j))) {
                        multiLetter += input.charAt(j++);
                    }
                    j--;
                    output += multiLetter;
                    theStack.displayStack("For " + multiLetter + " "); // *diagnostic*
                } else {
                    switch (ch) {
                        case '+': // it’s + or
                        case '-':
                            gotOper(ch, 1); // go pop operators
                            break; // (precedence 1)
                        case '*': // it’s * or /
                        case '/':
                            gotOper(ch, 2); // go pop operators
                            break; // (precedence 2)
                        case '(': // it’s a left paren
                            theStack.push(ch); // push it
                            break;
                        case ')': // it’s a right paren
                            gotParen(ch); // go pop operators
                            break;
                    } // end switch
                }
            }
        }

        while (!theStack.isEmpty()) // pop remaining opers
        {
            theStack.displayStack("While "); // *diagnostic*
            output = output + theStack.pop(); // write to output
        }
        theStack.displayStack("End   "); // *diagnostic*
        return output; // return postfix
    } // end doTrans()

    public void gotOper(char opThis, int prec1) { // got operator from input
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') // if it’s a ‘(‘
            {
                theStack.push(opTop); // restore ‘(‘
                break;
            } else // it’s an operator
            {
                int prec2; // precedence of new op
                if (opTop == '+' || opTop == '-') // find new op prec
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) // if prec of new op less
                { // than prec of old
                    theStack.push(opTop); // save newly-popped op
                    break;
                } else // prec of new not less
                    output = output + opTop; // than prec of old
            } // end else (it’s an operator)
        } // end while
        theStack.push(opThis); // push new operator
    } // end gotOp()

    public void gotParen(char ch) { // got right paren from input
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(') // if popped ‘(‘
                break; // we’re done
            else // if popped operator
                output = output + chx; // output it
        } // end while
    } // end popOps()
} // end class InToPost
  ////////////////////////////////////////////////////////////////

class InfixApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString(); // read a string from kbd
            // check if user input both number and variables
            boolean hasLetter = false;
            boolean hasNum = false;
            boolean errorOccur = false;
            for (char ch : input.toCharArray()) {
                if (Character.isDigit(ch)) {
                    hasNum = true;
                } else if (Character.isLetter(ch)) {
                    hasLetter = true;
                }
                if (hasLetter && hasNum) {
                    System.out.println("Error!!! Either enter numbers or enter variables, you cannot enter both");
                    errorOccur = true;
                    break;
                }
            }
            if (errorOccur) {// stop all when error message input both number and variables
                continue;
            }

            if (input.equals("")) // quit if [Enter]
                break;
            // make a translator
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans(); // do the translation

            // make sure only print when not error message
            if (!output.isEmpty()) {
                System.out.println("Postfix is " + output + '\n');
            }

        } // end while
    } // end main()

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
} // end class InfixApp
