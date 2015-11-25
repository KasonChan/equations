package equations.massbalance

import equations.massbalance.MassBalance._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/25/15.
 */
class MultiplySumSpec extends FlatSpec with Matchers {

  "Test 1" should "pass" in {
    multiplySum(List(MX(None, None, None))) shouldBe 0.0
  }

}
