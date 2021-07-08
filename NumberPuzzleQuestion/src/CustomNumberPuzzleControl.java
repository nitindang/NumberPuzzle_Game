import java.awt.*;
import java.util.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		int idx=0;
		for(int i=0;i<buttons.length;i++){
			if(buttons[i]==buttonClicked){
				idx=i;
				break;
			}
		}
		if(Math.abs(idx-emptyCellId)==1 || Math.abs(idx-emptyCellId)==4)
		{
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId=idx;
		}

		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		while(numbers.size()!=15) {
			int a = getRandomNumber();
			a=a%16;
			if(a!=0 && !numbers.contains(a)) {
				numbers.add(a);
			}
		}
		for(int i=0;i<arr.length;i++) {
			arr[i]=numbers.get(i);
		}

		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int [] buttonids=getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<buttonids.length;i++){
			if((i + 1) == buttonids[i]){
				continue;
			}
			else{
				winner=false;
				break;
			}
		}

		return winner;
	}
}