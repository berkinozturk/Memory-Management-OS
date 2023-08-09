# Memory-Management-OS
This repository contains Java code that demonstrates memory management and page replacement algorithms. The PageReplacement class simulates various page replacement strategies, including FIFO, Optimal, and LRU, showcasing their page fault behavior. The Main class implements memory allocation algorithms like First Fit, Worst Fit, and Best Fit, displaying process allocations within available memory blocks. This code provides insights into memory optimization techniques and serves as a learning resource for students and developers interested in memory management concepts.


## PageReplacement Class:

This class focuses on simulating different page replacement algorithms for managing memory in a computer system.

1. The findPageToReplaceFIFO method:

* This method implements the First-In-First-Out (FIFO) page replacement algorithm.
* It takes a deque (double-ended queue) of page frames as a parameter and returns the page that needs to be replaced according to the FIFO algorithm.

---

2. The findPageToReplaceOptimal method:

* This method implements the Optimal page replacement algorithm.
*It takes the reference string (an array representing the sequence of page requests), the deque of page frames, and the current index in the reference string as parameters.
* It iterates through the frames and calculates the index of the next occurrence of each frame in the reference string.
* The frame with the highest index (indicating the frame that will not be used for the longest time) is selected for replacement.

---

3. The findPageToReplaceLRU method:

*This method implements the Least Recently Used (LRU) page replacement algorithm.
*It takes a hashmap representing the last usage time of each page (frame) and the deque of page frames as parameters.
*It iterates through the frames and selects the frame that was least recently used according to the recorded usage times.

---

4. The main method:

* This method is where the simulation starts.
* It takes user input for the number of frames available for page storage.
* It defines a reference string of page requests.
* It simulates the FIFO, Optimal, and LRU page replacement algorithms by maintaining page frames and counting page faults.
* After each simulation, the number of page faults for each algorithm is displayed.



## Main Class:

This class focuses on implementing three memory allocation algorithms: First Fit, Worst Fit, and Best Fit.

1. The firstFit method:
* This method implements the First Fit memory allocation algorithm.
* It takes arrays representing block sizes (bSize) and process sizes (pSize), as well as the lengths of these arrays.
* It iterates through the processes and assigns them to the first block that can accommodate their size.

---

2. The worstFit method:

* This method implements the Worst Fit memory allocation algorithm.
* It takes arrays representing block sizes (bSize) and process sizes (pSize), as well as the lengths of these arrays.
* It iterates through the processes and assigns them to the block with the largest available size that can accommodate their size.

---

3. The bestFit method:

* This method implements the Best Fit memory allocation algorithm.
* It takes arrays representing block sizes (bSize) and process sizes (pSize), as well as the lengths of these arrays.
* It iterates through the processes and assigns them to the block with the smallest available size that can accommodate their size.

---

4. The main method:

* This method is where the simulation for memory allocation algorithms starts.
* It defines block sizes (bSize) and process sizes (pSize) arrays.
* It calls the firstFit, worstFit, and bestFit methods to simulate memory allocation for each algorithm.
* The results of the allocation (process numbers, sizes, and block numbers) are displayed for each algorithm.

---

In summary, the PageReplacement class simulates different page replacement algorithms for memory management, while the Main class implements and demonstrates memory allocation algorithms like First Fit, Worst Fit, and Best Fit.




