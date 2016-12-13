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

## Read from file

```java

private static ClassLoader classLoader;

static {
    classLoader = ReadWriteFiles.class.getClassLoader();
}

public static void main(String[] args) {

    // Read from file
    URL fileUrl = classLoader.getResource("sample.in");

    BufferedReader reader;
    try {
        if (fileUrl == null) {
            System.out.println("Could not read file sample.in from classpath");
        }
        reader = Files.newBufferedReader(Paths.get(fileUrl.getPath()), StandardCharsets.UTF_8);
        String strLine;
        while ((strLine = reader.readLine()) != null) {
            System.out.println(strLine);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

## Write to file

```java

private static String outputFileName = "src/main/resources/sample.out";

public static void main(String[] args) {

    Path file = Paths.get(outputFileName);
    try {
        Files.write(file, str.getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```