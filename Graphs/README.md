# 📘 Graph Problems

This folder contains my solutions for graph-based problems in Java.

## ✅ Solved Problems

| Problem Name     | Technique | File                    |
|------------------|-----------|-------------------------|
| Rotten Oranges   | BFS       | RottenOranges_BFS.java  |

Each file includes comments explaining the logic and time/space complexity.

# 🔄 Cycle Detection in an Undirected Graph (Java)

## Problem
Given an undirected graph with `V` vertices and `E` edges, determine whether the graph contains a cycle.

- Input: `V` (number of vertices), `edges[][]` (edge list)
- Output: `true` if the graph contains a cycle, otherwise `false`

---
# Cycle Detection in an Undirected Graph (Java)

This project implements **cycle detection in an undirected graph** using **Breadth-First Search (BFS)**.

The algorithm checks all connected components of a graph and returns whether a cycle exists.

---

## 📌 Algorithm

1. Build an **adjacency list** from the given edges.
2. For each unvisited node:
   - Run **BFS**, keeping track of `(node, parent)`.
   - If we encounter a visited neighbor that is **not the parent**, a cycle exists.
3. If no such case is found in any component, the graph is cycle-free.
