package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.Parameters;
import com.burakcoskun.litebuild.runnablecommands.AndroidSDKCommandCreator;
import com.burakcoskun.litebuild.utils.ProcessRunner;

/**
 * Created by burakcoskun on 7/30/17.
 */
@Parameters(separators = "=", commandDescription = "Compiles source files, but first creates R.java then compiles source files then creates dex file.")
public class CommandCompile extends Command {

    @Override
    public int runWithoutHelp() throws Exception {
        ProcessRunner processRunner = new ProcessRunner();
        AndroidSDKCommandCreator commandCreator = new AndroidSDKCommandCreator();
        processRunner.run(commandCreator.createRJavaCommand());
        return 0;
    }

}
