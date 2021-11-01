package io.javabrains.springbootquickstart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.tools.jconsole.JConsoleContext;
import io.javabrains.springbootquickstart.models.DTOModels.QuestionDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="question_id")
    private int id;

    @Column(name="like_count")
    private int likeCount;

    @Column(name="dislike_count")
    private int dislikeCount;

    @Column(name="text")
    private String text;

    @JsonIgnoreProperties("hibernateLazyInitializer")
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @OneToMany( fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,orphanRemoval = true, mappedBy = "question")
    private Set<Answer> answer;

    public Question() {

    }

    public Question(QuestionDTO questionDTO, Category category) {
        this.id = questionDTO.getId();
        this.likeCount = questionDTO.getLikeCount();
        this.dislikeCount = questionDTO.getDislikeCount();
        this.text = questionDTO.getText();
        this.category = category;
        this.answer = new HashSet<>();
    }

    public Question(int likeCount, int dislikeCount, String text, Category category) {
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.text = text;
        this.category = category;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("numberOfAnswers")
    public int getNumberOfAnswers() {
        return answer.size();
    }
}
