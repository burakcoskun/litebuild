package com.burakcoskun.litebuild.cli;

import com.beust.jcommander.JCommander;

/**
 * Created by burakcoskun on 7/29/17.
 */
public abstract class AndroidSDKCommand extends Command {

    protected String androidHome;

    @Override
    public void run(JCommander jCommander) throws Exception {
        super.run(jCommander);

        androidHome = System.getenv().get("ANDROID_HOME");
        if (androidHome == null)
            throw new Exception("Environment variable ANDROID_HOME is not set. It should be pointing to the sdk folder.");
    }
}
