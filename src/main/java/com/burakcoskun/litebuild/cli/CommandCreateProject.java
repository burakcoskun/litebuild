package com.burakcoskun.litebuild.cli;


import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.burakcoskun.litebuild.runnablecommands.AndroidSDKCommandCreator;
import com.burakcoskun.litebuild.utils.ConfFileHandler;
import com.burakcoskun.litebuild.utils.ProcessRunner;


/**
 * Created by burakcoskun on 7/28/17.
 */
@Parameters(separators = "=", commandDescription = "Creates new android project with it's most basic form")
public class CommandCreateProject extends Command {

    @Parameter(names = {"-t", "--target"}, description = "Target ID of the new project. [required]", required = true)
    private String target;

    @Parameter(names = {"-n", "--name"}, description = "Project name")
    private String name;

    @Parameter(names = {"-p", "--package"}, description = "Android package name for the application. [required]", required = true)
    private String packageName;

    @Parameter(names = {"-a", "--activity"}, description = "Name of the default Activity that is created.")
    private String activity = "Main";

    @Parameter(names = {"-d", "--dir"}, description = "Directory(Path) to create project. [required]", required = true)
    private String dir;

    public CommandCreateProject() {
        super();
    }

    @Override
    public int runWithoutHelp() throws Exception {
        ProcessRunner processRunner = new ProcessRunner();
        processRunner.run(new AndroidSDKCommandCreator()
                .createProjectCommand(activity, dir, name, target, packageName));
        new ConfFileHandler().createEmptyConfFile(dir, target);
        return 0;
    }

}
