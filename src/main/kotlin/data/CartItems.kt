package data

object CartItems { // cartItems는 프로젝트 전역에서 상품 데이터를 저장하는 class 이므로 항상 같은 값이 유지되어야 하므로 싱글턴 객체가 적합
    private val mutableProducts = mutableMapOf<Product, Int>() // mutable 타입은 private으로 설정해 외부에서 수정하지 못하도록
    val products: Map<Product, Int> = mutableProducts // 외부에 공개하는 products는 immutable -> read only

    fun addProducts(product: Product){
        mutableProducts[product]?.let{
            mutableProducts[product] = it + 1
        } ?: kotlin.run {
            mutableProducts[product] = 1
        }
    }
}