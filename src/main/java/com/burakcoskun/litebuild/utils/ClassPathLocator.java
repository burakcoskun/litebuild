package com.burakcoskun.litebuild.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClassPathLocator {

    private String classPathDelimiter;

    public String getClassPathDelimiter() {
        return classPathDelimiter;
    }

    public ClassPathLocator() {
        if (System.getProperty("os.name")
                .startsWith("Windows"))
            classPathDelimiter = ";";
        else
            classPathDelimiter = ":";
    }

    public List<String> findAllClassPaths(String path) {
        Collection<File> jars = FileUtils.listFiles(new File(path), new String[]{"jar"}, true);
        List<String> packages = new ArrayList<String>();
        for (File jar : jars)
            packages.add(jar.getAbsolutePath());
        return packages;
    }
}
