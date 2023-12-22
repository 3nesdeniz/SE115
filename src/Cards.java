public class Cards {

    private String color;
    private int number;
    private boolean isJoker;
    private boolean isPlay = false;
    private boolean isComputerHand=false;

    

    public Cards(String stringValue, int intValue) {
        color = stringValue;
        number = intValue; 
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public String toString() {
        return color + " " + number;
    }
    public boolean getIsJoker() {
        return isJoker;
    }

    public void setIsJoker(boolean isJoker) {
        this.isJoker = isJoker;
    }
    public boolean isPlay() {
        return isPlay;
    }

    public void setIsPlay(boolean isPlay) {
        this.isPlay = isPlay;
    }

    public boolean isComputerHand() {
        return isComputerHand;
    }

    public void setIsComputerHand(boolean isComputerHand) {
        this.isComputerHand = isComputerHand;
    }
   
}
    
