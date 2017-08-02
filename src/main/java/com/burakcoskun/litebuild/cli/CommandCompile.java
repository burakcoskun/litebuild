package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.Parameters;
import com.burakcoskun.litebuild.runnablecommands.AndroidSDKCommandCreator;
import com.burakcoskun.litebuild.runnablecommands.JavaCommandCreator;

/**
 * Created by burakcoskun on 7/30/17.
 */
@Parameters(separators = "=", commandDescription = "Compiles source files, but first creates R.java then compiles source files then creates dex file.")
public class CommandCompile extends Command {

    JavaCommandCreator javaCommandCreator;
    AndroidSDKCommandCreator androidSDKCommandCreator;


    public CommandCompile() {
        super();
        androidSDKCommandCreator = new AndroidSDKCommandCreator();
        command = "compile";
    }

    @Override
    public int runWithoutHelp() {

        runBeforeAfterCommands(true);

        javaCommandCreator = new JavaCommandCreator();
        processRunner.run(androidSDKCommandCreator.createRJavaCommand());
        System.out.println("MyCompileCommand:" + javaCommandCreator.compileCommand());

        runBeforeAfterCommands(false);
        return 0;
    }


}
