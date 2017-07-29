package com.burakcoskun.litebuild;

import java.io.IOException;

/**
 * Created by burakcoskun on 7/29/17.
 */
public class ProcessRunner {
    public void run(String[] cmd) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process p = processBuilder.start();
        p.waitFor();
    }
}
