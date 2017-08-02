package com.burakcoskun.litebuild.commandbuilders;

import com.burakcoskun.litebuild.utils.ClassPathLocator;
import com.burakcoskun.litebuild.utils.PackageFinder;

import java.io.File;
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

    public String compileCommand(String codePackage) {
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
        addAllJavaFiles(builder, codePackage);
        return builder.toString();
    }

    private void addAllJavaFiles(StringBuilder builder, String codePackage) {
        File[] files = new File(codePackage).listFiles();
        for (int i = 0; i < files.length; ++i)
            if (files[i].getName().endsWith(PackageFinder.fileExtendsion))
                builder.append(" " + files[i].getAbsolutePath());
    }
}
