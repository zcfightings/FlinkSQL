package org.apache.flink.table.codegen

import org.apache.flink.api.common.functions
import org.apache.flink.api.common.functions.Function
import org.apache.flink.api.common.io.InputFormat
import org.apache.flink.api.common.typeinfo.TypeInformation

/**
  * Describes a generated expression.
  *
  * @param resultTerm term to access the result of the expression
  * @param nullTerm boolean term that indicates if expression is null
  * @param code code necessary to produce resultTerm and nullTerm
  * @param resultType type of the resultTerm
  * @param literal flag to indicate a constant expression do not reference input and can thus
  *                 be used in the member area (e.g. as constructor parameter of a reusable
  *                 instance)
  */
case class GeneratedExpression(
                                resultTerm: String,
                                nullTerm: String,
                                code: String,
                                resultType: TypeInformation[_],
                                literal: Boolean = false)

object GeneratedExpression {
  val ALWAYS_NULL = "true"
  val NEVER_NULL = "false"
  val NO_CODE = ""
}

/**
  * Describes a generated [[functions.Function]]
  *
  * @param name class name of the generated Function.
  * @param returnType the type information of the result type
  * @param code code of the generated Function.
  * @tparam F type of function
  * @tparam T type of function
  */
case class GeneratedFunction[F <: Function, T <: Any](
                                                       name: String,
                                                       returnType: TypeInformation[T],
                                                       code: String)

/**
  * Describes a generated aggregate helper function
  *
  * @param name class name of the generated Function.
  * @param code code of the generated Function.
  */
case class GeneratedAggregationsFunction(
                                          name: String,
                                          code: String)

/**
  * Describes a generated [[InputFormat]].
  *
  * @param name class name of the generated input function.
  * @param returnType the type information of the result type
  * @param code code of the generated Function.
  * @tparam F type of function
  * @tparam T type of function
  */
case class GeneratedInput[F <: InputFormat[_, _], T <: Any](
                                                             name: String,
                                                             returnType: TypeInformation[T],
                                                             code: String)

/**
  * Describes a generated [[org.apache.flink.util.Collector]].
  *
  * @param name class name of the generated Collector.
  * @param code code of the generated Collector.
  */
case class GeneratedCollector(name: String, code: String)

/**
  * Describes a generated [[org.apache.flink.cep.pattern.conditions.IterativeCondition]].
  *
  * @param name class name of the generated IterativeCondition.
  * @param code code of the generated IterativeCondition.
  */
case class GeneratedIterativeCondition(name: String, code: String)

/**
  * Describes a generated [[org.apache.flink.cep.PatternSelectFunction]].
  *
  * @param name class name of the generated PatternSelectFunction.
  * @param code code of the generated PatternSelectFunction.
  */
case class GeneratedPatternSelectFunction(name: String, code: String)

/**
  * Describes a generated [[org.apache.flink.cep.PatternFlatSelectFunction]].
  *
  * @param name class name of the generated PatternFlatSelectFunction.
  * @param code code of the generated PatternFlatSelectFunction.
  */
case class GeneratedPatternFlatSelectFunction(name: String, code: String)
