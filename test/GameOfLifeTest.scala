import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class GameOfLifeTest extends FunSuite {

	test("Live cell one neighbor") {
	  val expectedResult = false
	  val actualResult = GameOfLife.isAlive(true, 1)
	  assert(actualResult == expectedResult)
	}
	
	test("Live cell four neighbor") {
	  val expectedResult = false
	  val actualResult = GameOfLife.isAlive(true, 4)
	  assert(actualResult == expectedResult)
	}
	
	test("Live cell two neighbor") {
	  val expectedResult = true
	  val actualResult = GameOfLife.isAlive(true, 2)
	  assert(actualResult == expectedResult)
	}
	
	test("Live cell three neighbor") {
	  val expectedResult = true
	  val actualResult = GameOfLife.isAlive(true, 3)
	  assert(actualResult == expectedResult)
	}
	
	test("Dead cell one neighbor") {
	  val expectedResult = false
	  val actualResult = GameOfLife.isAlive(false, 1)
	  assert(actualResult == expectedResult)
	}
	
	test("Dead cell four neighbor") {
	  val expectedResult = false
	  val actualResult = GameOfLife.isAlive(false, 4)
  	  assert(actualResult == expectedResult)
	}
	
	test("Dead cell two neighbor") {
	  val expectedResult = false
	  val actualResult = GameOfLife.isAlive(false, 2)
  	  assert(actualResult == expectedResult)
	}
	
	test("Dead cell three neighbor") {
	  val expectedResult = true
	  val actualResult = GameOfLife.isAlive(false, 3)
	  assert(actualResult == expectedResult)
	}
	
	test("Generate Signals for cell (2, 3)") {
	  val expectedResult = List((1, 2), (1, 3), (1, 4), (2, 2),
		(2, 4), (3, 2), (3, 3), (3, 4))
	  val actualResult = GameOfLife.generateSignals((2, 3))
	  assert(actualResult == expectedResult)
	}
	
	test("Generate Signals for cell (1, 4)") {
	  val expectedResult = List((0, 3), (0, 4), (0, 5), (1, 3), 
		(1, 5), (2, 3), (2, 4), (2, 5))
	  val actualResult = GameOfLife.generateSignals((1, 4))
	  assert(actualResult == expectedResult)
	}
	
	test("Generate Signals for cell (0, 0)") {
	  val expectedResult = List((-1, -1), (-1, 0), (-1, 1), (0, -1), 
		(0, 1), (1, -1), (1, 0), (1, 1))
	  val actualResult = GameOfLife.generateSignals((0, 0))
	  assert(actualResult == expectedResult)
	}
	
	test("Generate Signals for all live cells 0") {
	  val liveCells = List((1, 2), (2, 3))
	  val actualResult = List((0, 1), (0, 2), (0, 3), (1, 1), (1, 3), 
		(2, 1), (2, 2), (2, 3), (1, 2), (1, 3), (1, 4), (2, 2),
		(2, 4), (3, 2), (3, 3), (3, 4))
	  val expectedResult = GameOfLife.generateSignalsForAllLiveCells(liveCells)
	  assert(actualResult == expectedResult)
	}
	
	test("Generate Signals for all live cells 1") {
	  val liveCells = List((1, 4), (2, 3), (0, 0))
	  val actualResult = List((0, 3), (0, 4), (0, 5), (1, 3), (1, 5),
        (2, 3), (2, 4), (2, 5), (1, 2), (1, 3), (1, 4), (2, 2), (2, 4),
		(3, 2), (3, 3), (3, 4), (-1, -1), (-1, 0), (-1, 1), (0, -1), 
		(0, 1), (1, -1), (1, 0), (1, 1))
	  val expectedResult = GameOfLife.generateSignalsForAllLiveCells(liveCells)
	  assert(actualResult == expectedResult)
	}
	
	test("Count Signals 0") {
	  val signals = List()
	  val actualResult = Map()
	  val expectedResult = GameOfLife.countSignals(signals)
	  assert(actualResult == expectedResult)
	}
	
	test("Count Signals 1") {
	  val signals = List((1, 2))
	  val actualResult = Map((1, 2) -> 1)
	  val expectedResult = GameOfLife.countSignals(signals)
	  assert(actualResult == expectedResult)
	}
	
	test("Count Signals 2 at same position") {
	  val signals = List((1, 2), (1, 2))
	  val actualResult = Map((1, 2) -> 2)
	  val expectedResult = GameOfLife.countSignals(signals)
	  assert(actualResult == expectedResult)
	}
	
	test("Count Signals 3 with 2 at same position") {
	  val signals = List((1, 2), (2, 1), (1, 2))
	  val actualResult = Map((1, 2) -> 2, (2, 1) -> 1)
	  val expectedResult = GameOfLife.countSignals(signals)
	  assert(actualResult == expectedResult)
	}
	
	test("Next Generation with single live cell") {
	  val liveCells = List((0, 0))
	  val actualResult = List()
	  val expectedResult = GameOfLife.nextGeneration(liveCells)
	  assert(actualResult == expectedResult)
	}
	
	test("Next Generation with two live cell") {
	  val liveCells = List((0, 0), (0, 1))
	  val actualResult = List()
	  val expectedResult = GameOfLife.nextGeneration(liveCells)
	  assert(actualResult == expectedResult)
	}
	
	test("Next Generation with block live cell") {
	  val liveCells = List((0, 0), (0, 1), (1, 0), (1, 1))
	  val actualResult = List((0, 0), (1, 1), (0, 1), (1, 0))
	  val expectedResult = GameOfLife.nextGeneration(liveCells)
	  assert(actualResult == expectedResult)
	}
	
	test("Next Generation with horizontal blinker cell") {
	  val liveCells = List((0, 0), (0, 1), (0, 2))
	  val actualResult = List((1,1), (0,1), (-1,1))
	  val expectedResult = GameOfLife.nextGeneration(liveCells)
	  assert(actualResult == expectedResult)
	}
	
	test("Next Generation with vertical blinker cell") {
	  val liveCells = List((0, 1), (1, 1), (2, 1))
	  val actualResult = List((1,1), (1,2), (1,0))
	  val expectedResult = GameOfLife.nextGeneration(liveCells)
	  assert(actualResult == expectedResult)
	}
}