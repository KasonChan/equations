package equations.monooperation

import equations.monooperation.MonoOperation._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/26/15.
 */
class SolveMHelperSpec extends FlatSpec with Matchers {

  "Test 1" should "pass" in {
    solveMHelper((Left(None), Left(None)), subtract) shouldBe None
  }

  "Test 2" should "pass" in {
    solveMHelper((Left(None), Left(None)), divide) shouldBe None
  }

  "Test 3" should "pass" in {
    solveMHelper((Right(None, None), Right(None, None)), subtract) shouldBe None
  }

  "Test 4" should "pass" in {
    solveMHelper((Right(None, None), Right(None, None)), divide) shouldBe None
  }


  "Test 5" should "pass" in {
    solveMHelper((Left(None), Right(None, Some(1.0))), subtract) shouldBe Some(-1.0)
  }

  "Test 6" should "pass" in {
    solveMHelper((Left(None), Right(None, Some(1.0))), divide) shouldBe Some(0.0)
  }

  "Test 7" should "pass" in {
    solveMHelper((Left(None), Right(Some(1.0), None)), subtract) shouldBe Some(0.0)
  }

  "Test 8" should "pass" in {
    intercept[java.lang.IllegalArgumentException] {
    solveMHelper((Left(None), Right(Some(1.0), None)), divide)
    }
  }

  "Test 9" should "pass" in {
    solveMHelper((Right(None, Some(1.0)), Left(None)), subtract) shouldBe Some(-1.0)
  }

  "Test 10" should "pass" in {
    solveMHelper((Right(None, Some(1.0)), Left(None)), divide) shouldBe Some(0.0)
  }

  "Test 11" should "pass" in {
    solveMHelper((Right(Some(1.0), None), Left(None)), subtract) shouldBe Some(0.0)
  }

  "Test 12" should "pass" in {
    intercept[java.lang.IllegalArgumentException] {
    solveMHelper(( Right(Some(1.0), None), Left(None)), divide)
    }
  }

}
