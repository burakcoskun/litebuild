package com.burakcoskun.litebuild;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by burakcoskun on 7/29/17.
 */
public class ConfFileHandler {

    private List<String> addBeforeAfter(String s){
        List<String> res = new ArrayList<String>();
        res.add(s+".before{");
        res.add("");
        res.add("}");
        res.add(s+".after{");
        res.add("");
        res.add("}");
        return res;
    }

    private void printEmptySettings(File file) throws IOException {
        List<String> lines = new ArrayList<String>();
        lines.addAll(addBeforeAfter("compile"));
        lines.addAll(addBeforeAfter("package"));
        lines.addAll(addBeforeAfter("launch"));
        FileUtils.writeLines(file,lines);
    }

    public void createEmptyConfFile(String path) throws Exception {
        File file = new File(path+"/litebuild.settings");
        if(!file.createNewFile())
            throw new Exception("Conf File Could Not Created");
        printEmptySettings(file);
        System.out.println("Added file "+file.getPath());
    }

}
