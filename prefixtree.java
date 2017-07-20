package daa;

public class prefixtree {
	//String pr;
	int port;
	//prefixtree left,right;
	 static prefixtree root=null;
		String data;
		prefixtree left=null;
		prefixtree right=null;
		prefixtree pt,ft;
		
		@SuppressWarnings("null")
		prefixtree insert(String p,prefixtree n,prefixtree point,int port)
		{
			if(root==null)
			{ System.out.print("in pt "+n+" "+point);
			   //n=new prefixtree();
				n.data=p;
				n.left=null;
				n.right=null;
						n.port=port;;
				root=n;
				ft=root;
				point=n;
				 System.out.print("in pt "+n+" "+root);
				 return point;
			}
			else
			{
				
				pt=root;
			ft=root;
				for(int k=0;k<p.length();k++)
				{
					System.out.println(p.length());
					if(p.charAt(k)=='0')
					{
						System.out.println("left "+pt.data+" "+p.charAt(k));
						ft=pt;
						pt=pt.left;
						
						if(pt==null)
						{
							System.out.println("done");
							//prefixtreeinsert n=new prefixtreeinsert();
							pt=new prefixtree();
							pt.data=p;
							pt.port=port;
							pt.left=null;
							pt.right=null;
							ft.left=pt;
							ft=pt;
							System.out.println(pt);
							//pt=n;
							break;
						}
					}
					if(p.charAt(k)=='1')
					{
						System.out.println(pt.data+" "+p.charAt(k));
						ft=pt;
						pt=pt.right;
						//ft=pt;
						if(pt==null){
							System.out.println("done");
							//prefixtreeinsert n=new prefixtreeinsert();
							pt=new prefixtree();
							pt.data=p;
							pt.port=port;
							pt.left=null;
							pt.right=null;
							ft.right=pt;
							ft=pt;
							break;
							
						}
					}
				}
			}
			return point;
		}
		
		//static search root=null;
		//String data;
		//search left=null;
		//search right=null;
		//search pt,ft;
		static int k=0;

	int pt_search(String DA,prefixtree r ){
			int max=-1;
			prefixtree t=r;
			int maxlen=0;
		if(r==null)
			return -1;
		while(t!=null){
		if(DA.startsWith(t.data)){
			//System.out.println(r.data);
			if(maxlen<t.data.length()){
				maxlen=t.data.length();
				max=t.port;
				//System.out.println(max);
			}
			//return t;
		}
		
			//pt=root;
			if(DA.charAt(k)=='0'&&k<DA.length()-1){
				k++;
				//System.out.println("l "+t.left);
				t=t.left;
			}
			else if(DA.charAt(k)=='1'&&k<DA.length()-1){
				k++;
				//System.out.println("r "+t.right);
				t=t.right;
			}
		}
		return max;
	}


		void print(prefixtree r){
			
			if(r==null){
				//System.out.println(null);
				return;
			}
			//System.out.println("pt ");	
			print(r.left);
			System.out.println(r.data+" ");
			print(r.right);
		}

}
