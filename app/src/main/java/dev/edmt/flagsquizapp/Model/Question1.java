package dev.edmt.flagsquizapp.Model;

/**
 * Created by reale on 30/09/2016.
 */

public class Question1 {
    private int ID;
    private String Quest;
    private String CorrectAnswer;

    public Question1(int ID, String quest, String correctAnswer) {
        this.ID = ID;
        Quest = quest;
        CorrectAnswer = correctAnswer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuest() {
        return Quest;
    }

    public void setQuest(String quest) {
        Quest = quest;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }
}
