package com.burakcoskun.litebuild.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by burakcoskun on 7/29/17.
 * <p>
 * This class locates latest build-tool on the system.
 */
public class BuildToolsLocator {

    public String getLatestAvailableBuildToolsVersion(String androidHome) throws FileNotFoundException {
        File folder = new File(androidHome + "/build-tools");
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles.length == 0)
            throw new FileNotFoundException("Build Tools Not Found");
        Arrays.sort(listOfFiles, new Comparator<File>() {
            public int compare(File o1, File o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        return listOfFiles[0].getName();
    }
}
