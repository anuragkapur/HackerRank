Solutions to various challenges hosted on [https://www.hackerrank.com](https://www.hackerrank.com)

# Utility code

## Reading from stdin

```java
import java.util.Scanner;

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while(scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if (line.equalsIgnoreCase("exit")) {
            break;
        }
        System.out.println("Echo :: " + line);
    }
}
```