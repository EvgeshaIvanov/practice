import java.math.BigDecimal
import java.math.BigDecimal.ONE
import java.math.BigDecimal.ROUND_HALF_UP


class PI {
    private val TWO = BigDecimal(2)
    private val FOUR = BigDecimal(4)



    // Gauss-Legendre Algorithm
    fun pi(SCALE: Int): BigDecimal? {
        var a: BigDecimal = ONE
        var b: BigDecimal = ONE.divide(sqrt(TWO, SCALE), SCALE, ROUND_HALF_UP)
        var t = BigDecimal(0.25)
        var x: BigDecimal = ONE
        var y: BigDecimal
        while (a != b) {
            y = a
            a = a.add(b).divide(TWO, SCALE, ROUND_HALF_UP)
            b = sqrt(b.multiply(y), SCALE)
            t = t.subtract(x.multiply(y.subtract(a).multiply(y.subtract(a))))
            x = x.multiply(TWO)
        }
        return a.add(b).multiply(a.add(b)).divide(t.multiply(FOUR), SCALE, ROUND_HALF_UP)
    }

    // the Babylonian square root method (Newton's method)
    fun sqrt(A: BigDecimal, SCALE: Int): BigDecimal {
        var x0 = BigDecimal("0")
        var x1 = BigDecimal(Math.sqrt(A.toDouble()))
        while (x0 != x1) {
            x0 = x1
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP)
            x1 = x1.add(x0)
            x1 = x1.divide(TWO, SCALE, ROUND_HALF_UP)
        }
        return x1
    }


    //////TODO

}