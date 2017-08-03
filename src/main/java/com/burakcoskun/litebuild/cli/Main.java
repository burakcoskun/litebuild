package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Main {

    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help;

    private CommandCreateProject commandCreateProcject;
    private CommandCompile commandCompile;
    private CommandPackage commandPackage;
    private CommandLaunch commandLaunch;

    public void runMainThenExit(String[] args) {

        commandCreateProcject = new CommandCreateProject();
        commandCompile = new CommandCompile();
        commandPackage = new CommandPackage();
        commandLaunch = new CommandLaunch();

        JCommander jcommander = JCommander.newBuilder()
                .addObject(this)
                .addCommand("project", commandCreateProcject)
                .addCommand("compile", commandCompile)
                .addCommand("package", commandPackage)
                .addCommand("launch", commandLaunch)
                .build();

        jcommander.parse(args);
        if (help || jcommander.getParsedCommand() == null) {
            jcommander.usage();
            return;
        }

        if (jcommander.getParsedCommand().equals("project"))
            commandCreateProcject.run(jcommander.getCommands().get("project"));
        else if (jcommander.getParsedCommand().equals("compile"))
            commandCompile.run(jcommander.getCommands().get("compile"));
        else if (jcommander.getParsedCommand().equals("package"))
            commandPackage.run(jcommander.getCommands().get("package"));
        else if (jcommander.getParsedCommand().equals("launch"))
            commandLaunch.run(jcommander.getCommands().get("launch"));

    }

    public static void main(String[] args) {

        new Main().runMainThenExit(args);

    }
}
