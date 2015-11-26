package equations.monooperation

import equations.monooperation.MonoOperation.subtract
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/26/15.
 */
class SubtractSpec extends FlatSpec with Matchers {

  "Test 1" should "pass" in {
    subtract(0, 0) shouldBe 0.00
  }

  "Test 2" should "pass" in {
    subtract(-1, -1) shouldBe 0.00
  }

  "Test 3" should "pass" in {
    subtract(2, 1) shouldBe 1.00
  }

  "Test 4" should "pass" in {
    subtract(2, -1) shouldBe 3.00
  }

  "Test 5" should "pass" in {
    subtract(4, 3) shouldBe 1.00
  }

  "Test 6" should "pass" in {
    subtract(4, -3) shouldBe 7.00
  }

  "Test 7" should "pass" in {
    subtract(-4, -3) shouldBe -1.00
  }

  "Test 8" should "pass" in {
    subtract(-4, 3) shouldBe -7.00
  }

}
