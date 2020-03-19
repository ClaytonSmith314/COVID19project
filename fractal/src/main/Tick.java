package main;

import java.util.ArrayList;

public interface Tick {
	public static ArrayList<Object> tickers = new ArrayList<>();
	public static ArrayList<Integer> tickerspriority = new ArrayList<>();
	
	public static int addTicker(Object O, int priority){
		int x;
		if (tickers.size() == 0){
			tickers.add(O);
			tickerspriority.add(priority);
			x = tickers.size();
		}
		else if (priority > tickerspriority.get(tickers.size()-1)){
			tickers.add(O);
			tickerspriority.add(priority);
			x = tickers.size();
		}
		else {
			for (x=0; priority>tickerspriority.get(x); x++);
			tickers.add(x, O); 
			tickerspriority.add(x, priority);
		}
		return x;
	}
	public static void clearTicker(){
		tickers.clear();
	}
	
	public static void tickAll(){
		for(int n = 0; n<tickers.size(); n++){
			((Tick) tickers.get(n)).tick();
		}
	}
	
	public void tick();
}
