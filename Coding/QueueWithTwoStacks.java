/*
  
  2 Stacks - - 

  1st stack used for enqueueing 
  on 1st deque, pop all elements and push onto 2nd stack
  Pop 2nd stack once and return the value
  Sunbsequent enqueues can be done on the 1st stack
  Subsequent dequeues can be easily done on the 2nd stack
  Once 2nd stack is empty, again dump the entire 1st stack onto 2nd and process repeats
  
  Deque: Double ended queue. Can be used for implementing both Queues and Stacks.
  
*/

import java.util.*;

public static  class QueueToStacks{
    private Deque<Integer> inStack=new ArrayDeque<Integer>();
    private Deque<Integer> outStack=new ArrayDeque<Integer>();

    public void enqueue(int item){
        inStack.push(item);
    }

    public int dequeue(){
        if(!outStack.isEmpty()){
            outStack.pop();
        }

        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }

        if(outStack.isEmpty()){
            throw new NoSuchElementException("Can't dequeue from empty queue!");
        } 

        return outStack.pop();
    }


}
