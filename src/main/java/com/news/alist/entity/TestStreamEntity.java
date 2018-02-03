package com.news.alist.entity;

import java.util.ArrayList;
import java.util.List;

public class TestStreamEntity {

    private Long kid;

    private Integer id;

    private String name;

    private Integer sex;

    private String remark;

    public Long getKid() {
        return kid;
    }

    public void setKid(Long kid) {
        this.kid = kid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<TestStreamEntity> getData() {
        List<TestStreamEntity> list = new ArrayList<TestStreamEntity>() {{
            TestStreamEntity entity = new TestStreamEntity();
            entity.setId(1);
            entity.setKid(2L);
            entity.setName("测试王");
            entity.setRemark("注释一下111");
            entity.setSex(1);
            add(entity);

            TestStreamEntity entity2 = new TestStreamEntity();
            entity2.setId(2);
            entity2.setKid(4L);
            entity2.setName("测试张");
            entity2.setRemark("注释一下223");
            entity2.setSex(0);
            add(entity2);

            TestStreamEntity entity3 = new TestStreamEntity();
            entity3.setId(3);
            entity3.setKid(6L);
            entity3.setName("测试神");
            entity3.setRemark("注释一下334");
            entity3.setSex(0);
            add(entity3);
        }};

        return list;
    }

}
