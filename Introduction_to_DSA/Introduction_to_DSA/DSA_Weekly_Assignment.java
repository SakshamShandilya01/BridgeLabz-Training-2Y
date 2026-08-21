public class DSA_Weekly_Assignment {

    // ============================================================
    // SECTION 3: TIME COMPLEXITY
    // ============================================================


    // ============================================================
    // TC-1: LINEAR SEARCH TIME COMPLEXITY
    // ============================================================

    static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    /*
    TC-1: Linear Search Time Complexity

    Sample Input Array:
    {8, 61, 2, 3, 4, 0}


    1. Best Case:

    Target = 8

    The target is the first element of the array.
    Only one comparison is required.

    Best Case Time Complexity = O(1)


    2. Worst Case:

    Target = 0

    The target is the last element of the array.
    All elements are checked before finding the target.

    A target such as 5, which is not present in the array,
    also requires checking all elements.

    Worst Case Time Complexity = O(n)


    3. Average Case:

    The target may be located at any random position.
    On average, approximately n/2 elements are checked.

    Ignoring the constant 1/2:

    Average Case Time Complexity = O(n)
    */


    // ============================================================
    // TC-2: ITERATIVE BINARY SEARCH COMPLEXITY
    // ============================================================

    static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /*
    TC-2: Iterative Binary Search Complexity

    Sample Sorted Array:
    {0, 2, 3, 4, 8, 61}

    Target = 4


    1. Step-by-Step Search Range:

    Step 1:

    low = 0
    high = 5

    mid = (0 + 5) / 2
    mid = 2

    arr[2] = 3

    Since 3 < 4, search the right half.

    New range:
    low = 3
    high = 5


    Step 2:

    mid = (3 + 5) / 2
    mid = 4

    arr[4] = 8

    Since 8 > 4, search the left half.

    New range:
    low = 3
    high = 3


    Step 3:

    mid = (3 + 3) / 2
    mid = 3

    arr[3] = 4

    Target found.


    2. Worst Case Mathematical Derivation:

    The search space is divided by 2 at every iteration:

    N
    N/2
    N/4
    N/8
    ...

    After k comparisons:

    N / 2^k <= 1

    N <= 2^k

    k >= log2(N)

    Therefore:

    Worst Case Time Complexity = O(log n)
    */


    // ============================================================
    // TC-3: MERGE SORT TIME COMPLEXITY
    // ============================================================

    static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);

            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /*
    TC-3: Merge Sort Time Complexity

    Sample Input Array:
    {8, 61, 2, 3, 4, 0}


    1. Division / Split Tree:

                    [8, 61, 2, 3, 4, 0]
                       /             \
                 [8, 61, 2]       [3, 4, 0]
                  /      \         /      \
                [8]    [61, 2]   [3]    [4, 0]
                        /   \            /   \
                      [61]  [2]        [4]  [0]


    The array is repeatedly divided into two halves
    until each subarray contains one element.


    2. Recurrence Relation:

    T(n) = 2T(n/2) + O(n)


    3. Recursion Tree Method:

    Level 0:
    Work = O(n)

    Level 1:
    Work = O(n)

    Level 2:
    Work = O(n)


    At every level, the total merging work is O(n).

    Number of levels = log2(n)


    Total work:

    O(n) * O(log n)

    = O(n log n)


    Therefore:

    Best Case Time Complexity = O(n log n)

    Average Case Time Complexity = O(n log n)

    Worst Case Time Complexity = O(n log n)
    */


    // ============================================================
    // SECTION 4: SPACE COMPLEXITY
    // ============================================================


    // ============================================================
    // SC-1: LINEAR SEARCH SPACE COMPLEXITY
    // ============================================================

    /*
    SC-1: Linear Search Space Complexity

    Sample Input Array:
    {8, 61, 2, 3, 4, 0}

    Iterative Linear Search does not create another array
    or any additional data structure.

    It only uses a constant number of variables such as
    i and target.

    Therefore, the auxiliary space does not increase
    with the size of the input array.

    Auxiliary Space Complexity = O(1)
    */


    // ============================================================
    // SC-2: BINARY SEARCH SPACE COMPLEXITY
    // ============================================================

    /*
    SC-2: Binary Search Space Complexity

    The Binary Search solution used in this assignment
    is iterative.

    It uses only a constant number of variables such as:

    low
    high
    mid
    target

    It does not create an additional array and does not
    use a recursive call stack.

    Therefore:

    Auxiliary Space Complexity = O(1)
    */


    // ============================================================
    // SC-3: MERGE SORT SPACE COMPLEXITY
    // ============================================================

    /*
    SC-3: Merge Sort Space Complexity

    During the merging process, Merge Sort creates temporary
    arrays to store the divided subarrays.

    These temporary arrays require additional memory
    proportional to the number of elements being merged.

    Therefore:

    Auxiliary Space Complexity = O(n)


    Comparison with In-Place Sorting Algorithms:

    Insertion Sort:
    Auxiliary Space Complexity = O(1)

    Quick Sort:
    Average Auxiliary Space Complexity = O(log n)
    due to the recursive call stack.

    Merge Sort:
    Auxiliary Space Complexity = O(n)


    Therefore, Merge Sort requires more auxiliary memory
    than Insertion Sort and typical in-place Quick Sort.

    However, Merge Sort has a consistent time complexity
    of O(n log n).
    */

}