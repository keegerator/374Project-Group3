package com.example.a374anroidsafetyapp;

public class generator {
    String[] questions = {"Each byte is assigned a unique","The Java compilier generates", "Every statement ends with","A group of statements are enclosed with","In Java, what is the size allocated for an int data type"};
    String[][] answers = {{"Address","CPU","Bit","Variable"},{"Machine code","Byte Code","Source Code","HTML"},{"Period","Semicolon","Brackets","Ending Brace"},{"Parenthesis","Brackets","Period","Semicolon"},{"8 bytes","16 bytes","4 bytes","2 bytes"}};
    int[] keys = {0,1,1,1,2};
    int correct,total=0;
    int index = -1;
    public generator(){
        String[] question = new String[5];
        String [][] answers = new String[5][4];
        int[] keys = new int[5];
        int index = -1;
        int correct = 0;
        int total = 0;
    }
    public void generate(){
        index++;
    }

    public String getQuestions(int index) {
        return questions[index];
    }
    public String getAnswer1(int index){
        return answers[index][0];
    }
    public String getAnswer2(int index){
        return answers[index][1];
    }
    public String getAnswer3(int index){
        return answers[index][2];
    }
    public String getAnswer4(int index){
        return answers[index][3];
    }
    public int getKey(int index) {
        return keys[index];
    }
    public int increaseCorrect(){
        return correct++;
    }
    public int increaseTotal(){
        return total++;
    }
    public int getCorrect() {
        return correct;
    }
    public int getTotal() {
        return total;
    }
}
