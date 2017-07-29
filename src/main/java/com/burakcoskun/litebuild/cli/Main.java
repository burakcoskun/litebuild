package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.io.File;

public class Main {

    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help;


    public static void main(String[] args) {
        Main main = new Main();
        CommandCreateProcject commandCreateProcject = new CommandCreateProcject();
        JCommander jcommander = JCommander.newBuilder()
                .addObject(main)
                .addCommand("project",commandCreateProcject)
                .build();
        try {
            jcommander.parse(args);
            main.run(jcommander);
        }catch(ParameterException e){
            System.err.println("Command Error:" +e.getMessage());
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    public void run(JCommander jCommander) {
        if(jCommander.getParsedCommand() == null) {
            jCommander.usage();
            return ;
        }
        if(help)
            jCommander.usage();
    }
}
