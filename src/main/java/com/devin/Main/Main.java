package com.devin.Main;
import com.devin.Service.SearchService;

import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ) throws Exception {
        SearchService searchService = new SearchService();
        int width = 40;
        int choice = 0;

        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println("=".repeat(width));
        System.out.println("  STAR WARS ENCYCLOPEDIA  ");
        System.out.println("=".repeat(width));
        System.out.println("[1] Search Character");
        System.out.println("[2] Search Planet");
        System.out.println("[3] Search Species");
        System.out.println("[4] Search Ships");
        System.out.println("[5] Exit");
        do{
            boolean validInput = false;
            System.out.print("Selection: ");
            while(!validInput){
                try{
                    choice = Integer.parseInt(scan.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid Input - Try again: ");
                }
            }
            switch(choice){
                case 1->{
                    System.out.print("Enter Character: ");
                    name = scan.nextLine();
                    searchService.searchCharacter(name);
                }
                case 2->{
                    System.out.print("Enter Planet: ");
                    name = scan.nextLine();
                    searchService.searchPlanet(name);
                }
                case 3->{
                    System.out.print("Enter Species: ");
                    name = scan.nextLine();
                    searchService.searchSpecies(name);
                }
                case 4->{
                    System.out.print("Enter Starship: ");
                    name = scan.nextLine();
                    searchService.searchStarShips(name);
                }
                case 5->{
                    System.out.println("Terminating Session");
                }
                default->{
                    System.out.println("Error: Non-Choice");
                }
            }
        }while(choice != 5);
    }
}
