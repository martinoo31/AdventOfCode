# AdventOfCode
These solution are in Java and are not optimized for performance, sometimes I forget to create a new file for part 2 so part 1 might be missing 
some days. 
### Day 2
__Part 1__ The maximun amount of cubes of each color is stored inside a HashMap, then each line of the input file is parsed and for each drawing the values are checked, when the game is deemed valid its added to the result.

__Part 2__ The minimum amoun of cubes of each color is stored inside a HashMap, then each line of the input file is parsed and for each drawing the values are checked, it the amount of cubes of a spcefic color is greater than the value stored in the HashMap, the map entry is updated. When all line drawing rounds are validated the power of the game is calculated and added to the result.

### Day 3
__Part 1__ Not Available

__Part 2__ The input text is parsed and put inside a 2D Array of chars. Two innested loops cycle through the matrix and evaluate whether a number is valid(it is adjacent to a gear(* star character)), if the number is valid an entry it gets stored in a Integer List which in turn is stored as a value in a HashMap, the key for the map is the object Coppia, a Java object containing the coordinates of the gear associated to that list. This means that a number can be associated to multiple gears. After looping through the matrix, each gear that has exactly two valid numbers is calculated and added to the result.


### Day 4
__Part 1__ Not Available

__Part2__ The program uses an ArrayList of Integers to memorize the how many of each scratchcards there are. For each line of the input text which correspond to a scratchcard the winning numbers and the card numbers are parsed, the number of matches is saved in a variable which is used to modify the values of the ArrayList. After processing all input lines all the ArrayList values are summed and the result is returned.

### Day 5
__Part 1__
The program parses the seeds and puts them in a Vector of Integers, then it starts cycling through the lines of the file. For each mapping block it reads the mapping lines and if one of the seeds is inside one of the ranges it gets added to the map vector and removed from the seeds vector. At the start of each mapping block the map vector gets copied on the seed vector. After the file is finished the program cycles through the map vector to find the lowest location.

__Part 2__
The program parses the seeds ranges and puts them in a Vector of ranges, then it starts cyclying through the lines of the file. For each mapping block it reads the mapping lines and if one the seed ranges partially or totally overlaps with one of the mapping ranges, the overlapping part is added to the map vector, a vector of ranges, while the non overlapping parts are added back to the non mapped ranges vector. After the file ends the program cycles through the map vector to find the lowest range start, which is the lowest location.

### Day 6
__Part 1__
The program parses all the race durations and distances to beat than for each race it calculates all possible outcomes and keeps only the one greater than the distance to beat. At the end the valid number of races are multiplied together

__Part 2__
The program is the same only the input text was manually changed to match the second part requirements.
