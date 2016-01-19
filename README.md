# wires-and-bitwise-logic-gates
Day 7: Some Assembly Required ---  wires and bitwise logic gates!

Step #1: Puzzle input stored as input.txt file under wires-and-bitwise-logic-gates\src\main\resources\com.exercise.part1\input.txt.
         Client Main.java class created.
         Read from input file mechanism created.

Step #2.1: Input file parsing mechanism created (based on Java regex).
         Bitwise Operation Executor created.
         Hashtable<String,Integer> wiresSignal will store bitwise operations results, key is a wire identifier, value is a signal (0<=signal<=65535)

Step #2.2: UT + testing resources

TODO in step #3: Required solution to handle situation when operation is performed on variables which are not defined/assigned yet (file content sore? Event listener?)

Step #3: The issue described in TODO solved by using Observer pattern.

Step #4: Gradle support added to the project.
