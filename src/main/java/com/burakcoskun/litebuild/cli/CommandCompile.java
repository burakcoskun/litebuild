package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.Parameters;
import com.burakcoskun.litebuild.runnablecommands.JavaCommandCreator;

/**
 * Created by burakcoskun on 7/30/17.
 */
@Parameters(separators = "=", commandDescription = "Compiles source files, but first creates R.java then compiles source files then creates dex file.")
public class CommandCompile extends Command {

    JavaCommandCreator javaCommandCreator;

    public CommandCompile() {
        super();
    }

    @Override
    public int runWithoutHelp() {
        javaCommandCreator = new JavaCommandCreator();
        processRunner.run(androidSDKCommandCreator.createRJavaCommand());
        System.out.println("MyCompileCommand:" + javaCommandCreator.compileCommand());
        return 0;
    }

}
