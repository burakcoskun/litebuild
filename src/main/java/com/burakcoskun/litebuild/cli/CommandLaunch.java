package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.Parameters;
import com.burakcoskun.litebuild.commandbuilders.AndroidSDKCommandBuilder;

/**
 * Created by burakcoskun on 8/3/17.
 */
@Parameters(separators = "=", commandDescription = "Launches apk on running emulator.")
public class CommandLaunch extends Command {

    AndroidSDKCommandBuilder androidSDKCommandBuilder;

    public CommandLaunch() {
        super();
        androidSDKCommandBuilder = new AndroidSDKCommandBuilder();
        command = "launch";
    }

    @Override
    public int runWithoutHelp() {

        runBeforeAfterCommands(true);

        processRunner.run(androidSDKCommandBuilder.launchCommand());

        runBeforeAfterCommands(false);

        return 0;
    }
}
