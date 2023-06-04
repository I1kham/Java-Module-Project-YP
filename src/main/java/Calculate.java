public class Calculate {        /*класс для хранения переменной и методов для подсчета*/
    public static float priceToPay;


    public static void splitTheBill(float totalBill, int howManyPersons) {
        priceToPay = totalBill / howManyPersons;
    }

    public static void showBillPerPerson(float totalBill, int howManyPersons) {
        splitTheBill(totalBill, howManyPersons);
        System.out.println("Cумма к оплате для одного гостя: " + PriceFormatterToString.priceFormattingToString(priceToPay));
    }
}
