package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class Main {

    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help;

    private CommandCreateProject commandCreateProcject;

    public static void main(String[] args) {

        new Main().runMainThenExit(args);

    }

    public void runMainThenExit(String[] args){

        commandCreateProcject = new CommandCreateProject();
        JCommander jcommander = JCommander.newBuilder()
                .addObject(this)
                .addCommand("project",commandCreateProcject)
                .build();

        try {
            jcommander.parse(args);
            if(help || jcommander.getParsedCommand() == null){
                jcommander.usage();
                return;
            }

            if(jcommander.getParsedCommand().equals("project"))
                commandCreateProcject.run(jcommander);

        }catch(ParameterException e){
            System.err.println("Command Error:" +e.getMessage());
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
