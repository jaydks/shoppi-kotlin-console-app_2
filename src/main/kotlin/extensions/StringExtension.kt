package extensions

//file로 추가한 이유는 Top-level함수로 확장함수를 추가하려고 해서
fun String?.getNotEmptyString(): String{
    var input = this
    while(input.isNullOrBlank()){
        println("값을 입력해주세요")
        input = readLine()
    }
    return input.trim()
}

fun String?.getNotEmptyInt(): Int{
    var input = this
    while(input.isNullOrEmpty()||input.toIntOrNull() == null){
        println("값을 입력해주세요")
        input = readLine()
    }
    return input.toInt()
}