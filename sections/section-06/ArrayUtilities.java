import acm.graphics.GImage;

public class ArrayUtilities {

    public static GImage flipHorizontal(GImage image) {
        int[][] pixels = image.getPixelArray();
        int height = pixels.length;

        for (int row = 0; row < height; row++) {
            int width = pixels[row].length;
            for (int left = 0; left < width / 2; left++) {
                int right = width - left - 1;
                int temporary = pixels[row][left];
                pixels[row][left] = pixels[row][right];
                pixels[row][right] = temporary;
            }
        }

        return new GImage(pixels);
    }
}
