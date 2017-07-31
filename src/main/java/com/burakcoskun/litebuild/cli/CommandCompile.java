package com.burakcoskun.litebuild.cli;

/**
 * Created by burakcoskun on 7/30/17.
 */
public class CommandCompile extends Command {
    String createActualCommand() {
        StringBuilder builder = new StringBuilder();
        builder.append("/bin/javac");
        builder.append(" -verbose");
        builder.append(" -d ./obj");
        //TODO: insert 3rd party jars here
        builder.append(" -classpath ANDROID_HOME/platforms/android-7/android.jar;DEV_HOME/obj");
        builder.append(" -sourcepath ");
        return builder.toString();
    }

    public int runWithoutHelp() throws Exception {
        return 0;
    }
}
