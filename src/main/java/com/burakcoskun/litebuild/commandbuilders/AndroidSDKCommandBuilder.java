package com.burakcoskun.litebuild.commandbuilders;

import com.burakcoskun.litebuild.utils.BuildToolsLocator;

/**
 * Created by burakcoskun on 7/31/17.
 */
public class AndroidSDKCommandBuilder extends CommandBuilder {

    public AndroidSDKCommandBuilder() {
        super();
    }

    public String createRJavaCommand() {

        String target = confFileHandler.getTarget(".");

        StringBuilder builder = new StringBuilder();
        builder.append(androidHome);
        builder.append("/build-tools/");
        builder.append(new BuildToolsLocator().getLatestAvailableBuildToolsVersion(androidHome));
        builder.append("/aapt");
        builder.append(" package");
        builder.append(" -v -f -m");
        builder.append(" -S ./res");
        builder.append(" -J ./src");
        builder.append(" -M ./AndroidManifest.xml");
        builder.append(" -I " + androidHome + "/platforms/" + target + "/android.jar");

        return builder.toString();
    }

    public String createDexFileCommand() {
        StringBuilder builder = new StringBuilder();
        builder.append(androidHome);
        builder.append("/build-tools/");
        builder.append(new BuildToolsLocator().getLatestAvailableBuildToolsVersion(androidHome));
        builder.append("/dx");
        builder.append(" --dex");
        builder.append(" --verbose");
        builder.append(" --output=./bin/classes.dex");
        builder.append(" obj");
        builder.append(" libs");
        return builder.toString();
    }

}