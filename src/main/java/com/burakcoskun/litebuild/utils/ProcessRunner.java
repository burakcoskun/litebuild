package com.burakcoskun.litebuild.utils;

/**
 * Created by burakcoskun on 7/29/17.
 */
public class ProcessRunner {

    public class CommandLineCommandCouldNotRunException extends RuntimeException {
        CommandLineCommandCouldNotRunException(String message) {
            super(message);
        }
    }

    public void run(String cmd) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(cmd.split(" "));
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process p = processBuilder.start();
            p.waitFor();
        } catch (Exception e) {
            throw new CommandLineCommandCouldNotRunException("Command: " + cmd + "\n" + "Could not executed - error:" + e.getMessage());
        }
    }
}
