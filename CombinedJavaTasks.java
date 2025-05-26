import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class CombinedJavaTasks{

    static Scanner scanner = new Scanner(System.in);

    // Record moved outside method for compatibility
    static record Point(int x, int y) {}

    public static void main(String[] args) {
        while(true) {
            System.out.println("\nSelect task number to run (0 to exit):");
            System.out.println("1. Hello World\n2. Simple Calculator\n3. Even or Odd\n4. Leap Year\n5. Multiplication Table");
            System.out.println("6. Data Types\n7. Type Casting\n8. Operator Precedence\n9. Grade Calculator\n10. Number Guessing Game");
            System.out.println("11. Factorial\n12. Method Overloading\n13. Recursive Fibonacci\n14. Array Sum & Average\n15. String Reversal");
            System.out.println("16. Palindrome Checker\n17. Class & Object\n18. Inheritance\n19. Interface\n20. Try-Catch Division");
            System.out.println("21. Custom Exception\n22. File Writing\n23. File Reading\n24. ArrayList Example\n25. HashMap Example");
            System.out.println("26. Threads\n27. Lambda Expressions\n28. Stream API\n29. Records\n30. Pattern Matching (classic)\n31-34 JDBC/Modules skipped");
            System.out.println("35-38 External Tools skipped\n39. Reflection\n40. Virtual Threads\n41. Executor Service");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch(Exception e) {
                System.out.println("Invalid input");
                continue;
            }
            if(choice == 0) {
                System.out.println("Exiting.");
                break;
            }

            switch(choice) {
                case 1 -> helloWorld();
                case 2 -> simpleCalculator();
                case 3 -> evenOddChecker();
                case 4 -> leapYearChecker();
                case 5 -> multiplicationTable();
                case 6 -> dataTypeDemo();
                case 7 -> typeCasting();
                case 8 -> operatorPrecedence();
                case 9 -> gradeCalculator();
                case 10 -> numberGuessingGame();
                case 11 -> factorialCalculator();
                case 12 -> methodOverloadingDemo();
                case 13 -> recursiveFibonacci();
                case 14 -> arraySumAverage();
                case 15 -> stringReversal();
                case 16 -> palindromeChecker();
                case 17 -> classObjectDemo();
                case 18 -> inheritanceDemo();
                case 19 -> interfaceDemo();
                case 20 -> tryCatchDivision();
                case 21 -> customExceptionDemo();
                case 22 -> fileWriting();
                case 23 -> fileReading();
                case 24 -> arrayListExample();
                case 25 -> hashMapExample();
                case 26 -> threadExample();
                case 27 -> lambdaExpressions();
                case 28 -> streamAPI();
                case 29 -> recordsDemo();
                case 30 -> patternMatchingClassicDemo();
                case 31,32,33 -> System.out.println("JDBC tasks skipped.");
                case 34 -> System.out.println("Java modules require separate compilation.");
                case 35,36,37,38 -> System.out.println("External tools/tasks skipped.");
                case 39 -> reflectionDemo();
                case 40 -> virtualThreadsDemo();
                case 41 -> executorServiceDemo();
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    // 1. Hello World
    static void helloWorld() {
        System.out.println("Hello, World!");
    }

    // 2. Simple Calculator
    static void simpleCalculator() {
        try {
            System.out.print("Enter first number: ");
            double a = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter second number: ");
            double b = Double.parseDouble(scanner.nextLine());
            System.out.print("Choose operation (+,-,*,/): ");
            char op = scanner.nextLine().charAt(0);
            double res = 0;
            switch(op) {
                case '+' -> res = a + b;
                case '-' -> res = a - b;
                case '*' -> res = a * b;
                case '/' -> res = (b == 0) ? Double.NaN : a / b;
                default -> {
                    System.out.println("Invalid operator.");
                    return;
                }
            }
            System.out.println("Result: " + res);
        } catch(Exception e) {
            System.out.println("Invalid input.");
        }
    }

    // 3. Even or Odd Checker
    static void evenOddChecker() {
        try {
            System.out.print("Enter an integer: ");
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println(n + " is " + (n % 2 == 0 ? "Even" : "Odd"));
        } catch(Exception e) {
            System.out.println("Invalid input.");
        }
    }

    // 4. Leap Year Checker
    static void leapYearChecker() {
        try {
            System.out.print("Enter a year: ");
            int year = Integer.parseInt(scanner.nextLine());
            boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            System.out.println(year + (leap ? " is a Leap Year." : " is NOT a Leap Year."));
        } catch(Exception e) {
            System.out.println("Invalid input.");
        }
    }

    // 5. Multiplication Table
    static void multiplicationTable() {
        try {
            System.out.print("Enter a number: ");
            int num = Integer.parseInt(scanner.nextLine());
            for (int i=1; i<=10; i++) {
                System.out.printf("%d x %d = %d\n", num, i, num*i);
            }
        } catch(Exception e) {
            System.out.println("Invalid input.");
        }
    }

    // 6. Data Type Demonstration
    static void dataTypeDemo() {
        int i = 42;
        float f = 3.14f;
        double d = 2.71828;
        char c = 'J';
        boolean b = true;
        System.out.println("int: " + i);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + b);
    }

    // 7. Type Casting Example
    static void typeCasting() {
        double d = 9.99;
        int i = (int) d;
        System.out.println("Double " + d + " cast to int: " + i);
        int j = 10;
        double e = (double) j;
        System.out.println("Int " + j + " cast to double: " + e);
    }

    // 8. Operator Precedence
    static void operatorPrecedence() {
        int result = 10 + 5 * 2;
        System.out.println("Expression: 10 + 5 * 2 = " + result);
        System.out.println("Multiplication happens before addition.");
    }

    // 9. Grade Calculator
    static void gradeCalculator() {
        try {
            System.out.print("Enter marks (0-100): ");
            int marks = Integer.parseInt(scanner.nextLine());
            char grade;
            if (marks >= 90) grade = 'A';
            else if (marks >= 80) grade = 'B';
            else if (marks >= 70) grade = 'C';
            else if (marks >= 60) grade = 'D';
            else grade = 'F';
            System.out.println("Grade: " + grade);
        } catch(Exception e) {
            System.out.println("Invalid input.");
        }
    }

    // 10. Number Guessing Game
    static void numberGuessingGame() {
        int target = new Random().nextInt(100) + 1;
        int guess = 0;
        System.out.println("Guess the number (1-100):");
        while(guess != target) {
            try {
                guess = Integer.parseInt(scanner.nextLine());
                if (guess > target) System.out.println("Too high!");
                else if (guess < target) System.out.println("Too low!");
                else System.out.println("Correct! Number was " + target);
            } catch(Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }

    // 11. Factorial
    static void factorialCalculator() {
        try {
            System.out.print("Enter a non-negative integer: ");
            int n = Integer.parseInt(scanner.nextLine());
            long fact = 1;
            for(int i=2; i<=n; i++) fact *= i;
            System.out.println("Factorial of " + n + " is " + fact);
        } catch(Exception e) {
            System.out.println("Invalid input.");
        }
    }

    // 12. Method Overloading Demo
    static void methodOverloadingDemo() {
        System.out.println("Overloaded sum methods:");
        System.out.println("sum(2,3) = " + sum(2,3));
        System.out.println("sum(2.5,3.5) = " + sum(2.5,3.5));
        System.out.println("sum(1,2,3) = " + sum(1,2,3));
    }
    static int sum(int a, int b) { return a + b; }
    static double sum(double a, double b) { return a + b; }
    static int sum(int a, int b, int c) { return a + b + c; }

    // 13. Recursive Fibonacci
    static void recursiveFibonacci() {
        try {
            System.out.print("Enter number of Fibonacci terms: ");
            int n = Integer.parseInt(scanner.nextLine());
            for(int i=0; i<n; i++) {
                System.out.print(fib(i) + " ");
            }
            System.out.println();
        } catch(Exception e) {
            System.out.println("Invalid input.");
        }
    }
    static int fib(int n) {
        if(n<=1) return n;
        return fib(n-1) + fib(n-2);
    }

    // 14. Array Sum & Average
    static void arraySumAverage() {
        System.out.print("Enter number of elements: ");
        try {
            int n = Integer.parseInt(scanner.nextLine());
            int[] arr = new int[n];
            System.out.println("Enter " + n + " integers:");
            int sum=0;
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(scanner.nextLine());
                sum += arr[i];
            }
            double avg = sum / (double) n;
            System.out.println("Sum = " + sum + ", Average = " + avg);
        } catch(Exception e) {
            System.out.println("Invalid input.");
        }
    }

    // 15. String Reversal
    static void stringReversal() {
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        String rev = new StringBuilder(s).reverse().toString();
        System.out.println("Reversed string: " + rev);
    }

    // 16. Palindrome Checker
    static void palindromeChecker() {
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        String rev = new StringBuilder(s).reverse().toString();
        System.out.println(s + (s.equals(rev) ? " is a palindrome." : " is NOT a palindrome."));
    }

    // 17. Class & Object
    static void classObjectDemo() {
        Person p = new Person("Alice", 25);
        p.display();
    }
    static class Person {
        String name;
        int age;
        Person(String n, int a) { name = n; age = a; }
        void display() { System.out.println("Name: " + name + ", Age: " + age); }
    }

    // 18. Inheritance
    static void inheritanceDemo() {
        Dog d = new Dog();
        d.sound();
    }
    static class Animal {
        void sound() { System.out.println("Animal sound"); }
    }
    static class Dog extends Animal {
        @Override
        void sound() { System.out.println("Bark"); }
    }

    // 19. Interface
    static void interfaceDemo() {
        Printable p = () -> System.out.println("Printing from interface");
        p.print();
    }
    interface Printable {
        void print();
    }

    // 20. Try-Catch Division
    static void tryCatchDivision() {
        try {
            System.out.print("Enter numerator: ");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter denominator: ");
            int b = Integer.parseInt(scanner.nextLine());
            System.out.println("Result: " + (a/b));
        } catch(ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } catch(Exception e) {
            System.out.println("Invalid input.");
        }
    }

    // 21. Custom Exception
    static void customExceptionDemo() {
        System.out.print("Enter positive number: ");
        try {
            int n = Integer.parseInt(scanner.nextLine());
            if (n < 0) throw new NegativeNumberException("Negative number not allowed");
            System.out.println("You entered: " + n);
        } catch(NegativeNumberException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Invalid input.");
        }
    }
    static class NegativeNumberException extends Exception {
        NegativeNumberException(String msg) { super(msg); }
    }

    // 22. File Writing
    static void fileWriting() {
        try {
            System.out.print("Enter filename: ");
            String filename = scanner.nextLine();
            System.out.print("Enter text to write: ");
            String text = scanner.nextLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(text);
            writer.close();
            System.out.println("Written to " + filename);
        } catch(IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // 23. File Reading
    static void fileReading() {
        try {
            System.out.print("Enter filename: ");
            String filename = scanner.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            System.out.println("File contents:");
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch(IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // 24. ArrayList Example
    static void arrayListExample() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        System.out.println("Languages: " + list);
    }

    // 25. HashMap Example
    static void hashMapExample() {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        System.out.println("Map contents: " + map);
    }

    // 26. Thread Example
    static void threadExample() {
        Thread t = new Thread(() -> {
            for(int i=0; i<5; i++) {
                System.out.println("Thread running: " + i);
                try { Thread.sleep(500); } catch(InterruptedException ignored) {}
            }
        });
        t.start();
        try { t.join(); } catch(InterruptedException ignored) {}
    }

    // 27. Lambda Expressions
    static void lambdaExpressions() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        list.forEach(s -> System.out.println(s.toUpperCase()));
    }

    // 28. Stream API
    static void streamAPI() {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        int sum = nums.stream().filter(n -> n%2==0).mapToInt(n -> n).sum();
        System.out.println("Sum of even numbers: " + sum);
    }

    // 29. Records demo
    static void recordsDemo() {
        Point p = new Point(10, 20);
        System.out.println("Point: (" + p.x() + ", " + p.y() + ")");
    }

    // 30. Pattern Matching demo (classic instanceof)
    static void patternMatchingClassicDemo() {
        Object obj = "Hello World";
        if (obj instanceof String) {
            String s = (String) obj; // classic cast
            System.out.println("Pattern matched string: " + s);
        } else {
            System.out.println("Not a string");
        }
    }

    // 39. Reflection demo
    static void reflectionDemo() {
        try {
            Class<?> cls = Class.forName("java.util.ArrayList");
            System.out.println("Class name: " + cls.getName());
            System.out.println("Methods:");
            Arrays.stream(cls.getDeclaredMethods())
                  .limit(5)
                  .forEach(m -> System.out.println(m.getName()));
        } catch(Exception e) {
            System.out.println("Reflection error: " + e.getMessage());
        }
    }

    // 40. Virtual Threads demo (Java 19+)
    static void virtualThreadsDemo() {
        try {
            Thread vt = Thread.startVirtualThread(() -> System.out.println("Hello from virtual thread!"));
            vt.join();
        } catch (UnsupportedOperationException e) {
            System.out.println("Virtual threads not supported in your JVM.");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    // 41. Executor Service demo
    static void executorServiceDemo() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> System.out.println("Task 1 running"));
        executor.submit(() -> System.out.println("Task 2 running"));
        executor.shutdown();
    }
}
