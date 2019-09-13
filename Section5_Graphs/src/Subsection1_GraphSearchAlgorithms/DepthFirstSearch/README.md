# Depth-First Search

## Motivation: Maze Exploration
**Maze Graph**
- Vertex = Intersection.
- Edge = passage connecting intersections.

**Goal** Explore every intersection (vertex in graph) in the maze.

**Algorithm: Trémaux maze exploration**
- Unroll a ball of string behind you.
- Mark each visited intersection and each visited passage.
- Retrace steps when no unvisited options.

## Depth-First Search

**Goal** Systematically search through a graph.

**Idea** Mimic maze exploration.

```pseudocode
DFS (to visit a vertex v)
Mark v as visited.
Recursively visit all unmarked vertices w adjacent to v.
```

**Applications**
- Find all vertices connected to a given source vertex.
- Find a path between two vertices.

## Design Pattern for Graph Processing

**Design pattern** Decouple graph data type from graph processing.

- Create a Graph object `graph`.
- Pass `graph` to a graph-processing routine.
- Query the graph-processing routine for information.

## Depth-First Search Properties

***Proposition*** DFS makrs all vertices connected to $s$ in time proportional
to the sum of their degrees.

**Proof of Correctness**
