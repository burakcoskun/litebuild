# litebuild

This is a very lightweight build system for Android.

# NOTE:
	   This application uses Android sdk tools and in the latest version(26) of the Android sdk
	   path/to/sdk/tools/android is deprecated and this app rely on this sdk tool.
	   So this app can't work with the newest version of Android sdk and you should use
	   Android Sdk Tools version 25 or older.
	   -litebuild app tested exclusively at Android SDK Tools 25.0.3 and various versions of build-tools.

It can create,compile, package and launch Android apps.

# Dependencies:
	aapt should be located at your_android_home/build-tools/build_tools_version/
	zipalign should be at the same folder with aapt
	dx		 should be at the same folder with aapt
	adb 	 should be located at your_android_home/platform-tools
	debug.keystore should be located at: your_home_directory/.android/

	android tool should not be the latest  version, it should be version 25 or older. below there are download links for older version.
	android tool should be located at your_android_home/android

# (If you are using latest version of android tools) Install Version 25 of Android Tools(you can also install older versions)
	for mac:    https://dl-ssl.google.com/android/repository/tools_r25.0.3-macosx.zip
	for windows:https://dl-ssl.google.com/android/repository/tools_r25.0.3-windows.zip

	replace downloaded folder with your_android_home/tools
	you can also change version number(25.0.3) to whatever you like except 26.

# Installation
	git clone https://github.com/burakcoskun/litebuild.git
	cd litebuild
	mvn clean install -DskipTests
	executable jar will be exported to target/litebuild.jar
	run it from anywhere by specifying full path:
	java -jar path_to_litebuild/target/litebuild.jar

# Usage
	Usage is really straightforward and you would understand when you run: java -jar litebuild.jar --help
	Anyway I should mention it beriefly:

	There are four commands this app runs {project,compile,package,launch}
	Arguments can be displayed like: java -jar project  --help . This would display usage of project command.

	Commands:
		project: creates new Android project with it's most basic form
			This command also creates a file named litebuild.settings which includes android target, you should not delete this line.
			Litebuild.settings file also comes with sections command.before and command.after .
			You can specify your own commands like this:
			compile.before{
				echo This command runs before the compile command
			}
			compile.after{
				echo this command runs after the compile command
			}
			You can specify before and after for compile,package and launch commands
		compile: compiles Android project along with sources and resources
		package: packages Android project signs with debug key store and zipaligns it
		launch  : install final apk to a running emulator