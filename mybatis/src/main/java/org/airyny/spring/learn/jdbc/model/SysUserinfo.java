package org.airyny.spring.learn.jdbc.model;

import java.io.Serializable;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/19 14:05
 * @Version:1.0
 * @deseription:
 **/
public class SysUserinfo implements Serializable {
        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.id
         *
         * @mbg.generated
         */
        private Integer id;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.user_id
         *
         * @mbg.generated
         */
        private String userId;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.user_lgn_code
         *
         * @mbg.generated
         */
        private String userLgnCode;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.user_lgn_pwd
         *
         * @mbg.generated
         */
        private String userLgnPwd;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.user_name
         *
         * @mbg.generated
         */
        private String userName;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.user_email
         *
         * @mbg.generated
         */
        private String userEmail;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.user_level
         *
         * @mbg.generated
         */
        private String userLevel;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.user_status
         *
         * @mbg.generated
         */
        private String userStatus;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.user_avatar
         *
         * @mbg.generated
         */
        private String userAvatar;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.create_time
         *
         * @mbg.generated
         */
        private String createTime;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column sys_userinfo.modify_time
         *
         * @mbg.generated
         */
        private String modifyTime;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table sys_userinfo
         *
         * @mbg.generated
         */
        private static final long serialVersionUID = 1L;

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.id
         *
         * @return the value of sys_userinfo.id
         *
         * @mbg.generated
         */
        public Integer getId() {
            return id;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.id
         *
         * @param id the value for sys_userinfo.id
         *
         * @mbg.generated
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.user_id
         *
         * @return the value of sys_userinfo.user_id
         *
         * @mbg.generated
         */
        public String getUserId() {
            return userId;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.user_id
         *
         * @param userId the value for sys_userinfo.user_id
         *
         * @mbg.generated
         */
        public void setUserId(String userId) {
            this.userId = userId == null ? null : userId.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.user_lgn_code
         *
         * @return the value of sys_userinfo.user_lgn_code
         *
         * @mbg.generated
         */
        public String getUserLgnCode() {
            return userLgnCode;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.user_lgn_code
         *
         * @param userLgnCode the value for sys_userinfo.user_lgn_code
         *
         * @mbg.generated
         */
        public void setUserLgnCode(String userLgnCode) {
            this.userLgnCode = userLgnCode == null ? null : userLgnCode.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.user_lgn_pwd
         *
         * @return the value of sys_userinfo.user_lgn_pwd
         *
         * @mbg.generated
         */
        public String getUserLgnPwd() {
            return userLgnPwd;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.user_lgn_pwd
         *
         * @param userLgnPwd the value for sys_userinfo.user_lgn_pwd
         *
         * @mbg.generated
         */
        public void setUserLgnPwd(String userLgnPwd) {
            this.userLgnPwd = userLgnPwd == null ? null : userLgnPwd.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.user_name
         *
         * @return the value of sys_userinfo.user_name
         *
         * @mbg.generated
         */
        public String getUserName() {
            return userName;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.user_name
         *
         * @param userName the value for sys_userinfo.user_name
         *
         * @mbg.generated
         */
        public void setUserName(String userName) {
            this.userName = userName == null ? null : userName.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.user_email
         *
         * @return the value of sys_userinfo.user_email
         *
         * @mbg.generated
         */
        public String getUserEmail() {
            return userEmail;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.user_email
         *
         * @param userEmail the value for sys_userinfo.user_email
         *
         * @mbg.generated
         */
        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail == null ? null : userEmail.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.user_level
         *
         * @return the value of sys_userinfo.user_level
         *
         * @mbg.generated
         */
        public String getUserLevel() {
            return userLevel;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.user_level
         *
         * @param userLevel the value for sys_userinfo.user_level
         *
         * @mbg.generated
         */
        public void setUserLevel(String userLevel) {
            this.userLevel = userLevel == null ? null : userLevel.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.user_status
         *
         * @return the value of sys_userinfo.user_status
         *
         * @mbg.generated
         */
        public String getUserStatus() {
            return userStatus;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.user_status
         *
         * @param userStatus the value for sys_userinfo.user_status
         *
         * @mbg.generated
         */
        public void setUserStatus(String userStatus) {
            this.userStatus = userStatus == null ? null : userStatus.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.user_avatar
         *
         * @return the value of sys_userinfo.user_avatar
         *
         * @mbg.generated
         */
        public String getUserAvatar() {
            return userAvatar;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.user_avatar
         *
         * @param userAvatar the value for sys_userinfo.user_avatar
         *
         * @mbg.generated
         */
        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar == null ? null : userAvatar.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.create_time
         *
         * @return the value of sys_userinfo.create_time
         *
         * @mbg.generated
         */
        public String getCreateTime() {
            return createTime;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.create_time
         *
         * @param createTime the value for sys_userinfo.create_time
         *
         * @mbg.generated
         */
        public void setCreateTime(String createTime) {
            this.createTime = createTime == null ? null : createTime.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column sys_userinfo.modify_time
         *
         * @return the value of sys_userinfo.modify_time
         *
         * @mbg.generated
         */
        public String getModifyTime() {
            return modifyTime;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column sys_userinfo.modify_time
         *
         * @param modifyTime the value for sys_userinfo.modify_time
         *
         * @mbg.generated
         */
        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime == null ? null : modifyTime.trim();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table sys_userinfo
         *
         * @mbg.generated
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" [");
            sb.append("Hash = ").append(hashCode());
            sb.append(", id=").append(id);
            sb.append(", userId=").append(userId);
            sb.append(", userLgnCode=").append(userLgnCode);
            sb.append(", userLgnPwd=").append(userLgnPwd);
            sb.append(", userName=").append(userName);
            sb.append(", userEmail=").append(userEmail);
            sb.append(", userLevel=").append(userLevel);
            sb.append(", userStatus=").append(userStatus);
            sb.append(", userAvatar=").append(userAvatar);
            sb.append(", createTime=").append(createTime);
            sb.append(", modifyTime=").append(modifyTime);
            sb.append(", serialVersionUID=").append(serialVersionUID);
            sb.append("]");
            return sb.toString();
        }
    }
