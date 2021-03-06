/**
 * THIS FILE IS AUTOGENERATED, DO NOT MODIFY. EDIT THE FILES IN templates/
 * AND RUN ./gradlew :codegen INSTEAD!
 */

package koma.internal.default.generated.ndarray

import koma.ndarray.*
import koma.internal.KomaJsName
import koma.internal.default.utils.*


/**
 * An (unoptimized) implementation of [NDArray] in pure Kotlin, for portability between the
 * different platforms koma supports.
 *
 * @param shape A vararg specifying the size of each dimension, e.g. a 3D array with size 4x6x8 would pass in 4,6,8)
 * @param init A function that takes a location in the new array and returns its initial value.
 */
open class DefaultGenericNDArray<T>(@KomaJsName("shape_private") vararg protected val shape: Int,
                             init: ((IntArray)->T)): NDArray<T> {

    /**
     * Underlying storage. Default backends uses a simple array.
     */
    private val storage: Array<T>

    init {
        @Suppress("UNCHECKED_CAST")
        storage = Array(shape.reduce{ a, b-> a * b}, {init.invoke(linearToNIdx(it)) as Any?}) as Array<T>
    }

    override fun getGeneric(vararg indices: Int): T {
        checkIndices(indices)
        return storage[nIdxToLinear(indices)]
    }
    override fun getGeneric(i: Int): T = storage[i]
    override fun setGeneric(i: Int, value: T) { storage[i] = value }

    override fun setGeneric(vararg indices: Int, value: T) {
        checkIndices(indices)
        storage[nIdxToLinear(indices)] = value
    }
    // TODO: cache this
    override val size get() = storage.size
    override fun shape(): List<Int> = shape.toList()
    override fun copy(): NDArray<T> = DefaultGenericNDArray(*shape, init = { this.getGeneric(*it) })
    override fun getBaseArray(): Any = storage

    private val wrongType = "Double methods not implemented for generic NDArray"
    override fun getDouble(i: Int): Double {
        val ele = getGeneric(i)
        if (ele is Double)
            return ele
        else
            error(wrongType)
    }
    override fun setDouble(i: Int, v: Double) {
       setGeneric(i, v as T)
    }

    override fun getByte(i: Int): Byte {
        val ele = getGeneric(i)
        if (ele is Byte)
            return ele
        else
            error(wrongType)
    }
    override fun setByte(i: Int, v: Byte) {
       setGeneric(i, v as T)
    }

    override fun getInt(i: Int): Int {
        val ele = getGeneric(i)
        if (ele is Int)
            return ele
        else
            error(wrongType)
    }
    override fun setInt(i: Int, v: Int) {
       setGeneric(i, v as T)
    }

    override fun getFloat(i: Int): Float {
        val ele = getGeneric(i)
        if (ele is Float)
            return ele
        else
            error(wrongType)
    }
    override fun setFloat(i: Int, v: Float) {
       setGeneric(i, v as T)
    }

    override fun getLong(i: Int): Long {
        val ele = getGeneric(i)
        if (ele is Long)
            return ele
        else
            error(wrongType)
    }
    override fun setLong(i: Int, v: Long) {
       setGeneric(i, v as T)
    }

    override fun getShort(i: Int): Short {
        val ele = getGeneric(i)
        if (ele is Short)
            return ele
        else
            error(wrongType)
    }
    override fun setShort(i: Int, v: Short) {
       setGeneric(i, v as T)
    }



}

