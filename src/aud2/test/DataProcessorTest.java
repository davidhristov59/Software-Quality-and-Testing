package aud2.test;

import static org.junit.jupiter.api.Assertions.*;

import aud2.DataProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DataProcessorTest {

    private DataProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new DataProcessor();
    }

    // Tests for Fibonacci method
    @Test
    public void testFibonacciBaseCase() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(0, processor.fibonacci(0, memo));
        assertEquals(1, processor.fibonacci(1, memo));
    }

    @Test
    public void testFibonacciRecursive() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(5, processor.fibonacci(5, memo));
        assertEquals(21, processor.fibonacci(8, memo));
    }

    @Test
    public void testFibonacciEdgeCaseNegative() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> processor.fibonacci(-1, memo));
    }

    @Test
    public void testFibonacciLargeInput() {
        Map<Integer, Integer> memo = new HashMap<>();
        assertEquals(832040, processor.fibonacci(30, memo));
    }

    // Tests for finding prime numbers in range
    @Test
    public void testFindPrimes() {
        List<Integer> primes = processor.findPrimes(10, 20);
        List<Integer> expectedPrimes = Arrays.asList(11, 13, 17, 19);
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testFindPrimesSingleNumber() {
        List<Integer> primes = processor.findPrimes(2, 2);
        List<Integer> expectedPrimes = Arrays.asList(2);
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testFindPrimesNoPrimes() {
        List<Integer> primes = processor.findPrimes(15, 16);
        assertTrue(primes.isEmpty());
    }

    @Test
    public void testFindPrimesLowerBound() {
        List<Integer> primes = processor.findPrimes(1, 10);
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testFindPrimesUpperBound() {
        List<Integer> primes = processor.findPrimes(90, 100);
        List<Integer> expectedPrimes = Arrays.asList(97);
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testFindPrimesEmptyRange() {
        List<Integer> primes = processor.findPrimes(15, 14);
        assertTrue(primes.isEmpty());
    }

    // Tests for string permutations
    @Test
    public void testGetPermutations() {
        Set<String> permutations = processor.getPermutations("abc");
        Set<String> expectedPermutations = new HashSet<>(Arrays.asList(
                "abc",
                "acb",
                "bac",
                "bca",
                "cab",
                "cba"
        ));
        assertEquals(expectedPermutations, permutations);
    }


    // Tests for depth-first search in a graph
    @Test
    public void testDepthFirstSearch() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(5));
        Set<Integer> visited = new HashSet<>();
        processor.depthFirstSearch(graph, 1, visited);
        Set<Integer> expectedVisited = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expectedVisited, visited);
    }

    @Test
    public void testDepthFirstSearchSelfLoop() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(1));
        Set<Integer> visited = new HashSet<>();
        processor.depthFirstSearch(graph, 1, visited);
        assertEquals(Collections.singleton(1), visited);
    }

    // Tests for linked list reversal
    @Test
    public void testReverseLinkedList() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        LinkedList<Integer> reversed = processor.reverseLinkedList(list);
        LinkedList<Integer> expectedReversed = new LinkedList<>(Arrays.asList(3, 2, 1));
        assertEquals(expectedReversed, reversed);
    }

    @Test
    public void testReverseEmptyLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> reversed = processor.reverseLinkedList(list);
        assertTrue(reversed.isEmpty());
    }

    @Test
    public void testReverseLinkedListOneElement() {
        LinkedList<Integer> list = new LinkedList<>(Collections.singletonList(1));
        LinkedList<Integer> reversed = processor.reverseLinkedList(list);
        assertEquals(list, reversed);
    }

    @Test
    public void testReverseLinkedListLargeList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        LinkedList<Integer> reversed = processor.reverseLinkedList(list);
        assertEquals(1000, reversed.size());
    }

    // Tests for longest common subsequence
    @Test
    public void testLongestCommonSubsequence() {
        String s1 = "ABCBDAB";
        String s2 = "BDCAB";
        assertEquals(4, processor.longestCommonSubsequence(s1, s2));
    }

    @Test
    public void testLongestCommonSubsequenceEmptyStrings() {
        String s1 = "";
        String s2 = "";
        assertEquals(0, processor.longestCommonSubsequence(s1, s2));
    }

    @Test
    public void testLongestCommonSubsequenceIdenticalStrings() {
        String s1 = "ABCDE";
        String s2 = "ABCDE";
        assertEquals(5, processor.longestCommonSubsequence(s1, s2));
    }

    @Test
    public void testLongestCommonSubsequenceAllDifferent() {
        String s1 = "ABC";
        String s2 = "XYZ";
        assertEquals(0, processor.longestCommonSubsequence(s1, s2));
    }

    // Tests for factorial method
    @Test
    public void testFactorial() {
        assertEquals(120, processor.factorial(5));
        assertEquals(1, processor.factorial(0));
    }

    @Test
    public void testFactorialNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> processor.factorial(-5));
    }

    // Tests for finding the missing number in an array
    @Test
    public void testFindMissingNumber() {
        int[] nums = {1, 2, 4, 5};
        assertEquals(3, processor.findMissingNumber(nums));
    }

    @Test
    public void testFindMissingNumberSingleElement() {
        int[] nums = {1};
        assertEquals(2, processor.findMissingNumber(nums));
    }

    @Test
    public void testFindMissingNumberAllButOne() {
        int[] nums = {1, 2, 4, 5, 6};
        assertEquals(3, processor.findMissingNumber(nums));
    }

    @Test
    public void testFindMissingNumberConsecutive() {
        int[] nums = {1, 2, 3};
        assertEquals(4, processor.findMissingNumber(nums));
    }

    // Tests for matrix transpose
    @Test
    public void testTransposeMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] transposed = processor.transposeMatrix(matrix);
        int[][] expectedTransposed = {{1, 4}, {2, 5}, {3, 6}};
        assertArrayEquals(expectedTransposed, transposed);
    }

    @Test
    public void testTransposeMatrixSingleRow() {
        int[][] matrix = {{1, 2, 3}};
        int[][] transposed = processor.transposeMatrix(matrix);
        int[][] expectedTransposed = {{1}, {2}, {3}};
        assertArrayEquals(expectedTransposed, transposed);
    }

    @Test
    public void testTransposeMatrixSingleColumn() {
        int[][] matrix = {{1}, {2}, {3}};
        int[][] transposed = processor.transposeMatrix(matrix);
        int[][] expectedTransposed = {{1, 2, 3}};
        assertArrayEquals(expectedTransposed, transposed);
    }

    @Test
    public void testTransposeSquareMatrix() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] transposed = processor.transposeMatrix(matrix);
        int[][] expectedTransposed = {{1, 3}, {2, 4}};
        assertArrayEquals(expectedTransposed, transposed);
    }

    // Tests for unique characters in string
    @Test
    public void testCountUniqueCharacters() {
        assertEquals(2, processor.countUniqueCharacters("aab"));
        assertEquals(4, processor.countUniqueCharacters("abcd"));
        assertEquals(1, processor.countUniqueCharacters("aaaa"));
        assertEquals(6, processor.countUniqueCharacters("abc123"));
    }
}
