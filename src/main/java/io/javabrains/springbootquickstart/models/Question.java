package io.javabrains.springbootquickstart.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Question {
    @Id
    int id;
    int likeCount;
    int dislikeCount;
    int numberOfAnswers;
    String text;

    @ManyToOne
    Category category;

    public Question() {
    }

    public Question(int id, int likeCount, int dislikeCount, int numberOfAnswers, String text, int categoryId) {
        this.id = id;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.numberOfAnswers = numberOfAnswers;
        this.text = text;
        category =new Category(categoryId,"","","",null);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(int numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
