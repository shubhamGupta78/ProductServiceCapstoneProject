package com.example.demo.services.Filter;

public class FilterFactory {


    public static FilterService getFilterService(String filterType) {
        switch (filterType) {
            case "Brand":
                return new BrandFilterService();
           case "Category":
               return new CategoryFilterService();
            case "Ram":
                return new RamFilterService();

        }

        return null;
    }
}
