package equations.monooperation

import equations.monooperation.MonoOperation.divide
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/26/15.
 */
class DivideSpec extends FlatSpec with Matchers {

  "Test 1" should "pass" in {
    intercept[java.lang.IllegalArgumentException] {
      divide(0, 0)
    }
  }

  "Test 2" should "pass" in {
    divide(-1, -1) shouldBe 1.00
  }

  "Test 3" should "pass" in {
    divide(2, 1) shouldBe 2.00
  }

  "Test 4" should "pass" in {
    divide(2, -1) shouldBe -2.00
  }

  "Test 5" should "pass" in {
    divide(4, 3) shouldBe 1.3333333333333333
  }

  "Test 6" should "pass" in {
    divide(4, -3) shouldBe -1.3333333333333333
  }

  "Test 7" should "pass" in {
    divide(-4, -3) shouldBe 1.3333333333333333
  }

  "Test 8" should "pass" in {
    divide(-4, 3) shouldBe -1.3333333333333333
  }

}
