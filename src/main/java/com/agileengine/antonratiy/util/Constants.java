package com.agileengine.antonratiy.util;

public final class Constants {
    public static final int ARGUMENTS_NUMBER = 3;
    public static final String ORIGIN_FILE_PATH = "originFilePath";
    public static final String SAMPLE_FILE_PATH = "sampleFilePath";
    public static final String ID = "id";
    public static final String ENCODING_UTF_8 = "utf-8";

    public final static class Messages {
        public static final String ILLEGAL_NUMBER_OF_ARGUMENTS = "Illegal number of arguments";
        public static final String ERROR_READING_FILE = "Error reading [{}] file";
        public static final String EXECUTION_RESULT = "--- Execution result ---";
        public static final String FOUND_ELEMENT_SELECTOR = "Found element's selector : ";
        public static final String FOUND_ELEMENT_MARKUP = "Found element's markup : ";
        public static final String FOUND_ELEMENT_IDENTITY_SIGNS = "Found element's identity signs : ";
        public static final String FOUND_ELEMENT_IDENTITY_LEVEL = "Found element's identity level : ";
    }

    public final static class Attributes {
        public static final String HREF = "href";
        public static final String TITLE = "title";
        public static final String ON_CLICK = "onClick";
    }

    public final static class IdentityDescriptions {
        public static final String TAG_NAMES = "Tag names are equals";
        public static final String PARENT_TAG_NAMES = "Parent's tag names are equals";
        public static final String CLASS_NAMES = "Class names are equals";
        public static final String PARENT_CLASS_NAMES = "Parent's class names are equals";
        public static final String ATTRIBUTE_NAME = "Attribute names are equals for current attributes : ";
        public static final String TEXT = "Text values are equals";
    }

}
