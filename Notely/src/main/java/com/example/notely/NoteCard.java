package com.example.notely;
public class NoteCard {
    private String term;
    private String definition;
    private int priorityNum;
    private int cardNumber;

    public NoteCard(){
        term = "";
        definition = "";
        priorityNum = 0;
        cardNumber = 1;
    }
    public NoteCard(String term, String definition, int priorityNum, int cardNumber){
        this.term = term;
        this.definition = definition;
        this.priorityNum = priorityNum;
        this.cardNumber = cardNumber;
    }
    public void setTerm(String term){
        this.term = term;
    }
    public void setDefinition(String definition){
        this.definition = definition;
    }
    public void setPriorityNum(int priorityNum){
        this.priorityNum = priorityNum;
    }
    public void setCardNumber(int cardNumber){
        this.cardNumber = cardNumber;
    }
    public String getTerm(){
        return term;
    }
    public String getDefinition(){
        return definition;
    }
    public int getPriorityNum(){
        return priorityNum;
    }
    public int getCardNumber(){
        return cardNumber;
    }

}
