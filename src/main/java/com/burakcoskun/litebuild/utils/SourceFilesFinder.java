package com.burakcoskun.litebuild.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SourceFilesFinder {

    public static String fileExtendsion = "java";

    public List<String> findAllPackagePaths(String path) {

        File file = new File(path);

        if (!file.isDirectory()) {
            List<String> javaFiles = new ArrayList<>();
            if (file.getName().endsWith(fileExtendsion))
                javaFiles.add(file.getAbsolutePath());
            return javaFiles;
        }

        List<String> filePaths = new ArrayList<>();
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; ++i)
            filePaths.addAll(findAllPackagePaths(files[i].getPath()));

        return filePaths;
    }
}
