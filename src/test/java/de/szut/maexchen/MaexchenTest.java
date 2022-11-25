package de.szut.maexchen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class MaexchenTest {
    @Test
    @DisplayName("Maexchen")
    public void givenTwoAndOne_WhenCalculatePoints_Then1000(){
        //Arrange
        Maexchen game = new Maexchen();

        //Act
        int reachedPoints = game.calculatePoints(2, 1);

        //Assert with assertTrue
        assertTrue(1000 == reachedPoints);
    }

    @Test
    public void givenOneAndTwoWhenCalculatePointsThen1000(){
        //Arrange
        Maexchen game = new Maexchen();

        //Act and Assert with assertEquals
        assertEquals(1000, game.calculatePoints(1, 2));
    }

    @ParameterizedTest(name="throw1={0}, throw2={1}, points{2}")
    @CsvSource({"1, 1, 100", "2, 2, 200", "3, 3, 300", "4, 4, 400", "5, 5, 500", "6, 6, 600"})
    @DisplayName("Pasch")
    public void givenADoubletsWhenCalculatePointsThenScoreMultiplyWith100(int throw1, int throw2, int points){
        //da bei der Bennenung der Tests eine given-when-then-Benennung vorgenommen wurde hier statt arrange-act-assert alternativ

        //given
        Maexchen game = new Maexchen();

        //when
        int result = game.calculatePoints(throw1, throw2);

        //then
        assertEquals(points, result);
    }

    @Test
    public void givenThrow1biggerThanThrow2WhenCalculatePointsThenThrow1Multiply10PlusThrow2(){
        Maexchen game = new Maexchen();
        assertEquals(53, game.calculatePoints(5, 3));
    }

    @Test
    public void givenThrow1SmallerThanThrow2WhenCalculatePointsThenThrow2Multiply10PlusThrow1(){
        Maexchen game = new Maexchen();
        assertEquals(64, game.calculatePoints(4, 6));
    }

    @ParameterizedTest(name="throw1={0}, throw2={1}")
    @CsvSource({"-1, 2", "7, 2", "2, -7", "3, 8", "10, 20", "-4, -2"})
    public void givenParamsOutOfRange_WhenCalculatePoints_ThenThrowIllegalArgumentException(int throw1, int throw2){
        Maexchen game = new Maexchen();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> game.calculatePoints(throw1, throw2), "IllegalArgumentException should have been thrown!");
        assertEquals("Throw out of range!", exception.getMessage());
    }
}
