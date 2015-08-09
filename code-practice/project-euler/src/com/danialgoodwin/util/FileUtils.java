/**
 * Created by Danial on 3/10/2015.
 */
package com.danialgoodwin.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/** Static helper methods related to files in the filesystem. */
public class FileUtils {

    /** No need to instantiate this class. */
    private FileUtils() {}

    /** Returns a list of each row of string in the file. Only available for Java 7+.
     * Example usage: `FileUtils.readAllLines("src/com/danialgoodwin/projecteuler/sourcefile/q13-large-sum.txt", StandardCharsets.UTF_8);`
     * @param path the location of the file to read
     * @param encoding always specify an encoding, one example is `StandardCharsets.UTF_8` */
    public static List<String> readAllLines(String path, Charset encoding) throws IOException {
        return Files.readAllLines(Paths.get(path), encoding);
    }



    // More possibilities to add later:

//    for (Scanner sc = new Scanner(new File("my.file", "UTF-8")); sc.hasNext(); ) {
//        String line = sc.nextLine();
//        ... // do something with line
//    }

}
