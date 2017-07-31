package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * Created by burakcoskun on 7/29/17.
 */
public abstract class Command {

    @Parameter(names = {"-h", "--help"}, help = true)
    protected boolean help;

    public abstract int runWithoutHelp() throws Exception;

    public int run(JCommander jCommander) throws Exception {
        if (help) {
            jCommander.usage();
            return 0;
        }
        return runWithoutHelp();
    }

}