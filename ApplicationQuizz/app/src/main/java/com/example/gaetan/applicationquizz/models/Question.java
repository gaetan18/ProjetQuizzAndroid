package com.example.gaetan.applicationquizz.models;

public class Question {
    private int id;
    private String title;
    private String responseOne;
    private String responseTwo;
    private String responseThree;
    private String responseFour;
    private String theme;
    private String goodResponse;

    public Question(int id, String title, String responseOne, String responseTwo, String responseThree, String responseFour, String theme, String goodResponse) {
        this.id = id;
        this.title = title;
        this.responseOne = responseOne;
        this.responseTwo = responseTwo;
        this.responseThree = responseThree;
        this.responseFour = responseFour;
        this.theme = theme;
        this.goodResponse = goodResponse;
    }




    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public String getResponseOne(){return this.responseOne;}
    public void setResponseOne(String responseOne){ this.responseOne = responseOne;}

    public String getResponseTwo(){ return this.responseTwo;}
    public void setResponseTwo(String responseTwo){this.responseTwo = responseTwo;}

    public String getResponseThree(){return this.responseThree;}
    public void setResponseThree(String responseThree){ this.responseThree = responseThree;}

    public String getResponseFour(){return this.responseFour;}
    public void setResponseFour(String responseFour){this.responseFour = responseFour;}

    public String getTheme(){return this.theme;}
    public void setTheme(String theme){this.theme = responseFour;}

    public String getGoodResponse(){return this.goodResponse;}
    public void setGoodResponse(String goodResponse){this.goodResponse = goodResponse;}
}
