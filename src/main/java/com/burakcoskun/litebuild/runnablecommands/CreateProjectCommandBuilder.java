package com.burakcoskun.litebuild.runnablecommands;

public class CreateProjectCommandBuilder extends AndroidSDKCommandCreator {

    private String activity;
    private String dir;
    private String name;
    private String target;
    private String packageName;

    public CreateProjectCommandBuilder() {
        super();
    }

    public CreateProjectCommandBuilder setActivity(String activity) {
        this.activity = activity;
        return this;
    }

    public CreateProjectCommandBuilder setDir(String dir) {
        this.dir = dir;
        return this;
    }

    public CreateProjectCommandBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CreateProjectCommandBuilder setTarget(String target) {
        this.target = target;
        return this;
    }

    public CreateProjectCommandBuilder setPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append(androidHome + "/tools/android create project");
        builder.append(" -a " + activity);
        builder.append(" --path " + dir);
        if (name != null)
            builder.append(" -n " + name);
        builder.append(" -t " + target);
        builder.append(" --package " + packageName);
        return builder.toString();
    }

}
