package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.burakcoskun.litebuild.runnablecommands.AndroidSDKCommandCreator;
import com.burakcoskun.litebuild.utils.ProcessRunner;

/**
 * Created by burakcoskun on 7/29/17.
 */
public abstract class Command {

    @Parameter(names = {"-h", "--help"}, help = true)
    protected boolean help;

    protected ProcessRunner processRunner;
    protected AndroidSDKCommandCreator androidSDKCommandCreator;

    public Command() {
        processRunner = new ProcessRunner();
        androidSDKCommandCreator = new AndroidSDKCommandCreator();
    }

    public abstract int runWithoutHelp();

    public int run(JCommander jCommander) {
        if (help) {
            jCommander.usage();
            return 0;
        }
        return runWithoutHelp();
    }

}