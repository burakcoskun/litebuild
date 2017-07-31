package com.burakcoskun.litebuild.cli;

import com.burakcoskun.litebuild.utils.ConfFileHandler;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by burakcoskun on 7/30/17.
 */
public class CreateProjectTest {

    @Test
    public void isProjectCreatedWithoutAnError() throws IOException {
        String[] args = {"project", "-t", "android-26", "-p", "com.mycompany.package", "-a", "MMM", "-d", "MyTestProject", "-n", "MyTestProject"};
        Main.main(args);
        File projectFolder = new File("./MyTestProject");
        assertTrue(projectFolder.exists());
        File[] projectFiles = projectFolder.listFiles();
        assertTrue(projectFiles.length > 0);
        FileUtils.deleteDirectory(projectFolder);
    }


    @Test
    public void isConfFileCreated() throws Exception {
        new ConfFileHandler().createEmptyConfFile(".", "android-x");
        File file = new File("litebuild.settings");
        assertTrue(file.exists());
        file.delete();
    }
}
