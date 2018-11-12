Universal Programming Techniques homework 4

All the tasks have 3 levels of priority. If the first element in the stack is lucky enough and is of the highest priority level (2), it's getting pulled out by the Service thread. If the the first element is of 0 or 1, we increase its priority by one and move it to the end of the stack and try the first element once again.