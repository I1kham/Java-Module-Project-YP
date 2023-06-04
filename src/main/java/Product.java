import java.util.Locale;

public class Product {    /*новый класс для переменных продукт, содержит в себе номер строки или ноиер по парадку, название и цену*/
    static int productNumber;
    static String productName;
    static float productPrice;

    Product(int number, String name, float price) {  /*конструктор класса продукт*/
        productNumber = number;
        productName = name;
        productPrice = price;
    }

    public static String getProductData(Product product, String whatToShow) { /*метод класса продукт, возвращает строку в зависимости аргумента,
                                                                              на входе, получает переменную класса продукт и строку с названием
                                                                               данных которую необходимо получить  */

        switch (whatToShow) {
            case "number":
                return String.valueOf(Product.productNumber);
            case "name":
                return Product.productName;
            case "price":
                return String.valueOf(Product.productPrice);
            default:
                return "<getProductData> method can`t show this data";

        }
    }

    public static String saveProductToString(Product product) {
        String productPriceWithRUB = PriceFormatterToString.priceFormattingToString(Float.parseFloat(getProductData(product, "price")));
        return "# " + getProductData(product, "number") + " " + getProductData(product, "name") + " " + productPriceWithRUB + "\n";
    }
}
