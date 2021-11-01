package io.javabrains.springbootquickstart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.javabrains.springbootquickstart.models.DTOModels.AnswerDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="answer_id")
    private int id;

    @Column(name="like_count")
    private int likeCount;

    @Column(name="dislike_count")
    private int dislikeCount;

    @Column(name="text")
    private String text;

    @JsonIgnoreProperties("hibernateLazyInitializer")
    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    private Question question;

    public Answer() {

    }

    public Answer(AnswerDTO answerDTO, Question question) {
        this.id = answerDTO.getId();
        this.likeCount = answerDTO.getLikeCount();
        this.dislikeCount = answerDTO.getDislikeCount();
        this.text = answerDTO.getText();
        this.question = question;
    }

    public Answer(int likeCount, int dislikeCount, String text, Question question) {
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.text = text;
        this.question = question;
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
