package edu.eskisehir;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

public class SortOptions {

    @Option(name = "-r", aliases = "--reverse", usage = "sort in reverse order")
    boolean reverse;

    @Option(name = "-u", aliases = {"--unique", "--uniq"}, usage = "remove duplicates")
    boolean duplicates;

    // receives other command line parameters than options
    @Argument
    String fileName;

    @Option(name = "-e", aliases = "--encoding", usage = "encoding of the file: ASCII or UTF8")
    Encoding encoding;
}
