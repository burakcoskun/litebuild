package com.burakcoskun.litebuild.utils;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by burakcoskun on 7/29/17.
 * <p>
 * This class locates latest build-tool on the system.
 */
public class BuildToolsLocator {

    public class BuildToolsNotFoundException extends RuntimeException {
        BuildToolsNotFoundException(String message) {
            super(message);
        }
    }

    public String getLatestAvailableBuildToolsVersion(String androidHome) {
        File folder = new File(androidHome + "/build-tools");
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles.length == 0)
            throw new BuildToolsNotFoundException("Build Tools Not Found");
        Arrays.sort(listOfFiles, new Comparator<File>() {
            public int compare(File o1, File o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        return listOfFiles[0].getName();
    }
}
