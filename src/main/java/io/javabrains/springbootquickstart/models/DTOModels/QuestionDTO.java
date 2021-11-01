package io.javabrains.springbootquickstart.models.DTOModels;

public class QuestionDTO {
    private int id;
    private int likeCount;
    private int dislikeCount;
    private String text;
    private int categoryId;

    public QuestionDTO() {
    }

    public QuestionDTO(int likeCount, int dislikeCount, String text, int categoryId) {
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
