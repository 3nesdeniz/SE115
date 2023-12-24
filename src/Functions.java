import java.util.Random;
import java.util.Scanner;
import java.util.Formatter;
import java.io.FileWriter ;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

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
    public String getName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();
        return name;
    }

    public void areaSchema(String person, Cards[] cards){
    System.out.println("                  ____________________________________________________________________________");
    System.out.println("");

    System.out.print(person + "      ");
    printCards(cards);
    System.out.println("");

    System.out.println("                  ____________________________________________________________________________");
}
    public void areaSchemaHand(String person, Cards[] cards){
        System.out.println("                  ____________________________________________________________________________");
        System.out.println("");

        System.out.print(person + "      ");
        printCardsForHands(cards);
        System.out.println("");

        System.out.println("                  ____________________________________________________________________________");   
    }

    public void area(String name1,String name2,String name3,String name4,Cards[] card1,Cards[] card2,Cards[] card3,Cards[] card4){
        areaSchemaHand(name1,card1);
        System.out.println("");
        areaSchema(name2,card2);
        System.out.println("");
        areaSchema(name3,card3);
        System.out.println("");
        areaSchemaHand(name4,card4);
        System.out.println("");
        totalScore(card2,card3);

    }

public int notZero(int x) {
    Random rd = new Random(System.currentTimeMillis());

    while (x == 0) {
        x = rd.nextInt(13) - 6;
    }

    return x;
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
            hands[0][i].setIsComputerHand(true);

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

                       
                       System.out.print("     X      ");
                        
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
    public void printCardsForHands(Cards[] cards){
                for (Cards card : cards) {
             if (card != null){
                
                if(card.isComputerHand()==true){

                       
                       System.out.print("     X      ");
                        
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
                
            
            }else{
                 System.out.print("     O      ");
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
    
    public void useCard(Cards[][] gameBoard,Cards[][] hand,int time,int choice ,int who){//who for who play card player or computer
        Scanner sc= new Scanner(System.in);
        if(hand[who][choice]== null){
            
            System.out.print("Your Choice is wrong try again : ");
            choice = sc.nextInt()-1;
            useCard(gameBoard,hand,time,choice,who);
        }
        else{
            if(hand[who][choice].getIsJoker()==true){
                System.out.print("Choice Location To Play :");
                int choice2=sc.nextInt()-1;
                if(gameBoard[who][choice2]==null){
                    useCard(gameBoard,hand,time,choice,who);

                }
                else{
                    if (hand[who][choice].getNumber() == 0) {
                        gameBoard[who][choice2].setNumber(gameBoard[who][choice2].getNumber() * 2);
                    }
                    else{
                       gameBoard[who][choice2].setNumber(gameBoard[who][choice2].getNumber() * -1);

                    }
                }
            }
            else{
                gameBoard[who][time] = hand[who][choice];
                hand[who][choice] = null; 
            }
        
        
        }
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
    int choice1 = 0;
    while(true) {
        try {
            System.out.println("Game started. Please enter your choice: ");
            System.out.print("1 - Pick Card To Deck.\n2 - To Play Card On Your Hand.\n3 - To Stand.\nEnter your choice: ");

            choice1 = sc.nextInt();
            if(choice1 == 1 || choice1 == 2 || choice1 == 3) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid choice.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid choice.");
            sc.next();
        }
    }
    return choice1;
}
 
    public int useChoice(int x, Cards[][] deck,Cards[][] board,Cards[][] hand,int timePlayer,boolean playerStand){
    if(x == 1){
        pickCard(deck,board,timePlayer);
        timePlayer = timePlayer+1;
        Scanner sc2 = new Scanner(System.in);
        int choice1 =0;
        area("Computer's Hand","Computer's Board","Your Board     ","Your Hand      ",hand[0],board[0],board[1], hand[1]);

        while(true) {
        try {
            System.out.println("Game started. Please enter your choice: ");
            System.out.print("1 - To Play Card On Your Hand.\n2 - To End Tour.\nEnter your choice: ");

            choice1 = sc2.nextInt();
            if(choice1 == 1 || choice1 == 2) {
                timePlayer = timePlayer+1;
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid choice.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid choice.");
            sc2.next(); 
        }
    }
        if(choice1 == 1){
            useChoice(2, deck,board,hand,timePlayer,playerStand);
            timePlayer = timePlayer+1;
        }
    }
    else if (x == 2) {
    Scanner sc = new Scanner(System.in);
    boolean validChoice = false;
    while (!validChoice) {
        try {
            System.out.print("Choice to play card : ");
            int choice = sc.nextInt()-1;
            useCard(board, hand, timePlayer, choice, 1);
            validChoice = true;
        } catch (Exception e) {
            System.out.println("Wrong choice please try again");
            sc.nextLine();
        }
    }
}
    else if(x == 3){
        playerStand = true;
    }
    else{
        System.out.println("Is there some problem please do it again");
        int k = choice();
        useChoice(k,deck,board,hand,timePlayer,playerStand);
    }
        return timePlayer;
    }
    
    public void totalScore(Cards[] pc,Cards[] player){
        int totalpc =0;
        int totalplayer =0;
        
        
        
        for(int i=0;i<9;i++){
            if(player[i]==null){
                continue;
            }
            else{
                totalplayer = totalplayer+player[i].getNumber();
            }
        }
        for(int i=0;i<9;i++){
            if(pc[i]==null){
                continue;
            }
            else{
                totalpc = totalpc+pc[i].getNumber();
            }
        }
        
        System.out.println("Computer Score:"+ totalpc);
        
        System.out.println("Player Score: "+totalplayer);
    }

    public void pickCardForPc(Cards[][] deck,Cards[][] board,int timePc){
         Random rd = new Random();
            int rd1 = rd.nextInt(10);
            int rd2 = rd.nextInt(4);
            while(deck[rd2][rd1] == null){
                rd1 = rd.nextInt(10);
                rd2 = rd.nextInt(4);
            }
            

            board[0][timePc] = deck[rd2][rd1];
            deck[rd2][rd1]=null;
    }
    
    public int playerScore(Cards[] player){
         int totalPlayer =0;
        
        
        
        for(int i=0;i<5;i++){
            if(player[i]==null){
                continue;
            }
            else{
                totalPlayer = totalPlayer+player[i].getNumber();
            }
        }
        return totalPlayer;
    }
    
    public int computerScore(Cards[] pc){
            int totalpc =0;

            for(int i=0;i<9;i++){
            if(pc[i]==null){
                continue;
            }
            else{
                totalpc = totalpc+pc[i].getNumber();
            }
        }
            return totalpc;
    }
    
    public void computerUseCard(Cards[][] gameBoard,Cards[][] hand,int time,int choice ,int who,int locationToPlay){

        if(hand[who][choice]!=null){
            if(hand[who][choice].getIsJoker()==true){
                if(gameBoard[who][locationToPlay]==null){
                    useCard(gameBoard,hand,time,choice,who);

                }
                else{
                    if (hand[who][choice].getNumber() == 0) {
                        gameBoard[who][locationToPlay].setNumber(gameBoard[who][locationToPlay].getNumber() * 2);
                    }
                    else{
                       gameBoard[who][locationToPlay].setNumber(gameBoard[who][locationToPlay].getNumber() * -1);

                    }
                }
            }
            else{
        hand[who][choice].setIsComputerHand(false);

                gameBoard[who][time] = hand[who][choice];
                
                hand[who][choice] = null; 
            
                gameBoard[who][time].setIsComputerHand(false);
            }
        }
        
        }
     
    public void clearBoard(Cards[][] board){
        Cards hand[][] = new Cards[2][9];//0. bilgisayar 1. de kullanıcı
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 9; j++) {
                hand[i][j] = null;
            }
        }
    }
    
    public boolean computerAI(int computerScore,Cards[][] computerHand,Cards[][] computerBoard,int time,Cards[][] deck,int playerScore,boolean playerStand,boolean computerStand){
        int winCondition = 20;
        int lengthBoard = computerBoard.length;
        int lengthHand = computerHand.length;
        boolean useCard = false;
        if(playerScore<computerScore&&computerScore<20&&playerStand == true){//i didnt do <= because it is risk and in draw I dont want risk
            computerStand = true;
        }else{

        for(int i=0;i<lengthHand;i++){
           if(computerHand[0][i]!=null){
               if(computerHand[0][i].getIsJoker()==true){
               if (computerHand[0][i].getNumber() == 0) {
                    for(int j=0;j<lengthBoard;j++){
                        if(computerBoard[0][j]!=null){
                            if(computerScore+(2*computerBoard[0][j].getNumber())==20){
                                computerUseCard(computerBoard,computerHand,time,i,1,j);
                                useCard=true;
                                break;
                            }
                        }
                    }
                }
                else if(computerHand[0][i].getNumber() == 1) {
                    for(int k=0;k<lengthBoard;k++){
                        if(computerBoard[0][k]!=null){
                            if(computerScore+(-1*computerBoard[0][k].getNumber())<=20){
                                computerUseCard(computerBoard,computerHand,time,i,1,k);
                                useCard=true;

                                break;
                                                                            
                            }
                        }
                    }
                }
            }else{
               
                                
                                if(computerScore + computerHand[0][i].getNumber() ==20){
                                    computerUseCard(computerBoard,computerHand,time,i,0,0);
                                    useCard=true;

                                    break;
                                
                                    
                                
                            
                        
                    }
                
           }
           
           
           
           
     
           }
                 
        }
       /* if(playerScore>computerScore&&computerScore<20&&playerStand == true){
            computerStand = true;
            pickCardForPc(deck, computerBoard, time);
            this is for if I stand 19 but it 17 it will be pick in this situation but this  get some bugs so I unfortunately close this but after maybe I can do 
        } 
       */ 
            
        
         if(useCard==false){
            if(computerScore<17){
                pickCardForPc(deck, computerBoard, time);
            }
            else{
                computerStand = true;
            }
        }
         }
        return computerStand;
    }
public void writeFile(int playerWin, int computerWin, String name) {
    Formatter fr = null;
    FileWriter fw = null;

    try {
        File file = new File("blueJack.txt");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();

            if (lines >= 40) {
                file.delete(); // Dosyayı sil
                file.createNewFile(); // Yeni dosya oluştur
            }
        }

        fw = new FileWriter("blueJack.txt", true);
        fr = new Formatter(fw);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        fr.format("Date: %s%n", now.format(formatter));
        fr.format(name + " Win: %d%n", playerWin);
        fr.format("Computer Wins: %d%n", computerWin);
        fr.format("________________________%n");
        

    } catch (IOException e) {
        System.out.println("An error occurred while writing to the file.");
        e.printStackTrace();
    } finally {
        try {
            if (fr != null) {
                fr.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (IOException e) {
            System.out.println("Error in closing the FileWriter/Formatter.");
            e.printStackTrace();
        }
    }
}//kazananları kaydetme  
    public void playGame(){

        int tour= 0;
        Functions function = new Functions();
        
            Cards[][] deck = function.createDeck();//to create deck

            deck = function.shuffleDeck(deck,4,10);//  to shuffle deck

            function.startGame(); // to get start screen
            
            String name = function.getName();

            Cards[][] hands = function.crateDeck(deck);     // to create boards

            hands = function.dealCards(hands); // to get it to board



            Cards[][] gameDeck = function.createGameDeck(deck);
            Cards[][] gameBoard = function.gameBoard(deck);

            function.area("Computer's Hand","Computer's Board","Your Board   ","Your Hand      ",hands[0],gameBoard[0],gameBoard[1], hands[1]);
            
            int computerWin = 0;
            int playerWin = 0;

            function.inToGame(gameDeck, hands, computerWin, playerWin,deck,name);
            
            
            
            
            
        }
    
    public void inToGame(Cards[][] gameDeck,Cards[][] hands,int computerWin,int playerWin,Cards[][] deck,String name){
        
        Functions function = new Functions();
        
        
        Cards[][] gameBoard = function.gameBoard(deck);

        boolean playerStand = false;
        boolean computerStand = false;        
        int pcScore= 0;
        int playerScore=0;
        int timePlayer = 0;
        int timeComputer = 0;        
        int tour = 0;
        clearBoard(gameBoard);
        function.pickCardForPc(gameDeck, gameBoard,timeComputer);
        timeComputer=timeComputer+1;
        function.pickCard(gameDeck, gameBoard, timePlayer);
        timePlayer=timePlayer+1;
        function.area("Computer's Hand","Computer's Board","Your Board     ","Your Hand      ",hands[0],gameBoard[0],gameBoard[1], hands[1]);
        while(tour<8){
                playerScore=playerScore(gameBoard[1]);

                if(playerScore>20){
                   computerWin=computerWin+1;
                    break;
                }
            if(playerStand==false){
                if(playerScore>20){
                   computerWin=computerWin+1;
                    break;
                }
                int choice = function.choice();
                if(choice==3){
                    playerStand=true;
                }
                if(playerScore>20){
                   computerWin=computerWin+1;
                    break;
                }
                timePlayer = function.useChoice(choice, gameDeck, gameBoard,hands, timePlayer,playerStand);
                playerScore=playerScore(gameBoard[1]);
                if(playerScore>20){
                   computerWin=computerWin+1;
                    break;
                }    
            
            }
            
            pcScore = computerScore(gameBoard[0]);
            if(computerStand==false){
            pcScore = computerScore(gameBoard[0]);
            
            computerStand = function.computerAI(pcScore, hands, gameBoard, timeComputer, gameDeck,playerScore,playerStand,computerStand);
            timeComputer = timeComputer+1;    
            pcScore = computerScore(gameBoard[0]);
            
            }
            pcScore = computerScore(gameBoard[0]);
            
            function.area("Computer's Hand","Computer's Board","Your Board     ","Your Hand      ",hands[0],gameBoard[0],gameBoard[1], hands[1]);
            tour = tour+1;
            if(pcScore>20){


                playerWin=playerWin+1;
                break;
            }
            if(playerScore>20){
                   computerWin=computerWin+1;
                    break;
                }
            if(playerScore==20){
                boolean allblueplayer = true;
                for(int i = 0;i<gameBoard[1].length;i++){
                    if(gameBoard[1][i]!=null){
                       if( gameBoard[1][i].getColor()!="blue"){
                           allblueplayer = false;
                       }
                    }
                }if(allblueplayer == true){
                    playerWin=3;
                    break;
                }
                
                if(pcScore==20){
                    System.out.println("There Is Draw");
                    break;
                }else{
                    System.out.println("Player Win the game");
                    playerWin=playerWin+1;
                    break;
                }
            }
            if(pcScore==20){
                boolean allbluepc = true;
                for(int i = 0;i<gameBoard[1].length;i++){
                    if(gameBoard[0][i]!=null){
                       if( gameBoard[0][i].getColor()!="blue"){
                           allbluepc = false;
                       }
                    }
                }if(allbluepc == true){
                    computerWin=3;
                    break;
                }
                
                if(playerScore==20){
                    System.out.println("There Is Draw");

                    break;
                }else{
                    System.out.println("Computer Win The Game");
                  computerWin=computerWin+1;
                    
                  break;
                }
            }
            if(computerStand==true&&playerStand==true){
                if(pcScore<playerScore){
                    playerWin=playerWin+1;
                    break;
                }

                
                else if(pcScore>playerScore){
                    computerWin=computerWin+1;
                    break;
                }
                else{
                    break;
                }
            }

        }

        System.out.println("_______________________________");
        function.totalScore(gameBoard[0],gameBoard[1]);
        
        System.out.println("Computer's win : " + computerWin);
        System.out.println("Player's win : "+playerWin);
        System.out.println("_______________________________");
        if(computerWin==3){
            System.out.println("Computer Win The Game... :(");
            System.out.println("Computer Score : " + computerWin);
            System.out.println("Player Score : "+playerWin);
            writeFile(playerWin,computerWin,name);
        }
        else if(playerWin==3){
            System.out.println(name+ " Win The Game... :)");
            System.out.println("Computer Score : " + computerWin);
            System.out.println("Player Score : "+playerWin);            
            writeFile(playerWin,computerWin,name);

        }
        else{
            function.inToGame(gameDeck, hands, computerWin, playerWin,deck,name);
        }
        
    }

    
        
    }
