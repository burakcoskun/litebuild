package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.Parameters;
import com.burakcoskun.litebuild.commandbuilders.AndroidSDKCommandBuilder;

/**
 * Created by burakcoskun on 8/2/17.
 */
@Parameters(separators = "=", commandDescription = "Compiles source files, but first creates R.java then compiles source files then creates dex file.")
public class CommandPackage extends Command {

    AndroidSDKCommandBuilder androidSDKCommandBuilder;

    public CommandPackage() {
        super();
        command = "package";
        androidSDKCommandBuilder = new AndroidSDKCommandBuilder();
    }

    @Override
    public int runWithoutHelp() {

        runBeforeAfterCommands(true);

        processRunner.run(androidSDKCommandBuilder.packageCommand());

        runBeforeAfterCommands(false);

        return 0;
    }
}
