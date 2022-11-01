import screen.ShoppingHome
/*
* Step 1. 장바구니에 추가한 상품 관리
* Step 2. 사용자 입력값 요청 처리 공통화 -> extension 함수를 활용해 반복되는 부분에 대한 처리를 간단하게 해보자
* Step 3. 프로젝트 전역에서 참조하는 상수
* */
fun main(args: Array<String>){
    val shoppingHome = ShoppingHome()
    shoppingHome.start()
}