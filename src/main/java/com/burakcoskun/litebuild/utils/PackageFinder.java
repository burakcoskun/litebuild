package com.burakcoskun.litebuild.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PackageFinder {

    public static String fileExtendsion = "java";

    public List<String> findAllPackagePaths(String path) {
        File file = new File(path);
        if (!file.isDirectory())
            return new ArrayList<>();
        List<String> packages = new ArrayList<>();
        File[] files = file.listFiles();
        boolean addThisFolderToResults = false;
        for (int i = 0; i < files.length; ++i) {
            if (files[i].isDirectory())
                packages.addAll(findAllPackagePaths(files[i].getPath()));
            if (files[i].getName().endsWith(fileExtendsion))
                addThisFolderToResults = true;
        }
        if (addThisFolderToResults)
            packages.add(file.getAbsolutePath());
        return packages;
    }
}
