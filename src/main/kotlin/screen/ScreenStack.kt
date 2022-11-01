package screen

object ScreenStack { // ScreenStack도 프로그램 전체제서 관리하는 싱글톤 패턴이어도 괜찮을 듯
    private val screenStack = mutableListOf<Screen>()

    fun push(screen: Screen){
        screenStack.add(screen)
    }

    fun pop(){
        screenStack.removeLastOrNull()
    }

    fun peek(): Screen? {
        return screenStack.lastOrNull()
    }
}

sealed class Screen // 우리가 만든 모든 화면들은 Screen의 서브 클래스가 될 것