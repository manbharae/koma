@file:koma.internal.JvmName("MatrixExtensions")
@file:koma.internal.JvmMultifileClass

/**
 * THIS FILE IS AUTOGENERATED, DO NOT MODIFY. EDIT THE FILES IN templates/
 * AND RUN ./gradlew :codegen INSTEAD!
 */

package koma.extensions

import koma.matrix.Matrix
import koma.internal.KomaJsName
import koma.internal.KomaJvmName

/**
 * Checks to see if any element in the matrix causes f to return true.
 *
 * @param f A function which takes in an element from the matrix and returns a Boolean.
 *
 * @return Whether or not any element, when passed into f, causes f to return true.
 */
@KomaJsName("anyInt")
@KomaJvmName("anyInt")
inline fun  Matrix<Int>.any(f: (Int) -> Boolean): Boolean {
    for (row in 0 until this.numRows())
        for (col in 0 until this.numCols())
            if (f(this[row, col]))
                return true
    return false
}

/**
 * Checks to see if all elements cause f to return true.
 *
 * @param f A function which takes in an element from the matrix and returns a Boolean.
 *
 * @return Returns true only if f is true for all elements of the input matrix
 */
@KomaJsName("allInt")
@KomaJvmName("allInt")
inline fun  Matrix<Int>.all(f: (Int) -> Boolean): Boolean {
    for (row in 0 until this.numRows())
        for (col in 0 until this.numCols())
            if (!f(this[row, col]))
                return false
    return true
}

/**
 * Fills the matrix with the values returned by the input function.
 *
 * @param f A function which takes row,col and returns the value to fill. Note that
 * the return type must be the matrix primitive type (e.g. Double).
 */
@KomaJsName("fillInt")
@KomaJvmName("fillInt")
inline fun  Matrix<Int>.fill(f: (row: Int, col: Int) -> Int): Matrix<Int> {
    for (row in 0 until this.numRows())
        for (col in 0 until this.numCols())
            this[row, col] = f(row, col)
    return this
}

/**
 * Passes each element in row major order into a function.
 *
 * @param f A function that takes in an element
 *
 */
@KomaJsName("forEachInt")
@KomaJvmName("forEachInt")
inline fun  Matrix<Int>.forEach(f: (Int) -> Unit) {
    for (row in 0 until this.numRows())
        for (col in 0 until this.numCols())
            f(this[row, col])
}

/**
 * Passes each element in row major order into a function along with its index location.
 *
 * @param f A function that takes in a row,col position and an element value
 */
@KomaJsName("forEachIndexedInt")
@KomaJvmName("forEachIndexedInt")
inline fun  Matrix<Int>.forEachIndexed(f: (row: Int, col: Int, ele: Int) -> Unit) {
    for (row in 0 until this.numRows())
        for (col in 0 until this.numCols())
            f(row, col, this[row, col])
}


/**
 * Takes each element in a matrix, passes them through f, and puts the output of f into an
 * output matrix. This process is done in row-major order.
 *
 * @param f A function that takes in an element and returns an element
 *
 * @return the new matrix after each element is mapped through f
 */
@KomaJsName("mapInt")
@KomaJvmName("mapInt")
inline fun  Matrix<Int>.map(f: (Int) -> Int): Matrix<Int> {
    val out = this.getFactory().zeros(this.numRows(), this.numCols())
    for (row in 0 until this.numRows())
        for (col in 0 until this.numCols())
            out[row, col] = f(this[row, col])
    return out
}

/**
 * Takes each element in a matrix, passes them through f, and puts the output of f into an
 * output matrix. This process is done in row-major order.
 *
 * @param f A function that takes in an element and returns an element. Function also takes
 *      in the row, col index of the element's location.
 *
 * @return the new matrix after each element is mapped through f
 */
@KomaJsName("mapIndexedInt")
@KomaJvmName("mapIndexedInt")
inline fun  Matrix<Int>.mapIndexed(f: (row: Int, col: Int, ele: Int) -> Int): Matrix<Int> {
    val out = this.getFactory().zeros(this.numRows(), this.numCols())
    for (row in 0 until this.numRows())
        for (col in 0 until this.numCols())
            out[row, col] = f(row, col, this[row, col])
    return out
}


@KomaJsName("getInt")
operator fun  Matrix<Int>.get(i: Int, j: Int): Int = getInt(i, j)
/**
 * Gets the ith element in the matrix. If 2D, selects elements in row-major order.
 */
@KomaJsName("get1DInt")
operator fun  Matrix<Int>.get(i: Int): Int = getInt(i)

/**
 * Allow slicing, e.g. ```matrix[1..2, 3..4]```. Note that the range 1..2 is inclusive, so
 * it will retrieve row 1 and 2. Use 1.until(2) for a non-inclusive range.
 *
 * @param rows the set of rows to select
 * @param cols the set of columns to select
 *
 * @return a new matrix containing the submatrix.
 */
@KomaJvmName("getRangesInt")
@KomaJsName("getRangesInt")
operator fun  Matrix<Int>.get(rows: IntRange, cols: IntRange): Matrix<Int>
{
    val wrows = wrapRange(rows, numRows())
    val wcols = wrapRange(cols, numCols())

    val out = this.getFactory().zeros(wrows.endInclusive - wrows.start + 1,
            wcols.endInclusive - wcols.start + 1)
    for (row in wrows)
        for (col in wcols)
            out[row - wrows.start, col - wcols.start] = this[row, col]
    return out
}
/**
 * Allows for slicing of the rows and selection of a single column
 */
@KomaJvmName("setRowRangeInt")
@KomaJsName("getRowRangeInt")
operator fun  Matrix<Int>.get(rows: IntRange, cols: Int) = this[rows, cols..cols]

/**
 * Allows for slicing of the cols and selection of a single row
 */
@KomaJvmName("getColRangeInt")
@KomaJsName("getColRangeInt")
operator fun  Matrix<Int>.get(rows: Int, cols: IntRange) = this[rows..rows, cols]


/**
 * Set the ith element in the matrix. If 2D, selects elements in row-major order.
 */
@KomaJvmName("set1DInt")
@KomaJsName("set1DInt")
operator fun  Matrix<Int>.set(i: Int, v: Int) = setInt(i, v)
@KomaJvmName("set2DInt")
@KomaJsName("set2DInt")
operator fun  Matrix<Int>.set(i: Int, j: Int, v: Int) = setInt(i, j, v)
/**
 * Allow assignment to a slice, e.g. ```matrix[1..2, 3..4]```=something. Note that the range 1..2 is inclusive, so
 * it will retrieve row 1 and 2. Use 1.until(2) for a non-inclusive range.
 *
 * @param rows the set of rows to select
 * @param cols the set of columns to select
 * @param value the matrix to set the subslice to
 *
 */
@KomaJvmName("setRangesInt")
@KomaJsName("setRangesInt")
operator fun  Matrix<Int>.set(rows: IntRange, cols: IntRange, value: Matrix<Int>)
{
    val wrows = wrapRange(rows, numRows())
    val wcols = wrapRange(cols, numCols())

    for (i in wrows)
        for (j in wcols)
            this[i, j] = value[i - wrows.start, j - wcols.start]
}
@KomaJsName("setRangesScalarInt")
operator fun  Matrix<Int>.set(rows: IntRange, cols: IntRange, value: Int)
{
    val wrows = wrapRange(rows, numRows())
    val wcols = wrapRange(cols, numCols())

    for (i in wrows)
        for (j in wcols)
            this[i, j] = value
}
/**
 * Allow assignment to a slice, e.g. ```matrix[2, 3..4]```=something. Note that the range 3..4 is inclusive, so
 * it will retrieve col 3 and 4. Use 1.until(2) for a non-inclusive range.
 *
 * @param rows the row to select
 * @param cols the set of columns to select
 * @param value the matrix to set the subslice to
 *
 */
@KomaJvmName("setColRangeInt")
@KomaJsName("setColRangeInt")
operator fun  Matrix<Int>.set(rows: Int, cols: IntRange, value: Matrix<Int>)
{
    this[rows..rows, cols] = value
}
@KomaJvmName("setColRangeScalarInt")
@KomaJsName("setColRangeScalarInt")
operator fun  Matrix<Int>.set(rows: Int, cols: IntRange, value: Int)
{
    this[rows..rows, cols] = value
}
/**
 * Allow assignment to a slice, e.g. ```matrix[1..2, 3]```=something. Note that the range 1..2 is inclusive, so
 * it will retrieve row 1 and 2. Use 1.until(2) for a non-inclusive range.
 *
 * @param rows the set of rows to select
 * @param cols the column to select
 * @param value the matrix to set the subslice to
 *
 */
@KomaJvmName("setRowRangeInt")
@KomaJsName("setRowRangeInt")
operator fun  Matrix<Int>.set(rows: IntRange, cols: Int, value: Matrix<Int>) {
    this[rows, cols..cols] = value
}
@KomaJsName("setRowRangeScalarInt")
operator fun  Matrix<Int>.set(rows: IntRange, cols: Int, value: Int) {
    this[rows, cols..cols] = value
}

