# litebuild

This is a very lightweight build system for Android.

# NOTE:
	   This application uses Android sdk tools and in latest version(26) of the Android sdk
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

# Installation
	git clone https://github.com/burakcoskun/litebuild.git
	cd litebuild
	mvn clean install -DskipTests
	executable jar will be exported to litebuild/target/litebuild.jar
	run it from anywhere by specifying full path:
	java -jar path_to_litebuild/target/litebuild.jar

# Usage
	Usage is really straightforward and you would understand when you run: java -jar litebuild.jar --help
	Anyway I should add a few samples:

	There are four commands this app runs {project,compile,package,launch}
	Arguments can be displayed like: java -jar project  --help . This would display usage of project command.

	Commands:
		Project: creates new Android project with it's most basic form
		Compile: compiles Android project along with sources and resources
		Package: packages Android project signs with debug key store and zipaligns it
		Laucn  : install final apk to a running emulator
