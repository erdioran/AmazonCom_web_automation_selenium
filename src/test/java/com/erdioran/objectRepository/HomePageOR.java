package com.erdioran.objectRepository;


import org.openqa.selenium.By;

public class HomePageOR {


    public static final By SEARCH_BAR = By.id("twotabsearchtextbox");
    public static final By SEARCH_BAR_SUBMIT_BUTTON = By.id("nav-search-submit-button");
    public static final By SORT_BY_BUTTON = By.xpath("(//span[@class='a-button-inner'])[1]");
    public static final By NEWEST_ARRIVALS_BUTTON = By.id("s-result-sort-select_4");
    public static final By PRICE_OF_THE_FIRST_PRODUCT_ON_THE_PAGE = By.xpath("(//span[@class='a-price'])[1]");



    public static final By ACCEPT_COOKIES = By.id("sp-cc-accept");

    public static final String HOME_URL="https://www.amazon.co.uk/";


}
