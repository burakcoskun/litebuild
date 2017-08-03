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
    }

    @Override
    public int runWithoutHelp() {

        processRunner.run(androidSDKCommandBuilder.launchCommand());

        return 0;
    }
}
