package daa;

import java.util.Scanner;

public class mpt {
	
	static int c=0;
	 int t=0;
	static int m=2;
	String[] p=new String[m];
	int[] portp=new int[m];
	prefixtree pt;
	mpt[] child=new mpt[4];
	static mpt root=null;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		functions f=new functions();
		int n;
		do
		{
			System.out.println("Enter your choice\n 1. Insert \n 2. Search \n 3. Exit");
			Scanner scan=new Scanner(System.in);
			n=scan.nextInt();
			switch(n)
			{
			
			
			case 1:
				System.out.println( "enter the prefix to be inserted");
				String p=scan.next();
				System.out.println("enter the port no.");
				int port=scan.nextInt();
				f.mpt_insert(p, mpt.root,0, port);
				System.out.println("the mpt is:");
				//System.out.println(mpt.root+" "+mpt.root.p[0]);
				f.print(mpt.root);
				break;
			case 2:
				System.out.println("enter the destination address\n");
				String Da=scan.next();
				System.out.println("read");
				int res=f.search(Da, mpt.root, 0);
				System.out.println("the longest prefix is :"+ res);
				break;
			case 3:
				break;
			}
		}while(n!=3);
		

	}

}
