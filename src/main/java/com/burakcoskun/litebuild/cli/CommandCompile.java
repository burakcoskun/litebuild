package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.Parameters;
import com.burakcoskun.litebuild.runnablecommands.AndroidSDKCommandCreator;

/**
 * Created by burakcoskun on 7/30/17.
 */
@Parameters(separators = "=", commandDescription = "Compiles source files, but first creates R.java then compiles source files then creates dex file.")
public class CommandCompile extends Command {

    AndroidSDKCommandCreator androidSDKCommandCreator;

    public CommandCompile() throws Exception {
        super();
        androidSDKCommandCreator = new AndroidSDKCommandCreator();
    }

    @Override
    public int runWithoutHelp() throws Exception {
        processRunner.run(androidSDKCommandCreator.createRJavaCommand());
        return 0;
    }

}
