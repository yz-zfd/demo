package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author zfd
 */
@Entity
@Table(name="driver_information")
public class DriverInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;//id值
    @Column
    private String name;//名字
    @Column
    private String nationality;//国籍
    @Column
    private String phone_number;//电话号码
    @Column
    private Boolean marital_status;//婚姻状态
    @Column
    private String person_id;//身份证号
    @Column
    private String company;//公司
    @Column
    private String sex;//性别
    @Column
    private String foreign_language_ability;//外语能力
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column
    private Date birthday;//出生日期
    @Column
    private String education;//教育水平
    @Column
    private String photo;//头像

    public DriverInformation() {
    }

    public DriverInformation(String name, String phone_number, Boolean marital_status, String person_id, String company, String sex, Date birthday,String photo) {
        this.name = name;

        this.phone_number = phone_number;
        this.marital_status = marital_status;
        this.person_id = person_id;
        this.company = company;
        this.sex = sex;
        this.birthday = birthday;
        this.photo = photo;
    }

    public DriverInformation(String name, String nationality, String phone_number, Boolean marital_status, String person_id, String company, String sex, String foreign_language_ability, Date birthday, String education, String photo) {
        this.name = name;
        this.nationality = nationality;
        this.phone_number = phone_number;
        this.marital_status = marital_status;
        this.person_id = person_id;
        this.company = company;
        this.sex = sex;
        this.foreign_language_ability = foreign_language_ability;
        this.birthday = birthday;
        this.education = education;
        this.photo = photo;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public boolean isMarital_status() {
        return marital_status;
    }

    public void setMarital_status(boolean marital_status) {
        this.marital_status = marital_status;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getForeign_language_ability() {
        return foreign_language_ability;
    }

    public void setForeign_language_ability(String foreign_language_ability) {
        this.foreign_language_ability = foreign_language_ability;
    }

    public Boolean getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(Boolean marital_status) {
        this.marital_status = marital_status;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "DriverInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", marital_status=" + marital_status +
                ", person_id='" + person_id + '\'' +
                ", company='" + company + '\'' +
                ", sex='" + sex + '\'' +
                ", foreign_language_ability='" + foreign_language_ability + '\'' +
                ", birthday=" + birthday +
                ", education='" + education + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
