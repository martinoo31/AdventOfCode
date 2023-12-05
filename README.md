# AdventOfCode
These solution are in Java and are not optimized for performance, sometimes I forget to create a new file for part 2 so part 1 might be missing for some days. 

### Day 5
__Part 1__
The program parses the seeds and puts them in a Vector of Integers, then it starts cycling through the lines of the file. For each mapping block it reads the mapping lines and if one of the seeds is inside one of the ranges it gets added to the map vector and removed from the seeds vector. At the start of each mapping block the map vector gets copied on the seed vector. After the file is finished the program cycles through the map vector to find the lowest location

__Part 2__
The program parses the seeds ranges and puts them in a Vector of ranges, then it starts cyclying through the lines of the file. For each mapping block it reads the mapping lines and if one the seed ranges partially or totally overlaps with one of the mapping ranges, the overlapping part is added to the map vector, a vector of ranges, while the non overlapping parts are added back to the non mapped ranges vector. After the file ends the program cycles through the map vector to find the lowest range start, which is the lowest location.
