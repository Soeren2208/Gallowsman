package de.szut.hangman;

public class Hangman {
    private String wordToGuess;
    private StringBuffer actualGuessed= new StringBuffer();

    public Hangman(String wantedWord){
        this.wordToGuess = wantedWord;
        getWordInUnderscores();
    }

    private void getWordInUnderscores() {
        for(int i = 0; i<this.wordToGuess.length(); i++){
            actualGuessed = actualGuessed.append("_");
        }
    }

    public String guessCharacter(String character){
        if(isNotLowerCaseLetter(character))
            throw new IllegalArgumentException("Please give a lower case letter!");

        for(int i = 0; i<this.wordToGuess.length(); i++){
            if(isSameCharacter(character, i)){
                actualGuessed.replace(i,i+1, character);
            }
            if(isSameCharacter(character.toUpperCase(), i)){
                actualGuessed.replace(i,i+1, character.toUpperCase());
            }
        }
        return actualGuessed.toString();
    }

    private boolean isNotLowerCaseLetter(String character){
        return !character.matches("[a-z]");
    }

    private boolean isSameCharacter(String character, int i) {
        return this.wordToGuess.substring(i, i + 1).equals(character);
    }

    public String giveNewTry(){
        return this.actualGuessed.toString();
    }
}
