public class ChineseCheckerGroup7Agent implements BoardGameAgent {
	final int maximumExpansionCount;

	ChineseCheckerGroup7Agent(int maximumExpansionCount) {
		this.maximumExpansionCount = maximumExpansionCount;
	}

	@Override
	public int estimateDepth(BoardState boardState, Player player) {
		//counting unallocated pin number
		ChineseCheckerState chineseCheckerState = (ChineseCheckerState) boardState;
		int boardSize = chineseCheckerState.boardSize;

		int PlayerOneFinishLength = 0;
		int PlayerTwoFinishLength = 0;
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if (chineseCheckerState.get(x, y) == Player.One) {
					PlayerOneFinishLength += Math.abs(y - (boardSize - 1));
					PlayerOneFinishLength += Math.abs(x - (boardSize - 1));
				}else{
					PlayerTwoFinishLength += Math.abs(y - 0);
					PlayerTwoFinishLength += Math.abs(x - 0);
				}
			}
		}
		//by finding the average of the distances of the stones to the finish line, we can estimate the depth
		return (PlayerOneFinishLength + PlayerTwoFinishLength);
	}

	@Override
	public long estimateExpansionCount(BoardState boardState, int m, Player player) {
		ChineseCheckerState chineseCheckerState = (ChineseCheckerState) boardState;
		int boardSize = chineseCheckerState.boardSize;
		int legalMoves = 0;
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if (chineseCheckerState.get(x, y) == player) {
					legalMoves += chineseCheckerState.getMovements(chineseCheckerState, player, x, y).size();
				}
			}
		}
		//by finding the average of the distances of the stones to the finish line, we can estimate the depth
		return Math.max((long) Math.pow(legalMoves, m), maximumExpansionCount);
	}

	@Override
	public double getUtility(BoardState board, Player player) {
		// utility 1
		// System.out.println(board);
		int[] arr = chooseUtilPoint(board, player);
		ChineseCheckerState chineseCheckerState = (ChineseCheckerState) board;
		int boardSize = chineseCheckerState.boardSize;

		int distX = 0;
		int distY = 0;
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if (chineseCheckerState.get(x, y) == player) {
					distX += Math.abs(y - arr[0]);
					distY += Math.abs(x - arr[1]);
				}
			}
		}

		// return distX + distY;
		double utility1 = 1.0 / (1.0 + distX + distY);

		// utility 2
		Player opponent = player.getOpponent();

		int playerSCount = 0;
		int enemyScount = 0;

		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if (chineseCheckerState.get(x, y) == player
						&& chineseCheckerState.initialBoardCells[y][x] == opponent) {
					playerSCount++;
				}

				if (chineseCheckerState.initialBoardCells[y][x] == player
						&& chineseCheckerState.get(x, y) == opponent) {
					enemyScount++;
				}
			}
		}

		double utility2 = (1.0 + playerSCount) / (1.0 + enemyScount);

		// combined utility
		double combinedUtility = (1.0 + utility1) * (1.0 + utility2);

		return combinedUtility;
	}

	public int[] chooseUtilPoint(BoardState board, Player player) { // mesafesi ölçülen noktayı seçiyor
		int[] arr = new int[2];
		ChineseCheckerState chineseCheckerState = (ChineseCheckerState) board;
		int boardSize = chineseCheckerState.boardSize;
		// mesafesi ölçülen noktayı seçiyor
		int stoneCount = (boardSize / 2) - 1;
		// BoardSize EVEN
		if (player == Player.One) {// BLUE STONE
			for (int i = boardSize - 1; i > boardSize - stoneCount - 1; i--) {
				for (int j = boardSize - 1; j > boardSize - stoneCount - 1; j--) {
					if (chineseCheckerState.get(j, i) == null) {
						arr[0] = i;
						arr[1] = j;
						return arr;
					}
				}
			}
		} else {// RED STONE
			for (int i = 0; i < stoneCount - 1; i++) {
				for (int j = 0; j < stoneCount - 1; j++) {
					if (chineseCheckerState.get(i, j) == null) {
						arr[0] = i;
						arr[1] = j;
						return arr;
					}
				}
			}
		}
		if (player == Player.One) {
			arr[0] = boardSize - 1;
			arr[1] = boardSize - 1;
		} else {
			arr[0] = 0;
			arr[1] = 0;
		}
		return arr;
	}

	@Override
	public String toString() {
		return "Group7 Agent   200 < IQ";
	}
}
