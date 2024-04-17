package org.karthunter;

//CardAPI
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;

//Java Imports
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class KartHunter {

    public static void main(String[] args) {
        List<Card> deckOne = new ArrayList<>();
        List<Card> deckTwo = new ArrayList<>();
                                                                        //List<Card> deckOne = loadDecksFromFile("savedDeckOne.txt");
                                                                        //List<Card> deckTwo = loadDecksFromFile("savedDeckTwo.txt");
        String input = "";
        Scanner console = new Scanner(System.in);
        getCard(console, deckOne,deckTwo,input);
        System.out.println("Closing Program");
        console.close();
        System.out.print("Saving decks to savedDeckOne.txt and savedDeckTwo.txt"); //testing line will be removed
        saveDecksToFile(deckOne,"savedDeckOne.txt");
        saveDecksToFile(deckTwo,"savedDeckTwo.txt");
        System.exit(0); //app hanging when supposed to close, adding System.exit(0); to force exit
    }
    public static void saveDecksToFile(List<Card> deck, String fileName){
        int counter = 1;
        try(PrintWriter deckSaver = new PrintWriter(new File(fileName))){
            for(Card card : deck){
             deckSaver.println("[CARD " + counter+"]" + "    \nNAME: " + card.getName() + "  "  +  "\nMANA: " + card.getManaCost() + "    \nTYPE: " + card.getType() +  " "   + "\nPOWER/TOUGHNESS: " + "["+card.getPower()+"\\"+card.getToughness()+"]" + /*"\nRARITY:" + card.getRarity()COMMENTING OUT RARITY IT IS NOT SUPER USEFUL IN TERMS OF INFO TO PLAYER*/ " " + "\n\nABILITY: " + card.getText() + "\n\n");
             counter++;
            }
        } catch (FileNotFoundException noDeckSaved){
            System.out.print("FILE NOT FOUND");
        }
    }
    public static void fileWiper(String fileName){
        try (PrintWriter freshFile = new PrintWriter(fileName)){//wipes our file from previous run so we can generate a new deck to text file

        }catch(FileNotFoundException fileNotLocated){
            System.out.print("Could not find file savedDeckOne.txt");
        }
    }

    /*public static List<Card> loadDecksFromFile(String fileName){ //I tried to add the feature of loading a deck in from a previous session, but it messed up my remove card method and I couldn't find a clean way to implement this, commenting out for future attempt.
        List<Card> deck = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(fileName))){
            while(scanner.hasNextLine()){
                String cardName = scanner.nextLine();
                Card card = new Card();
                card.setName(cardName);
                deck.add(card);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return deck;
    }*/

    public static void getCard(Scanner console, List<Card> deckOne, List<Card> deckTwo,String input) {
        List<String> filters = new ArrayList<>();
        Card card = null;
        while (!input.trim().equals("EXIT PROGRAM")) {
            do {
                System.out.print("Enter name of card to search, Enter 'DECKS' to add a card to deck Enter 'DECK MANAGER' to manage decks, OR enter 'EXIT PROGRAM' to exit: ");
                input = console.nextLine();
                if(input.trim().isEmpty()){
                    System.out.println("Input cannot be empty");
                    continue;
                }
                if (input.trim().equals("DECK MANAGER")) {
                    deckManager(console, card, deckOne, deckTwo,input);
                } else if (!input.trim().equals("EXIT PROGRAM")) {
                    filters.clear();
                    filters.add("name=" + input.trim());
                    List<Card> cards = CardAPI.getAllCards(filters);
                    if (!cards.isEmpty() && !input.trim().equalsIgnoreCase("Forest")) {
                        card = cards.get(0);

                        System.out.println(card);
                    }
                    else if(!cards.isEmpty() && input.trim().equalsIgnoreCase("Forest")){ //if a user enters just "Forest" they're probably looking for a basic and not a special one, this prints the basic land forest using multiverseID if "Forest" is found
                        card = CardAPI.getCard(426971);

                        System.out.println(card + "\n");
                    }
                    if (input.trim().equals("DECKS")) {
                        addCardToDeck(console, card, deckOne, deckTwo);
                    } else if(cards.isEmpty()){
                        System.out.println("Card with that name does not exist");
                    }
                }
            } while (!input.trim().equals("EXIT PROGRAM"));

        }
    }
        public static void manageDeck(Scanner console, List<Card> deckOne){

        }
        public static void deckManager(Scanner console, Card card,List<Card> deckOne, List<Card> deckTwo,String input) {
                while (!input.trim().equals("BACK")) {
                    System.out.print("\nSelect deck to manage [1] or [2], OR type 'BACK' to return: ");
                    input = console.nextLine();
                    if (input.trim().equals("1")) {
                        System.out.println("DECK ONE");
                        for (int i = 0; i < deckOne.size(); i++) {
                            System.out.println("\nCARD " + (i + 1) + "" + deckOne.get(i) + "  \n ");
                        }
                        //System.out.println(deckOne);
                        System.out.print("Enter 'REMOVE' to remove card, OR type 'BACK' to leave: ");
                        input = console.nextLine();
                        if (input.trim().equals("REMOVE")) {
                            while (!input.trim().equals("BACK")) {
                                removeCardFromDeckOne(console, deckOne);
                                System.out.println("DECK ONE");
                                for (int i = 0; i < deckOne.size(); i++) {
                                    System.out.println("\nCARD " + (i + 1) + "" + deckOne.get(i) + "  \n ");
                                }
                                //System.out.println(deckOne);
                                break;
                            }
                        }
                        if (input.trim().equals("BACK")) {
                            break;
                        }
                    }
                    if (input.trim().equals("2")) {
                        System.out.println("DECK TWO");
                        for (int i = 0; i < deckTwo.size(); i++) {
                            System.out.println("\nCARD " + (i + 1) + "" + deckTwo.get(i) + "  \n ");
                        }
                        //System.out.print(deckTwo);
                        System.out.print("\nEnter 'REMOVE' to remove card, OR type 'BACK' to leave: ");
                        input = console.nextLine();
                        if(input.trim().equals("REMOVE")){
                            while(!input.trim().equals("BACK")){
                                removeCardFromDeckTwo(console, deckTwo);
                                System.out.println("DECK TWO");
                                for (int i = 0; i < deckTwo.size(); i++) {
                                    System.out.println("\nCARD " + (i + 1) + "" + deckTwo.get(i) + "  \n ");
                                }
                                break;
                            }
                        }
                    }
                }
        }
        public static void addCardToDeck(Scanner console, Card card,List<Card> deckOne, List<Card> deckTwo) {
            if (card != null) {
                System.out.print("\nSelect deck to ADD card to [1] or [2], OR enter any other key to exit: ");
                String input = console.nextLine();
                if (input.trim().equals("1")) {
                    System.out.print("\nCard added to deck :)\n");
                    deckOne.add(card);
                    System.out.print("\nDeck ONE ");
                    System.out.println("\n--------");
                    for (int i = 0; i < deckOne.size(); i++) {
                        System.out.println("\nCARD " + (i + 1) + "" + deckOne.get(i) + "  \n ");
                    }
                } else if (input.trim().equals("2")) {
                    System.out.print("\nCard added to deck :)\n");
                    deckTwo.add(card);
                    System.out.println("\nDeck TWO:  ");
                    System.out.println("\n--------");
                    for (int i = 0; i < deckTwo.size(); i++) {
                        System.out.println("CARD " + (i + 1) + " " + deckTwo.get(i) + "  \n  ");
                    }
                }
            }else{
                System.out.println("No card selected");
            }
        }
        public static void removeCardFromDeckOne(Scanner console, List<Card> deckOne){
            //System.out.print("\nEnter name of card to remove OR 'BACK' to return: ");
            String cardToRemove = "";
            boolean cardFound = false;
            while(!cardToRemove.trim().equals("BACK")) {
                System.out.println("\nEnter EXACT name of card to remove OR 'BACK' to return: ");
                cardToRemove = console.nextLine();
                if(cardToRemove.trim().equals("BACK")){
                    break;
                }
                //boolean cardFound = false;
                Iterator<Card> iterator = deckOne.iterator();
                while (iterator.hasNext()) {
                    Card card = iterator.next(); //setting card name to next iteration in the list, so we can compare https://www.w3schools.com/java/java_iterator.asp
                    if (card.getName().equalsIgnoreCase(cardToRemove.trim())) {
                        iterator.remove();
                        cardFound = true;
                        System.out.print("REMOVED CARD: " + card.getName());
                        break;
                    }
                }
            }
            if (!cardFound) {
                System.out.println("No card found  " + cardToRemove + " ");
            }
        }
    public static void removeCardFromDeckTwo(Scanner console, List<Card> deckTwo) {
        //System.out.print("\nEnter name of card to remove OR 'BACK' to return: ");
        String cardToRemove = "";
        boolean cardFound = false;
        while (!cardToRemove.trim().equals("BACK")) {
            System.out.print("\nEnter EXACT name of card to remove OR 'BACK' to return: "); //sadly requires exact name to remove a card, I could not figure out a way around this, so the user must input the name of the card exactly as it appears in order to remove it. This means then user must match things such as commas and spaces.
            cardToRemove = console.nextLine();
            if(cardToRemove.trim().equals("BACK")){
                break;
            }
            Iterator<Card> iterator = deckTwo.iterator();
            while (iterator.hasNext()) {
                Card card = iterator.next();
                if (card.getName().equalsIgnoreCase(cardToRemove.trim())) {
                    iterator.remove();
                    cardFound = true;
                    System.out.print("REMOVED CARD: " + card.getName());
                    break;
                }
            }
            if (!cardFound) {
                System.out.println("No card found  " + cardToRemove + " ");
            }
        }
    }

    }

