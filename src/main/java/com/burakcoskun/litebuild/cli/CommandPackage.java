package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.burakcoskun.litebuild.commandbuilders.AndroidSDKCommandBuilder;
import com.burakcoskun.litebuild.commandbuilders.JavaCommandBuilder;

import java.io.File;

/**
 * Created by burakcoskun on 8/2/17.
 */
@Parameters(separators = "=", commandDescription = "Creates package signs it with debug key and zipaligns the created package.")
public class CommandPackage extends Command {

    AndroidSDKCommandBuilder androidSDKCommandBuilder;
    JavaCommandBuilder javaCommandBuilder;

    public CommandPackage() {
        super();
        command = "package";
        androidSDKCommandBuilder = new AndroidSDKCommandBuilder();
        javaCommandBuilder = new JavaCommandBuilder();
    }

    @Parameter(names = {"-v","--validity"}, description = "Validity of debug key in days.")
    private String validity;

    @Override
    public int runWithoutHelp() {

        runBeforeAfterCommands(true);

        processRunner.run(androidSDKCommandBuilder.packageCommand());
        processRunner.run(javaCommandBuilder.signCommand());
        processRunner.run(javaCommandBuilder.zipAlignApk());

        runBeforeAfterCommands(false);

        return 0;
    }

}
