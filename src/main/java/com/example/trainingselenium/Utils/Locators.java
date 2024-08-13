package com.example.trainingselenium.Utils;

public class Locators {
    public static final String ACCEPT_ALL_COOKIES = "button[data-testid='uc-accept-all-button']";
    public static final String REFUSE_ALL_COOKIES = "button[data-testid='uc-deny-all-button']";
    public static final String COUNTRY_DROPDOWN = "//span[contains(@class,'country-container ')]//span[contains(@class,'p-dropdown-trigger-icon')]";
    public static final String COUNTRY_INPUT = "//input[contains(@class,'p-inputtext p-component')]";
    public static final String CURRENCY_DROPDOWN = "//div[contains(@class,'currency-container')]//span[contains(@class,'p-dropdown-trigger-icon')]";
    public static final String START_SHOPPING_BUTTON = "//button[text()='Start Shopping']";
    public static final String COUNTRY_DROPDOWN_ITEM = "//li[contains(@class,'p-dropdown-item')][text()='%s']";
    public static final String CURRENCY_ITEM = "//div[contains(@class,'currency-switcher-panel')]//li[contains(@aria-label,'%s')]";
    public static final String SUBSCRIPTION_EMAIL_INPUT = "//input[contains(@id,'subscription-email')]";
    public static final String SELECT_COUNTRY = "//select[contains(@name,'country')]";
    public static final String SELECT_GENERAL_INTEREST = "//select[contains(@name,'general_interest')]";
    public static final String SELECT_PRODUCT_INTEREST = "//select[contains(@name,'product_interest')]";
    public static final String SUBSCRIBE_BUTTON = "//button[contains(@aria-label,'Sign Up')]";
    public static final String COUNTRY_OPTION_XPATH = SELECT_COUNTRY + "//option[text()='%s']";
    public static final String GENERAL_INTEREST_OPTION_XPATH = SELECT_GENERAL_INTEREST + "//option[text()='%s']";
    public static final String PRODUCT_INTEREST_OPTION_XPATH = SELECT_PRODUCT_INTEREST + "//option[text()='%s']";
    public static final String SELECT_COUNTRY_CURRENCY_SHOPPING = "//header//span[contains(text(),'Change')]";
    public static final String POPUP_MESSAGE_SUCCESS_OF_SUBSCRIBE = "//div[text()='Thank you for your subscription.']";
    public static final String ICON_PERSON_IN_HEADER = "//img[contains(@id,'account-link')]";
//    public static final String FORGET_PASSWORD_LINK = "//form//span[contains(text(),'Forgotten the password?')]";
//    public static final String EMAIL_RESET_PASSWORD_INPUT = "//div[contains(@class,'forgot-password-wrapper')]//input[contains(@name,'email')]";
//    public static final String RESET_PASSWORD_BUTTON = "//div[contains(@class,'forgot-password-wrapper')]//button[contains(@aria-label,'Reset Password')]";
//    public static final String EMAIL_LOGIN_INPUT = "//div[contains(@class,'login-form')]//input[contains(@name,'email')]";
//    public static final String PASSWORD_LOGIN_INPUT = "//div[contains(@class,'login-form')]//input[contains(@name,'password')]";
//    public static final String LOGIN_BUTTON = "//div[contains(@class,'login-form')]//button[contains(@aria-label,'Log in to your Account')]";
    public static final String LINK_DETAILS_USER_PAGE = "//span[contains(@class,'account-menu-section')]//a[@href='/my-account']";
    public static final String MESSAGE_RECEIVED_EMAIL_INSTRUCTION_RESET_PASSWORD = "//div[@class='forgot-password-wrapper']//p[contains(text(),'Check your inbox and follow the link')]";
    public static final String BACK_TO_LOGIN_BUTTON = "//div[contains(@class,'forgot-password-wrapper')]//button[contains(@aria-label,'Back to login')]";
    public static final String ICON_SEARCH_IN_HEADER = "//div[contains(@class,'header-menu')]//i[contains(@class,'icon-search')]";
    public static final String SEARCH_INPUT = "//div[contains(@class,'searchbox')]//input[contains(@placeholder,'Search')]";
    public static final String SEARCH_BUTTON = "//div[contains(@class,'searchbox')]//button[contains(@class,'search')]";
    public static final String SEARCH_RESULT_TEXT = "//div[contains(@class,'toolbar-tabs ')]//div[contains(text(),'results')]//span";

    public static final String ICON_WISH_LIST_IN_HEADER = "//nav[@id='customer-navigation']//img[contains(@src,'nav-icons_wishlist')]";
    public static final String ICON_BAG_IN_HEADER = "//button[@id='basket-btn']";

    public static final String EMAIL_LOGING_INPUT = "//div[contains(@class,'login-form')]//input[@name='email']";
    public static final String PASSWORD_LOGIN_INPUT = "//div[contains(@class,'login-form')]//input[@type='password']";
    public static final String LOGIN_BUTTON = "//div[contains(@class,'login-form')]//button[@type='submit']";
    public static final String POST_LOGIN_POPUP_OK_BUTTON = "//button[contains(@id,'toast-ok-button')]";
    public static final String SUCCESS_LOGGED_MESSAGE_POPUP = "//div[contains(text(),'You are logged in!')]";
    public static final String POST_LOGIN_POPUP = "//div[contains(@class,'p-toast-message-content')]";

    public static final String NEWSLETTER_EMAIL_INPUT = "//input[contains(@id,'subscription-email')]";
    public static final String NEWSLETTER_COUNTRY_DROPDOWN = "//select[contains(@name,'country')]";
    public static final String NEWSLETTER_GENERAL_INTEREST = "//select[contains(@name,'general_interest')]";
    public static final String NEWSLETTER_PRODUCT_INTEREST = "//select[contains(@name,'product_interest')]";
    public static final String NEWSLETTER_SIGNUP_BUTTON = "//button[contains(@aria-label,'Sign Up')]";

    public static final String PRODUCTS_LIST_PAGE = "//div[contains(@class,'product-list-page')]";
    public static final String HAMPERS_CATEGORY = "//nav[contains(@class,'category-navigation')]/ul/li[2]";
    public static final String HAMPERS_CATEGORY_BIRTHDAYS = "//nav[contains(@class,'category-navigation')]//a[contains(@href,'birthdays')]";
    public static final String PRODUCT_DETAILS_PAGE = "//div[contains(@data-sku,'%s')]";
    public static final String ALL_PRODUCTS = "//div[contains(@class,'product-list-page')]//div[attribute::data-sku]";
    public static final String FIRST_PRODUCT = "//div[contains(@class,'product-list-page')]//div[attribute::data-sku][1]";
    public static final String PRODUCT_DETAILS_PAGE_ADD_TO_WISHLIST = "//section[contains(@class,'add-to-cart-main')]//span[contains(@class,'add-wishlist')]";
    public static final String WISHLIST_POPUP_PRODUCT_TITLE = "//span[contains(@class,'toast-product-details')]//div";
    public static final String WISHLIST_POPUP = "//div[contains(@class,'p-toast-message-content')]";
    public static final String WISHLIST_POPUP_VIEW_WISHLIST = "//div[contains(@class,'p-toast-message-content')]//button[@id='toast-view-wishlist-button']";
    public static final String PDP_PRODUCT_TITLE = "//h1[contains(@data-cy,'ProductFullDetail-productName')]";
    public static final String PLP_PRODUCT_TITLE = "//div[contains(@data-sku,'%s')]//div[contains(@class,'product-title')]//a";
    public static final String WISHLIST_PRODUCT_TITLE = "//div[contains(@class,'h-screen bg-white transition-all')]//button[contains(@class,'text-left')]";

    public static final String FORGOTTEN_THE_PASSWORD_LINK = "//span[contains(@class,'forgot-password')]";
    public static final String RESET_PASSWORD_EMAIL_INPUT = "//input[contains(@name,'email')]";
    public static final String RESET_PASSWORD_BUTTON = "//button[contains(@aria-label,'Reset Password')]";

    public static final String YOPMAIL_EMAIL_INPUT = "//input[contains(@id,'login')]";
    public static final String YOPMAIL_EMAIL_BUTTON = "//button[contains(@title,'Check Inbox @yopmail.com')]";
    public static final String YOPMAIL_SET_NEW_PASSWORD_LINK = "//a[text()='Set a New Password']";
    public static final String NEW_PASSWORD_INPUT = "//input[contains(@name,'password')]";
    public static final String CONFIRM_NEW_PASSWORD_INPUT = "//input[contains(@name,'repeatPassword')]";
    public static final String SAVE_NEW_PASSWORD_BUTTON = "//button[contains(@aria-label,'Save New password')]";
    public static final String LOGIN_TOAST_POPUP = "//div[contains(@class,'toast-message-wrapper')]";
    public static final String LOGIN_TOAST_POPUP_ICON = "//div[contains(@class,'toast-message-wrapper')]//span[contains(@class,'success-icon')]";


}