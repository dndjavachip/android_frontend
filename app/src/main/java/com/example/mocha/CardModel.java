package com.example.mocha;


public class CardModel {

    String text;
    int viewType;

    public CardModel(String text, int viewType) {
        this.text = text;
        this.viewType = viewType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}