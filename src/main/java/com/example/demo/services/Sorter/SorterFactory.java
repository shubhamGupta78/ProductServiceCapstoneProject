package com.example.demo.services.Sorter;



public class SorterFactory {

    public static SorterService getSorter(String type)
    {
        switch (type) {
            case ("LOW_TO_HIGH"):
                return new PriceLowToHighSorterService();
            case ("HIGH_TO_LOW"):
                return new PriceHighToLowSorterService();
            case ("Popularity"):
                return new PopularitySorterService();

        }
        return null;
    }
}
