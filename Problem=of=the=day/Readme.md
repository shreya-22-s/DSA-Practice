## Subarray Sum Equals K

**Problem**: Given an unsorted array of integers, find the number of subarrays whose sum is equal to a given integer `k`.

**Example**:
```java
Input: arr = [10, 2, -2, -20, 10], k = -10
Output: 3
platform : GFG


---

### 📌 Longest Subarray With Maximum Bitwise AND

🔹 **Problem Statement**  
You are given an integer array `nums` of size `n`.

- Consider all non-empty subarrays of `nums`.
- Compute the bitwise AND of each subarray.
- Let `k` be the maximum value of all these ANDs.
- Return the length of the longest contiguous subarray whose bitwise AND is exactly `k`.

---

# 🧮 Find Median of a Binary Search Tree (BST)

This repository contains a Java solution for finding the **median of a Binary Search Tree (BST)**.  
It follows the GeeksforGeeks-style definition:

- If number of nodes `n` is **odd**, median = `V((n + 1) / 2)`
- If number of nodes `n` is **even**, median = `V(n / 2)`
  
Here, `V1, V2, V3, …, Vn` represent the BST nodes in **ascending order** (inorder traversal).

---

# 🧮 Final Value After Performing Operations

## 📖 Problem Description

There is a programming language with only four operations and one variable `X`:

- `++X` and `X++` increment the value of `X` by **1**.  
- `--X` and `X--` decrement the value of `X` by **1**.  

Initially, the value of `X` is **0**.

Given an array of strings `operations`, return the **final value of `X`** after performing all the operations.

---

## 💡 Example 1

**Input:**
```java
operations = ["--X", "X++", "X++"]
Problem Statement

You are given an integer array nums and two integers k and numOperations.

You can perform at most numOperations operations, and in each operation you can:

Select an index i that has not been selected before.

Add any integer from the range [-k, k] to nums[i].

Your task is to maximize the frequency of any element in the array after performing all operations.

Examples
Example 1
Input: nums = [1, 4, 5], k = 1, numOperations = 2
Output: 2
Explanation:
- Add 0 to nums[1] → nums = [1,4,5]
- Add -1 to nums[2] → nums = [1,4,4]
Maximum frequency = 2

Example 2
Input: nums = [5, 11, 20, 20], k = 5, numOperations = 1
Output: 2
Explanation: Only one operation can be performed. Maximum frequency achievable = 2.

Example 3
Input: nums = [88, 53], k = 27, numOperations = 2
Output: 2
Explanation:
- 88 → 70 (−18)
- 53 → 70 (+17)
Both elements become 70. Frequency = 2

Example 4
Input: nums = [1, 90], k = 76, numOperations = 1
Output: 1
Explanation:
No two numbers can be made equal with just one operation.

Approach

Compute a frequency array for all numbers in nums.

Compute cumulative sums to quickly calculate the number of elements in any range.

For each possible target value:

Determine how many elements can be converted to this target using ±k.

Limit the number of conversions by numOperations.

Track the maximum frequency achievable.

Return the maximum frequency.
