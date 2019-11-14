import scala.sys.process._

object GameOfLife{ 

//Feedback: remove unnecessary ()
	def isAlive(alive: Boolean, numberOfLiveNeighbors: Int) = {
	  alive && numberOfLiveNeighbors == 2 || numberOfLiveNeighbors == 3
	}
	
	def generateSignals(liveCell: (Int, Int)) = {
	  val (x, y) = liveCell
	  List((x - 1, y - 1), (x - 1, y), (x - 1, y + 1), (x, y - 1),
		   (x, y + 1), (x + 1, y - 1), (x + 1, y), (x + 1, y + 1))
	}
	
	def generateSignalsForAllLiveCells(liveCells: List[(Int, Int)]) = {
	  liveCells.map(generateSignals).reduce((list1, list2) => List1 ::: List2)
	  //Feedback: what does x and y mean here?
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
	
	def clearScreen = {
	  val osName = System.getProperty("os.name").toLowerCase();
	  if(osName.contains("win")) {
		Process("cls")
	  } else {
		Process("clear")
	  }
	}
	
	def display(liveCells: List[(Int, Int)]) = {
	  print("\u001b[2J") // to clear screen
	  println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
	  val x = for (e <- liveCells) yield e._1
	  val y = for (e <- liveCells) yield e._2
	  val min_ = List(x.min, y.min).min
	  val max_ = List(x.max, y.max).max
	  for(i <- min_ to max_ + 1){
	    println((for(j <- min_ to max_ + 1) yield {if(liveCells.contains((i, j))){'X'} else{' '} }).mkString(""))  
	  }
	  Thread.sleep(1000)
	}
	
	def main(args: Array[String]) {
      println("Game Of Life!")
    }
	
}
