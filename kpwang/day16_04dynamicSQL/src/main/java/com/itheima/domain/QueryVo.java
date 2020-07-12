package com.itheima.domain;

import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-05 16:30
 */
public class QueryVo {
    private User user;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

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
