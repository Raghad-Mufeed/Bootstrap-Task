package io.javabrains.springbootquickstart.models;

import javax.persistence.*;

@Entity
@Table(name = "ANSWER")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="answer_id")
    int id;
    @Column(name="like_count")
    int likeCount;
    @Column(name="dislike_count")
    int dislikeCount;
    @Column(name="text")
    String text;

    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    private Question question;

    public Answer() {
    }

    public Answer(int likeCount, int dislikeCount, String text, int questionId, int categoryId) {
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.text = text;
        question = new Question(0,0,null,categoryId);
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
