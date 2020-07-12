package com.itheima.domain;

/**
 * @author kpwang
 * @create 2020-07-05 16:30
 */
public class QueryVo {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                '}';
    }
}
