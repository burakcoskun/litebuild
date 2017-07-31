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

    private void printEmptySettings(File file, String target) throws IOException {
        List<String> lines = new ArrayList<String>();
        lines.add("target=" + target);
        lines.addAll(addBeforeAfter("compile"));
        lines.addAll(addBeforeAfter("package"));
        lines.addAll(addBeforeAfter("launch"));
        FileUtils.writeLines(file, lines);
    }

    public void createEmptyConfFile(String path, String target) throws Exception {
        File file = new File(path + "/litebuild.settings");
        if (!file.createNewFile())
            throw new Exception("Conf File Could Not Created");
        printEmptySettings(file, target);
        System.out.println("Added file " + file.getPath());
    }

    public File getFileIfExists(String path) throws Exception {
        File file = new File(path + "/litebuild.settings");
        if (file.exists() == false)
            throw new Exception("Could not find litebuild.settings file. This may not be a project's root folder");
        return file;
    }

    public String getTarget(String path) throws Exception {
        File file = getFileIfExists(path);
        List<String> lines = FileUtils.readLines(file);
        for (int i = 0; i < lines.size(); ++i)
            if (lines.get(i).startsWith("target="))
                return lines.get(i).split("=")[1];
        throw new Exception("Android target is not specified in litebuild.settings");
    }
}
