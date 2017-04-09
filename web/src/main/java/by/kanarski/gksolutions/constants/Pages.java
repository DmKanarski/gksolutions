package by.kanarski.gksolutions.constants;

import java.util.Arrays;
import java.util.List;

public class Pages {
    //pages url
    public static final String PAGE_INDEX = "index";
    public static final String PAGE_START = "";
    public static final String PAGE_ERROR = "error";
    public static final String PAGE_SEARCH_RESULTS = "search_results";
    public static final String PAGE_HOTEL = "hotel";
    public static final String PAGE_MY_ACCOUNT = "my_account";
    public static final List<String> VIEW_LIST= Arrays.asList(
            PAGE_INDEX, PAGE_ERROR, PAGE_HOTEL, PAGE_SEARCH_RESULTS, PAGE_MY_ACCOUNT
    );
}
