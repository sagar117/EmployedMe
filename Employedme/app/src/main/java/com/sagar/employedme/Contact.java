package com.sagar.employedme;

/**
 * Created by MHC on 4/5/2015.
 */
public class Contact {
    String name,email,uname,pass,image,contactno,age,gender,city,reqjob,avjob;

    public Contact(String name, String uname) {
    }


    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setUname(String uname){
        this.uname=uname;
    }
    public String getUname(){
        return uname;
    }
    public void setPassword(String password){
        this.pass=password;
    }
    public String getPassword(){
        return pass;
    }
    public void setContactno(String contactno){
        this.contactno=contactno;
    }
    public String getContactno(){
        return pass;
    }
    public void setAge(String age){
        this.age=age;
    }
    public String getAge(){
        return age;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return gender;
    }
    public void setCity(String city){
        this.city=city;
    }
    public String getCity(){
        return city;
    }
    public void setReqjob(String reqjob){
        this.reqjob=reqjob;
    }
    public String getReqjob(){
        return reqjob;
    }
    public void setAvjob(String avjob){
        this.avjob=avjob;
    }
    public String getAvjob(){
        return avjob;
    }


}
