package com.burakcoskun.litebuild.cli;

import com.burakcoskun.litebuild.utils.ConfFileHandler;
import org.junit.Test;

/**
 * Created by burakcoskun on 8/3/17.
 */
public class PackageProjectTest {

    @Test(expected = ConfFileHandler.SettingsFileNotFoundException.class)
    public void couldNotRunCompileOnAnyFolder() {
        String[] args = {"package"};
        Main.main(args);
    }

    //TODO implement these tests after changing relative paths to system.getProperty("user.dir")
/*    @Test
    public void isAPKGeneratedSuccessfully(){
        String[] args = {"project", "-t", "android-26", "-p", "com.mycompany.package", "-a", "MMM", "-d", "MyTestProject", "-n", "MyTestProject"};
        Main.main(args);
        System.setProperty("user.dir",System.getProperty("user.dir")+"/MyTestProject");
        System.out.println("MyWorkingDir:"+System.getProperty("user.dir"));
        String[] compileArgs ={"compile"};
        Main.main(compileArgs);
        String[] packageArgs = {"package"};
        Main.main(packageArgs);
        assertTrue(new File("bin/AndroidTest.unsigned.apk").exists());
        assertTrue(new File("bin/AndroidTest.signed.apk").exists());
        assertTrue(new File("bin/AndroidTest.apk").exists());
    }*/
}
