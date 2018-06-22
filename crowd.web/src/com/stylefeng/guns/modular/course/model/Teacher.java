package com.stylefeng.guns.modular.course.model;

public class Teacher {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 是否使用
     */
    private String sfsy;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 账号
     * @return account 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 是否使用
     * @return sfsy 是否使用
     */
    public String getSfsy() {
        return sfsy;
    }

    /**
     * 是否使用
     * @param sfsy 是否使用
     */
    public void setSfsy(String sfsy) {
        this.sfsy = sfsy == null ? null : sfsy.trim();
    }

    /**
     *
     * @mbggenerated 2018-06-15
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", name=").append(name);
        sb.append(", sfsy=").append(sfsy);
        sb.append("]");
        return sb.toString();
    }
}