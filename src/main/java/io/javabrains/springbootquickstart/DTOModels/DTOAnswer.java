package io.javabrains.springbootquickstart.DTOModels;

public class DTOAnswer {
    int id;
    int likeCount;
    int dislikeCount;
    String text;
    int questionId;

    public DTOAnswer() {
    }

    public DTOAnswer(int likeCount, int dislikeCount, String text, int questionId) {
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.text = text;
        this.questionId = questionId;
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

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
