package com.challenge.controller;

public class CustomMessage {

    public String composeMessage(String operator, String a, String b){

        String result = operator + ","+ a +"," + b;

        System.out.println();

        return result;

    }
}
