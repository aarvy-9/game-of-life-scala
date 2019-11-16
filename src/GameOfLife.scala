object GameOfLife{ 

	def isAlive(alive: Boolean, numberOfLiveNeighbors: Int) = {
	  alive && numberOfLiveNeighbors == 2 || numberOfLiveNeighbors == 3
	}
	
	def generateSignals(liveCell: (Int, Int)) = {
	  val (x, y) = liveCell
	  List((x - 1, y - 1), (x - 1, y), (x - 1, y + 1), (x, y - 1),
		   (x, y + 1), (x + 1, y - 1), (x + 1, y), (x + 1, y + 1))
	}
	
	def generateSignalsForAllLiveCells(liveCells: List[(Int, Int)]) = {
	  liveCells.map(generateSignals).reduce(_ ::: _)
	}
	
	def countSignals(signals: List[(Int, Int)]) = {
	  signals.groupBy(cell => cell).mapValues(_.length)
	}
	
	def nextGeneration(liveCells: List[(Int, Int)]) = {
	  val allLiveSignals = generateSignalsForAllLiveCells(liveCells)
	  val signalCount = countSignals(allLiveSignals)
	  signalCount.filter{ 
	    case (cell, count) => isAlive(liveCells.contains(cell), count)
	  }.keys.toList
	}
	
	def display(liveCells: List[(Int, Int)]) = {
	  print("\u001b[2J")
	  println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
	  val xAxis = for (e <- liveCells) yield e._1
	  val yAxis = for (e <- liveCells) yield e._2
	  val min_ = List(xAxis.min, yAxis.min).min
	  val max_ = List(xAxis.max, yAxis.max).max
	  for(i <- min_ to max_ + 1){
	    println((for(j <- min_ to max_ + 1) yield {
		  if(liveCells.contains((i, j))){'X'} else{' '} 
		  }).mkString(""))  
	  }
	  Thread.sleep(1000)
	}
	
	def gameOfLife(liveCells: List[(Int, Int)]) : List[(Int, Int)] = {
	  display(liveCells)
	  nextGeneration(liveCells)
	}
	
	def main(args: Array[String]) {
	  val liveCells = List((0, 1), (1, 1), (2, 1))
	  Stream.from(1).foldLeft(liveCells) { (liveCells, e) => gameOfLife(liveCells) }	
    }
}
