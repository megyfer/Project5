
public class Arrival extends Event{
	private double timeOfEvent; 
public void print(){
	String y = toString().valueOf(timeOfEvent);
	if(y.indexOf(".")==2){
		if(y.length()==5){
			y=y;
		}
		else{
			y=y+"0";
		}
	}
	else{
		y="0"+y;
		if(y.length()!=5){
			y=y+"0";
		}
	}
	System.out.println("Arrival Event at time "+y+".\n");
}
public void printshort(){
	String y = toString().valueOf(timeOfEvent);
	if(y.indexOf(".")==2){
		if(y.length()==5){
			y=y;
		}
		else{
			y=y+"0";
		}
	}
	else{
		y="0"+y;
		if(y.length()!=5){
			y=y+"0";
		}
	}
	System.out.println("Arrival:"+y);
}
public void setTime(double t){
	
	 this.timeOfEvent=t;
}public double getTime(){
	 return timeOfEvent;
}
}
