package day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestModule {
    private String PATHNAME;
    private List<String> ActualList;
    private List<String> ExpectedList;

    @BeforeEach
    void setParams(){
        PATHNAME = "src\\main\\resources\\input.txt";
        ActualList = new ArrayList<String>();
        ExpectedList = new ArrayList<String>();
    }

    @Test
    @DisplayName("Add negative Values into the List")
    void CalcWithNegativeValues(){
        ActualList.add("-2000");
        ActualList.add("5000");

        ExpectedList.add("5000");

        int actual = Module.CalculateFuelPart2(ActualList);
        int expected = Module.CalculateFuelPart2(ExpectedList);

        assertEquals(expected, actual, "The program should not calculate the negative value and should not add it in the sum");
    }

    @Test
    @DisplayName("Add empty Strings into the List")
    void CalcWithEmptyString(){
        ActualList.add("5000");
        ActualList.add("");
        ActualList.add("2000");

        ExpectedList.add("5000");
        ExpectedList.add("2000");

        assertEquals(Module.CalculateFuelPart2(ExpectedList), Module.CalculateFuelPart2(ActualList));
    }

    @Test
    @DisplayName("Add any letters into the List")
    void CalculateWithLetters(){
        ActualList.add("2000");
        ActualList.add("abcd123");

        ExpectedList.add("2000");

        assertEquals(Module.CalculateFuelPart2(ExpectedList), Module.CalculateFuelPart2(ActualList));
    }

    @Test
    @DisplayName("Take input from AoC Website and result should be the same like from homepage - Day 1 Part 1")
    void CalculatePartOneFromAoC(){
        ActualList = Utils.readFileIntoList("input.txt");
        int expected = 3371958;

        assertEquals(expected, Module.CalculateAllFuelsPart1(ActualList));
    }

    @Test
    @DisplayName("Take input from AoC Website and result should be the same like from homepage - Day 1 Part 2")
    void CalculatePartTwoFromAoC(){
        ActualList = Utils.readFileIntoList("input.txt");
        int expected = 5055050;

        assertEquals(expected, Module.CalculateFuelPart2(ActualList));
    }

    @Test
    @DisplayName("Test the Calculation of a Fuel (take a sample from homepage as input")
    void TestCalculation(){
        int expected = 654;

        assertEquals(expected, Module.CalculationOfFuel("1969"));
    }
}
