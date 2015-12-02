package equations.massbalance

/**
 * A trait to represent a ''mass balance equation''.
 *
 * Specify the `variable` and `constant` when calling the solveMX function like this:
 *
 * {{{
 * 10 * 20 + 5 * 40 = x * 15
 * scala> inputs = List(MX(Some(10), Some(20)), MX(None, Some(40)))
 * scala> outputs = List(MX(None, Some(15)))
 * scala> solveMX(inputs, outputs)
 * Some(26.7)
 *
 * 50 * 10 * (100 - 15) / 100 = y * 25
 * scala> inputs = List(MX(Some(50), Some(10), Some(15)))
 * scala> outputs = List(MX(None, Some(25)))
 * scala> solveMX(inputs, outputs)
 * Some(17)
 * }}}
 */
sealed trait MassBalance {

  /**
   * A case class to represent a flow, other constituents and removal percentage.
   * @param M the value of flow.
   * @param X the value of other constituents.
   * @param Removal the value of removal percentage.
   */
  case class MX(M: Option[Double], X: Option[Double], Removal: Option[Double] = None)

  /**
   * Solves the equation of mass balances and returns the result; otherwise
   * returns 0.0.
   * @param inputs the list of mass balances on the left hand side of equation.
   * @param outputs the list of mass balances on the right hand side of equation.
   */
  def solveMX(inputs: List[MX], outputs: List[MX]): Option[Double] = {

    /**
     * Returns the sum of multiplication of the mass balances.
     * @param inputs the list of mass balances.
     */
    def multiplySum(inputs: List[MX]): Double = {
      inputs.foldLeft(0.0) {
        (m, n) => m + (n.M.getOrElse(0.0) * n.X.getOrElse(0.0) * ((100 - n.Removal.getOrElse(0.0)) / 100))
      }
    }

    /**
     * Returns the tuple of mass balance with unknown and grouped sum of
     * multiplication of the mass balances.
     * Otherwise, returns 0.0.
     * @param puts the list of mass balances.
     */
    def groupMX(puts: List[MX]): Either[Option[Double], (MX, Option[Double])] = {
      val spanned = puts match {
        case List() => None
        case l: List[MX] =>
          val r = l partition {
            mx => !mx.M.isDefined || !mx.X.isDefined
          }
          Some(r)
        case _ => None
      }

      spanned match {
        case None => Left(None)
        case Some(x) => x match {
          case (List(), t) => Left(Some(multiplySum(t)))
          case (h, t) =>
            h.size match {
              case 1 => Right(h.head, Some(multiplySum(t)))
              case _ => Left(None)
            }
        }
        case _ => Left(None)
      }
    }

    val i = groupMX(inputs)
    val o = groupMX(outputs)

    (i, o) match {
      case (Left(l), Left(r)) => None
      case (Left(l), Right(r)) => r match {
        case (mx, sum) =>
          (mx.M, mx.X, mx.Removal) match {
            case (Some(x), None, _) =>
              val result = (l.getOrElse(0.0) - sum.getOrElse(0.0)) / x
              Some(result)
            case (None, Some(x), _) =>
              val result = (l.getOrElse(0.0) - sum.getOrElse(0.0)) / x
              Some(result)
            case _ => None
          }
      }
      case (Right(l), Left(r)) => l match {
        case (mx, sum) =>
          (mx.M, mx.X, mx.Removal) match {
            case (Some(x), None, _) =>
              val result = (r.getOrElse(0.0) - sum.getOrElse(0.0)) / x
              Some(result)
            case (None, Some(x), _) =>
              val result = (r.getOrElse(0.0) - sum.getOrElse(0.0)) / x
              Some(result)
            case _ => None
          }
      }
      case (Right(l), Right(r)) => None
      case _ => None
    }
  }

}

/**
 * A companion object to represent a ''mass balance equation''.
 *
 * Specify the `variable` and `constant` when calling the solveMX function like this:
 *
 * {{{
 * 10 * 20 + 5 * 40 = x * 15
 * scala> inputs = List(MX(Some(10), Some(20)), MX(None, Some(40)))
 * scala> outputs = List(MX(None, Some(15)))
 * scala> solveMX(inputs, outputs)
 * Some(26.7)
 *
 * 50 * 10 * (100 - 15) / 100 = y * 25
 * scala> inputs = List(MX(Some(50), Some(10), Some(15)))
 * scala> outputs = List(MX(None, Some(25)))
 * scala> solveMX(inputs, outputs)
 * Some(17)
 * }}}
 */
object MassBalance extends MassBalance
