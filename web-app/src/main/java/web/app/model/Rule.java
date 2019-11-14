package web.app.model;

import javax.validation.constraints.Null;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/13 17:13
 * @Version:1.0
 * @deseription:
 **/
public class Rule {

    @Null
    private String name;

    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
