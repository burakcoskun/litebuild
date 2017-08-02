package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.burakcoskun.litebuild.utils.ConfFileHandler;
import com.burakcoskun.litebuild.utils.ProcessRunner;

import java.util.List;

/**
 * Created by burakcoskun on 7/29/17.
 */
public abstract class Command {

    @Parameter(names = {"-h", "--help"}, help = true)
    protected boolean help;

    protected String command;

    protected ProcessRunner processRunner;

    public Command() {
        processRunner = new ProcessRunner();
    }

    public abstract int runWithoutHelp();

    public int run(JCommander jCommander) {
        if (help) {
            jCommander.usage();
            return 0;
        }
        return runWithoutHelp();
    }

    protected void runBeforeAfterCommands(boolean isBefore) {
        List<String> commands = new ConfFileHandler().getBeforeAfterCommands(command, ".", isBefore);
        for (int i = 0; i < commands.size(); ++i)
            processRunner.run(commands.get(i));
    }
}