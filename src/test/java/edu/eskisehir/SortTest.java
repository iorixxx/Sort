package edu.eskisehir;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SortTest {

    @Test
    public void testBasicSort() throws IOException {

        List<String> input = List.of("zebra",
                "line 1", "ahmet", "biber",
                "friends", "zebra", "line 1",
                "ahmet", "biber", "friends",
                "burcu", "hello", "world", "xe");

        Files.write(inputFile, input, StandardCharsets.US_ASCII);

        String[] args = new String[1];
        args[0] = inputFile.toAbsolutePath().toString();

        System.setOut(new PrintStream(Files.newOutputStream(outFile)));

        Sort.main(args);

        List<String> actual = Files.readAllLines(outFile, StandardCharsets.US_ASCII);

        List<String> expected = List.of(
                "ahmet", "ahmet", "biber",
                "biber", "burcu", "friends",
                "friends", "hello", "line 1",
                "line 1", "world", "xe",
                "zebra", "zebra"
        );

        Assert.assertEquals(expected, actual);
    }

    @Before
    public void before() throws IOException {
        inputFile = Files.createTempFile("input", ".txt");
        outFile = Files.createTempFile("output", ".txt");
    }

    @After
    public void after() throws IOException {
        Files.deleteIfExists(inputFile);
        Files.deleteIfExists(outFile);
    }

    Path inputFile;
    Path outFile;

    @Test
    public void testUniqueSort() throws IOException {

        List<String> input = List.of("zebra",
                "line 1", "ahmet", "biber",
                "friends", "zebra", "line 1",
                "ahmet", "biber", "friends",
                "burcu", "hello", "world", "xe");

        Files.write(inputFile, input, StandardCharsets.US_ASCII);

        String[] args = new String[2];
        args[0] = inputFile.toAbsolutePath().toString();
        args[1] = "-u";

        System.setOut(new PrintStream(Files.newOutputStream(outFile)));

        Sort.main(args);

        List<String> actual = Files.readAllLines(outFile, StandardCharsets.US_ASCII);

        List<String> expected = List.of(
                "ahmet", "biber", "burcu",
                "friends", "hello", "line 1",
                "world", "xe", "zebra"
        );

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverseUniqueSort() throws IOException {

        List<String> input = List.of("zebra",
                "line 1", "ahmet", "biber",
                "friends", "zebra", "line 1",
                "ahmet", "biber", "friends",
                "burcu", "hello", "world", "xe");

        Files.write(inputFile, input, StandardCharsets.US_ASCII);

        String[] args = new String[3];
        args[0] = inputFile.toAbsolutePath().toString();
        args[1] = "-u";
        args[2] = "-r";

        System.setOut(new PrintStream(Files.newOutputStream(outFile)));

        Sort.main(args);

        List<String> actual = Files.readAllLines(outFile, StandardCharsets.US_ASCII);

        List<String> expected = List.of(
                "zebra", "xe", "world",
                "line 1", "hello", "friends",
                "burcu", "biber", "ahmet"
        );

        Assert.assertEquals(expected, actual);
    }
}
