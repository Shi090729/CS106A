/*
 * File: HangmanCanvas.java
 * ------------------------
 * Maintains the graphical Hangman display.
 */

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;

public class HangmanCanvas extends GCanvas {

    private static final int SCAFFOLD_HEIGHT = 360;
    private static final int BEAM_LENGTH = 144;
    private static final int ROPE_LENGTH = 18;
    private static final int HEAD_RADIUS = 36;
    private static final int BODY_LENGTH = 144;
    private static final int ARM_OFFSET_FROM_HEAD = 28;
    private static final int UPPER_ARM_LENGTH = 72;
    private static final int LOWER_ARM_LENGTH = 44;
    private static final int HIP_WIDTH = 36;
    private static final int LEG_LENGTH = 108;
    private static final int FOOT_LENGTH = 28;

    private int errors;
    private String incorrectGuesses;
    private GLabel wordLabel;
    private GLabel incorrectLabel;
    private double bodyX;
    private double headCenterY;

    public void reset() {
        removeAll();
        errors = 0;
        incorrectGuesses = "";
        wordLabel = null;
        incorrectLabel = null;
        drawScaffold();
    }

    public void displayWord(String word) {
        if (wordLabel != null) {
            remove(wordLabel);
        }

        wordLabel = new GLabel(word);
        wordLabel.setFont("SansSerif-bold-20");
        double x = (getWidth() - wordLabel.getWidth()) / 2.0;
        double y = getHeight() - 65;
        add(wordLabel, x, y);
    }

    public void noteIncorrectGuess(char letter) {
        incorrectGuesses += letter;
        if (incorrectLabel != null) {
            remove(incorrectLabel);
        }

        incorrectLabel = new GLabel(
                "Incorrect guesses: " + incorrectGuesses);
        incorrectLabel.setFont("SansSerif-plain-14");
        double x = (getWidth() - incorrectLabel.getWidth()) / 2.0;
        double y = getHeight() - 30;
        add(incorrectLabel, x, y);

        drawBodyPart(errors);
        errors++;
    }

    private void drawScaffold() {
        double scaffoldTop = Math.max(
                20, (getHeight() - SCAFFOLD_HEIGHT - 120) / 2.0);
        double scaffoldBottom = scaffoldTop + SCAFFOLD_HEIGHT;
        bodyX = getWidth() / 2.0;
        double scaffoldX = bodyX - BEAM_LENGTH;
        headCenterY = scaffoldTop + ROPE_LENGTH + HEAD_RADIUS;

        double baseHalfWidth = (BEAM_LENGTH + 36) / 2.0;
        add(new GLine(
                scaffoldX - baseHalfWidth, scaffoldBottom,
                scaffoldX + baseHalfWidth, scaffoldBottom));
        add(new GLine(scaffoldX, scaffoldBottom, scaffoldX, scaffoldTop));
        add(new GLine(scaffoldX, scaffoldTop, bodyX, scaffoldTop));
        add(new GLine(
                bodyX, scaffoldTop,
                bodyX, scaffoldTop + ROPE_LENGTH));
    }

    private void drawBodyPart(int part) {
        double neckY = headCenterY + HEAD_RADIUS;
        double hipY = neckY + BODY_LENGTH;
        double shoulderY = headCenterY + ARM_OFFSET_FROM_HEAD;
        double footY = hipY + LEG_LENGTH;

        switch (part) {
            case 0:
                add(new GOval(
                        bodyX - HEAD_RADIUS,
                        headCenterY - HEAD_RADIUS,
                        2 * HEAD_RADIUS,
                        2 * HEAD_RADIUS));
                break;
            case 1:
                add(new GLine(bodyX, neckY, bodyX, hipY));
                break;
            case 2:
                add(new GLine(
                        bodyX, shoulderY,
                        bodyX - UPPER_ARM_LENGTH,
                        shoulderY + LOWER_ARM_LENGTH));
                break;
            case 3:
                add(new GLine(
                        bodyX, shoulderY,
                        bodyX + UPPER_ARM_LENGTH,
                        shoulderY + LOWER_ARM_LENGTH));
                break;
            case 4:
                add(new GLine(
                        bodyX, hipY,
                        bodyX - HIP_WIDTH, footY));
                break;
            case 5:
                add(new GLine(
                        bodyX, hipY,
                        bodyX + HIP_WIDTH, footY));
                break;
            case 6:
                add(new GLine(
                        bodyX - HIP_WIDTH, footY,
                        bodyX - HIP_WIDTH - FOOT_LENGTH, footY));
                break;
            case 7:
                add(new GLine(
                        bodyX + HIP_WIDTH, footY,
                        bodyX + HIP_WIDTH + FOOT_LENGTH, footY));
                break;
            default:
                break;
        }
    }
}
