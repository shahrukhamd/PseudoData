package com.sasiddiqui.pseudodata.domain.model;

/**
 * Created by shahrukhamd on 15/05/18.
 * <p>
 * A simple model class that will define the data of a pseudo post.
 */
public class Post {

    private int userId;
    private int postId;
    private String title;
    private String body;

    /**
     * Initialize a post with data.
     *
     * @param userId The unique ID of user.
     * @param postId The unique ID of this post.
     * @param title The title of this post.
     * @param body The body of this post.
     */
    public Post(int userId, int postId, String title, String body) {
        this.userId = userId;
        this.postId = postId;
        this.title = title;
        this.body = body;
    }

    public Post() {}

    public int getUserId() {
        return userId;
    }

    public Post setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getPostId() {
        return postId;
    }

    public Post setPostId(int postId) {
        this.postId = postId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Post setBody(String body) {
        this.body = body;
        return this;
    }
}
