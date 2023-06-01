# Java Cheat Sheet



## Overview



## How To

### How to work with files
```java
// Java 11+
Files.writeString(myPath, "content", StandardOpenOption.APPEND, StandardOpenOption.CREATE);
// Java 7+
Files.write(myPath, "content".getBytes(StandardCharsets.UTF_8));
Files.write(myPath, Arrays.asList("1st line", "2nd line"), StandardCharsets.UTF_8);

Path path = Path.of(ClassLoader.getSystemResource("my-resource.txt").toURI());
List<String> lines = Files.readAllLines(path);
```


## Troubleshooting


## Resources


