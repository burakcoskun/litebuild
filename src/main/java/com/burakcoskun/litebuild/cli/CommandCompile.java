package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.Parameters;
import com.burakcoskun.litebuild.commandbuilders.AndroidSDKCommandBuilder;
import com.burakcoskun.litebuild.commandbuilders.JavaCommandBuilder;
import com.burakcoskun.litebuild.utils.SourceFilesFinder;

import java.io.File;

/**
 * Created by burakcoskun on 7/30/17.
 */
@Parameters(separators = "=", commandDescription = "Compiles source files, but first creates R.java then compiles source files then creates dex file.")
public class CommandCompile extends Command {

    JavaCommandBuilder javaCommandBuilder;
    AndroidSDKCommandBuilder androidSDKCommandBuilder;


    public CommandCompile() {
        super();
        androidSDKCommandBuilder = new AndroidSDKCommandBuilder();
        command = "compile";
    }

    @Override
    public int runWithoutHelp() {

        runBeforeAfterCommands(true);

        javaCommandBuilder = new JavaCommandBuilder();
        File file = new File("obj");
        file.mkdir();

        processRunner.run(androidSDKCommandBuilder.createRJavaCommand());
        processRunner.run(javaCommandBuilder.
                compileCommand(new SourceFilesFinder().findAllPackagePaths("src")));
        processRunner.run(androidSDKCommandBuilder.createDexFileCommand());

        runBeforeAfterCommands(false);
        return 0;
    }

}
