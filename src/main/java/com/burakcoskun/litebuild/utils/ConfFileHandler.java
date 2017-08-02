package com.burakcoskun.litebuild.utils;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by burakcoskun on 7/29/17.
 */
public class ConfFileHandler {

    private String confFileName = "litebuild.settings";

    public class SettingsFileNotCreatedException extends RuntimeException {
        public SettingsFileNotCreatedException(String message) {
            super(message);
        }
    }

    public class SettingsFileNotFoundException extends RuntimeException {
        public SettingsFileNotFoundException(String message) {
            super(message);
        }
    }

    public class AndroidTargetIsNotSpecifiedInSettingsException extends RuntimeException {
        public AndroidTargetIsNotSpecifiedInSettingsException(String message) {
            super(message);
        }
    }

    private List<String> addBeforeAfter(String s) {
        List<String> res = new ArrayList<String>();
        res.add(s + ".before{");
        res.add("");
        res.add("}");
        res.add(s + ".after{");
        res.add("");
        res.add("}");
        return res;
    }

    private void printEmptySettings(File file, String target) {
        List<String> lines = new ArrayList<String>();
        lines.add("target=" + target);
        lines.addAll(addBeforeAfter("compile"));
        lines.addAll(addBeforeAfter("package"));
        lines.addAll(addBeforeAfter("launch"));
        try {
            FileUtils.writeLines(file, lines);
        } catch (IOException e) {
            throw new SettingsFileNotCreatedException("Conf File Could Not Created - error:" + e.getMessage());
        }
    }

    public void createEmptyConfFile(String path, String target) {
        File file = new File(path + "/" + confFileName);
        try {
            file.createNewFile();
            printEmptySettings(file, target);
        } catch (IOException e) {
            throw new SettingsFileNotCreatedException("Conf File Could Not Created - error:" + e.getMessage());
        }

        System.out.println("Added file " + file.getPath());
    }

    public File getFileIfExists(String path) {
        File file = new File(path + "/" + confFileName);
        if (file.exists() == false)
            throw new SettingsFileNotFoundException("Could not find " + confFileName + " file. This may not be a project's root folder");
        return file;
    }

    public String getTarget(String path) {

        File file = getFileIfExists(path);
        List<String> lines = null;

        try {
            lines = FileUtils.readLines(file);
        } catch (IOException e) {
            throw new AndroidTargetIsNotSpecifiedInSettingsException("Error reading target from " + confFileName + " - error:" + e.getMessage());
        }

        for (int i = 0; i < lines.size(); ++i)
            if (lines.get(i).startsWith("target="))
                return lines.get(i).split("=")[1];

        throw new AndroidTargetIsNotSpecifiedInSettingsException("Android target is not specified in " + confFileName);
    }

}
