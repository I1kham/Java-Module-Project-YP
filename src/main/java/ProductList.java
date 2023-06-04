public class ProductList { /*класс для хранения списка продуктов, как по мне
 *костыль, но в массивы мы не умеем ¯\_( ͡❛ ͜ʖ ͡❛)_/¯*/
    public static String productList;
    public static float totalProductPrice;
    public static void writeToProductList(Product product) {             /*тут пишем в строку отформатированные данные для сохранения в строку*/
        productList = productList + Product.saveProductToString(product);
        totalProductPrice = totalProductPrice + Float.parseFloat(Product.getProductData(product, "price"));
    }

    public static void showProductList() {
        System.out.println(ProductList.productList);   /*сием выводим в консоль список продуктов*/
    }

    public static void showTotalProductListPrice() {        /*сием выводим в консоль общую сумму*/
        System.out.println("Общая сумма к оплате: " + PriceFormatterToString.priceFormattingToString(ProductList.totalProductPrice));
    }
}

