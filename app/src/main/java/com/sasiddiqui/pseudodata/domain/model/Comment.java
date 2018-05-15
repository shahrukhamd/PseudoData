package com.sasiddiqui.pseudodata.domain.model;

/**
 * Created by shahrukhamd on 15/05/18.
 * <p>
 * A model class defining the class data.
 */
public class Comment {

    private int postId;
    private int commentId;
    private String userName;
    private String userEmail;
    private String body;

    public Comment(int postId, int commentId, String userName, String userEmail, String body) {
        this.postId = postId;
        this.commentId = commentId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.body = body;
    }

    public Comment() {}

    public int getPostId() {
        return postId;
    }

    public Comment setPostId(int postId) {
        this.postId = postId;
        return this;
    }

    public int getCommentId() {
        return commentId;
    }

    public Comment setCommentId(int commentId) {
        this.commentId = commentId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Comment setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Comment setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Comment setBody(String body) {
        this.body = body;
        return this;
    }
}
