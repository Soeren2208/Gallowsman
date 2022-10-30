package de.szut.maexchen;

public class Maexchen {

    public int calculatePoints(int throw1, int throw2){
        int result = 0;
        if(throw1<1 || throw2<1 || throw1 > 6 || throw2>6 ){
            throw new IllegalArgumentException("Throw out of range!") ;
        }

        if (throw1 + throw2 == 3) {
            result = 1000;
        } else if (throw1 == throw2) {
            result = throw1 * 100;
        } else if (throw1 > throw2) {
            result = 10 * throw1 + throw2;
        } else if (throw1 < throw2){
            result = 10 * throw2 + throw1;
        }
        else{
            result = 0;
        }
        return result;
    }
}
