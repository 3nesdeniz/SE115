import java.util.Random;
import java.util.Scanner;
public class Functions {

    public Cards[][] createDeck() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] colors = {"yellow", "blue", "red", "green"};
        Cards[][] deck = new Cards[4][10];

        for (int r = 0; r < 4; r++) {
            for (int s = 0; s < 10; s++) {
                deck[r][s] = new Cards(colors[r], numbers[s]);
            }
        }

        return deck;
    }

    public Cards[][] shuffleDeck(Cards[][] deck, int x , int y) {
        Random rd = new Random();

        int totalCards = x * y;
        int k = totalCards -1;
            int row1 = 0;
            int col1 = 0;

            int row2 = 0;
            int col2 = 0;
        for (int i = k; i > 0; i--) {
            row1 = rd.nextInt(x);
            col1 = rd.nextInt(y);

            row2 = rd.nextInt(x);
            col2 = rd.nextInt(y);

            Cards temp = deck[row1][col1];
            deck[row1][col1] = deck[row2][col2];
            deck[row2][col2] = temp;
        }

        return deck; 
    }

    public boolean startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("Welcome to the Game!");
        System.out.println("To start the game, please enter '1'.");
        System.out.print("Your choice: ");
        int number = 0;
       try {
            System.out.println("Enter your number:");
            number = scanner.nextInt();
            
        } catch (Exception e) {
            System.out.println("Wrong type please enter number...");
        }
        boolean result = false;

        if (number == 1) {
            result = true;
            System.out.println("We are starting...");
        } else {
            result = startGame();
        }
        return result;
    }

    public void areaSchema(String person, Cards[] cards){
    System.out.println("                  ____________________________________________________________________________");
    System.out.println("");

    System.out.print(person + "      ");
    printCards(cards);
    System.out.println("");

    System.out.println("                  ____________________________________________________________________________");
}

    public void area(String name1,String name2,String name3,String name4,Cards[] card1,Cards[] card2,Cards[] card3,Cards[] card4){
        areaSchema(name1,card1);
        System.out.println("");
        areaSchema(name2,card2);
        System.out.println("");
        areaSchema(name3,card3);
        System.out.println("");
        areaSchema(name4,card4);
        System.out.println("");
        totalScore(card2,card3);

    }

    public int notZero(int x){
        Random rd = new Random(System.currentTimeMillis());
        if (x == 0) {
            x = rd.nextInt(13) - 6;
            return notZero(x);
        }   
        else {
           return x;
        }
    }

    public Cards[][] crateDeck(Cards[][] deck) {
    Cards[][] hands = new Cards[2][10];

    Random rd = new Random(System.currentTimeMillis());
    int x = 9;
    int k = 0;
    for (int i = 0; i < 5; i++) {
        hands[0][i] = deck[0][i];
        hands[1][i] = deck[3][x-i]; 
    }
    String[] colors = {"yellow","blue ","red","green "};
    for (int i = 0; i<3;i++){
        x = rd.nextInt(13)-6;
        x = notZero(x);
        k = rd.nextInt(4);
        String selectedColor = colors[k];
        
        hands[0][i + 5] = new Cards(selectedColor, x);
    
    }
         for (int i = 0; i<3;i++){
        x = rd.nextInt(13)-6;
        x = notZero(x);
        k = rd.nextInt(4);
        String selectedColor = colors[k];
        
        hands[1][i + 5] = new Cards(selectedColor, x);
    
    }
    //----------------joker computer ------------
    x = rd.nextInt(101);
    if(x>20){
        x = rd.nextInt(13)-6;
        x = notZero(x);
        k = rd.nextInt(4);
        String selectedColor = colors[k];
        
         hands[0][8] =  new Cards(selectedColor, x);
    }
    else{
      
            hands[0][8] = new Cards("2x", 0);
            hands[0][8].setIsJoker(true);
   
    }
    x = rd.nextInt(101);
    if(x>20){
        x = rd.nextInt(13)-6;
        x = notZero(x);
        k = rd.nextInt(4);
        String selectedColor = colors[k];
        
         hands[0][9] =  new Cards(selectedColor, x);
    }
    else{
      
            hands[0][9] = new Cards("+/-", 1);
            hands[0][9].setIsJoker(true);
   
    }
        //----------------joker player ------------
        x = rd.nextInt(101);
    if(x>20){
        x = rd.nextInt(13)-6;
        x = notZero(x);
        k = rd.nextInt(4);
        String selectedColor = colors[k];
        
         hands[1][8] =  new Cards(selectedColor, x);
    }
    else{
      
            hands[1][8] = new Cards("2x", 0);
            hands[1][8].setIsJoker(true);
   
    }
    x = rd.nextInt(101);
    if(x>20){
        x = rd.nextInt(13)-6;
        x = notZero(x);
        k = rd.nextInt(4);
        String selectedColor = colors[k];
        
         hands[1][9] =  new Cards(selectedColor, x);
    }
    else{
      
            hands[1][9] = new Cards("+/-", 1);
            hands[1][9].setIsJoker(true);
   
    }
    for(int i=0;i<10;i++){
        hands[0][i].setIsComputerHand(true);
    }

    return hands;
}

    public Cards[][] dealCards(Cards[][] deck){
        Cards[][] hands = new Cards[2][4];
        Random rd = new Random(System.currentTimeMillis());
        int rd1 = 0;
        
        for(int i=0;i<4;i++){
            rd1= rd.nextInt(10);
            while(deck[0][rd1]==null){
            rd1 = rd.nextInt(10);
            }
            hands[0][i] = deck[0][rd1];
            deck[0][rd1]=null;
        }
        for(int i=0;i<4;i++){
            rd1= rd.nextInt(10);
            while(deck[1][rd1]==null){
            rd1 = rd.nextInt(10);
            }
            hands[1][i] = deck[1][rd1];
            deck[1][rd1]=null;

        }
        return hands;
    }

    public void printCards(Cards[] cards) {
        if (cards == null)
            System.out.print("a");
        else{
        
        
        for (Cards card : cards) {
             if (card != null){
                
                if(card.isComputerHand()==true){
                        if(card.isPlay()==true){
                        System.out.print("      O      ");

                        }
                        else{
                            System.out.print("      X      ");
                        }
                }
                else{
                   if(card.isPlay()==true){
                       System.out.print("     O      ");
                   }
                   else{
                        if(card.getIsJoker() == true){
                            System.out.print(card.getColor() + "    ");
                        }
                        else{
                        System.out.print(card.toString() + "      ");
                        }
                   }
                }
                
            
            }

            
        
        }
    }
}

    public Cards[][] createGameDeck(Cards[][] deck) {
        Cards gameDeck[][] = new Cards[4][10];
        for(int i=0;i<4;i++){
            for (int j=0;j<10;j++){
               gameDeck[i][j]=deck[i][j];
            }
        }


        for(int i=0;i<5;i++){

            gameDeck[0][i] = null;
        }
        for(int i=9;i>4;i--){
           gameDeck[3][i] = null;

        }
        return gameDeck;
    }
    
    public void pickCard(Cards[][] deck,Cards[][] board,int time){
            
            Random rd = new Random(System.currentTimeMillis());
            int rd1 = rd.nextInt(10);
            int rd2 = rd.nextInt(4);
            while(deck[rd2][rd1] == null){
                rd1 = rd.nextInt(10);
                rd2 = rd.nextInt(4);
            }
            

            board[1][time] = deck[rd2][rd1];
            deck[rd2][rd1]=null;
    }
    
    public Cards[][] useCard(Cards[][] gameBoard,Cards[][] hand,int time,int choice ,int who){//who for who play card player or computer
        Scanner sc= new Scanner(System.in);
        if(hand[who][choice]== null){
            System.out.println("Your Choice is wrong try again");
            choice = sc.nextInt();
            useCard(gameBoard,hand,time,choice,who);
        }
        gameBoard[who][time] = hand[who][choice];
        hand[who][choice] = null;
    return gameBoard;
}

    public Cards[][] gameBoard(Cards[][] deck){
        Cards hand[][] = new Cards[2][9];//0. bilgisayar 1. de kullanıcı
        for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 9; j++) {
            hand[i][j] = null;
        }
    }

        return hand;
    }

    public int choice(){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
           try {
        System.out.println("Game started. Please enter your choice: ");
        System.out.print("1 -  Pick Card To Deck.\n2 - To Play Card On Your Hand.\n3 - To Stand.\nEnter your choice: ");

        choice = sc.nextInt();
        } 
           catch (Exception e) {
        System.out.println("Invalid input. Please enter a valid choice.");
        }

    return choice;
    }
 
    public void useChoice(int x, Cards[][] deck,Cards[][] board,Cards[][] hand,int timePlayer){
    if(x == 1){
        pickCard(deck,board,timePlayer);
        timePlayer = timePlayer+1;
    }
    else if(x == 2){
        Scanner sc = new Scanner(System.in);
        try{
        System.out.println("Choice to play card");
        int choice = sc.nextInt()-1;
        useCard(board,hand,timePlayer,choice,1);
        //do not forget end tour ---
        }
        catch(Exception e){
            System.out.print("Wrong choice please try again");
            useChoice(x, deck,board,hand,timePlayer);
        }
    }
    else if(x == 3){
        
    }
    else{
        System.out.println("Is there some problem please do it again");
        int k = choice();
        useChoice(k,deck,board,hand,timePlayer);
    }
        
    }
    
    public void totalScore(Cards[] pc,Cards[] player){
        int totalpc =0;
        int totalplayer =0;
        
        
        
        for(int i=0;i<5;i++){
            if(player[i]==null){
                continue;
            }
            else{
                totalplayer = totalplayer+player[i].getNumber();
            }
        }
        for(int i=0;i<5;i++){
            if(pc[i]==null){
                continue;
            }
            else{
                totalpc = totalplayer+pc[i].getNumber();
            }
        }
        
        System.out.println("Computer Score:"+ totalpc);
        
        System.out.println("Player Score: "+totalplayer);
    }





}
    

