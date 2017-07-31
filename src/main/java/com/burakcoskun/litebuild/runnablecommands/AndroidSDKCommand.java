package com.burakcoskun.litebuild.runnablecommands;

import com.burakcoskun.litebuild.utils.ProcessRunner;

import java.io.IOException;

/**
 * Created by burakcoskun on 7/31/17.
 */
public class AndroidSDKCommand {

    private String androidHome;
    private String command;

    public AndroidSDKCommand(String command) throws Exception {

        androidHome = System.getenv().get("ANDROID_HOME");
        if (androidHome == null)
            throw new Exception("Environment variable ANDROID_HOME is not set. It should be pointing to the sdk folder.");

        this.command = androidHome + command;
    }

    public void run() throws IOException, InterruptedException {
        System.out.println("Running Command:"+command);
        new ProcessRunner().run(command);
    }
}
