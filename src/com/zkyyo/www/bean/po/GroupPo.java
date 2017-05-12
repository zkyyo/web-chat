package com.zkyyo.www.bean.po;

import java.sql.Timestamp;

public class GroupPo {
    private int groupId;
    private String name;
    private String description;
    private int population;
    private Timestamp created;

    public GroupPo() {

    }

    public GroupPo(int groupId, String name, String description, int population, Timestamp created) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.population = population;
        this.created = created;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "GroupPo{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", population=" + population +
                ", created=" + created +
                '}';
    }
}
