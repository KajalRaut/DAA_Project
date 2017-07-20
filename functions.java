package daa;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class functions {

	 mpt v;
	int k=2;
	public mpt mpt_create()
	{
		System.out.println(0);
		v=new mpt();
		
		if(mpt.c==0)
		{mpt.root=v;
		mpt.c++;
		}
		return v;
	}

	public void mpt_insert(String p,mpt v,int level,int port)
	{if(v==null)
	{
		System.out.println(1);
		v=mpt_create();
		System.out.println(v);
	}
		
	if(in_pt(p.length(),level))
	{
		System.out.println(2);
		prefixtree u=new prefixtree();
		v.pt=pt_insert(p,u,v.pt,port);
		// System.out.print("pt "+u+" "+v.pt);
	}
	else if(is_full(v))
	{
		System.out.println(3+"full"+v.p[v.t-2]);
		
		
		if(v.p[v.t-1].length()<p.length())
		{System.out.println(4);
			String t;
			t=v.p[v.t-1];
			v.p[v.t-1]=p;
			 for(int i=0;i<v.t;i++)
			 {
				 System.out.println(v.p[i]);
			 }
			//Arrays.sort(v.p,Collections.reverseOrder());
			 Arrays.sort(v.p, new Comparator<String>() {
			        public int compare(String a, String b) {
			            return Integer.compare(b.length(),a.length());//specifying compare type that is compare with length
			        }
			    });
			 for(int i=0;i<v.t;i++)
			 {
				 System.out.println(v.p[i]);
			 }
			 int r=get(t,k*level,k*(level+1)-1);
			 mpt z=v;
			 v=v.child[r];
			 System.out.println("v value"+v);
			 
			 mpt_insert(t,v,level+1,z.portp[z.t-1]);
			 
		}
		else
		{System.out.println(5);
			int r=get(p,k*level,k*(level+1)-1);
			 v=v.child[r];
			 mpt_insert(p,v,level+1,port);
		}
			
	}
	else{
		//System.out.println(mpt.m);
		
		System.out.println(6);
		v.p[v.t]=p;
		v.portp[v.t]=port;
		v.t++;
		
	}
	}
	
	public Boolean in_pt(int l,int level){
		if(l<k*(level+1)){
			System.out.println(7);
			return true;	
		}
		System.out.println(8);
		return false;
	}

	public Boolean is_full(mpt v){
		System.out.println(mpt.m+" "+(v.t));
		if(v.t==mpt.m){
			System.out.println(9);
			return true;
		}
		System.out.println(10);
		return false;
	}
	
	public int get(String p,int i,int j){
		System.out.println(11);
		String sub=p.substring(i, j);
		int d=Integer.parseInt(sub,10);
		
		return d;
		
	}
	
	public prefixtree pt_insert(String p,prefixtree u,prefixtree vs,int port){
		prefixtree o=new prefixtree();
		vs=o.insert(p,u,vs,port);
		
		 //System.out.print("in pt "+u+" "+vs);
		 return vs;
	}
	
	static Queue<mpt> q=new LinkedList<mpt>();
	 int x=0;
	public void print(mpt r)
	{prefixtree o=new prefixtree();
		if(r==mpt.root)
			q.add(r);
		 
		
				if(!q.isEmpty())
				{
					//System.out.println("level "+(x++));
					for(int j=0;j<r.t;j++)
					{
						System.out.print("\n"+r.p[j]+"\t");
					}
					System.out.println( "pt ");
					o.print(r.pt);
					for(int i=0;i<4;i++)
					{
						if(r.child[i]!=null)
						q.add(r.child[i]);
					}
					q.remove();
					print(q.peek());
					//r=q.peek();
					
				}
		
	}
	
	public int pt_lookup(String DA,prefixtree v)
	{
		prefixtree o=new prefixtree();
		int r=o.pt_search(DA, v);
	return r;	
	}
	
	
	
	
	
	
	
	
	
	public int search(String DA,mpt v,int level)
	{
		int default_route=9999;
		level=0;
		int next_hop=default_route,flag=0;
		while(v!=null)
		{
			int max=0;
			for(int i=0;i<v.t;i++){
				if(DA.startsWith(v.p[i])){
					max=v.portp[i];
					next_hop=max;
					flag++;
					//break;
					return next_hop;
				}
			}
			if(flag==0){
				next_hop=pt_lookup(DA,v.pt);
				if(next_hop==-1)
					next_hop=default_route;
				int r=get(DA,k*level,k*(level+1)-1);
				v=v.child[r];
				level+=1;
			}	
		}
		return next_hop;
	}
	
	
	
}
