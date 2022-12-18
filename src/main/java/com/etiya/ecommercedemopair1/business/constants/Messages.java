package com.etiya.ecommercedemopair1.business.constants;

public class Messages {

   public static class AllSuffix
    {
        public static final String allFetchedFromDatabase ="All fetched from database";

        public static final String getByIdSuffixOfMessages ="Fetched according to id from database";

        public static final  String addSuffixOfMessages ="Added to database";
    }

    public static class User
    {
        public  static final  String userExists="userNotFound";
        public static final String usergetted="allUserFetched";
    }
    public static class City
    {
        public static final String cityExists="cityNotFound";
    }
    public static class Country
    {
        public static final String countryExists="countryNotFound";
    }
    public static class Category
    {
        public static final String categoryNameExists="categoryNameExists";
        public static final String categoryExistsInProduct="categoryExistsInProduct";
    }
    public static class ProductCategory{
        public static final String categoryExistsInProduct="categoryExistsInProduct";

    }
    public static class Order{
        public static final String orderExists="orderExists";
        public static final String orderAdded="orderAdded";
    }
    public static class Cart{
        public static final String productExists="productExists";
    }
    public static class Address{
        public static final String addressExists="addressExists";
        public static final String addressSuccessAdded="addressSuccessAdded";
        public static final String addressWasFound="addressWasFound";
        public static final String getAllAddresses="getAllAddresses";
        public static final String ordersListedByAddressId="ordersListedByAddressId";
    }
    public static class Customer
    {
        public static final String getAllCustomers="getAllCustomers";
        public static final String getcustomerWasFound="customerWasFound";
        public static final String customerWasAdded="customerWasAdded";
        public static final String customerWithGender="customerWithGender";
        public static final String emailByName="emailByName";

    }
    public static class Product{
        public static String  productByName="productByName";
        public static String  allProductByCalled ="allProductByCalled";
        public static String productWasFound="productWasFound";
        public static String  productSortedAsc="productSortedAsc";
        public static String productGreaterThanStock="productGreaterThanStock";

    }

}
