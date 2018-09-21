package com.shivansh.iiitamun18;

public  class Teammembers{
    private int imageid;
    private String name;
    private String description;
    private String no;
    private String email;
    private String fb;
    int isgeneral;

    Teammembers(int imageid,String name, String description, String no, String email, String fb, int isgeneral){

        this.imageid = imageid;
        this.name=name;
        this.description = description;
        this.no= no;
        this.email = email;
        this.fb = fb;
        this.isgeneral = isgeneral;
     }
     public int getimage(){
        return imageid;
     }
     public String getname(){
         return name;
     }
     public String getdes(){
         return description;
     }
     public String getno(){
         return no;
     }
     public String getmail(){
         return email;
     }
     public String getfb(){
         return fb;
     }
     public int getIsgeneral(){
         return isgeneral;
     }

 }
