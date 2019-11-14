object GameOfLife{ 

	def isAlive(alive: Boolean, numberOfLiveNeighbors: Int) =
	  alive && numberOfLiveNeighbors == 2 || numberOfLiveNeighbors == 3

}
