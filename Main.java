public class Main {
    public static void main(String[] args) {


            //blocks assigned
            int bSize[] = {150, 600, 300, 700, 100};
            //processes assigned
            int pSize[] = {125, 248, 379, 222 ,175};

            //first fit approach
            firstFit(bSize, bSize.length, pSize, pSize.length);
            //worst fit approach
            worstFit(bSize, bSize.length, pSize, pSize.length);
            //best fit approach
            bestFit(bSize, bSize.length, pSize, pSize.length);
        }

        public static void firstFit(int bSize[], int a,int pSize[], int b)
    {
        // array of block allocated to a process
        int allocation[] = new int[b];

        // Initially no block is assigned to any process,so it is in default stage
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick every process one by one and find each suitable block for them
        for (int i = 0; i < b; i++)
        {
            for (int j = 0; j < a; j++)
            {
                if (bSize[j] >= pSize[i])
                {
                    // allocate block j to p[i] process
                    allocation[i] = j;

                    bSize[j] -= pSize[i];

                    break;
                }
            }
        }

        //print the result
        System.out.println("\t\t***For First Fit***");
        System.out.println("Process No.  Process Size  Block no.");
        for (int i = 0; i < b; i++)
        {
            System.out.print("\t" + (i+1) + " \t\t\t" +
                    pSize[i] + "\t\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("No Allocation");
            System.out.println();
        }
    }
    public static void worstFit(int bSize[], int a, int pSize[],int b) {
        // array of block allocated to a process
        int allocation[] = new int[b];

        // Initially no block is assigned to any process,so it is in default stage
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick every process one by one and find each suitable block for them
        for (int i = 0; i < b; i++) {
            // Find the best fit block for current process
            int worstIndex = -1;
            for (int j = 0; j < a; j++) {
                if (bSize[j] >= pSize[i]) {
                    if (worstIndex == -1)
                        worstIndex = j;
                    else if (bSize[worstIndex] < bSize[j])
                        worstIndex = j;
                }
            }

            // If we could find a block for current process
            if (worstIndex != -1) {
                // allocate block j to p[i] process
                allocation[i] = worstIndex;

                // Reduce available memory in this block.
                bSize[worstIndex] -= pSize[i];
            }
        }

        //print the result
        System.out.println("\t\t***For Worst Fit***");
        System.out.println("Process No.  Process Size  Block no.");
        for (int i = 0; i < b; i++) {
            System.out.print("\t" + (i + 1) + " \t\t\t" +
                    pSize[i] + "\t\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("No Allocation");
            System.out.println();
        }
    }
    static void bestFit(int bSize[], int a, int pSize[], int b) {
        // array of block allocated to a process
        int allocation[] = new int[b];

        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick every process one by one and find each suitable block for them
        for (int i = 0; i < b; i++) {
            // Find the best fit block for current process
            int bestIndex = -1;
            for (int j = 0; j < a; j++) {
                if (bSize[j] >= pSize[i]) {
                    if (bestIndex == -1)
                        bestIndex = j;
                    else if (bSize[bestIndex] > bSize[j])
                        bestIndex = j;
                }
            }

            // If we could find a block for current process
            if (bestIndex != -1) {
                // allocate block j to p[i] process
                allocation[i] = bestIndex;

                // Reduce available memory in this block.
                bSize[bestIndex] -= pSize[i];
            }
        }

        //print the result
        System.out.println("\t\t***For Best Fit***");
        System.out.println("Process No.  Process Size  Block no.");
        for (int i = 0; i < b; i++) {
            System.out.print("\t" + (i + 1) + " \t\t\t" +
                    pSize[i] + "\t\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("No Allocation");
            System.out.println();
        }
    }
    }

