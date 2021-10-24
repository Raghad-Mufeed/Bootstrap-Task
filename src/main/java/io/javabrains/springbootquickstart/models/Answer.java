package io.javabrains.springbootquickstart.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Answer {
    @Id
    int id;
    int likeCount;
    int dislikeCount;
    String text;

    @ManyToOne
    Question question;

    public Answer() {
    }

    public Answer(int id, int likeCount, int dislikeCount, String text, int questionId, int categoryId) {
        this.id = id;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.text = text;
        question = new Question(questionId,0,0,0,null,categoryId);
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
