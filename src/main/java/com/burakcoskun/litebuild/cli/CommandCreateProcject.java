package com.burakcoskun.litebuild.cli;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * Created by burakcoskun on 7/28/17.
 */
@Parameters(separators = "=", commandDescription = "Creates new android project with it's most basic form")
public class CommandCreateProcject  {

    @Parameter(names = {"-t", "--target"},description = "Target ID of the new project")
    private String target;

    @Parameter(names = {"-n", "--name"})
    private String name;

    @Parameter(names = {"-p", "--package"}, required = true)
    private String packageName;

    @Parameter(names = {"-a" , "--activity"})
    private String activity;


    public void run(JCommander jCommander){

    }

}
