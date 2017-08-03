package com.burakcoskun.litebuild.cli;

import com.burakcoskun.litebuild.utils.ConfFileHandler;
import com.burakcoskun.litebuild.utils.SourceFilesFinder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by burakcoskun on 8/3/17.
 */
public class CompileProjectTest {

    @Test
    public void isSourceFilesFound() throws IOException {
        File file = new File("mysrc/com/mycompany/myproject/A.java");
        file.getParentFile().mkdirs();
        file.createNewFile();
        SourceFilesFinder sourceFilesFinder = new SourceFilesFinder();
        assertTrue(sourceFilesFinder.findAllPackagePaths("./mysrc").size() > 0);
        assertTrue(sourceFilesFinder.findAllPackagePaths("./mysrc").get(0).endsWith("A.java"));
        FileUtils.deleteDirectory(new File("mysrc"));
    }

    @Test(expected = ConfFileHandler.SettingsFileNotFoundException.class)
    public void couldNotRunCompileOnAnyFolder() {
        String[] args = {"compile"};
        Main.main(args);
    }

}
