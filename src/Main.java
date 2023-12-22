
public class Main {

    public static void main(String[] args) {
         Functions function = new Functions();
         
        Cards[][] deck = function.createDeck();//to create deck
       
        deck = function.shuffleDeck(deck,4,10);//  to shuffle deck
       
        function.startGame(); // to get start screen
        
        Cards[][] hands = function.crateDeck(deck);     // to create boards
        
        hands = function.dealCards(hands); // to get it to board
        
        Cards[][] gameDeck = function.createGameDeck(deck);
        Cards[][] gameBoard = function.gameBoard(deck);

        function.area("Computer's Hand","Computer's Board","Your Board     ","Your Hand      ",hands[0],gameBoard[0],gameBoard[1], hands[1]);
        
        int timePlayer = 0;
        int timeComputer = 0;
        int choice = function.choice();
        
        
        function.useChoice(choice, gameDeck, gameBoard,hands, timePlayer);
        timePlayer = timePlayer +1;
        function.pickCardForPc(gameDeck, gameBoard, timeComputer);
        timeComputer = timeComputer+1;
        function.area("Computer's Hand","Computer's Board","Your Board     ","Your Hand      ",hands[0],gameBoard[0],gameBoard[1], hands[1]);
        function.pickCardForPc(gameDeck, gameBoard, timeComputer);
        timeComputer = timeComputer+1;
        choice = function.choice();
        function.useChoice(choice, gameDeck, gameBoard,hands, timePlayer);
        timePlayer = timePlayer +1;
        function.area("Computer's Hand","Computer's Board","Your Board     ","Your Hand      ",hands[0],gameBoard[0],gameBoard[1], hands[1]);


       
                System.out.println("  ----------------");

        for (int i = 0; i < gameDeck.length; i++) {
    for (int j = 0; j < gameDeck[i].length; j++) {
        // gameDeck[i][j] null değilse değerlerini yazdır
        if (deck[i][j] != null) {
            //System.out.println(gameDeck[i][j].getColor() + " " + gameDeck[i][j].getNumber() + " ");
            //System.out.println(deck[i][j].isComputerHand());

        }
    }
}
    }
}

     