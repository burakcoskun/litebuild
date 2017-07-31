package com.burakcoskun.litebuild.runnablecommands;

/**
 * Created by burakcoskun on 7/31/17.
 */
public abstract class JavaCommand {

    protected String javaHome;

    protected JavaCommand() throws Exception {

        javaHome = System.getenv().get("JAVA_HOME");
        if (javaHome == null)
            throw new Exception("Environment variable JAVA_HOME is not set.");
    }
}
