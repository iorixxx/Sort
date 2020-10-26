package edu.eskisehir;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// suppose a Java application called Sort sorts lines in a file.

// To sort and remove duplicates pass the -u option to sort. This will write a sorted list to standard output and remove duplicates.

// To sort in reverse order pass the -r option to sort. This will sort in reverse order and write the result to standard output.

public class Sort {

    public static void main(String[] args) throws IOException {

        //  JOptionPane.showMessageDialog(null, "Hello Executable Jar!");

        SortOptions bean = new SortOptions();

        CmdLineParser parser = new CmdLineParser(bean);

        try {
            parser.parseArgument(args);
        } catch( CmdLineException e ) {
            System.err.println(e.getMessage());
            System.err.println("java -jar myprogram.jar [options...] arguments...");
            parser.printUsage(System.err);
            return;
        }

       // your logic goes here


        Path path = Paths.get(bean.fileName);

        if (!Files.exists(path)) {
            System.out.println("no such file : " + path.toString());
            return;
        }

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        if (bean.duplicates) {
            Set<String> set = new HashSet<>(lines);
            lines.clear();
            lines.addAll(set);
        }

        Collections.sort(lines);

        if (bean.reverse)
            Collections.reverse(lines);

        for (String s : lines)
            System.out.println(s);

    }
}