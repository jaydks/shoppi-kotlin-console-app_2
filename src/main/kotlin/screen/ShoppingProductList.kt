package screen

import data.CartItems
import data.Product

class ShoppingProductList {
    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션", "겨울 바지"),
        Product("전가 기기", "핸드폰"),
        Product("전가 기기", "블루투스 이어폰"),
        Product("전가 기기", "노트북"),
        Product("반려동물용품", "건식사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식")
    )
    private val categories: Map<String, List<Product>> = products.groupBy { product ->
        product.categoryLabel
    }

    fun showProduct(selectedCategory: String){
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()){
            println("""
                ***====================================***
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())

            categoryProducts.forEachIndexed{ index, product ->
                println("${index}. ${product.name}")
            }
            showCartOption(categoryProducts, selectedCategory)


        }else{
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts: List<Product>, selectedCategory: String) {
        println("""
                ***====================================***
                장바구니에 담을 상품 번호를 선택해주세요.
            """.trimIndent()
        )

        val selectedIndex = readLine()?.toIntOrNull()!! // 입력 값이 없는 값이면?
        categoryProducts.getOrNull(selectedIndex)?.let{product ->
            CartItems.addProducts(product)
            println("=> 장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *를 입력해주세요.")
            val answer = readLine()
            if(answer == "#"){
                val shoppingcart = ShoppingCart()
                shoppingcart.showCartItems()
            } else if(answer == "*"){
                showProduct(selectedCategory)
            } else{
                // TODO 그 외 값을 입력한 경우에 대한 처리
            }
        }

    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리의 상품이 등록되기 전입니다.")
    }
}