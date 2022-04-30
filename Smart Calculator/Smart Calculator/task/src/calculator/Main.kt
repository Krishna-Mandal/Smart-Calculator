package calculator

import java.math.BigInteger
import kotlin.system.exitProcess

const val EXIT = "/exit"
const val HELP = "/help"

enum class COMMANDS {
    EXIT,
    HELP,
    BLANK,
    UNKNOWN,
    EVALUATE
}

class Calculator {

    private val infixExpression = mutableListOf<String>()
    private val postfixExpression = mutableListOf<String>()
    private var varAssignment = mutableMapOf<String, BigInteger>()

    companion object Property {
        val POSSIBLE_COMMANDS = listOf(
            EXIT,
            HELP
        )
        private val OPERATORS = "[+-\\\\*^]+".toRegex()
        private val COMMANDS_REGEX = "/\\w+".toRegex()
        private val NUMBERS = "[+-]?\\d+".toRegex()
        private val SPACES = "\\s+".toRegex()
        private val VARIABLE = "[a-zA-Z]+\\w*".toRegex()
        private const val SPACE = " "
        val VAR_NAMES = "[a-zA-Z]+\\w*".toRegex()
        val ASSIGNMENT_WITH_NUM = "\\w+\\s*=\\s*[+-]?\\w+".toRegex()
        val ASSIGNMENT_WITHOUT_NUM = "[A-Za-z]+\\s*=\\s*[+-]?\\w+\\s*".toRegex()

        fun isNumber(input: String): Boolean {
            return input.matches(NUMBERS)
        }

        fun isOpenBracket(input: String): Boolean {
            return input.trim() == "("
        }

        fun isClosingBracket(input: String): Boolean {
            return input.trim() == ")"
        }

        fun isVariable(input: String): Boolean {
            return input.matches(VARIABLE)
        }

        fun isWhiteSpace(input: String): Boolean {
            return input.matches(SPACES)
        }

        fun priority(value: String): Int {
            return when (value) {
                "(" -> 0
                "+", "-" -> 1
                "*", "/" -> 2
                "^" -> 3
                else -> -1
            }
        }
    }

    fun calculate() {
        while (true) {
            when(validateUserInput()) {
                COMMANDS.HELP -> println("The program calculates the sum of numbers")
                COMMANDS.EXIT -> {
                    println("Bye!")
                    exitProcess(0)
                }
                COMMANDS.UNKNOWN -> println("Unknown command")
                COMMANDS.EVALUATE -> evaluatePostFix()
                COMMANDS.BLANK -> {}
            }
        }
    }

    private fun validateUserInput(): COMMANDS {
        val input = readln().trim()
        infixExpression.clear()
        return if (input == EXIT) {
            COMMANDS.EXIT
        } else if (input == HELP) {
            COMMANDS.HELP
        } else if (input.matches(COMMANDS_REGEX) && input !in POSSIBLE_COMMANDS) {
            COMMANDS.UNKNOWN
        } else if (input.isBlank()) {
            COMMANDS.BLANK
        } else if (input.matches(ASSIGNMENT_WITH_NUM) || input.matches(VAR_NAMES) || input.contains("=")) {
            evaluateAssignment(input)
            COMMANDS.BLANK
        } else {
            val tmpList = input.trim().toList().map { it.toString().trim() }
            if (
                tmpList.filter { it == "(" }.size !=
                tmpList.filter { it == ")" }.size
            ) {
                println("Invalid expression")
                COMMANDS.BLANK
            } else {
                convertToPostFix(input.replace(SPACES, SPACE))
            }
        }
    }

    private fun convertToPostFix(expressions: String): COMMANDS {
        val postfixExpression = mutableListOf<String>()
        val tmpExpressions = "( $expressions )".replace(
            "\\(\\s*".toRegex(), "( "
        ).replace(
            "\\s*\\)".toRegex(), " )"
        ).split(" ")

        for (tmpString in tmpExpressions) {
            when {
                isOpenBracket(tmpString) -> infixExpression.add(tmpString)
                isClosingBracket(tmpString) -> do {
                    val tmpPopItem = infixExpression.removeLast()
                    if (tmpPopItem != "(") postfixExpression.add(tmpPopItem)
                } while (tmpPopItem != "(")
                isNumber(tmpString) -> postfixExpression.add(tmpString)
                isVariable(tmpString) -> postfixExpression.add(varAssignment[tmpString].toString())
                isWhiteSpace(tmpString) -> {}
                else -> {
                    var operand = ""
                    try {
                        operand = evaluateOperand(tmpString.trim())
                    } catch (except: Exception) {
                        println("Invalid expression")
                        return COMMANDS.BLANK
                    }
                    while (priority(infixExpression.last()) >= priority(operand) ) {
                        postfixExpression.add(infixExpression.removeLast())
                    }
                    infixExpression.add(evaluateOperand(operand))
                }
            }
        }

        while (infixExpression.isNotEmpty()) {
            postfixExpression.add(infixExpression.removeLast())
        }

        return if (postfixExpression.contains("(")) {
            println("Invalid expression")
            COMMANDS.BLANK
        } else {
            this.postfixExpression.addAll(postfixExpression)
            COMMANDS.EVALUATE
        }
    }

    private fun evaluateOperand(operand: String): String {
        if (
            !OPERATORS.matches(operand) ||
            operand.toCharArray().filter { it.toString() == "*" }.size > 1 ||
            operand.toCharArray().filter { it.toString() == "/" }.size > 1 ||
            operand.toCharArray().filter { it.toString() == "^" }.size > 1 ||
            (
                operand.toCharArray().size > 1 &&
                    (
                        operand.contains("*") ||
                            operand.contains("/") ||
                            operand.contains("^")
                    )
            )
        ) {
            throw Exception()
        }

        return if(operand.toCharArray().size == 1) {
            operand
        } else if (operand.toCharArray().filter { it.toString() == "-" }.size % 2 == 0) {
            "+"
        } else {
            "-"
        }
    }

    private fun evaluatePostFix() {
        val stack = mutableListOf<String>()
        for (tempItem in this.postfixExpression) {
            when {
                isNumber(tempItem) -> stack.add(tempItem)
                isWhiteSpace(tempItem) -> {}
                else -> {
                    val op2 = stack.removeLast().toString()
                    val op1 = stack.removeLast().toString()
                    stack.add(evaluateExpression(op1, tempItem, op2).toString())
                }
            }
        }
        println(stack.last())
    }

    private fun evaluateExpression(operator1: String, operand: String, operator2: String): BigInteger {
        val op1 = operator1.toBigInteger()
        val op2 = operator2.toBigInteger()
        return when(operand) {
            "+" -> op1 + op2
            "-" -> op1 - op2
            "*" -> op1 * op2
            "/" -> op1 / op2
            "^" -> op1.pow(op2.toInt())
            else -> {throw Exception()}
        }
    }

    private fun evaluateAssignment(expr: String) {
        if (expr.matches(VAR_NAMES)) {
            if (varAssignment.containsKey(expr)) {
                println(varAssignment[expr])
            } else {
                println("Unknown variable")
            }
        } else if (!expr.matches(ASSIGNMENT_WITHOUT_NUM)) {
            println("Invalid identifier")
        } else {
            val (variable, value) = expr.split("=").map { it.trim() }
            if (!variable.matches(VAR_NAMES)) {
                println("Invalid identifier")
            } else if (!value.matches(NUMBERS) && !value.matches(VAR_NAMES)) {
                println("Invalid assignment")
            } else if (value.matches(VAR_NAMES)) {
                if (varAssignment.containsKey(value)) {
                    varAssignment[variable] = varAssignment[value]!!
                } else {
                    println("Unknown variable")
                }
            } else {
                varAssignment[variable] = value.toBigInteger()
            }
        }
    }
}

fun main() {
    val calculator = Calculator()
    calculator.calculate()
}