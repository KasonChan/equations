package equations.monooperation

import equations.monooperation.MonoOperation._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/26/15.
 */
class SolveMSpec extends FlatSpec with Matchers {

  "Test 1" should "pass" in {
    solveM(List(), List(), 'add) shouldBe None
  }

  "Test 2" should "pass" in {
    solveM(List(), List(), 'multiple) shouldBe None
  }

  "Test 3" should "pass" in {
    solveM(List(None), List(None), 'add) shouldBe None
  }

  "Test 4" should "pass" in {
    solveM(List(None), List(None), 'multiple) shouldBe None
  }

  "Test 5" should "pass" in {
    solveM(List(None), List(Some(2), Some(3)), 'add) shouldBe Some(5)
  }

  "Test 6" should "pass" in {
    solveM(List(None), List(Some(2), Some(3)), 'multiple) shouldBe Some(6)
  }

  "Test 7" should "pass" in {
    solveM(List(None), List(Some(100), Some(.25)), 'add) shouldBe Some(100.25)
  }

  "Test 8" should "pass" in {
    solveM(List(None), List(Some(100), Some(.25)), 'multiple) shouldBe Some(25)
  }

  "Test 9" should "pass" in {
    solveM(List(None), List(Some(3), Some(4)), 'add) shouldBe Some(7.0)
  }

  "Test 10" should "pass" in {
    solveM(List(Some(3)), List(Some(3), None), 'multiple) shouldBe Some(1.0)
  }

  "Test 11" should "pass" in {
    solveM(List(Some(3)), List(Some(3), None), 'lol) shouldBe None
  }

}
