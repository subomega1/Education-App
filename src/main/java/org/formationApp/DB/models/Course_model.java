package org.formationApp.DB.models;

public class Course_model {
    private String title, description;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
    public Course_model(String title , String description){
        setTitle(title);
        setDescription(description);
    }
}
