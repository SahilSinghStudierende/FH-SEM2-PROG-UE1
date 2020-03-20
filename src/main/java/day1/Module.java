package day1;

import org.w3c.dom.ls.LSOutput;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Module {

    public static int CalculateAllFuelsPart1(List<String> input){
        //int summe = input.stream().mapToInt(item -> (int) (Math.floor(Double.parseDouble(item) / 3.0) - 2)).sum();
        int summe = 0;
        for(int i = 0; i < input.size(); i++){
            summe += CalculationOfFuel(input.get(i));
        }
        return summe;
    }

    // int rundet automatisch runter
    public static int CalculationOfFuel(String fuelAmount){
        return Integer.parseInt(fuelAmount)/3 - 2;
    }

    public static int CalculateFuelPart2(List<String> input){
        int summe = 0;

        // Go through the input list
        for(int i = 0; i < input.size(); i++){
            int currentFuel = 0;
            //Check if the value is parsable into int
            if(tryParseInt(input.get(i))) {
                currentFuel = Integer.parseInt(input.get(i));
                while ((int)CalculationOfFuel(Integer.toString(currentFuel)) > 0) {
                    int newFuel = (int) CalculationOfFuel(Integer.toString(currentFuel));
                    currentFuel = newFuel;
                    summe += newFuel;
                }
            }
        }
        return summe;
    }

    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
