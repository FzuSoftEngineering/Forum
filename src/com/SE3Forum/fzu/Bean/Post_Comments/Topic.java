package com.SE3Forum.fzu.Bean.Post_Comments;

import com.SE3Forum.fzu.Bean.users.User;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Feng on 3/30/16.
 */

    /*
    * 用户发帖
    * 帖子ID
    * 帖子类型
    * 帖子内容
    * 帖子评论   一篇帖子可有多个评论*/
@Entity
@Table(name = "Topic",schema = "ForumDataBase")
public class Topic {

    private int id;
    private String Theme;
    private String Content;
    private User user;
    private List<Post>posts;
    private List<image> images;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User userEntity) {
        this.user = userEntity;
    }

    @OneToMany
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @OneToMany
    public List<image> getImages() {
        return images;
    }

    public void setImages(List<image> images) {
        this.images = images;
    }
}
