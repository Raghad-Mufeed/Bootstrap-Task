package io.javabrains.springbootquickstart.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Category {
    @Id
    int id;
    String name;
    String description;

    public Category(){
    }

    public Category(int id, String name, String description, String imageURL, String[] tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        ImageURL = imageURL;
        this.tags = tags;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    String ImageURL;
    String tags[];

}
