# Divide-and-Conquer

In divide-and-conquer, we solve a problem recursively, applying three steps at each level of recursion.

- **Divide** the problem into a number of subproblems that are smaller instances of the same problem.
- **Conquer** the subproblems by solving them recursively. If the subproblems’ sizes are small enough,
however, just solve the subproblems in a straightforward manner.
- **Combine** the solutions to the subproblems into the solution for the original problem.

## Recurrences

A ***recurrence*** is an equation or inequality that describes a function in terms of its value on
smaller inputs.

There are three methods of solving recurrences—that is, for obtaining asymptotic “$\Theta$” or “$O$”:

- 