# N-queens problem solution

Need to place N queens on an NxN chess board so that none of them attack each other (the classic n-queens problem).

## Approach

Backtracking approach was used. We check if queen could be placed in the given position. If not program goes back and tries another not-checked position.
There are three main steps: 
- check position: Check if queen could be placed.
- step forward: Update counters, prepare for next check.
- step backward: Update counters, prepare for next check.

There are some assumptions and optimizations were made in order to speed up calculations.

## Optimization

Solution should check if queen could be placed on the field each step. It could be done by checking vertical, horizontal 45 and 135 degree lines.
There are several optimisations that increase processing speed a lot:
- The one-dimensional array is used to describe queens field. Index is a column value is a row. With this optimization guarantee that there will be only one queen in the column. 
- To be sure there are no two queens in the same horizontal line we should be sure there are no identical values inside queens field array. The fastest way is to store values in the hash set and use it to check on the each step. 
- In order to place queen correctly program also needs to check 45 and 135 degree diagonal lines. We can use two boolean arrays for such purposes: one for 45 degree lines, another one for 135 degree lines.
Each item of such arrays describes one diagonal line: false means there are no items, true there is one item placed. We can use such approach to fast checking if queen could be placed on the field or not.

## Additional conditions
 We need to be sure no three queens are in a straight line at ANY angle, so queens on A1, C2 and E3, despite not attacking each other, form a straight line at some angle.
 
### Approach
In order to make this possible we should modify backtracking procedure. We need to check if three queens are in one line. 
There could be a lot of lines, so before actual process start we should create specific 2d array that will help us to check 
this condition. This array contains dots and each dot contains all possible lines that could be drown through this dot.
Also, this array and lines should satisfy following conditions:
- Each item of such 2d array contains either null or at least one line object.
- Each line object linked to several 2d array items
- Each line contains the number of queens that were already placed on that line.

Each step we have actual coordinates to check, so with such array program can figure out if we should place new dots on queens field or not.  

#### ArrayList vs LinkedList for lines
Each specific 2d array coordinate contains a list of line objects to check. There were two alternatives for such list:arrayList or LinkedList. ArrayList implementation gives better performance for for-each operations.

#### MultiKeyMap vs 2d array 
There were two alternatives for diagonal fields implementation: Apache MultiKeyHash Map or generic array. Generic array gives better a performance comparing to MultiKeyMap.
#### Line reflections
There are also reflected lines or lines with similar angle going through a given coordinate. We can remove or ignore such duplicates and significantly increase overall speed. 

## Usage

In order to run you can simply type 
```
gradlew run 
```

Solution will use default parameters (chess field size = 9, dots = 3) and return you binary array with queens positions or message `There is no solution for given parameters`

Our program contains two parts such as parameters initialization and field actual check. 
After the execution it will return time spent for both parts. This will help to analyze complexity and tune up the solution. 

Solution also contains basic unit tests, in order to run them:
```
gradlew test
```
Tests report will be placed into `report` folder. 

We can also specify different N or different dots count (for example if we want `no 5 dots in a line for N = 10`)


for Windows
```
gradlew run --args="--n 10 -dots 5"
```
for Linux based systems
```
gradlew run --args='--n 10 -dots 5'
```
