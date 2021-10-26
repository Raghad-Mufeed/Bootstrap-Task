package io.javabrains.springbootquickstart.models;

import io.javabrains.springbootquickstart.converters.ListToStringConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    int id;
    @Column(name="name")
    String name;
    @Column(name="description")
    String description;
    @Column(name="image_url")
    String imageURL;
    @Column(name="tags")
    @Convert(converter = ListToStringConverter.class)
    List<String> tags;

    @OneToMany(mappedBy="category")
    private Set<Question> question;


    public Category(){
    }

    public Category(String name, String description, String imageURL, String[] tags) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.tags = new ArrayList<String>(Arrays.asList(tags));
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
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = new ArrayList<String>(Arrays.asList(tags));
    }

}
