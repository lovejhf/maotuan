package com.hkt.mao.app.android.bean;

public class DesignTypeVo {
    private String name;
    private String projectName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public DesignTypeVo(String name, String projectName) {
        this.name = name;
        this.projectName = projectName;
    }
}
