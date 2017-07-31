package com.burakcoskun.litebuild.runnablecommands;

import com.burakcoskun.litebuild.utils.BuildToolsLocator;
import com.burakcoskun.litebuild.utils.ConfFileHandler;

/**
 * Created by burakcoskun on 7/31/17.
 */
public class AndroidSDKCommandCreator {

    private String androidHome;
    private ConfFileHandler confFileHandler;

    public AndroidSDKCommandCreator() throws Exception {

        androidHome = System.getenv().get("ANDROID_HOME");
        if (androidHome == null)
            throw new Exception("Environment variable ANDROID_HOME is not set. It should be pointing to the sdk folder.");

        confFileHandler = new ConfFileHandler();
    }

    public String createRJavaCommand() throws Exception {
        String target = confFileHandler.getTarget(".");
        StringBuilder builder = new StringBuilder();
        builder.append(androidHome + "/build-tools");///aapt");
        builder.append("/" + new BuildToolsLocator().getLatestAvailableBuildToolsVersion(androidHome));
        builder.append("/aapt");
        builder.append(" package");
        builder.append(" -v -f -m");
        builder.append(" -S ./res");
        builder.append(" -J ./src");
        builder.append(" -M ./AndroidManifest.xml");
        builder.append(" -I " + androidHome + "/platforms/" + target + "/android.jar");
        System.out.println("Creating R.java:" + builder.toString());
        return builder.toString();
    }


    public String createProjectCommand(String activity, String dir, String name, String target, String packageName) {
        StringBuilder builder = new StringBuilder();
        builder.append(androidHome + "/tools/android create project");
        builder.append(" -a " + activity);
        builder.append(" --path " + dir);
        if (name != null)
            builder.append(" -n " + name);
        builder.append(" -t " + target);
        builder.append(" --package " + packageName);
        return builder.toString();
    }
}