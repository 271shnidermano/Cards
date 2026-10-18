//--------------------------------------------------------------------
// HigherLower.java         by Dale/Joyce/Weems              Chapter 6
//
// Plays Higher or Lower? with user through command line interface. 
//--------------------------------------------------------------------
import java.util.Scanner;

public class HigherLower 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        CardDeck deck = new CardDeck();
        deck.shuffle();
        Card current = deck.nextCard();

        int score = 0;
        boolean gameOver = false;

        System.out.println("Welcome to Higher Lower!");
        System.out.println("The first card is: " + current);
        while (!gameOver && deck.hasNextCard())
        {
            System.out.print("Will the next card be higher or lower? (H for Higher, L for Lower) ");
            String guess = input.nextLine().toLowerCase();
            Card nextCard = deck.nextCard();
            System.out.println("Next card: " + nextCard);
            int comparison = nextCard.compareTo(current);
            if (comparison == 0)
            {
                System.out.println("The card ranks are the same!");
                System.out.println("No points");
            }
            else if (guess.equals("h") && comparison > 0)
            {
                score++;
                System.out.println("Correct! Your score is " + score);
            }
            else if (guess.equals("l") && comparison < 0)
            {
                score++;
                System.out.println("Correct! Your score is " + score);
            }
            else
            {
                System.out.println("Incorrect guess!");
                gameOver = true;
            }

            // The next card becomes the current card
            current = nextCard;
        }

        System.out.println("Game over!");
        System.out.println("Final score: " + score);

        input.close();
    }
    }