package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.JCommander;

/**
 * Created by burakcoskun on 7/30/17.
 */
public abstract class JavaCommand extends Command {

    protected String javaHome;

    @Override
    public void run(JCommander jCommander) throws Exception {
        super.run(jCommander);

        javaHome = System.getenv().get("JAVA_HOME");
        if (javaHome == null)
            throw new Exception("Environment variable JAVA_HOME is not set. It should be pointing to the sdk folder.");
    }
}
