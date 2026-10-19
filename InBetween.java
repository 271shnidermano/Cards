
import java.util.Scanner;

public class InBetween 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        CardDeck deck = new CardDeck();
        deck.shuffle();
        int moneyToBet = 100;
        int betAmount = 0;
        boolean gameOver = false;
        System.out.println("Welcome to In Between!");
        while(!gameOver && deck.hasNextCard() && moneyToBet > 0)
        {
             Card firstCard = deck.nextCard();
            Card secondCard = deck.nextCard();
            System.out.println("What is your bet? ");
            betAmount = input.nextInt();
            input.nextLine();
           if(betAmount > moneyToBet || betAmount <= 0)
            {
                System.out.println("Invalid bet.");
                gameOver = true;
                break;
            }
            System.out.println("First card: " + firstCard);
            System.out.println("Second card: " + secondCard);
            if(firstCard.compareTo(secondCard) == 0)
            {
                System.out.println("The first and second cards are equal!");
                System.out.println("Automatic win");
                moneyToBet += betAmount;
                betAmount = 0;
            }
            else if(firstCard.compareTo(secondCard) == -1 || firstCard.compareTo(secondCard) == 1)
            {
                System.out.println("The first and second cards are too close!");
                System.out.println("Automatic loss");
                moneyToBet -= betAmount;
                betAmount = 0;
            }
            else
            {
            System.out.println("Want to double your bet? (Y for Yes, N for No) ");
            String doubleBet = input.nextLine().toLowerCase();
            if(doubleBet.equals("y"))
            {
                betAmount *= 2;
            }
            System.out.print("Will the next card be in between the two cards? (Y for Yes, N for No) ");
            String guess = input.nextLine().toLowerCase();

            Card nextCard = deck.nextCard();
            System.out.println("Next card: " + nextCard);
            boolean inBetween = (nextCard.compareTo(firstCard) > 0 && nextCard.compareTo(secondCard) < 0) || (nextCard.compareTo(firstCard) < 0 && nextCard.compareTo(secondCard) > 0);
           
            if((guess.equals("y") && inBetween) || (guess.equals("n") && !inBetween))
            {
                moneyToBet+=betAmount;
                betAmount=0;
                System.out.println("Correct! You now have " + moneyToBet + " dollars.");
                System.out.println("Do you want to continue playing? (Y for Yes, N for No) ");
                String continuePlaying = input.nextLine().toLowerCase();
                if(continuePlaying.equals("n"))
                {
                    gameOver = true;   
                }
            }
            else
            {
                moneyToBet-=betAmount;
                betAmount=0;
                System.out.println("Incorrect! You now have " + moneyToBet + " dollars.");
                System.out.println("Do you want to continue playing? (Y for Yes, N for No) ");
                String continuePlaying = input.nextLine().toLowerCase();
                if(continuePlaying.equals("n"))
                {
                    gameOver = true;   
                }
            
            }
            if (moneyToBet <= 0)
            {
                System.out.println("You have no more money to bet! Game Over.");
                gameOver = true;
            }
            for(int i = 0; i<10; i++)
            {
                if(!deck.hasNextCard())
                {
                    CardDeck v2 = new CardDeck();
                    v2.shuffle();
                    deck=v2;

                }
            }
        }
        }
        input.close();
    }
    }