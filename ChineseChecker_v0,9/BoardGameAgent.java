// Change class name with your group name. 
// For example for group 'Eagles': EaglesChineseCheckerState instead of ChineseCheckerState

interface BoardGameAgent {

	abstract public int estimatedDepth(BoardState boardState);
	
	abstract public long estimatedExpansionCount(BoardState boardState, int m);
	
	abstract public double getUtility(BoardState boardState, Player player);
	
}
