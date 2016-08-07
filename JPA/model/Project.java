package com.endava.jpa.model;

import javax.persistence.Id;

/**
 * Created by tvasile on 7/26/2016.
 */
public class Project {

    @Id
    private int id;

    private String name;

    private String project_manager;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject_manager() {
        return project_manager;
    }

    public void setProject_manager(String project_manager) {
        this.project_manager = project_manager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", project_manager='" + project_manager + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
