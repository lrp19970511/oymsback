package com.oyms.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.userName
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.userPassword
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    private String userpassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.userImg
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    private String userimg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.createTime
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.role_id
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    private Integer roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.userName
     *
     * @return the value of user.userName
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.userName
     *
     * @param username the value for user.userName
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.userPassword
     *
     * @return the value of user.userPassword
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public String getUserpassword() {
        return userpassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.userPassword
     *
     * @param userpassword the value for user.userPassword
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.userImg
     *
     * @return the value of user.userImg
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public String getUserimg() {
        return userimg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.userImg
     *
     * @param userimg the value for user.userImg
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public void setUserimg(String userimg) {
        this.userimg = userimg == null ? null : userimg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.createTime
     *
     * @return the value of user.createTime
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.createTime
     *
     * @param createtime the value for user.createTime
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.role_id
     *
     * @return the value of user.role_id
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.role_id
     *
     * @param roleId the value for user.role_id
     *
     * @mbg.generated Thu Oct 31 14:33:00 CST 2019
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}