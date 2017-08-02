package com.burakcoskun.litebuild.runnablecommands;

import com.burakcoskun.litebuild.utils.BuildToolsLocator;

/**
 * Created by burakcoskun on 7/31/17.
 */
public class AndroidSDKCommandCreator extends CommandCreator {

    public AndroidSDKCommandCreator() {
        super();
    }

    public String createRJavaCommand() {
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
        return builder.toString();
    }

}