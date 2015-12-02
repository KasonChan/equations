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

  "Test 12" should "pass" in {
    solveM(List(), List(), 'add) shouldBe None
  }

  "Test 13" should "pass" in {
    solveM(List(), List(), 'multiple) shouldBe None
  }

  "Test 14" should "pass" in {
    solveM(List(Some(1)), List(Some(1)), 'add) shouldBe None
  }

  "Test 15" should "pass" in {
    solveM(List(None), List(None), 'add) shouldBe None
  }

  "Test 16" should "pass" in {
    solveM(List(None, Some(1)), List(None, Some(1)), 'add) shouldBe None
  }

  "Test 17" should "pass" in {
    solveM(List(None, Some(1), None), List(None, Some(1), None), 'add) shouldBe None
  }

  "Test 18" should "pass" in {
    solveM(List(Some(1)), List(Some(1)), 'multiple) shouldBe None
  }

  "Test 19" should "pass" in {
    solveM(List(None), List(None), 'multiple) shouldBe None
  }

  "Test 20" should "pass" in {
    solveM(List(None, Some(1)), List(None, Some(1)), 'multiple) shouldBe None
  }

  "Test 21" should "pass" in {
    solveM(List(None, Some(1), None), List(None, Some(1), None), 'multiple) shouldBe None
  }

  "Test 22" should "pass" in {
    solveM(List(Some(1), Some(2), Some(3)), List(Some(1), Some(2), Some(3)), 'add) shouldBe None
  }

  "Test 23" should "pass" in {
    solveM(List(Some(1), Some(2), Some(3)), List(Some(1), Some(2), Some(3)), 'multiple) shouldBe None
  }

  "Test 24" should "pass" in {
    solveM(List(Some(1), Some(2), Some(3), None), List(Some(1), Some(2), Some(3), None), 'add) shouldBe None
  }

  "Test 25" should "pass" in {
    solveM(List(Some(1), Some(2), Some(3), None), List(Some(1), Some(2), Some(3), None), 'multiple) shouldBe None
  }

  "Test 26" should "pass" in {
    solveM(List(Some(1), Some(2), Some(3), None), List(Some(1), Some(2), Some(3)), 'multiple) shouldBe Some(1.0)
  }

  "Test 27" should "pass" in {
    solveM(List(Some(1)), List(Some(1), Some(2), Some(3), None), 'multiple) shouldBe Some(0.16666666666666666)
  }

  "Test 28" should "pass" in {
    solveM(List(Some(1), Some(2), Some(3), None), List(Some(1)), 'multiple) shouldBe Some(0.16666666666666666)
  }

}
