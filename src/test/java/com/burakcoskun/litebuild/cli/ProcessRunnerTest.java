package com.burakcoskun.litebuild.cli;

/**
 * Created by burakcoskun on 8/3/17.
 */

import com.burakcoskun.litebuild.utils.ProcessRunner;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ProcessRunnerTest {

    @Test
    public void isSimpleCommandRunOnProcessRunner() throws IOException {
        ProcessRunner processRunner = new ProcessRunner();
        processRunner.run("mkdir myTestFolder");
        File file = new File("myTestFolder");
        assertTrue(file.exists());
        FileUtils.deleteDirectory(file);
    }
}
