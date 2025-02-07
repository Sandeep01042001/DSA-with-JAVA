import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String str = "9-5+4*3/6";
		infixElea(str);
	}
	public static void infixElea(String str){
		Stack<Integer> val = new Stack<>();
		Stack<Character> op = new Stack<>();
		for(int i=0;i<str.length(); i++){
			char ch = str.charAt(i);
			int acsii = (int)ch;
            if(acsii>=48 && acsii<=57){
				val.push(acsii-48);
			}else if(op.size()==0){
				 op.push(ch);
			}else{
				if(ch == '+' || ch == '-'){
					int v2 = val.pop();
					int v1 = val.pop();
					if(op.peek()=='+') val.push(v1+v2);
					if(op.peek()=='-') val.push(v1-v2);
					if(op.peek()=='*') val.push(v1*v2);
					if(op.peek()=='/') val.push(v1/v2);
					op.pop();
					op.push(ch);
				}
				if(ch == '*' || ch == '/'){
					if(op.peek()=='*' || op.peek()=='/'){
						int v2 = val.pop();
					    int v1 = val.pop();
					    if(op.peek()=='*') val.push(v1*v2);
					    if(op.peek()=='/') val.push(v1/v2);
						op.pop();
						op.push(ch);
					}else{
						op.push(ch);
					}
				}
			}
		}
		while(val.size()>1){
			int v2 = val.pop();
			int v1 = val.pop();
			if(op.peek()=='+') val.push(v1+v2);
			if(op.peek()=='-') val.push(v1-v2);
			if(op.peek()=='*') val.push(v1*v2);
			if(op.peek()=='/') val.push(v1/v2);
			op.pop();
		}
		System.out.print(val.peek());
	}
}