package com.niharikakhanna.app.quiz;

import android.app.Application;

/**
 * Created by Khanna on 01/01/17.
 */

public class QuestionDatabase extends Application {

    private static Questions[] mQuestionBank;

    private static String[] arrayOne = {"Domino's", "Pizza Hut", "NY Pizza", "Papa John's"};
    private static String[] arrayTwo = {"Arrow", "Next", "Amazon", "Michelin"};
    private static String[] arrayThree = {"BMW", "Hyundai", "Lamborghini", "Porsche"};
    private static String[] arrayFour = {"Mattel", "Barbie", "Bella", "Baskin Robins"};
    private static String[] arrayFive = {"Five Guys", "Chipotle", "KFC", "Burger King"};
    private static String[] arraySix = {"Chevrolet", "Citroen", "Suzuki", "Jaguar"};
    private static String[] arraySeven = {"Costa", "Starbucks", "Barista", "Subway"};
    private static String[] arrayEight = {"Twitter", "Vimeo", "Musicly", "Tumblr"};
    private static String[] arrayNine = {"IBM", "HP", "Intel", "Microsoft"};
    private static String[] arrayTen = {"HP", "IBM", "Dell", "Lenovo"};
    private static String[] arrayEleven = {"Matador", "Red Bull", "Red Tape", "Superdry"};
    private static String[] array12 = {"Pantene","L'Oréal","Lancôme","Lush"};
    private static String[] array13 = {"Louis Vuitton", "Yves Saint Lauren", "Ralph Lauren", "Karl Lagerfeld"};
    private static String[] array14 = {"Burger King", "McDonald's", "Milkshakes CO.", "Maltesers"};
    private static String[] array15 = {"Dunlop", "Gnome","Michelin","Yakasumo"};
    private static String[] array16 = {"VH1","MTV","HBO","Star Movies"};
    private static String[] array17 = {"Twitter","Bubble","Flickr","Skype"};
    private static String[] array18 = {"Mercedes","Volkswagen","Bentley","Chevrolet"};
    private static String[] array19 = {"Pringles","Lays","Walkers","Tyrell's"};
    private static String[] array20 = {"Puma","Adidas","Reebok","JJ"};
    private static String[] array21 = {"Slowgold","Quiksilver","FastBronze","LiquidPlatinum"};
    private static String[] array22 = {"Check","Nike","Tickr","Prefect"};
    private static String[] array23 = {"Nissan","Range Rover","Daimler","Peugeot"};

    public static Questions[] getArray() {
         mQuestionBank = new Questions[]{
                new Questions(R.drawable.ic_pizzahut, "Pizza Hut", arrayOne, false, false,false),
                new Questions(R.drawable.ic_amazon, "Amazon", arrayTwo, false, false,false),
                new Questions(R.drawable.ic_bmw, "BMW", arrayThree, false, false,false),
                new Questions(R.drawable.ic_barbie, "Barbie", arrayFour, false, false,false),
                new Questions(R.drawable.ic_burgerking, "Burger King", arrayFive, false, false,false),
                new Questions(R.drawable.ic_citroen, "Citroen", arraySix, false, false,false),
                new Questions(R.drawable.ic_starbucks, "Starbucks", arraySeven, false, false,false),
                new Questions(R.drawable.ic_twitter, "Twitter", arrayEight, false, false,false),
                new Questions(R.drawable.ic_hp, "HP", arrayNine, false, false,false),
                new Questions(R.drawable.ic_ibm, "IBM", arrayTen, false, false,false),
                new Questions(R.drawable.ic_redbull, "Red Bull", arrayEleven, false, false,false),
                new Questions(R.drawable.ic_loreal, "L'Oréal", array12, false, false,false),
                new Questions(R.drawable.ic_louisvuitton, "Louis Vuitton", array13, false, false,false),
                new Questions(R.drawable.ic_mcdonalds, "McDonald's", array14, false, false,false),
                new Questions(R.drawable.ic_michelin, "Michelin", array15, false, false,false),
                new Questions(R.drawable.ic_mtv, "MTV", array16, false, false,false),
                new Questions(R.drawable.ic_skype, "Skype", array17, false, false,false),
                new Questions(R.drawable.ic_volkswagen, "Volkswagen", array18, false, false,false),
                new Questions(R.drawable.ic_pringles, "Pringles", array19, false, false,false),
                new Questions(R.drawable.ic_reebok, "Reebok", array20, false, false,false),
                new Questions(R.drawable.ic_quiksilver, "Quiksilver", array21, false, false,false),
                new Questions(R.drawable.ic_nike, "Nike", array22, false, false,false),
                new Questions(R.drawable.ic_nissan, "Nissan", array23, false, false,false),
        };

        return mQuestionBank;
    }


    public static Integer[] getImages() {
        Integer[] mThumbIds = {
                R.drawable.ic_pizzahut,
                R.drawable.ic_amazon,
                R.drawable.ic_bmw,
                R.drawable.ic_barbie,
                R.drawable.ic_burgerking,
                R.drawable.ic_citroen,
                R.drawable.ic_starbucks,
                R.drawable.ic_twitter,
                R.drawable.ic_hp,
                R.drawable.ic_ibm,
                R.drawable.ic_redbull,
                R.drawable.ic_loreal,
                R.drawable.ic_louisvuitton,
                R.drawable.ic_mcdonalds,
                R.drawable.ic_michelin,
                R.drawable.ic_mtv,
                R.drawable.ic_skype,
                R.drawable.ic_volkswagen,
                R.drawable.ic_pringles,
                R.drawable.ic_reebok,
                R.drawable.ic_quiksilver,
                R.drawable.ic_nike,
                R.drawable.ic_nissan
        };

        return mThumbIds;

    }

}
