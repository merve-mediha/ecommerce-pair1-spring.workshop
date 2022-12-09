package com.etiya.ecommercedemopair1.business.constants;

public class Messages {
    public static class User
    {
        public  static final  String userExists="This user doesn't exist";
    }
    public static class City
    {
        public static final String cityExists="This city doesn't exist";
    }
    public static class Country
    {
        public static final String countryExists="This country doesn't exist";
    }
    public static class Category
    {
        public static final String categoryNameExists="This category already exists";
        public static final String categoryExistsInProduct="This category doesn't exist. Could not be added product";
    }
    public static class ProductCategory{
        public static final String categoryExistsInProduct="This category hasn't any product";

    }

    public static class AllSuffix
    {
        public static final String getAllSuffixOfMessages = "All fetched from database";

        public static final String getByIdSuffixOfMessages = "Fetched according to id from database";

        public static final  String addSuffixOfMessages = "Added to database";
    }

}
