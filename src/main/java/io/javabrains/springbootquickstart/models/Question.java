package io.javabrains.springbootquickstart.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="question_id")
    int id;
    @Column(name="like_count")
    int likeCount;
    @Column(name="dislike_count")
    int dislikeCount;
    @Column(name="text")
    String text;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @OneToMany(mappedBy="question")
    private Set<Answer> answer;

    public Question() {
    }

    public Question(int likeCount, int dislikeCount, String text, int categoryId) {
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.text = text;
        category =new Category("","","",null);
        category.setId(categoryId);
    }

    @JsonProperty("numberOfAnswers")
    public int getNumberOfAnswers() {
        return answer.size();
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

}
