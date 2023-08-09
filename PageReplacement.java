import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class PageReplacement {
    // A utility function to find the page to be replaced
    // using FIFO algorithm
    private static int findPageToReplaceFIFO(Deque<Integer> frames) {
        return frames.poll();
    }

    // A utility function to find the page to be replaced
    // using Optimal algorithm
    private static int findPageToReplaceOptimal(int[] referenceString, Deque<Integer> frames, int currentIndex) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;

        // find the page that will not be used in the future
        for (int frame : frames) {
            int index = currentIndex;
            while (index < referenceString.length) {
                if (referenceString[index] == frame) {
                    break;
                }
                index++;
            }

            if (index > maxValue) {
                maxValue = index;
                maxIndex = frame;
            }
        }

        return maxIndex;
    }

    // A utility function to find the page to be replaced
    // using LRU algorithm
    private static int findPageToReplaceLRU(HashMap<Integer, Integer> pageUseTime, Deque<Integer> frames) {
        int minTime = Integer.MAX_VALUE;
        int minTimeFrame = -1;

        // find the page that was least recently used
        for (int frame : frames) {
            if (pageUseTime.get(frame) < minTime) {
                minTime = pageUseTime.get(frame);
                minTimeFrame = frame;
            }
        }

        return minTimeFrame;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of frames: ");
        int numFrames = scanner.nextInt();

        // reference string to simulate page faults
        int[] referenceString = {1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 4, 3, 7, 6, 6, 5, 3, 2, 1, 2, 3, 6};

        // FIFO page replacement algorithm
        Deque<Integer> frames = new ArrayDeque<>();
        int pageFaultsFIFO = 0;

        for (int i = 0; i < referenceString.length; i++) {
            if (frames.size() < numFrames) {
                // if the frame is not full, add the page
                if (!frames.contains(referenceString[i])) {
                    frames.add(referenceString[i]);
                    pageFaultsFIFO++;
                }
            } else {
                // if the frame is full, find a page to replace
                if (!frames.contains(referenceString[i])) {
                    int pageToReplace = findPageToReplaceFIFO(frames);
                    frames.remove(pageToReplace);
                    frames.add(referenceString[i]);
                    pageFaultsFIFO++;
                }
            }
        }
        System.out.println("Number of page faults using FIFO: " + pageFaultsFIFO);

        // Optimal page replacement algorithm
        frames.clear();
        int pageFaultsOptimal = 0;

        for (int i = 0; i < referenceString.length; i++) {
            if (frames.size() < numFrames) {
                // if the frame is not full, add the page
                if (!frames.contains(referenceString[i])) {
                    frames.add(referenceString[i]);
                    pageFaultsOptimal++;
                }
            } else {
                // if the frame is full, find a page to replace
                if (!frames.contains(referenceString[i])) {
                    int pageToReplace = findPageToReplaceOptimal(referenceString, frames, i);
                    frames.remove(pageToReplace);
                    frames.add(referenceString[i]);
                    pageFaultsOptimal++;
                }
            }
        }
        System.out.println("Number of page faults using Optimal: " + pageFaultsOptimal);

        // LRU page replacement algorithm
        frames.clear();
        int pageFaultsLRU = 0;
        HashMap<Integer, Integer> pageUseTime = new HashMap<>();

        for (int i = 0; i < referenceString.length; i++) {
            if (frames.size() < numFrames) {
                // if the frame is not full, add the page
                if (!frames.contains(referenceString[i])) {
                    frames.add(referenceString[i]);
                    pageFaultsLRU++;
                }
                pageUseTime.put(referenceString[i], i);
            } else {
                // if the frame is full, find a page to replace
                if (!frames.contains(referenceString[i])) {
                    int pageToReplace = findPageToReplaceLRU(pageUseTime, frames);
                    frames.remove(pageToReplace);
                    frames.add(referenceString[i]);
                    pageFaultsLRU++;
                }
                pageUseTime.put(referenceString[i], i);
            }
        }
        System.out.println("Number of page faults using LRU: " + pageFaultsLRU);
    }
}
