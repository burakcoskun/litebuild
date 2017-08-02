package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.Parameters;
import com.burakcoskun.litebuild.commandbuilders.AndroidSDKCommandBuilder;
import com.burakcoskun.litebuild.commandbuilders.JavaCommandBuilder;
import com.burakcoskun.litebuild.utils.PackageFinder;

import java.io.File;
import java.util.List;

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
        runCompileCommandForAllPackages();
        processRunner.run(androidSDKCommandBuilder.createDexFileCommand());

        runBeforeAfterCommands(false);
        return 0;
    }

    private void runCompileCommandForAllPackages() {
        List<String> packagePaths = new PackageFinder().findAllPackagePaths("src");
        for (int i = 0; i < packagePaths.size(); ++i) {
            processRunner.run(
                    javaCommandBuilder.compileCommand(packagePaths.get(i)));
        }
    }

}
