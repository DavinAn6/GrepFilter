# Grep Filter

### Translation
[한국어](https://github.com/DavinAn6/GrepFilter/blob/main/README.kor.md)

## Description
"The `grep` command in Unix/Linux searches a file for a particular pattern of characters, and displays all lines that contain that pattern. The pattern that is searched in the file is referred to as the regular expression (grep stands for **g**lobal search for **r**egular **e**xpression and **p**rint out)." - IBM command reference

In this project, we implement a Java version of grep. To simplify the project, we only implement one flag (-i).

## Functional Requirements
1. Program is usable as a command line utility
2. Program parses the command line arguments for appropriate parameters
3. Program checks for flag
4. Program searches a user-specified directory hierarchy for a user-specified String
5. The directory is searched recursively
6. Program supports both case-sensitive and insensitive searching
7. Program prints out the results of the search as follows  
`[filename]:[linenumber]:[line containing match]`, with each match on its own line
8. Exception Handling
   - IllegalArgumentException : Command line argument doesn't have enough arguments
   - FileNotFoundException : User passed in a directory name that doesn't exit
   - InvalidSearchStringException : String to search for contains a new line character

## Implementation
- On the command line, the program takes in three arguments
  - An optional `-i` flag to search case-insensitively
  - The string to search for
  - The directory to be run on

### Example
We have a test directory "/books" to search the string "Never again" as follows :  
```java Main -i "Never again" books```

Output :
```
books\A\Austen\Emma.txt:12654:Bates should never again--no, never! If attention, in future, could do
books\A\Austen\PrideAndPrejudice.txt:10948:never again distressed himself, or provoked his dear sister Elizabeth,
books\A\LittleWomen.txt:10289:fever was a thing of the past.  Not an invalid exactly, but never again
books\B\Bronte\JaneEyre.txt:11518:"I will never again come to your side: I am torn away now, and cannot
books\B\Bronte\Villette.txt:1508:departure--little thinking then I was never again to visit it; never
books\B\Bronte\Villette.txt:13725:enlightened him, and taught him well never again to expect of me the
books\B\PeterPan.txt:3672:tree. As so often before, but never again.
books\B\PeterPan.txt:4487:personification of cockiness as, taken together, will never again, one
books\D\TheCountOfMonteCristo.txt:9269:with nothingness! Alone!—never again to see the face, never again to
books\D\TheCountOfMonteCristo.txt:14950:the poor fellow never again set foot in Tunis. This was a useless clause
books\D\TheCountOfMonteCristo.txt:24829:and the money stolen. Benedetto never again appeared at Rogliano,
books\D\TheCountOfMonteCristo.txt:53259:and she should never again see Morrel!
books\D\TheCountOfMonteCristo.txt:60437:Happily, I vanquished death. Henceforth, Valentine, you will never again
books\J\Ulysses.txt:17604:him aside as if he was so much filth and never again would she cast as
books\J\Ulysses.txt:32116:seaside but Id never again in this life get into a boat with him after
books\M\MobyDick.txt:9832:probability would be that he and his shipmates would never again
books\M\MobyDick.txt:19748:But in either case, the needle never again, of itself, recovers the
books\R\TheHistoryOfJava.txt:17344:his power) that he cursed them, and swore that they should never again
books\R\TheHistoryOfJava.txt:18427:Bumi_, that the earth might never again see to attack the heavens, and
books\S\Dracula.txt:2473:never again think that a man must be playful always, and never earnest,
```