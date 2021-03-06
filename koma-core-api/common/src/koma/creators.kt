@file:koma.internal.JvmName("Koma")
@file:koma.internal.JvmMultifileClass

package koma

import koma.extensions.fill
import koma.internal.KomaJsName
import koma.matrix.Matrix
import koma.matrix.MatrixTypes
import koma.matrix.MatrixType
/**
 * This file defines a set of functions to create new matrices. Follows
 * numpy conventions as closely as possible. For example, a 3x3 zero
 * matrix can be created via zeros(3,3)
 */

/**
 * Creates a zero-filled matrix with the given size
 */
@KomaJsName("zeros")
fun zeros(rows: Int, cols: Int): Matrix<Double> = zeros(rows, cols, dtype= MatrixTypes.DoubleType)
fun <T> zeros(rows:Int,
              cols:Int,
              dtype: MatrixType<T>): Matrix<T>
        = dtype().zeros(rows,cols)


/**
 * Creates a matrix filled with the given range of values.
 */
@KomaJsName("createRange")
fun create(data: IntRange) = create(data, dtype= MatrixTypes.DoubleType)
fun <T> create(data: IntRange,
               dtype: MatrixType<T>): Matrix<T>
        = dtype().create(data)

/**
 * Creates a matrix filled with the given set of values as a row-vector.
 */
@KomaJsName("createArray")
fun create(data: DoubleArray) = create(data, dtype= MatrixTypes.DoubleType)
fun <T> create(data: DoubleArray,
               dtype: MatrixType<T>): Matrix<T>
        = dtype().create(data).asRowVector()

/**
 * Creates a matrix filled with the given set of values in row-major order.
 */
@KomaJsName("createArraySized")
fun create(data: DoubleArray, numRows: Int, numCols: Int): Matrix<Double> =
        create(data, numRows, numCols, dtype= MatrixTypes.DoubleType)
fun <T> create(data: DoubleArray,
               numRows: Int,
               numCols: Int,
               dtype: MatrixType<T>): Matrix<T> {
    // TODO: Replace when also exists in kotlin-native
    val out = dtype().zeros(numRows,numCols)
    data.forEachIndexed { idx, value -> out.setDouble(idx,value) }
    return out
}

/**
 * Creates a matrix filled with the given data, assuming input is row major.
 */
@KomaJsName("create2DArray")
fun create(data: Array<DoubleArray>): Matrix<Double> = create(data, dtype= MatrixTypes.DoubleType)
fun <T> create(data: Array<DoubleArray>,
               dtype: MatrixType<T>): Matrix<T>
        = dtype().create(data)


/**
 * Creates a one-filled matrix with the given size
 */
@KomaJsName("ones")
fun ones(rows: Int, columns: Int): Matrix<Double> = ones(rows, columns, dtype= MatrixTypes.DoubleType)
fun <T> ones(rows: Int,
             columns: Int,
             dtype: MatrixType<T>): Matrix<T>
        = dtype().ones(rows, columns)

/**
 * Creates a square identity matrix with the given size
 */
@KomaJsName("eye")
fun eye(size: Int): Matrix<Double> = eye(size, dtype= MatrixTypes.DoubleType)
fun <T> eye(size: Int,
            dtype: MatrixType<T>): Matrix<T>
        = dtype().eye(size)

/**
 * Creates an identity matrix with the given size
 */
@KomaJsName("eyeSized")
fun eye(rows: Int, cols: Int): Matrix<Double> = eye(rows, cols, dtype= MatrixTypes.DoubleType)
fun <T> eye(rows: Int,
            cols: Int,
            dtype: MatrixType<T>): Matrix<T>
        = dtype().eye(rows, cols)

/**
 * Creates a new matrix that fills all the values with the return values of func(row,val)
 */
@KomaJsName("fill")
fun fill(rows: Int, cols: Int, func: (Int, Int) -> Double) = zeros(rows, cols).fill(func)
fun <T> fill(rows: Int,
             cols: Int,
             dtype: MatrixType<T>,
             func: (Int, Int) -> T)
        = zeros(rows, cols, dtype).fill(func)

/**
 * Creates a new matrix that fills all the values with [value]
 */
@KomaJsName("fillScalar")
fun fill(rows: Int,
         cols: Int,
         value: Double) = zeros(rows, cols).fill({ _, _ -> value })
fun <T> fill(rows: Int,
             cols: Int,
             value: T,
             dtype: MatrixType<T>)
        = zeros(rows, cols, dtype).fill({ _, _ -> value })


/**
 * Creates an matrix filled with unit uniform random numbers
 */
@KomaJsName("rand")
fun rand(rows: Int, cols: Int): Matrix<Double> = rand(rows, cols, dtype= MatrixTypes.DoubleType)
fun <T> rand(rows: Int,
             cols: Int,
             dtype: MatrixType<T>): Matrix<T>
        = dtype().rand(rows, cols)

/**
 * Creates an matrix filled with unit normal random numbers, using the given seed for the RNG.
 * Subsequent calls with the same seed will produce identical numbers.
 */
@KomaJsName("randSeed")
@Deprecated("Call setSeed and randn separately")
fun rand(rows: Int, cols: Int, seed: Long): Matrix<Double> = rand(rows,
        cols,
        seed,
        dtype= MatrixTypes.DoubleType)
@Deprecated("Call setSeed and randn separately")
fun <T> rand(rows: Int,
             cols: Int,
             seed: Long,
             dtype: MatrixType<T>): Matrix<T> {
    setSeed(seed)
    return dtype().rand(rows, cols)
}

/**
 * Creates an matrix filled with unit normal random numbers
 */
@KomaJsName("randn")
fun randn(rows: Int, cols: Int): Matrix<Double> = randn(rows,
        cols,
        dtype= MatrixTypes.DoubleType)
fun <T> randn(rows: Int,
              cols: Int,
              dtype: MatrixType<T>): Matrix<T>
        = dtype().randn(rows, cols)

/**
 * Creates an matrix filled with unit normal random numbers, using the given seed for the RNG.
 * Subsequent calls with the same seed will produce identical numbers.
 */
@KomaJsName("randnSeed")
@Deprecated("Call setSeed and randn separately")
fun randn(rows: Int, cols: Int, seed: Long): Matrix<Double> = randn(rows,
        cols,
        seed,
        dtype= MatrixTypes.DoubleType)
@Deprecated("Call setSeed and randn separately")
fun <T> randn(rows: Int,
              cols: Int,
              seed: Long,
              dtype: MatrixType<T>): Matrix<T> {
    setSeed(seed)
    return dtype().randn(rows, cols)
}

/**
 * Creates an vector filled in by the given range information. The filled values will start at [start] and
 * end at [stop], with the interval between each value [step].
 */
@KomaJsName("arange")
fun arange(start: Double, stop: Double, step: Double): Matrix<Double> = arange(start,
        stop,
        step,
        dtype= MatrixTypes.DoubleType)
fun <T> arange(start: Double,
               stop: Double,
               step: Double,
               dtype: MatrixType<T>): Matrix<T>
        = dtype().arange(start, stop, step)

// TODO: Get these versions working
//fun linspace(...) = factory.linspace(lower, upper, num)
