package com.leet.code;

import java.util.*;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;

        if (x == 0 && y % 2 == 0) {
            return (nums2[y / 2] + nums2[y / 2 - 1]) / 2;
        }

        if (x == 0 && y % 2 != 0) {
            return nums2[y / 2];
        }

        if (y == 0 && x % 2 == 0) {
            return (nums1[x / 2] + nums1[x / 2 - 1]) / 2;
        }

        if (y == 0 && x % 2 != 0) {
            return nums1[x / 2];
        }

        if (x > y)
            return findMedianSortedArrays(nums2, nums1);

        int start = 0;
        int end = x;

        while (start <= end) {

            int partitionX = (start + end) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }

            } else if (maxLeftX > minRightY) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }

        return 0.0d;
    }

    public int threeSumClosest(int[] nums, int target) {

        if (nums.length == 0)
            return 0;

        return sumClosest(nums, target, 0, 3, 0);
    }

    private int sumClosest(int[] nums, int target, int sum, int number, int index) {

        if (number == 0)
            return sum;

        if (index >= nums.length)
            return Integer.MIN_VALUE;

        int sum1 = sumClosest(nums, target, sum + nums[index], number - 1, index + 1);
        int sum2 = sumClosest(nums, target, sum, number, index + 1);

        if (sum1 == Integer.MIN_VALUE && sum2 == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if (sum1 == Integer.MIN_VALUE)
            return sum2;

        if (sum2 == Integer.MIN_VALUE)
            return sum1;

        if (Math.abs(target - sum1) > Math.abs(target - sum2)) {
            return sum2;
        } else {
            return sum1;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            int sum = target - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;

                } else if (nums[low] + nums[high] > sum) {
                    high--;
                } else {
                    low++;
                }
            }

        }

        return result;
    }

    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<Character>();

        for (char character : s.toCharArray()) {

            if (!stack.empty() && (character == ')' && stack.peek() == '(' || character == ']' && stack.peek() == '[' || character == '}' && stack.peek() == '{')) {
                stack.pop();
                continue;
            }

            if (!stack.empty() && character > stack.peek())
                return false;

            stack.push(character);
        }

        return stack.empty();
    }

    public int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 1;
        }

        int index = partition(nums) + 1;
        int temp = 0;
        int result = index;

        for (int i = 0; i < index; i++) {
            temp = Math.abs(nums[i]);
            if (temp <= index) {
                nums[temp - 1] = (nums[temp - 1] < 0) ? nums[temp - 1] : -nums[temp - 1];
            }
        }

        for (int i = 0; i < index; i++) {
            if (nums[i] > 0) {
                result = i;
                break;
            }
        }

        return result + 1;
    }

    private int partition(int[] nums) {
        int q = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                q++;
                swap(nums, i, q);
            }
        }

        return q;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public void rotate(int[][] matrix) {

        int len = matrix.length-1;
        for (int d = 0; d < matrix.length / 2; d++) {
            for (int l = 0, k = matrix.length - 1; l + d < matrix.length - 1 -d && k >= 0; l++, k--) {
                int temp = matrix[d][l + d]; // left upper corner
                matrix[d][l + d] = matrix[k - d][d];

                int temp2 = matrix[l + d][len - d];  // rigth upper corner
                matrix[l + d][len - d] = temp;

                temp = matrix[len - d][k-d]; // right bottom corner
                matrix[len - d][k-d] = temp2;

                matrix[k - d][d] = temp; // left bottom corner
            }
        }
    }
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \\
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0, cols, d1, d2, n);
        return count;
    }

    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) count++;

        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }

    public int[][] generateMatrix(int n) {
        final int[][] result = new int[n][n];
        int value = 1;

        for (int d = 0; d < n/2; d++) {
            for (int j = 0; j < n - 1; j++) {
                result[d][d + j] = value;
                result[d + j][n - 1 - d] = value + n - 1 - d * 2;
                result[n - 1 - d][n - 1 - d - j] = value + 2 * n - 2 - d * 4;
                result[n - 1 - d - j][d] = value + 3 * n -3 - d * 4;
                value++;
            }
            value = value + 3 * n -3 - d * 8;
        }

        return result;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int currLen = 0; Set<String> temp = new HashSet<>();
        for (String word : words) {
            if (currLen + temp.size() - 1 <= maxWidth) {
                temp.add(word);
                currLen += word.length();
            } else {
                int numSpace = maxWidth - currLen / (temp.size() - 1);
                final StringBuilder sb = new StringBuilder();

                boolean first = true;
                for (String wrd : temp) {
                    if (!first) {
                        for (int i = 0; i < numSpace; i++) {
                            sb.append(" ");
                        }
                    }
                    sb.append(wrd);
                    first = false;
                }

                result.add(sb.toString());

                temp.clear();
                temp.add(word);
                currLen = word.length();
            }
        }

        if (temp.size() > 0) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (String tmp : temp) {

                if (!first) {
                    sb.append(" ");
                }

                sb.append(tmp);
                first = false;
            }
            result.add(sb.toString());
        }

        return result;
    }
}