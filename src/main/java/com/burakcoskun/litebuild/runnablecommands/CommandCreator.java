package com.burakcoskun.litebuild.runnablecommands;

import com.burakcoskun.litebuild.utils.ConfFileHandler;

public abstract class CommandCreator {

    protected ConfFileHandler confFileHandler;
    protected String androidHome;

    public CommandCreator() throws Exception {

        confFileHandler = new ConfFileHandler();

        androidHome = System.getenv().get("ANDROID_HOME");
        if (androidHome == null)
            throw new Exception("Environment variable ANDROID_HOME is not set. It should be pointing to the sdk folder.");

    }
}
