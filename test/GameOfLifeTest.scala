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
	
}