package io.javabrains.springbootquickstart.DTOModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.javabrains.springbootquickstart.models.Answer;
import io.javabrains.springbootquickstart.models.Category;

import javax.persistence.*;
import java.util.Set;

public class DTOQuestion {
    int id;
    int likeCount;
    int dislikeCount;
    String text;
    int categoryId;

    public DTOQuestion() {
    }

    public DTOQuestion(int likeCount, int dislikeCount, String text, int categoryId) {
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.text = text;
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
