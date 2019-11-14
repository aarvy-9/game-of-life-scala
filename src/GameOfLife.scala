object GameOfLife{ 

	def isAlive(alive: Boolean, numberOfLiveNeighbors: Int) = {
	  (alive && numberOfLiveNeighbors == 2) || numberOfLiveNeighbors == 3
	}
	
	def generateSignals(liveCell: (Int, Int)) = {
	  val (x, y) = liveCell
	  List((x - 1, y - 1), (x - 1, y), (x - 1, y + 1), (x, y - 1),
			(x, y + 1), (x + 1, y - 1), (x + 1, y), (x + 1, y + 1))
	}
	
	def generateSignalsForAllLiveCells(liveCells: List[(Int, Int)]) = {
	  liveCells.map(generateSignals).reduce((x, y) => x ::: y)
	}
	
	def countSignals(signals: List[(Int, Int)]) = {
	  signals.groupBy(cell => cell).mapValues(_.length)
	}
}
