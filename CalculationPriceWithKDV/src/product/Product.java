package product;

import kdv.ProperiesOfKDV;

public class Product extends ProperiesOfKDV {
    private int count;
    private int priceProduct;
    private String nameProduct;

    public Product(double costKDV) {
        super(costKDV);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double calculatePriceIncludeKDV(){
        return (double) getPriceProduct() + calculatekdvCost();
    }

    private double calculatekdvCost(){
        return getPriceProduct()*getCostKDV();
    }
}
