package chess

import kotlin.math.abs
import kotlin.system.exitProcess

val VALID_CHESS_POS = Regex("[a-h][1-8][a-h][1-8]")
val SAME_FILE = Regex("^([a-h])[1-8]\\1[1-8]")
const val EXIT = "exit"
const val BLACK = "B"
const val WHITE = "W"
const val HORIZONTAL = "+---+---+---+---+---+---+---+---+"
const val VERTICAL = "|"
const val SPACE_1 = " "
const val SPACE_2 = "$SPACE_1$SPACE_1"
const val SPACE_3 = "$SPACE_2$SPACE_1"

val FILES = listOf("a", "b", "c", "d", "e", "f", "g", "h")
val RANKS = listOf(1, 2, 3, 4, 5, 6, 7, 8)
val currPosBlackPlayer =
    mutableListOf("a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7")
val currPosWhitePlayer =
    mutableListOf("a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2")
val enpassant = mutableMapOf<String, String>()
var enpassantAvailable = false
var consumer: String = ""

enum class Win {
    WHITE_WIN,
    BLACK_WIN,
    STALEMATE,
    GAME_ON;
}

fun startChess() {
    println("Pawns-Only Chess")

    println("First Player's name:")
    val firstPlayer = readln()

    println("Second Player's name:")
    val secondPlayer = readln()
    printChess()

    possibleMoves(firstPlayer, secondPlayer)
}

fun makeMove(player: String, isWhite: Boolean = false) {

    println("$player's turn:")
    var firstMover = readln()
    while (!exit(firstMover) && !isValidMove(firstMover, isWhite)) {
        println("$player's turn:")
        firstMover = readln()
    }

    val currPos = firstMover.substring(0, 2)
    val futPos = firstMover.substring(2, 4)

    when (isWhite) {
        true -> {
            if (currPosWhitePlayer.remove(currPos)) {
                currPosWhitePlayer.add(futPos)
            }
            if (!currPosBlackPlayer.remove(futPos)) {
                if (enpassant.isNotEmpty()) {
                    if (enpassantAvailable) {
                        currPosBlackPlayer.remove(enpassant.values.first())
                        enpassant.clear()
                        enpassantAvailable = false
                    }
                }
            }
            if (consumer.isNotEmpty() && consumer == WHITE && enpassant.isNotEmpty()) {
                enpassant.clear()
                enpassantAvailable
                consumer = ""
            }

        }
        false -> {
            if (currPosBlackPlayer.remove(currPos)) {
                currPosBlackPlayer.add(futPos)
            }
            if (!currPosWhitePlayer.remove(futPos)) {
                if (enpassant.isNotEmpty()) {
                    if (enpassantAvailable) {
                        currPosWhitePlayer.remove(enpassant.values.first())
                        enpassant.clear()
                        enpassantAvailable = false
                    }
                }
            }

            if (consumer.isNotEmpty() && consumer == BLACK && enpassant.isNotEmpty()) {
                enpassant.clear()
                enpassantAvailable
                consumer = ""
            }

        }
    }

    printChess()
    checkGameCondition(isWhite = isWhite, move = futPos)
}

fun possibleMoves(firstPlayer: String, secondPlayer: String) {
    while (true) {
        // White Moves
        makeMove(firstPlayer, true)

        // Black Moves
        makeMove(secondPlayer, false)
    }
}

fun exit(msg: String): Boolean {
    if (msg == EXIT) {
        println("Bye!")
        exitProcess(0)
    }

    return false
}

fun isValidMove(move: String, isWhite: Boolean = false,
                printStatement: Boolean = true): Boolean {

    val currPos = move.substring(0, 2)
    val currFile = move.first().code
    val currRank = move.substring(1, 2).toInt()
    val futPos = move.substring(2, 4)
    val futFile = move[move.length - 2].code
    val futRank = move.substring(3, 4).toInt()

    // Validate that position follows FILE and RANK
    if (!VALID_CHESS_POS.matches(move)) {
        if (printStatement) println("Invalid Input")
        return false
    }

    if (isWhite) {
        if (currPos !in currPosWhitePlayer) {
            if (printStatement) println("No white pawn at $currPos")
            return false
        }

        if (futPos in currPosBlackPlayer || futPos in enpassant.keys) {
            enpassantAvailable = futPos in enpassant.keys
            if (abs(futRank - currRank) == 1 && futFile == currFile) {
                if (printStatement) println("Invalid Input")
                return false
            } else if (abs(futRank - currRank) == 1 && abs(futFile - currFile) == 1) {
                return true
            }
        }

        if (currRank == 2) {
            if (abs(currRank - futRank) > 2) {
                if (printStatement) println("Invalid Input")
                return false
            } else if (abs(currRank - futRank) == 2) {
                enpassant.clear()
                enpassant["${futFile.toChar()}${futRank - 1}"] = futPos
                enpassantAvailable = false
                consumer = BLACK
            }
        }

        if (currRank != 2 && abs(currRank - futRank) > 1) {
            if (printStatement) println("Invalid Input")
            return false
        }

        if (futRank < currRank) {
            if (printStatement) println("Invalid Input")
            return false
        }

    } else {
        if (currPos !in currPosBlackPlayer) {
            if (printStatement) println("No black pawn at $currPos")
            return false
        }

        if (futPos in currPosWhitePlayer || futPos in enpassant.keys) {
            enpassantAvailable = futPos in enpassant.keys
            if (abs(futRank - currRank) == 1 && futFile == currFile) {
                if (printStatement) println("Invalid Input")
                return false
            } else if (abs(futRank - currRank) == 1 && abs(futFile - currFile) == 1) {
                return true
            }
        }

        if (currRank == 7) {
            if (abs(currRank - futRank) > 2) {
                if (printStatement) println("Invalid Input")
                return false
            } else if (abs(currRank - futRank) == 2) {
                enpassant.clear()
                enpassant["${futFile.toChar()}${futRank + 1}"] = futPos
                enpassantAvailable = false
                consumer = WHITE
            }
        }

        if (currRank != 7 && abs(currRank - futRank) > 1) {
            if (printStatement) println("Invalid Input")
            return false
        }

        if (futRank > currRank) {
            if (printStatement) println("Invalid Input")
            return false
        }


    }

    // Pawn can only move in same file
    if (!SAME_FILE.matches(move)) {
        if (printStatement) println("Invalid Input")
        return false
    }

    if (currPos == futPos) {
        if (printStatement) println("Invalid Input")
        return false
    }

    return true
}

fun printChess() {
    val chess = """${chessBuilder()}
    """.trimIndent()

    println(chess)
}

fun chessBuilder(): StringBuilder {
    val chess: StringBuilder = StringBuilder()
    for (rank in RANKS.reversed()) {
        chess.append(SPACE_2)
        chess.append(HORIZONTAL)
        chess.append("\n")
        chess.append(rank)
        chess.append(SPACE_1)
        for (file in FILES) {
            chess.append(VERTICAL)
            when ("$file$rank") {
                in currPosBlackPlayer -> {
                    chess.append("$SPACE_1$BLACK$SPACE_1")
                }
                in currPosWhitePlayer -> {
                    chess.append("$SPACE_1$WHITE$SPACE_1")
                }
                else -> {
                    chess.append(SPACE_3)
                }
            }

        }
        chess.append(VERTICAL)
        chess.append("\n")
    }
    chess.append(SPACE_2)
    chess.append(HORIZONTAL)
    chess.append("\n")
    chess.append(SPACE_1)
    for (file in FILES) {
        chess.append(SPACE_3)
        chess.append(file)
    }

    return chess
}

fun checkGameCondition(isWhite: Boolean, move: String) {

    if(isWhite) {
        if (currPosBlackPlayer.isEmpty() || move.last().toString().toInt() ==
         8 || staleMateCondition(false) == Win.WHITE_WIN
        ) {
            println("White Wins!")
            println("Bye!")
            exitProcess(0)
        }
    } else {
        if (currPosWhitePlayer.isEmpty() || move.last().toString().toInt() ==
            1 || staleMateCondition(true) == Win.BLACK_WIN
        ) {
            println("Black Wins!")
            println("Bye!")
            exitProcess(0)
        }
    }

    if(staleMateCondition(isWhite = isWhite) == Win.STALEMATE) {
        println("Stalemate!")
        println("Bye!")
        exitProcess(0)
    }
}

fun staleMateCondition(isWhite: Boolean): Win {
    var whiteInStaleMate = true
    var blackInStalemate = true

    for (move in currPosWhitePlayer) {
        var futMov1 = "${move.first()}${move.last().toString().toInt() + 1}"
        var futMov2 = "${(move.first().code + 1).toChar()}${move.last()
            .toString().toInt() + 1}"
        var futMov3 = "${(move.first().code - 1).toChar()}${move.last()
            .toString().toInt() + 1}"

        if (isValidMove("$move$futMov1", isWhite = true,
                printStatement = false) ||
            isValidMove("$move$futMov2", isWhite = true,
                printStatement = false) ||
            isValidMove("$move$futMov3", isWhite = true,
                printStatement = false)) {
            whiteInStaleMate = false
            break
        }
    }

    for (move in currPosBlackPlayer) {
        var futMov1 = "${move.first()}${move.last().toString().toInt() - 1}"
        var futMov2 = "${move.first() - 1}${move.last()}"
        var futMov3 = "${move.first() + 1}${move.last()}"

        if (isValidMove("$move$futMov1", isWhite = false,
                printStatement = false) ||
            isValidMove("$move$futMov2", isWhite = false,
                printStatement = false) ||
            isValidMove("$move$futMov3", isWhite = false,
                printStatement = false)) {
            blackInStalemate = false
            break
        }
    }

    var win = Win.STALEMATE
    (if (whiteInStaleMate && blackInStalemate) {
        Win.STALEMATE
    } else if(isWhite && blackInStalemate) {
        Win.STALEMATE
    } else if (!isWhite && whiteInStaleMate){
        Win.STALEMATE
    } else {
        Win.GAME_ON
    }).also { win = it }

    return win
}

fun main() {
    startChess()
}