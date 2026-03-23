package dsa;

import generics.Product;

import java.util.*;

public class PlayGround {

    private static int currentValue;

    public static void initialPlays() {

        Product<String, Double> games = new Product<>("God of War", 45.5);

        Stack<Student> firstStack = new Stack<>();
        Queue<String> firstQueue = new LinkedList<>();
        List<String> actualList = new ArrayList<>();
        actualList.add("One");
        actualList.add("two");
        actualList.add("three");
        actualList.add("four");
        actualList.add(2, "before three");

        System.out.println(actualList);


//        one.push("hello");


        firstStack.push(new Student("Derrick Keteku", 45));
        firstStack.push(new Student("Jason Lau", 45));
        firstStack.push(new Student("Ronaldo", 23));


        Comparator<Student> compare = new Comparator<Student>() {
            public int compare(Student a, Student b) {
                if (a.getAge() > b.getAge()) return 1;
                else return -1;

            }
        };
        firstStack.sort(compare);

        Queue<Double> studentGPAs = new LinkedList<>();
        studentGPAs.offer(4.0);
        studentGPAs.offer(3.5);
        studentGPAs.offer(3.3);
        studentGPAs.offer(2.8);

//        while (!studentGPAs.isEmpty()) {
//            System.out.println(studentGPAs.poll());
//        }

    }

    public static void comparingDynamicArrayLinkedList() {

        //    linkedList - ArrayList comparison


        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        long startTime;
        long endTime;
        long elapsedTime;

        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

//    ------------ testing LinkedList -----------------------------------
        startTime = System.nanoTime();

//        test
//        linkedList.get(500000); //
        linkedList.remove(500000);

        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;

        System.out.println("LinkedList - " + elapsedTime + " ns");

//    --------------- testing Arraylist -----------------------------
        startTime = System.nanoTime();

//        arrayList.get(500000);
        arrayList.remove(500000);
        endTime = System.nanoTime();


        elapsedTime = endTime - startTime;

        System.out.println("Arraylist - " + elapsedTime + " ns");

//       getFirstElement
//        linkedList - 5459
//        arrayList - 1625
//       getLastElement
//        linkedList - 4667
//        arrayList - 1334



    }

    public static void UsingLinearSearch () {
        int[] array = { 9, 0,9,8, 4, 7, 8};

        System.out.println("Does item exists : " + linearSearch(array, 1));

    }
    public static boolean linearSearch(int[] array, int item) {
        for (int elem: array) {
            if (elem == item) return true;
        }

        return false;
    }


    public static void usingBinarySearch() {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int[] numbers = new int[10000];

        for (int i = 0; i < 10000; i++) {
            numbers[i] = i + 1;
        }

        System.out.println("Whats the position of : " + 'Z' + " -  " + binarySearchIII(numbers, 5000));
    }
    public static int binarySearch(char[] array, char item)  {
//        first get total size of array and find half of it.
//        use start and end variables to determine the beginning and end index
//        compare the element at the index of half the size
//        if it's not it, compare
//        if its item is greater than
        int end = array.length - 1;
        int start = 0;
        int middle = start + end / 2;

//        whiles our start and end remain sane and keep doing its thing
        while( start <= end ) {
            if (array[middle] == item) return middle;
            else if (array[middle] > item) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }

            middle = (start + end) / 2;
            System.out.println("Middle : "+ middle);
        }
        return -1;


    }


    public static int binarySearchIII(int[] array, int item ){
        int start = 0;
        int middle = array.length / 2;
        int end = array.length - 1;

        while (start <= end) {
            if (array[middle] > item) end = middle - 1;
            else if (array[middle] < item) start = middle + 1;
            else return middle;

            middle = (start + end) / 2;
        }
        return -1;
    }


    public static int binarySearchII(char[] array, char item) {
        int start = 0;
        int end = array.length - 1;
        int middle;

        while (start <= end) {
            middle = (int) start + end / 2;

            if (array[middle] == item) {
                return middle;
            } else if (array[middle] > item) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static void usingInterpolationSearch() {
        int[] scores = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150 };


        int positionOfItem = interpolationSearch(scores, 100);

        System.out.println("Position : "+ positionOfItem);

    }


    public static int interpolationSearch(int[] array,int item) {
        int low = 0;
        int high = array.length - 1;

        while (item >= array[low] && item <= array[high]) {
//            guess (calculate ) the position
            int position = low + ( (item - array[low]) * ( high - low )) / (array[high] - array[low] );

            System.out.println("First Guess : " + position);
            if(array[position] == item) return  position;
            else if (array[position] > item) high = position - 1;
            else low = position + 1;
        }
        return -1;
    }


    public static void usingBubbleSort() {
        int[] scores = { 50, 60, 70, 8, 120, 130, 10, 20, 0, 90, 100, 30, 40, 140, 150 };

        System.out.println("Scrambled scores: " + Arrays.toString(scores));
        System.out.println("Sorted List: " + Arrays.toString(bubbleSortII(scores)));
    }
    

//    Very inefficient sort algorithm

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {

                int currentValue = array[j];

                int nextIndex = j + 1;
                int nextValue = array[nextIndex];

//                swap the greater than and less than sign if want to change the order from ascending order
//                to descending order
                if (currentValue > nextValue) {
                    array[j] = nextValue;
                    array[nextIndex] = currentValue;
                }
            }

        }
        return array;
    }

    public static int[] bubbleSortII(int[] array) {
        for (int i = 0; i < array.length -1 ; i++) {
            for (int j = 0; j < array.length - i -1; j++) {
                int currentValue = array[j];
                int adjacentValue = array[j+1];

                if (currentValue < adjacentValue) {
                    array[j] = adjacentValue;
                    array[j+1] = currentValue;
                }

            }
        }

        return array;
    }
    public static void usingSelectionSort() {
//        int[] scores = { 50, 60, 70, 8, 120, 130, 10, 20, 0, 90, 100, 30, 40, 140, 150 };
        int[] scores = {1, 5, 3, 2, 4};

        System.out.println("original array : "+ Arrays.toString(scores));

        System.out.println("Print Minimum value : " + Arrays.toString(selectionSortII(scores)));
    }

    public static int[] selectionSortII(int[] array) {
        int smallestValue = array[0];
        int originalIndexOfSmallestValue = 0;


        // original iteration
        for (int i = 0; i < array.length; i++) {
            // hold beginning value and iteration
            smallestValue = array[i];
            originalIndexOfSmallestValue = i;

            for (int j = i; j < array.length; j++) {
                // loop for the smallest value in the array
                if (array[j] > smallestValue) {
                    smallestValue = array[j];
                    originalIndexOfSmallestValue = j;
                }
            }

            // swap the smallest value to with the current position in the original iteration
            int temp = array[i];
            array[i] = smallestValue;
            array[originalIndexOfSmallestValue] = temp;
        }

        return array;
    }

    public static int[] selectionSortDoesNtWorkOnAllOccasions(int[] array){
//        find the smallest value of the array

//        We identified our indexes
        int smallestIndex = 0;
        int startingIndex = 0;

        for (int j = 0; j < array.length; j++) {
//            setup our values based on the identified indices


            int smallest = array[startingIndex];
            int starting = array[startingIndex];

//            this is the first step to find the smallest value in the array
//
            for (int i = startingIndex; i < array.length; i++) {

                if (array[i] < smallest) {
                    smallest = array[i];
                    smallestIndex = i;
                }
            }
//            then swap its position with the first element in the array
//            do this outside the loop
//            then increment the starting position to decrease the size of the array
//            then increment the starting position to reduce the scan for the smallest element in the array
//            in the next iteration
            array[startingIndex] = smallest;
            array[smallestIndex] = starting;
            startingIndex++;
        }

        return array;
    }

    public static void usingInsertionSort() {
        int[] scores = { 50, 60, 70, 8, 120, 130, 10, 20, 0, 90, 100, 30, 40, 140, 150 };

        System.out.println("print sorted array : " + Arrays.toString(insertionSort(scores)));

    }

    public static int[] insertionSort(int[] array) {
//        original iteration
        for (int i = 1; i < array.length; i++) {

            //beginning value and location
            int temp = array[i];
            int emptyIndex = i;

            for (int j = i; j > -1; j--) {
//                look for larger values and move to right
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                    emptyIndex--;
                }
            }
//           put temporary holding value in the empty slot
            array[emptyIndex] = temp;
        }

        return array;
    }

    public static int[] selectionSort(int[] array) {
//        iterate over the loop, at each point find the smallest value and put it to the point you are in
//        work with the index
        for (int i = 0; i < array.length - 1; i++) {
            int min =  i;

            for (int j = i + 1; j < array.length; j++) {
//                find the index with the smallest value
                if (array[min] > array[j]) min = j;

            }
//            hold our smallest value
            int temp = array[min];

//            put the current iteration positional value  where the smallest is
            array[min] = array[i];

//            then put smallest at the edge
            array[i] = temp;
        }

        return array;
    }


//    recursion



}
