import java.io.*;
import java.util.*;

class StackQueue
{
    Stack<Integer> mainSt = new Stack<>();
    Stack<Integer> helper = new Stack<>(); 
    void Push(int x)
    {
	   mainSt.push(x);
	  
    }
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        if(mainSt.size()==0){
            return -1;
        }
	   while(mainSt.size()>1){
         int val = mainSt.pop();
         helper.push(val);
       }
       int popVal = mainSt.pop();
       while(helper.size()!=0){
         mainSt.push(helper.pop());
       }
       return popVal;
	    
    }
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);  
        StackQueue s = new StackQueue();	
        int q = sc.nextInt();
        ArrayList<Integer> ans= new ArrayList<>();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1)
            {
                int a = sc.nextInt();
                s.Push(a);
            }
            else if(QueryType == 2)
            ans.add(s.Pop());
        q--;
        }	
        for(int x:ans)
        System.out.print(x+" ");       
     System.out.println();
    }
}
