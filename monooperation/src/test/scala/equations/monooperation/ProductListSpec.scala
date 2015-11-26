package equations.monooperation

import equations.monooperation.MonoOperation.productList
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/26/15.
 */
class ProductListSpec extends FlatSpec with Matchers {

  "Test 1" should "pass" in {
    productList(List()) shouldBe 1.00
  }

  "Test 2" should "pass" in {
    productList(List(Some(1.0))) shouldBe 1.00
  }

  "Test 3" should "pass" in {
    productList(List(Some(1.0), None)) shouldBe 1.00
  }

  "Test 4" should "pass" in {
    productList(List(Some(1.0), Some(100), None)) shouldBe 100.00
  }

  "Test 5" should "pass" in {
    productList(List(Some(1.0), None, None)) shouldBe 1.00
  }

  "Test 6" should "pass" in {
    productList(List(Some(1.0), Some(2), Some(3))) shouldBe 6.00
  }

  "Test 7" should "pass" in {
    productList(List(None, None, None)) shouldBe 1.00
  }

}
