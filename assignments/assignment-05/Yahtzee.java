/*
 * File: Yahtzee.java
 * ------------------
 * Plays a complete multiplayer game of Yahtzee.
 */

import acm.io.IODialog;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {

    private int nPlayers;
    private String[] playerNames;
    private YahtzeeDisplay display;
    private final RandomGenerator rgen = RandomGenerator.getInstance();

    public static void main(String[] args) {
        new Yahtzee().start(args);
    }

    public void run() {
        readPlayerInformation();
        display = new YahtzeeDisplay(getGCanvas(), playerNames);
        playGame();
    }

    private void readPlayerInformation() {
        IODialog dialog = getDialog();
        nPlayers = dialog.readInt(
                "Enter number of players", 1, MAX_PLAYERS);
        playerNames = new String[nPlayers];
        for (int player = 0; player < nPlayers; player++) {
            playerNames[player] = dialog.readLine(
                    "Enter name for player " + (player + 1));
        }
    }

    private void playGame() {
        int[][] scores = new int[nPlayers][N_CATEGORIES + 1];
        boolean[][] categoryUsed =
                new boolean[nPlayers][N_CATEGORIES + 1];

        for (int round = 0; round < N_SCORING_CATEGORIES; round++) {
            for (int player = 1; player <= nPlayers; player++) {
                playTurn(player, scores, categoryUsed);
            }
        }

        updateTotals(scores);
        announceWinner(scores);
    }

    private void playTurn(
            int player, int[][] scores, boolean[][] categoryUsed) {
        int[] dice = new int[N_DICE];
        display.waitForPlayerToClickRoll(player);
        rollAllDice(dice);
        display.displayDice(dice);

        for (int reroll = 0; reroll < 2; reroll++) {
            display.waitForPlayerToSelectDice();
            rerollSelectedDice(dice);
            display.displayDice(dice);
        }

        int category = readUnusedCategory(player, categoryUsed);
        int score = scoreCategory(dice, category);
        int playerIndex = player - 1;
        scores[playerIndex][category] = score;
        categoryUsed[playerIndex][category] = true;
        display.updateScorecard(category, player, score);
    }

    private void rollAllDice(int[] dice) {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = rgen.nextInt(1, 6);
        }
    }

    private void rerollSelectedDice(int[] dice) {
        for (int i = 0; i < dice.length; i++) {
            if (display.isDieSelected(i)) {
                dice[i] = rgen.nextInt(1, 6);
            }
        }
    }

    private int readUnusedCategory(
            int player, boolean[][] categoryUsed) {
        int playerIndex = player - 1;
        while (true) {
            int category = display.waitForPlayerToSelectCategory();
            if (isCategoryAvailable(
                    playerIndex, category, categoryUsed)) {
                return category;
            }
            display.printMessage(
                    "Choose an unused scoring category.");
        }
    }

    private boolean isCategoryAvailable(
            int playerIndex,
            int category,
            boolean[][] categoryUsed) {
        return isScoringCategory(category)
                && !categoryUsed[playerIndex][category];
    }

    private boolean isScoringCategory(int category) {
        return category >= ONES && category <= SIXES
                || category >= THREE_OF_A_KIND && category <= CHANCE;
    }

    private int scoreCategory(int[] dice, int category) {
        int[] counts = countDice(dice);
        int sum = sumDice(dice);

        if (category >= ONES && category <= SIXES) {
            return counts[category] * category;
        }

        switch (category) {
            case THREE_OF_A_KIND:
                return hasAtLeast(counts, 3) ? sum : 0;
            case FOUR_OF_A_KIND:
                return hasAtLeast(counts, 4) ? sum : 0;
            case FULL_HOUSE:
                return hasCount(counts, 3) && hasCount(counts, 2)
                        ? 25 : 0;
            case SMALL_STRAIGHT:
                return hasStraight(counts, 4) ? 30 : 0;
            case LARGE_STRAIGHT:
                return hasStraight(counts, 5) ? 40 : 0;
            case YAHTZEE:
                return hasAtLeast(counts, 5) ? 50 : 0;
            case CHANCE:
                return sum;
            default:
                return 0;
        }
    }

    private int[] countDice(int[] dice) {
        int[] counts = new int[7];
        for (int die : dice) {
            counts[die]++;
        }
        return counts;
    }

    private int sumDice(int[] dice) {
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }

    private boolean hasAtLeast(int[] counts, int amount) {
        for (int value = 1; value <= 6; value++) {
            if (counts[value] >= amount) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCount(int[] counts, int amount) {
        for (int value = 1; value <= 6; value++) {
            if (counts[value] == amount) {
                return true;
            }
        }
        return false;
    }

    private boolean hasStraight(int[] counts, int length) {
        int consecutive = 0;
        for (int value = 1; value <= 6; value++) {
            if (counts[value] > 0) {
                consecutive++;
                if (consecutive >= length) {
                    return true;
                }
            } else {
                consecutive = 0;
            }
        }
        return false;
    }

    private void updateTotals(int[][] scores) {
        for (int playerIndex = 0;
                playerIndex < nPlayers;
                playerIndex++) {
            int upperScore = sumRange(
                    scores[playerIndex], ONES, SIXES);
            int upperBonus = upperScore >= 63 ? 35 : 0;
            int lowerScore = sumRange(
                    scores[playerIndex], THREE_OF_A_KIND, CHANCE);
            int total = upperScore + upperBonus + lowerScore;

            scores[playerIndex][UPPER_SCORE] = upperScore;
            scores[playerIndex][UPPER_BONUS] = upperBonus;
            scores[playerIndex][LOWER_SCORE] = lowerScore;
            scores[playerIndex][TOTAL] = total;

            int player = playerIndex + 1;
            display.updateScorecard(UPPER_SCORE, player, upperScore);
            display.updateScorecard(UPPER_BONUS, player, upperBonus);
            display.updateScorecard(LOWER_SCORE, player, lowerScore);
            display.updateScorecard(TOTAL, player, total);
        }
    }

    private int sumRange(int[] scores, int first, int last) {
        int total = 0;
        for (int category = first; category <= last; category++) {
            total += scores[category];
        }
        return total;
    }

    private void announceWinner(int[][] scores) {
        int highestScore = scores[0][TOTAL];
        for (int player = 1; player < nPlayers; player++) {
            highestScore = Math.max(highestScore, scores[player][TOTAL]);
        }

        int winnerCount = 0;
        for (int player = 0; player < nPlayers; player++) {
            if (scores[player][TOTAL] == highestScore) {
                winnerCount++;
            }
        }

        StringBuilder winners = new StringBuilder();
        int winnersAdded = 0;
        for (int player = 0; player < nPlayers; player++) {
            if (scores[player][TOTAL] == highestScore) {
                if (winnersAdded > 0) {
                    winners.append(
                            winnersAdded == winnerCount - 1
                                    ? " and " : ", ");
                }
                winners.append(playerNames[player]);
                winnersAdded++;
            }
        }

        if (winnerCount == 1) {
            display.printMessage(
                    "Congratulations, " + winners
                            + ", you're the winner!");
        } else {
            display.printMessage(
                    "It's a tie between " + winners + "!");
        }
    }
}
