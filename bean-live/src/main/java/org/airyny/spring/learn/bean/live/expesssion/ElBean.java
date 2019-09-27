package org.airyny.spring.learn.bean.live.expesssion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/9/27 16:10
 * @Version:1.0
 * @deseription:
 **/
@Component("elBean")
public class ElBean {

    @Value("#{role}")
    private Role role;

    @Value("#{role.id}")
    private Long id;

    @Value("#{role.getNote()?.toString()}")
    private String note;


    @Value("#{role.id+1}")
    private int num;

    @Value("#{role.roleName+role.note}")
    private String str;

    @Value("#{role.id == 1}")
    private boolean equalNum;

    @Value("#{role.note eq 'note_1'}")
    private boolean eqaulNote;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean isEqualNum() {
        return equalNum;
    }

    public void setEqualNum(boolean equalNum) {
        this.equalNum = equalNum;
    }

    public boolean isEqaulNote() {
        return eqaulNote;
    }

    public void setEqaulNote(boolean eqaulNote) {
        this.eqaulNote = eqaulNote;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ElBean{" +
                "role=" + role +
                ", id=" + id +
                ", note='" + note + '\'' +
                ", num=" + num +
                ", str='" + str + '\'' +
                ", equalNum=" + equalNum +
                ", eqaulNote=" + eqaulNote +
                '}';
    }
}
