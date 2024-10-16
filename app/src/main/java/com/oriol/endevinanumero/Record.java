package com.oriol.endevinanumero;

public class Record {
    private int score;
    private String name;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Record(String name,int score) {
        this.score = score;
        this.name = name;
    }
}
