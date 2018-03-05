# Stack
Java implementation of a stack

Usage: java Stack `<name of file with commands>`

All commands must be provided as a space-separated list in a text file. An example file, stackTest.txt, has been included in the repository.

Commands:
* Push a node with value of `key` onto the head of the stack - use "key.push"  
* Pop a node off the head of the stack - use "pop"

The first entry in the command file MUST be an integer that specifies the size of the stack.

Entries that exceed the size of the stack will be ignored.

Example: `5 1.push 2.push 3.push 4.push 5.push pop 6.push 7.push`

The output will be `6 4 3 2 1`
  
Only integers are allowed as keys. 

The updated stack will be output to the command line after each command. 

