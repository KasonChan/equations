package massbalance

import massbalance.MassBalance._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/24/15.
 */
class MassBalanceSuite extends FlatSpec with Matchers {

  "MX(Some(1), Some(2))" should "MX(1), Some(2), None)" in {
    MX(Some(1), Some(2)) shouldBe MX(Some(1), Some(2), None)
  }

  "MX(None, None, None)" should "MX(None, None, None)" in {
    MX(None, None, None) shouldBe MX(None, None, None)
  }

  "MX(None, None, Some(3))" should "MX(None, None, Some(3))" in {
    MX(None, None, Some(3)) shouldBe MX(None, None, Some(3))
  }

  "MX(None, Some(2), None)" should "MX(None, Some(2), None)" in {
    MX(None, Some(2), None) shouldBe MX(None, Some(2), None)
  }

  "MX(None, Some(2), Some(3))" should "MX(None, Some(2), Some(3))" in {
    MX(None, Some(2), Some(3)) shouldBe MX(None, Some(2), Some(3))
  }

  "MX(Some(1), None, None)" should "MX(Some(1), None, None)" in {
    MX(Some(1), None, None) shouldBe MX(Some(1), None, None)
  }

  "MX(Some(1), None, Some(3))" should "MX(Some(1), None, Some(3))" in {
    MX(Some(1), None, Some(3)) shouldBe MX(Some(1), None, Some(3))
  }

  "MX(Some(1), Some(2), None)" should "MX(1), Some(2), None)" in {
    MX(Some(1), Some(2), None) shouldBe MX(Some(1), Some(2), None)
  }


  "(1.5 * 3) + (4 * 2.5) = (5 * X)" should "X = 2.9" in {
    val inputs = List(MX(Some(1.5), Some(3)), MX(Some(4), Some(2.5)))
    val outputs = List(MX(Some(5), None))
    solveMX(inputs, outputs) shouldBe Some(2.9)
  }

  "(1.5 * 3) + (4 * 2.5) = (M * 5)" should "M = 2.9" in {
    val inputs = List(MX(Some(1.5), Some(3)), MX(Some(4), Some(2.5)))
    val outputs = List(MX(None, Some(5)))
    solveMX(inputs, outputs) shouldBe Some(2.9)
  }

  "(M * 3) + (4 * 2.5) = (2.9 * 5)" should "M = 1.5" in {
    val inputs = List(MX(None, Some(3)), MX(Some(4), Some(2.5)))
    val outputs = List(MX(Some(2.9), Some(5)))
    solveMX(inputs, outputs) shouldBe Some(1.5)
  }

  "(1.5 * X) + (4 * 2.5) = (2.9 * 5)" should "X = 3.0" in {
    val inputs = List(MX(Some(1.5), None), MX(Some(4), Some(2.5)))
    val outputs = List(MX(Some(2.9), Some(5)))
    solveMX(inputs, outputs) shouldBe Some(3.0)
  }

  "(1.5 * 3) + (M * 2.5) = (2.9 * 5)" should "M = 4" in {
    val inputs = List(MX(Some(1.5), Some(3)), MX(None, Some(2.5)))
    val outputs = List(MX(Some(2.9), Some(5)))
    solveMX(inputs, outputs) shouldBe Some(4)
  }

  "(1.5 * 3) + (4 * X) = (2.9 * 5)" should "X = 2.5" in {
    val inputs = List(MX(Some(1.5), Some(3)), MX(Some(4), None))
    val outputs = List(MX(Some(2.9), Some(5)))
    solveMX(inputs, outputs) shouldBe Some(2.5)
  }


  "(10 * 20) + (5 * 40) = (M * 15)" should "M = 26.666666666666668" in {
    val inputs = List(MX(Some(10), Some(20)), MX(Some(5), Some(40)))
    val outputs = List(MX(None, Some(15)))
    solveMX(inputs, outputs) shouldBe Some(26.666666666666668)
  }

  "(10 * 20) + (5 * 40) = (15 * X)" should "X = 26.666666666666668" in {
    val inputs = List(MX(Some(10), Some(20)), MX(Some(5), Some(40)))
    val outputs = List(MX(Some(15), None))
    solveMX(inputs, outputs) shouldBe Some(26.666666666666668)
  }

  "(M * 20) + (5 * 40) = (15 * 26.666666666666668)" should "M = 10" in {
    val inputs = List(MX(None, Some(20)), MX(Some(5), Some(40)))
    val outputs = List(MX(Some(15), Some(26.666666666666668)))
    solveMX(inputs, outputs) shouldBe Some(10)
  }

  "(10 * X) + (5 * 40) = (15 * 26.666666666666668)" should "X = 20" in {
    val inputs = List(MX(Some(10), None), MX(Some(5), Some(40)))
    val outputs = List(MX(Some(15), Some(26.666666666666668)))
    solveMX(inputs, outputs) shouldBe Some(20)
  }

  "(10 * 20) + (M * 40) = (15 * 26.666666666666668)" should "M = 5" in {
    val inputs = List(MX(Some(10), Some(20)), MX(None, Some(40)))
    val outputs = List(MX(Some(15), Some(26.666666666666668)))
    solveMX(inputs, outputs) shouldBe Some(5)
  }

  "(10 * 20) + (5 * X) = (15 * 26.666666666666668)" should "X = 40" in {
    val inputs = List(MX(Some(10), Some(20)), MX(Some(5), None))
    val outputs = List(MX(Some(15), Some(26.666666666666668)))
    solveMX(inputs, outputs) shouldBe Some(40)
  }

  "Solve more 1" should "pass" in {
    val inputs = List(MX(Some(1240973.21), Some(201.55), Some(27)))
    val outputs = List(MX(Some(1240973.21), None))
    solveMX(inputs, outputs) shouldBe Some(147.13150000000002)
  }

  "Solve more 2" should "pass" in {
    val inputs = List()
    val outputs = List()
    solveMX(inputs, outputs) shouldBe None
  }

  "Solve more 3" should "pass" in {
    val inputs = List(MX(Some(1), Some(2)))
    val outputs = List()
    solveMX(inputs, outputs) shouldBe None
  }

  "Solve more 4" should "pass" in {
    val inputs = List()
    val outputs = List(MX(Some(1), Some(2)))
    solveMX(inputs, outputs) shouldBe None
  }

  "Solve more 5" should "pass" in {
    val inputs = List(MX(Some(1), Some(2)))
    val outputs = List(MX(Some(1), Some(2)))
    solveMX(inputs, outputs) shouldBe None
  }

  "Solve more 6" should "pass" in {
    val inputs = List(MX(None, None))
    val outputs = List(MX(None, None))
    solveMX(inputs, outputs) shouldBe None
  }

  "Solve more 7" should "pass" in {
    val inputs = List(MX(Some(1), None))
    val outputs = List(MX(Some(1), None))
    solveMX(inputs, outputs) shouldBe None
  }

  "Solve more 8" should "pass" in {
    val inputs = List(MX(None, Some(2)))
    val outputs = List(MX(None, Some(2)))
    solveMX(inputs, outputs) shouldBe None
  }

  "Solve more 9" should "pass" in {
    val inputs = List(MX(None, None), MX(None, None))
    val outputs = List(MX(None, None), MX(None, None))
    solveMX(inputs, outputs) shouldBe None
  }

  "Solve more 10" should "pass" in {
    val inputs = List(MX(Some(1), None), MX(Some(1), None))
    val outputs = List(MX(Some(1), None), MX(Some(1), None))
    solveMX(inputs, outputs) shouldBe None
  }

  "Solve more 11" should "pass" in {
    val inputs = List(MX(Some(1), None), MX(Some(1), None), MX(Some(1), None))
    val outputs = List(MX(Some(1), None), MX(Some(1), None), MX(Some(1), None))
    solveMX(inputs, outputs) shouldBe None
  }

  "Solve more 12" should "pass" in {
    val inputs = List(MX(Some(1), None), MX(Some(1), None), MX(Some(1), Some(2)))
    val outputs = List(MX(Some(1), None), MX(Some(1), None), MX(Some(1), Some(2)))
    solveMX(inputs, outputs) shouldBe None
  }

}
