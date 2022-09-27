package com.github.devraghav.stack;

import java.util.Stack;

public class LargestRectangleHistogram {

    class Rectangle {
        int width = 0;
        int height = 0;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;

        Stack<Rectangle> monoTonicIncreasingStack = new Stack<>();
        monoTonicIncreasingStack.add(new Rectangle(1, heights[0]));
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            var currentWidth = i + 1;
            var currentHeight = heights[i];
            var lastIndexHeight = monoTonicIncreasingStack.peek();
            if (lastIndexHeight.height > currentHeight) {
                int lastIndexPopped = lastIndexHeight.width;
                while (!monoTonicIncreasingStack.isEmpty()) {
                    var peekEle = monoTonicIncreasingStack.peek();
                    if (peekEle.height <= currentHeight) break;
                    max = Math.max(max, (peekEle.height * (currentWidth - peekEle.width)));
                    monoTonicIncreasingStack.pop();
                    lastIndexPopped = peekEle.width;
                }
                monoTonicIncreasingStack.add(new Rectangle(lastIndexPopped, currentHeight));
            } else {
                monoTonicIncreasingStack.add(new Rectangle(currentWidth, currentHeight));
            }
        }
        while (!monoTonicIncreasingStack.isEmpty()) {
            var poppedRectangle = monoTonicIncreasingStack.pop();
            max = Math.max(max, poppedRectangle.height * ((len - poppedRectangle.width) + 1));
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        System.out.println(largestRectangleHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleHistogram.largestRectangleArea(new int[]{2, 4}));
        System.out.println(largestRectangleHistogram.largestRectangleArea(new int[]{4, 2}));
    }
}
