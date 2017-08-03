package com.burakcoskun.litebuild.cli;

import com.burakcoskun.litebuild.utils.ConfFileHandler;
import org.junit.Test;

/**
 * Created by burakcoskun on 8/3/17.
 */
public class LaunchProjectTest {

    @Test(expected = ConfFileHandler.SettingsFileNotFoundException.class)
    public void couldNotRunCompileOnAnyFolder() {
        String[] args = {"launch"};
        Main.main(args);
    }
}
