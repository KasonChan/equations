package equations.monooperation

import equations.monooperation.MonoOperation._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/26/15.
 */
class GroupMSpec extends FlatSpec with Matchers {

  "Test 1" should "pass" in {
    groupM(List(), sumList) shouldBe Left(None)
  }

  "Test 2" should "pass" in {
    groupM(List(), productList) shouldBe Left(None)
  }


  "Test 3" should "pass" in {
    groupM(List(Some(1)), sumList) shouldBe Left(Some(1.0))
  }

  "Test 4" should "pass" in {
    groupM(List(None), sumList) shouldBe Right(None, Some(0.0))
  }

  "Test 5" should "pass" in {
    groupM(List(None, Some(1)), sumList) shouldBe Right(None, Some(1.0))
  }

  "Test 6" should "pass" in {
    groupM(List(None, Some(1), None), sumList) shouldBe Left(None)
  }


  "Test 7" should "pass" in {
    groupM(List(Some(1)), productList) shouldBe Left(Some(1.0))
  }

  "Test 8" should "pass" in {
    groupM(List(None), productList) shouldBe Right(None, Some(1.0))
  }

  "Test 9" should "pass" in {
    groupM(List(None, Some(1)), productList) shouldBe Right(None, Some(1.0))
  }

  "Test 10" should "pass" in {
    groupM(List(None, Some(1), None), productList) shouldBe Left(None)
  }


  "Test 11" should "pass" in {
    groupM(List(Some(1), Some(2), Some(3)), sumList) shouldBe Left(Some(6))
  }

  "Test 12" should "pass" in {
    groupM(List(Some(1), Some(2), Some(3)), productList) shouldBe Left(Some(6))
  }

  "Test 13" should "pass" in {
    groupM(List(Some(1), Some(2), Some(3), None), sumList) shouldBe Right(None, Some(6))
  }

  "Test 14" should "pass" in {
    groupM(List(Some(1), Some(2), Some(3), None), productList) shouldBe Right(None, Some(6))
  }

}
