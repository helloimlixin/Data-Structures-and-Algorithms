# Divide-and-Conquer

In divide-and-conquer, we solve a problem recursively, applying three steps at each level of recursion.

- **Divide** the problem into a number of subproblems that are smaller instances of the same problem.
- **Conquer** the subproblems by solving them recursively. If the subproblems’ sizes are small enough,
however, just solve the subproblems in a straightforward manner.
- **Combine** the solutions to the subproblems into the solution for the original problem.

## Recurrences

A ***recurrence*** is an equation or inequality that describes a function in terms of its value on
smaller inputs.

There are three methods of solving recurrences—that is, for obtaining asymptotic “$\Theta$” or “$O$” bounds:

- **Substitution method**: guess a bound and then use mathematical induction to prove our guess correct.

- **Recursion-tree method**: convert the recurrence into a tree whose nodes represent the costs incurred at various levels of the recursion. We use techniques for bounding summations to solve the recurrence.

- **Master method**: provide bounds for recurrences of the form:

  $$T(n) = aT(n/b) + f(n)$$,

  where $a\geq1$, $b\geq1$, and $f(n)$ is a given function. A recurrence of the form in the above equation characterizes a divide-and-conquer algorithm that creates $a$ subproblems, each of which is $1/b$ the size of the original problem, and in which  the divide and combine steps together take $f(n)$ time.


