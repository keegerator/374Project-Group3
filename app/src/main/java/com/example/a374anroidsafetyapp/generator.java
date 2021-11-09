package com.example.a374anroidsafetyapp;

public class generator {
    String[] questions = {"Which of the following is the strongest password?","How often should you update your phone?", "What is the best way to protect your google account?","What is the first thing you should do with your new android device","Which setting(s) should be deactivated when not in use"};
    String[][] answers = {{"$9981023Qtz!","Pa$$word123!","Password123","Qwerty!$"},{"Annually","As soon as available","Weekly","A week or two after release, to ensure the update works as intended"},{"VPN","2-factor Authentication","Antivirus software","Enable remote lock and wipe"},{"Download a VPN","Add a passcode to get in","Download Antivirus software","Enable two factor authentication"},{"Wifi","Bluetooth","Location Services","All of the above"}};
    int[] keys = {0,1,1,1,3};
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
