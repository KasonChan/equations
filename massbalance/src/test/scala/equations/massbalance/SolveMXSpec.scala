package equations.massbalance

import equations.massbalance.MassBalance._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/25/15.
 */
class SolveMXSpec extends FlatSpec with Matchers {

  "Test 1" should "pass" in {
    solveMX(List(MX(None, None)), List(MX(None, None))) shouldBe None
  }

  "Test 2" should "pass" in {
    solveMX(List(MX(None, None), MX(None, None)), List(MX(None, None), MX(None, None))) shouldBe None
  }

  "Test 3" should "pass" in {
    solveMX(List(MX(Some(1), Some(2))), List(MX(Some(1), None))) shouldBe Some(2.0)
  }

  "Test 4" should "pass" in {
    solveMX(List(MX(Some(1), Some(2))), List(MX(None, Some(2)))) shouldBe Some(1.0)
  }

  "Test 5" should "pass" in {
    solveMX(List(MX(Some(1), None)), List(MX(Some(1), Some(2)))) shouldBe Some(2.0)
  }

  "Test 6" should "pass" in {
    solveMX(List(MX(None, Some(2))), List(MX(Some(1), Some(2)))) shouldBe Some(1.0)
  }

  "Test 7" should "pass" in {
    solveMX(List(MX(None, Some(2)), MX(Some(1), Some(2))),
      List(MX(Some(1), Some(2)), MX(Some(1), Some(2)))) shouldBe Some(1)
  }

  "Test 8" should "pass" in {
    solveMX(List(MX(Some(1), None), MX(Some(1), Some(2))),
      List(MX(Some(1), Some(2)), MX(Some(1), Some(2)))) shouldBe Some(2)
  }

  "Test 9" should "pass" in {
    solveMX(List(MX(Some(1), Some(2)), MX(Some(1), Some(2))),
      List(MX(Some(1), Some(2)), MX(None, Some(2)))) shouldBe Some(1)
  }

  "Test 10" should "pass" in {
    solveMX(List(MX(Some(1), Some(2)), MX(Some(1), Some(2))),
      List(MX(Some(1), Some(2)), MX(Some(1), None))) shouldBe Some(2)
  }

  "Test 11" should "pass" in {
    solveMX(List(MX(None, Some(2)), MX(Some(1), Some(2))),
      List(MX(None, Some(2)), MX(Some(1), Some(2)))) shouldBe None
  }

}
