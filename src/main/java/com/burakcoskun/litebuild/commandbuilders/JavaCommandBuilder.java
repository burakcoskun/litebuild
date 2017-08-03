package com.burakcoskun.litebuild.commandbuilders;

import com.burakcoskun.litebuild.utils.BuildToolsLocator;
import com.burakcoskun.litebuild.utils.ClassPathLocator;

import java.util.List;

/**
 * Created by burakcoskun on 7/31/17.
 */
public class JavaCommandBuilder extends CommandBuilder {

    private String javaHome;
    private ClassPathLocator classPathLocator;

    public class JavaHomeIsNotDefinedException extends RuntimeException {
        JavaHomeIsNotDefinedException(String message) {
            super(message);
        }
    }

    public JavaCommandBuilder() {
        super();

        classPathLocator = new ClassPathLocator();

        javaHome = System.getenv().get("JAVA_HOME");
        if (javaHome == null)
            throw new JavaHomeIsNotDefinedException("Environment variable JAVA_HOME is not set.");

    }

    public String compileCommand(List<String> sourceFiles) {
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
        addAllJavaFiles(builder, sourceFiles);
        return builder.toString();
    }

    private void addAllJavaFiles(StringBuilder builder, List<String> sourceFiles) {
        for (int i = 0; i < sourceFiles.size(); ++i)
            builder.append(" " + sourceFiles.get(i));
    }

    public String signCommand() {
        StringBuilder builder = new StringBuilder();
        builder.append(javaHome + "/bin/jarsigner");
        builder.append(" -verbose");
        builder.append(" -keystore " + System.getProperty("user.home") + "/.android/debug.keystore");
        builder.append(" -storepass android");
        builder.append(" -keypass android");
        builder.append(" -signedjar bin/AndroidTest.signed.apk");
        builder.append(" bin/AndroidTest.unsigned.apk");
        builder.append(" androiddebugkey");
        return builder.toString();
    }

    public String zipAlignApk() {
        StringBuilder builder = new StringBuilder();

        builder.append(androidHome + "/build-tools/" + new BuildToolsLocator().getLatestAvailableBuildToolsVersion(androidHome));
        builder.append("/zipalign");
        builder.append(" -v");
        builder.append(" -f");
        builder.append(" 4");
        builder.append(" bin/AndroidTest.signed.apk");
        builder.append(" bin/AndroidTest.apk");

        return builder.toString();
    }

}
