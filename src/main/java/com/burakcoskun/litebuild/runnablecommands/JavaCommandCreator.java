package com.burakcoskun.litebuild.runnablecommands;

import com.burakcoskun.litebuild.utils.ClassPathLocator;

import java.util.List;

/**
 * Created by burakcoskun on 7/31/17.
 */
public class JavaCommandCreator extends CommandCreator {

    private String javaHome;
    private ClassPathLocator classPathLocator;

    public JavaCommandCreator() throws Exception {
        super();

        classPathLocator = new ClassPathLocator();

        javaHome = System.getenv().get("JAVA_HOME");
        if (javaHome == null)
            throw new Exception("Environment variable JAVA_HOME is not set.");

    }

    public String compileCommand() throws Exception {
        String target = confFileHandler.getTarget(".");
        StringBuilder builder = new StringBuilder();
        builder.append(javaHome + "/bin/javac");
        builder.append(" -verbose");
        builder.append(" -d ./obj");

        builder.append(" -classpath " + androidHome + "/platforms/");
        builder.append(target + "/android.jar" + classPathLocator.getClassPathDelimiter() + "./obj");
        List<String> thirdPartyJars = classPathLocator.findAllClassPaths("libs");
        for (String jarPath : thirdPartyJars) {
            builder.append(classPathLocator.getClassPathDelimiter() + jarPath);
        }
        builder.append(" -sourcepath " + androidHome + "/src");
        return builder.toString();
    }
}
