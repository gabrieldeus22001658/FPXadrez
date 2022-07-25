fun buildMenu(): String {
    return "1-> Start New Game;\n" + "2-> Exit Game.\n"
}
fun checkIsNumber(number: String): Boolean {
    return number[0].toInt() in 48..57 && number != ""
}
fun checkName(number: String): Boolean {
    var testarCaracter = 0
    while (number[testarCaracter] != ' ') {
        if (testarCaracter + 1 >= number.length) {
            return false
        }
        testarCaracter++

    }
    return when {
        number[0].toInt() >= 65 && number[0].toInt() <= 90 && testarCaracter < number.length
                && number[testarCaracter + 1].toInt() >= 65 && number[testarCaracter + 1].toInt() <= 90 -> true
        else -> false
    }
}
fun showChessLegendOrPieces(message: String): Boolean? {
    return when (message) {
        'y'.toString() -> true
        'Y'.toString() -> true
        'n'.toString() -> false
        'N'.toString() -> false
        else -> null
    }
}
fun buildBoard(numColumns: Int, numLines: Int, showLegend: Boolean = false, showPieces: Boolean = false,
               pieces: Array<Pair<String,String>?>): String {
    val esc: String = Character.toString(27)
    val startBlue = "$esc[30;44m"
    val startGrey = "$esc[30;47m"
    val startWhite = "$esc[30;30m"
    val end = "$esc[0m"
    var count = 0
    var count2 = 1
    var count3 = 0
    var return1 : String = ""
    var return2 : String = ""
    var return3 : String = ""
    val abc : Array<Char> =
        arrayOf('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z')
    var count4 : Int

    while (count < numColumns + 2) {

        if(showLegend){
            if (count == 0 || count == numColumns + 1) {
                return2 += "$startBlue   $end"
            }else{
                return2 += "$startBlue ${abc[count-1]} $end"
            }
            return3 += "$startBlue   $end"
            count3++
        }

        count++
    }                                                                   // Barra azul de cima e de baixo
    return2 += "\n"

    count4=0
    for (linha in 1..numLines) {
        if (showLegend) {
            return1 += "$startBlue $count2 $end"        // Barra azul do lado esquerdo
        }
        else {
            //return1 += "$startBlue   $end"
        }
        count2++
        for (coluna in 1..numColumns) {
            var peca = pieces[count4]?.first
            var cor = pieces[count4]?.second
            if(peca==null)peca="X"
            if(cor==null)cor="X"
            if(!showPieces){
                peca="X"
                cor="X"
            }
            val pecaString = convertStringToUnicode(peca,cor)
            if ((coluna % 2 == 0 && linha % 2 == 0) || (coluna % 2 != 0 && linha % 2 != 0)) {
                return1 += "$startWhite $pecaString $end"

            } else {

                return1 += "$startGrey $pecaString $end"

            }
            count4++
        }
        if(showLegend) {
            return1 += "$startBlue   $end"           // Barra azul do lado direito
        }
        return1 += "\n"
    }
    var returnfinal : String
    if(showLegend){
         returnfinal = return2 + return1 + return3 + "\n"
    }else{
         returnfinal = return1
    }
    return returnfinal
}
fun createInitialBoard(numColumns: Int, numLines: Int): Array<Pair<String,String>?> {

    var pecas : Array<Pair<String,String>?> = arrayOfNulls<Pair<String,String>?>(0)
    if (numColumns == 8 && numLines == 8) {
        pecas = arrayOfNulls<Pair<String,String>?>(numColumns*numLines)
        pecas[0] = Pair("T" , "b"); pecas[1] = Pair("H" , "b"); pecas[2] = Pair("B" , "b"); pecas[3] = Pair("Q" , "b")
        pecas[4] = Pair("K" , "b"); pecas[5] = Pair("B" , "b"); pecas[6] = Pair("H" , "b"); pecas[7] = Pair("T" , "b")
        pecas[8] = Pair("P" , "b"); pecas[9] = Pair("P" , "b"); pecas[10] = Pair("P" , "b"); pecas[11] = Pair("P" , "b")
        pecas[12] = Pair("P" , "b"); pecas[13] = Pair("P" , "b"); pecas[14] = Pair("P" , "b"); pecas[15] = Pair("P" , "b")
        pecas[48] = Pair("P" , "w"); pecas[49] = Pair("P" , "w"); pecas[50] = Pair("P" , "w");pecas[51] = Pair("P" , "w")
        pecas[52] = Pair("P" , "w"); pecas[53] = Pair("P" , "w"); pecas[54] = Pair("P" , "w"); pecas[55] = Pair("P" , "w")
        pecas[56] = Pair("T" , "w"); pecas[57] = Pair("H" , "w"); pecas[58] = Pair("B" , "w"); pecas[59] = Pair("K" , "w")
        pecas[60] = Pair("Q" , "w"); pecas[61] = Pair("B" , "w"); pecas[62] = Pair("H" , "w"); pecas[63] = Pair("T" , "w")
    }
    else if (numColumns == 7 && numLines == 7) {
        pecas = arrayOfNulls<Pair<String,String>?>(numColumns*numLines)
        pecas[0] = Pair("T" , "b");pecas[1] = Pair("H" , "b");pecas[2] = Pair("B" , "b");pecas[3] = Pair("K" , "b")
        pecas[4] = Pair("B" , "b");pecas[5] = Pair("H" , "b");pecas[6] = Pair("T" , "b");pecas[7] = Pair("P" , "b")
        pecas[8] = Pair("P" , "b");pecas[9] = Pair("P" , "b");pecas[10] = Pair("P" , "b");pecas[11] = Pair("P" , "b")
        pecas[12] = Pair("P" , "b");pecas[13] = Pair("P" , "b");pecas[35] = Pair("P" , "w");pecas[36] = Pair("P" , "w")
        pecas[37] = Pair("P" , "w");pecas[38] = Pair("P" , "w");pecas[39] = Pair("P" , "w");pecas[40] = Pair("P" , "w")
        pecas[41] = Pair("P" , "w");pecas[42] = Pair("T" , "w");pecas[43] = Pair("H" , "w");pecas[44] = Pair("B" , "w")
        pecas[45] = Pair("K" , "w");pecas[46] = Pair("B" , "w");pecas[47] = Pair("H" , "w");pecas[48] = Pair("T" , "w")
    }
    else if (numColumns == 6 && numLines == 6) {
        pecas = arrayOfNulls<Pair<String,String>?>(numColumns*numLines)
        pecas[0] = Pair("H" , "b");pecas[1] = Pair("B" , "b");pecas[2] = Pair("Q" , "b");pecas[3] = Pair("K" , "b")
        pecas[4] = Pair("B" , "b");pecas[5] = Pair("T" , "b");pecas[6] = Pair("P" , "b");pecas[7] = Pair("P" , "b")
        pecas[8] = Pair("P" , "b");pecas[9] = Pair("P" , "b");pecas[10] = Pair("P" , "b");pecas[11] = Pair("P" , "b")
        pecas[24] = Pair("P" , "w");pecas[25] = Pair("P" , "w");pecas[26] = Pair("P" , "w");pecas[27] = Pair("P" , "w")
        pecas[28] = Pair("P" , "w");pecas[29] = Pair("P" , "w");pecas[30] = Pair("H" , "w");pecas[31] = Pair("B" , "w")
        pecas[32] = Pair("K" , "w");pecas[33] = Pair("Q" , "w");pecas[34] = Pair("B" , "w");pecas[35] = Pair("T" , "w")
    }
    else if (numColumns == 6 && numLines == 7){
        pecas = arrayOfNulls<Pair<String,String>?>(numColumns*numLines)
        pecas[0] = Pair("T" , "b");pecas[1] = Pair("B" , "b");pecas[2] = Pair("Q" , "b");pecas[3] = Pair("K" , "b")
        pecas[4] = Pair("B" , "b");pecas[5] = Pair("H" , "b");pecas[6] = Pair("P" , "b");pecas[7] = Pair("P" , "b")
        pecas[8] = Pair("P" , "b");pecas[9] = Pair("P" , "b");pecas[10] = Pair("P" , "b");pecas[11] = Pair("P" , "b")
        pecas[30] = Pair("P" , "w");pecas[31] = Pair("P" , "w");pecas[32] = Pair("P" , "w");pecas[33] = Pair("P" , "w")
        pecas[34] = Pair("P" , "w");pecas[35] = Pair("P" , "w");pecas[36] = Pair("T" , "w");pecas[37] = Pair("B" , "w")
        pecas[38] = Pair("K" , "w");pecas[39] = Pair("Q" , "w");pecas[40] = Pair("B" , "w");pecas[41] = Pair("H" , "w")
    }
    else if (numColumns == 4 && numLines == 4) {
        pecas = arrayOfNulls<Pair<String,String>?>(numColumns*numLines)
        pecas[2] = Pair("T","b"); pecas[3] = Pair("B","b"); pecas[12] = Pair("T","w"); pecas[13] = Pair("Q","w")
    }
    return pecas
}
fun convertStringToUnicode(piece: String, color: String): String {
    if (piece == "K" && color == "w") { return "\u2654" }
    else if (piece == "K" && color == "b") { return "\u265A" }
    else if (piece == "K" && color == "w") { return "\u2654" }
    else if (piece == "Q" && color == "b") { return "\u265B" }
    else if (piece == "Q" && color == "w") { return "\u2655" }
    else if (piece == "B" && color == "b") { return "\u265D" }
    else if (piece == "B" && color == "w") { return "\u2657" }
    else if (piece == "H" && color == "b") { return "\u265E" }
    else if (piece == "H" && color == "w") { return "\u2658" }
    else if (piece == "T" && color == "b") { return "\u265C" }
    else if (piece == "T" && color == "w") { return "\u2656" }
    else if (piece == "P" && color == "b") { return "\u265F" }
    else if (piece == "P" && color == "w") { return "\u2659" }
    else return " "
}
fun createTotalPiecesAndTurn(numColumns: Int, numLines: Int): Array<Int?> {
    val totalPiecesAndTurn = arrayOf(null,null,0)
    var nPecasDeCada = 0
    if (numColumns == 8 && numLines == 8) {
        nPecasDeCada=16
    }
    else if (numColumns == 7 && numLines == 7) {
        nPecasDeCada=14
    }
    else if (numColumns == 6 && numLines == 6) {
        nPecasDeCada=12
    }
    else if (numColumns == 6 && numLines == 7){
        nPecasDeCada=12
    }
    else if (numColumns == 4 && numLines == 4) {
        nPecasDeCada=2
    }
    totalPiecesAndTurn[0]=nPecasDeCada
    totalPiecesAndTurn[1]=nPecasDeCada
    return totalPiecesAndTurn
}
fun getCoordinates (readText: String?): Pair<Int, Int>? {
    if(readText == null || readText.length != 2) return null
    val coordenadaX = readText[0].toInt() - 48
    val coordenadaY = readText[1].toUpperCase().toInt() -64
    val coordinates = Pair(coordenadaX,coordenadaY)
    return coordinates
}
fun converterCoordenadaParaIndex (coordenada: Pair<Int,Int>,numColumns: Int):Int {
    return ((((coordenada.first-1)*numColumns)+coordenada.second)-1)
}
fun checkRightPieceSelected(pieceColor: String, turn: Int): Boolean {
    return (turn == 0 && pieceColor == "w") || (turn == 1 && pieceColor == "b")
}
fun isCoordinateInsideChess (coord: Pair<Int, Int>,numColumns: Int,numLines: Int):Boolean {
    return (coord.first <= numLines && coord.first > 0) && (coord.second <= numColumns && coord.second > 0)
}
fun isKnightValid(currentCoord: Pair<Int, Int>,targetCoord: Pair<Int, Int>,pieces: Array<Pair<String, String>?>,
                  numColumns: Int,numLines: Int):Boolean {
    if(isCoordinateInsideChess(targetCoord,numColumns,numLines)) {
        if (pieces[converterCoordenadaParaIndex(currentCoord, numColumns)]?.second == "w") {
            if ((targetCoord.first - currentCoord.first == -1 || targetCoord.first - currentCoord.first == 1) &&
                targetCoord.second == currentCoord.second) {
                return pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second != "w"
            }
        } else {
            if ((targetCoord.first - currentCoord.first == -1 || targetCoord.first - currentCoord.first == 1) &&
                targetCoord.second == currentCoord.second) {
                return pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second != "b"
            }
        }
    }
    return false
}
fun isHorseValid(currentCoord: Pair<Int, Int>,targetCoord : Pair<Int, Int>,pieces : Array<Pair<String, String>?>,
                 numColumns: Int, numLines: Int): Boolean {
    if (isCoordinateInsideChess(targetCoord, numColumns, numLines)) {
        if (pieces[converterCoordenadaParaIndex(currentCoord, numColumns)]?.second == "w") {
            if (pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == "b" ||
                pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == null) {
                if ((((targetCoord.first - currentCoord.first == 2) || (targetCoord.first - currentCoord.first == -2))
                            && (targetCoord.second - currentCoord.second == 1 ||
                            targetCoord.second - currentCoord.second == -1)) ||
                    ((targetCoord.first - currentCoord.first == 1) || (targetCoord.first - currentCoord.first == -1))
                    && (targetCoord.second - currentCoord.second == 2 ||
                            targetCoord.second - currentCoord.second == -2)) {
                    return true
                }
            }
        } else {
            if (pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == "w" ||
                pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == null) {
                if ((((targetCoord.first - currentCoord.first == 2) || (targetCoord.first - currentCoord.first == -2))
                            && (targetCoord.second - currentCoord.second == 1
                            || targetCoord.second - currentCoord.second == -1)) ||
                    ((targetCoord.first - currentCoord.first == 1)
                            || (targetCoord.first - currentCoord.first == -1))
                    && (targetCoord.second - currentCoord.second == 2 ||
                            targetCoord.second - currentCoord.second == -2)) {
                }
                return true
            }
        }
    }
    return false
}
fun isKingValid(currentCoord: Pair<Int, Int>,targetCoord : Pair<Int, Int>,pieces: Array<Pair<String, String>?>,
                numColumns: Int,numLines: Int):Boolean {
    if (isCoordinateInsideChess(targetCoord, numColumns, numLines)) {
        if (pieces[converterCoordenadaParaIndex(currentCoord, numColumns)]?.second == "w") {
            if (pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == "b" ||
                pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == null) {
                if (((targetCoord.first - currentCoord.first == -1) || (targetCoord.first - currentCoord.first == 1) ||
                            (targetCoord.first == currentCoord.first)) &&
                    (targetCoord.second - currentCoord.second == 1 ||
                            targetCoord.second - currentCoord.second == -1 ||
                            targetCoord.second == currentCoord.second)) {
                    return true
                }
            }
        }else {
            if (pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == "w" ||
                    pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == null) {
                        if ((targetCoord.first - currentCoord.first == -1 || targetCoord.first - currentCoord.first
                                    == 1 ||
                                targetCoord.first == currentCoord.first) &&
                        (targetCoord.second - currentCoord.second == 1 ||
                                targetCoord.second - currentCoord.second == -1 ||
                                targetCoord.second == currentCoord.second)) {
                        return true
                    }
            }
        }
    }
    return false
}
fun isTowerValid(currentCoord: Pair<Int, Int>,targetCoord: Pair<Int, Int>,pieces: Array<Pair<String, String>?>,
                 numColumns: Int,numLines: Int):Boolean {
    if (isCoordinateInsideChess(targetCoord, numColumns, numLines)) {
        if (pieces[converterCoordenadaParaIndex(currentCoord, numColumns)]?.second == "w") {
            if (pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == "b" ||
                pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == null) {
                if ((currentCoord.first == targetCoord.first))  {
                    return true
                }
                else if((currentCoord.second == targetCoord.second)) {
                    return true
                }
            }
        }
        else {
            if (pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == "w" ||
                pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == null) {
                if ((currentCoord.first == targetCoord.first))  {
                    return true
                }
                else if ((currentCoord.second == targetCoord.second)) {
                    return true
                }
            }
        }
    }
    return false
}
fun isBishopValid(currentCoord: Pair<Int, Int>,targetCoord: Pair<Int, Int>,pieces: Array<Pair<String, String>?>,
                  numColumns: Int,numLines: Int): Boolean {
    if (isCoordinateInsideChess(targetCoord, numColumns, numLines)) {
        if (pieces[converterCoordenadaParaIndex(currentCoord, numColumns)]?.second == "w") {
            if (pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == "b" ||
                pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == null) {
                val diferencaDeLinhas = currentCoord.first - targetCoord.first
                val differencaDeColunas = currentCoord.second - targetCoord.second
                if (diferencaDeLinhas == differencaDeColunas || diferencaDeLinhas == -differencaDeColunas) {
                    return true
                }
            }
        }else{
            if (pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == "w" ||
                pieces[converterCoordenadaParaIndex(targetCoord, numColumns)]?.second == null) {
                val diferencaDeLinhas = currentCoord.first - targetCoord.first
                val differencaDeColunas = currentCoord.second - targetCoord.second
                if (diferencaDeLinhas == differencaDeColunas || diferencaDeLinhas == -differencaDeColunas) {
                    return true
                }
            }
        }
    }
    return false
}
fun isQueenValid(currentCoord: Pair<Int, Int>,targetCoord: Pair<Int, Int>,pieces: Array<Pair<String, String>?>,
                 numColumns: Int,numLines: Int):Boolean {
    return isTowerValid(currentCoord, targetCoord,pieces,numColumns,numLines) ||
            isBishopValid(currentCoord,targetCoord,pieces,numColumns,numLines)
}
fun isValidTargetPiece(currentSelectedPiece: Pair<String, String>,currentCoord : Pair<Int, Int>, targetCoord :
Pair<Int, Int>, pieces : Array<Pair<String, String>?>, numColumns: Int, numLines: Int): Boolean {
    return when (currentSelectedPiece.first) {
        "K" -> isKingValid(currentCoord,targetCoord,pieces,numColumns,numLines)
        "Q" -> isQueenValid(currentCoord,targetCoord,pieces,numColumns,numLines)
        "B" -> isBishopValid(currentCoord,targetCoord,pieces,numColumns,numLines)
        "H" -> isHorseValid(currentCoord,targetCoord,pieces,numColumns,numLines)
        "T" -> isTowerValid(currentCoord,targetCoord,pieces,numColumns,numLines)
        "P" -> isKnightValid(currentCoord,targetCoord,pieces,numColumns,numLines)
        else -> false
    }
}
fun movePiece(pieces : Array<Pair<String, String>?>, numColumns: Int, numLines: Int, currentCoord: Pair<Int, Int>,
              targetCoord: Pair<Int, Int>, totalPiecesAndTurn : Array<Int>): Boolean {
    val pecaSelecionada : Pair<String,String>? = pieces[converterCoordenadaParaIndex(currentCoord, numColumns)]
    if (pecaSelecionada!=null) {
        if (checkRightPieceSelected(pecaSelecionada.second,totalPiecesAndTurn[2])) {
            if (isValidTargetPiece(pecaSelecionada,currentCoord,targetCoord,pieces,numColumns,numLines)) {
                if (pieces[converterCoordenadaParaIndex(targetCoord, numColumns)] != null) {
                    if(totalPiecesAndTurn[2]==0) {
                        totalPiecesAndTurn[1]--
                    }
                    else {
                        totalPiecesAndTurn[0]--
                    }
                }
                pieces[converterCoordenadaParaIndex(targetCoord, numColumns)] = pieces[converterCoordenadaParaIndex(currentCoord, numColumns)]
                pieces[converterCoordenadaParaIndex(currentCoord, numColumns)] = null
                if(totalPiecesAndTurn[2] == 0) {
                    totalPiecesAndTurn[2] = 1
                    return true
                }
                else {
                    totalPiecesAndTurn[2] = 0
                    return true
                }
            }
        }
    }
    return false
}
fun conversor(totalPiecesAndTurn : Array<Int?>):Array<Int>?{
    val aDevolver : Array<Int>? = arrayOf(0,0,0)
    var converter=totalPiecesAndTurn[0]
    if(converter!=null && aDevolver != null){
        aDevolver[0]=converter
        converter=totalPiecesAndTurn[1]
        if(converter!=null && aDevolver != null) {
            aDevolver[1] = converter
            converter = totalPiecesAndTurn[2]
            if (converter != null && aDevolver != null) {
                aDevolver[2] = converter
                return aDevolver
            }
        }
    }
    return null
}
fun startNewGame (whitePlayer: String, blackPlayer: String, pieces : Array<Pair<String, String>?>,
                  totalPiecesAndTurn : Array<Int?>, numColumns: Int,numLines: Int, showLegend: Boolean= false,
                  showPieces: Boolean = false) {
    val totalPiecesAndTurnDef = conversor(totalPiecesAndTurn)
    if(totalPiecesAndTurnDef == null) return
    while (totalPiecesAndTurn[0] != 0 && totalPiecesAndTurn[1] != 0) {
        println(buildBoard(numColumns, numLines, showLegend, showPieces, pieces))
        var nomeJogador = ""
        if (totalPiecesAndTurnDef[2] == 0) { nomeJogador = whitePlayer }
        else nomeJogador = blackPlayer
        println("$nomeJogador, choose a piece (e.g 2D).\nMenu-> m;\n")
        var current = readLine()
        if (current == "m") return
        var currentCoord = getCoordinates(current)
        var color : String?
        var validCurrentCoord=false
        val vezDeJogar = totalPiecesAndTurnDef[2]
        if(currentCoord!=null && converterCoordenadaParaIndex(currentCoord, numColumns)<pieces.size &&
            converterCoordenadaParaIndex(currentCoord, numColumns)>-1){
            color = pieces[converterCoordenadaParaIndex(currentCoord, numColumns)]?.second
            if(color!=null && vezDeJogar!= null && checkRightPieceSelected(color,vezDeJogar)){
                validCurrentCoord=true
            }
        }
        println("$nomeJogador, choose a target piece (e.g 2D).\nMenu-> m;\n")
        var target = readLine()
        if (target == "m") return
        var targetCoord = getCoordinates(target)
        var validTargetCoord=false
        if(targetCoord!=null && converterCoordenadaParaIndex(targetCoord, numColumns)<pieces.size &&
            converterCoordenadaParaIndex(targetCoord, numColumns)>-1){
            if(currentCoord!=null && movePiece(pieces, numColumns, numLines, currentCoord, targetCoord, totalPiecesAndTurnDef)){
                validTargetCoord=true
            }
        }
        while(!validTargetCoord && !validCurrentCoord){
            println("Invalid response.")
            println("$nomeJogador, choose a piece (e.g 2D).\nMenu-> m;\n")
            current = readLine()
            if (current == "m") return
            currentCoord = getCoordinates(current)
            if(currentCoord!=null && converterCoordenadaParaIndex(currentCoord, numColumns)<pieces.size &&
                converterCoordenadaParaIndex(currentCoord, numColumns)>-1){
                    color = pieces[converterCoordenadaParaIndex(currentCoord, numColumns)]?.second
                    if(color!=null && vezDeJogar!= null && checkRightPieceSelected(color,vezDeJogar)){
                        validCurrentCoord=true
                    }
                }
            println("Invalid response.")
            println("$nomeJogador, choose a piece (e.g 2D).\nMenu-> m;\n")
            target = readLine()
            if (target == "m") return
            targetCoord = getCoordinates(target)
            if(targetCoord!=null && converterCoordenadaParaIndex(targetCoord, numColumns)<pieces.size &&
                converterCoordenadaParaIndex(targetCoord, numColumns)>-1){
                if(currentCoord!=null && movePiece(pieces, numColumns, numLines, currentCoord, targetCoord, totalPiecesAndTurnDef)){
                    validTargetCoord=true
                }
            }
        }
    }
}
fun wantSpecificPiece(message: String): Boolean? {
    return when (message) {
        'y'.toString() -> true
        'Y'.toString() -> true
        'n'.toString() -> false
        'N'.toString() -> false
        else -> null
    }
}
fun isASpecificPieceValid(piece: String): Boolean {
    return when (piece.toUpperCase()) {
        "K" -> true
        "Q" -> true
        "B" -> true
        "H" -> true
        "T" -> true
        "P" -> true
        else -> false
    }
}
fun replaceWithSpecificPiece(pieces: Array<Pair<String,String>?>, piece: String) {
    for (index in 0..pieces.size -1) {
        if (pieces[index] != null) {
            if (pieces[index]?.second == "w") {
                pieces[index] = Pair(piece , "w" )
            }else {
                if (pieces[index]?.second == "b") {
                    pieces[index] = Pair(piece, "b")
                }
            }
        }
    }
}
fun main () {
    println("Welcome to the Chess Board Game!")
    val buildMenu = buildMenu()
    var exitGame = false
    while (exitGame == false) {
        println(buildMenu)
        val opcao: String? = readLine() ?: return
        when (opcao) {
            "1" -> {
                println("First player name?\n")
                var whitePlayer = readLine()
                while (whitePlayer == null || !checkName(whitePlayer)) {
                    println("Invalid response.");println("First player name?\n")
                    whitePlayer = readLine()
                }
                println("Second player name?\n")
                var blackPlayer = readLine()
                while (blackPlayer == null || !checkName(blackPlayer)) {
                    println("Invalid response.");println("Second player name?\n")
                    blackPlayer = readLine()
                }
                println("How many chess columns?\n")
                var columns = readLine()
                println("How many chess lines?\n")
                var lines = readLine()
                while (!(lines != null && checkIsNumber(lines) && ((columns == "8" && lines == "8") ||
                            (columns == "7" && lines == "7") || (columns == "6" && lines == "6") ||
                            (columns == "6" && lines == "7") ||
                            (columns == "4" && lines == "4")))) {
                    println("Invalid response.");println("How many chess columns?\n")
                    columns = readLine()
                    println("How many chess lines?\n")
                    lines = readLine()
                }
                println("Show legend (y/n)?\n")
                var legend = readLine()
                while (legend == null || showChessLegendOrPieces(legend) == null) {
                    println("Invalid response.");println("Show legend (y/n)?\n")
                    legend = readLine()
                }
                println("Show pieces (y/n)?\n")
                var pieces = readLine()
                while (pieces == null || showChessLegendOrPieces(pieces) == null) {
                    println("Invalid response.");println("Show pieces (y/n)?\n")
                    pieces = readLine()
                }
                println("Do you want to play with only one type of piece on the board? (y/n)?\n")
                var onePiece = readLine()
                while (onePiece == null || wantSpecificPiece(onePiece) == null) {
                    println("Invalid response.")
                    println("Do you want to play with only one type of piece on the board? (y/n)?\n")
                    onePiece = readLine()
                }
                val numColumns = columns.toInt();
                val numLines = lines.toInt()
                val pecas = createInitialBoard(numColumns, numLines)
                val totalPiecesAndTurn = createTotalPiecesAndTurn(numColumns, numLines)
                val showLegend = showChessLegendOrPieces(legend);
                val showPieces = showChessLegendOrPieces(pieces)
                if (onePiece == "y" || onePiece == "Y") {
                    println("Choose a specific piece\n")
                    var specificPiece = readLine()
                    while (specificPiece == null || isASpecificPieceValid(specificPiece) == null) {
                        println("Invalid response.");println("Choose a specific piece\n")
                        specificPiece = readLine()
                    }
                    replaceWithSpecificPiece(pecas, specificPiece)
                }
                if (showLegend != null && showPieces != null) {
                    startNewGame(whitePlayer, blackPlayer, pecas, totalPiecesAndTurn, numColumns, numLines, showLegend,
                        showPieces
                    )
                }
            }
            "2" -> {exitGame = true}
        }
    }
}

