package com.burakcoskun.litebuild.cli;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by burakcoskun on 7/30/17.
 */
public class CreateProjectTest {

    @Test
    public void isProjectCreatedWithoutAnError() throws IOException {
        String[] args = {"project","-t","android-26","-p","com.mycompany.package","-a","MMM","-d","MyTestProject","-n","MyTestProject"};
        Main.main(args);
        File projectFolder = new File("./MyTestProject");
        assertTrue(projectFolder.exists());
        File[] projectFiles = projectFolder.listFiles();
        assertTrue(projectFiles.length > 0);
//        assertTrue(containsConfFile(projectFiles,"liteBuild.Conf"));
        FileUtils.deleteDirectory(projectFolder);
    }
}