//everything should work
//compiles with eclipse java mars

import java.util.Scanner;

public class MinHeap {
	private Event[] H;
	private int size=0;
	private int max;
	private int r = 1;
	static Scanner in = new Scanner(System.in);
	static boolean Heap = false;
	
	
	private int parent(int x){
		return x/2;
	}
	private int left(int x){
		return (2*x);
	}
	private int right(int x){
		return (2*x);
	}
	private boolean leaf(int x){
		if(x>=(size/2) && x<=size){
			return true;
		}
		return false;
	}
	private void dup(int x, int y){
		Event t;
		t=H[x];
		H[x]=H[y];
		H[y]=t;
	}
	public void buildHeap(){
		for(int x = (size/2); x>=1;x--){
			sort(x);
		}
		Heap = true;
	}
	public void sort(int x){
		if(!leaf(x)){
			if(H[x].getTime()>H[left(x)].getTime() || H[x].getTime()>H[right(x)].getTime()){
				if(H[left(x)].getTime()<H[right(x)].getTime()){
					dup(x, left(x));
					sort(left(x));
				}else
				{
					dup(x, right(x));
					sort(right(x));
				}
			}
		}
	}
	
	void insert(Event e){
		
		/*H[size++]=e;
		
		int c = size;
		while(H[c].getTime()<H[parent(c)].getTime()){
			dup(c, parent(c));
			c=parent(c);*/
		this.add(e);
		this.sort(size);
		
	}
	public void printH(){
		for(int i = 0; i<H.length; i++){
			
				H[i].printshort();
				
			}
		}
	
	public Event deleteMin(){
		Event e =H[0];
		Event[] p = new Event[H.length-1];
		size--;
		for(int i=0;i<p.length;i++){
			p[i]=H[i+1];
		}
		H=p;
		return e;
	}
	void add(Event e){
		
		if(H[0]==null){
			 
			 H[0]=e;
			 size++;
			 
		}
		else{
		 int x = H.length;
				size++;
		Event[] p = new Event[size];
		for(int i = 0; i<H.length; i++){
			p[i]=H[i];
		}
		p[x]=e;
		H=p;
		
		} 
		
		}
	boolean isEmpty(){
		if(this.size==0){
			return true;
		}
		return false;
	}
	public static void main(String[] args){
		MinHeap m = new MinHeap();
		m.H = new Event[1];
		String x = "8";
		while(!x.equalsIgnoreCase("6")){
		System.out.println("1.Add event\n"+"2.insert\n"+"3.Print Array\n"+
				"4.Build Heap\n"+"5.Delete min\n"+"6.Quit\n");
		 		x = in.nextLine();
		if(x.equalsIgnoreCase("1")){
			if(Heap==false){ //if buildheap not yet executed
				System.out.println("What type of event? 1 for Arrival, 2 for EndOfService, 3 for Termination.\n");
				String y = in.next();
				if(!y.equalsIgnoreCase("1")&& !y.equalsIgnoreCase("2") && !y.equalsIgnoreCase("3")){ //if not valid
					System.out.println("That is not a valid event type.");
				}
				else if(y.equalsIgnoreCase("1")){ //if 1
					System.out.println("What time?"); 
					String at = in.next();
					Arrival e = new Arrival(); //new arrival
					e.setTime(Double.parseDouble(at));
					
					m.add(e); //add arrival
				}
				else if(y.equalsIgnoreCase("2")){ //if 2
					System.out.println("What time?");
					String et = in.next();
					EndOfService e = new EndOfService(); //new eos
					e.setTime(Double.parseDouble(et));
					m.add(e); //add eos
				}
				else{
					System.out.println("What time?");
					String tt = in.next();
					Termination e = new Termination(); //new termination
					e.setTime(Double.parseDouble(tt));
					m.add(e); //add termination
				}
			
			}
			else{System.out.println("Can’t add into the heap use insert");}
		} //case 1
		
		else if(x.equalsIgnoreCase("2")){
			if(Heap==false){
				System.out.println("Can’t insert into the heap use build heap first or just add");
			}
			else{
				System.out.println("What type of event? 1 for Arrival, 2 for EndOfService, 3 for Termination.\n");
				String y = in.next();
				if(!y.equalsIgnoreCase("1")&& !y.equalsIgnoreCase("2") && !y.equalsIgnoreCase("3")){
					System.out.println("That is not a valid event type.");
				}
				else if(y.equalsIgnoreCase("1")){
					System.out.println("What time?");
					String at = in.next();
					Arrival e = new Arrival();
					e.setTime(Double.parseDouble(at));
					
					m.insert(e);
				}
				else if(y.equalsIgnoreCase("2")){
					System.out.println("What time?");
					String et = in.next();
					EndOfService e = new EndOfService();
					e.setTime(Double.parseDouble(et));
					m.insert(e);
				}
				else{
					System.out.println("What time?");
					String tt = in.next();
					Termination e = new Termination();
					e.setTime(Double.parseDouble(tt));
					m.insert(e);
				}
			}
		}//case 2
		else if(x.equalsIgnoreCase("3")){
			if(m.H==null){
				System.out.println("nothing here.\n");
			}
			else{
				m.printH();
			}
		}//case 3
		else if(x.equalsIgnoreCase("4")){
			m.buildHeap();
			System.out.println("done.\n");
		}//case 4
		else if(x.equalsIgnoreCase("5")){
			m.deleteMin().print();
		}
		else if(x.equalsIgnoreCase("6")){
			System.exit(0);
		}
		else{
			System.out.println("Command invalid.\n");
		}
	}
}
}
