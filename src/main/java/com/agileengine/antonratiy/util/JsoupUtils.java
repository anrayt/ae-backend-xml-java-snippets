package com.agileengine.antonratiy.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public final class JsoupUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(JsoupUtils.class);

    public static Optional<Element> getElementById(File originFile, String id) {
        try {
            Document doc = Jsoup.parse(
                    originFile,
                    Constants.ENCODING_UTF_8,
                    originFile.getAbsolutePath());

            return Optional.of(doc.getElementById(id));
        } catch (IOException e) {
            LOGGER.error(Constants.Messages.ERROR_READING_FILE, originFile.getAbsolutePath(), e);
            return Optional.empty();
        }
    }

    public static Optional<Elements> getAllElements(File originFile) {
        try {
            Document doc = Jsoup.parse(
                    originFile,
                    Constants.ENCODING_UTF_8,
                    originFile.getAbsolutePath());

            return Optional.of(doc.getAllElements());
        } catch (IOException e) {
            LOGGER.error(Constants.Messages.ERROR_READING_FILE, originFile.getAbsolutePath(), e);
            return Optional.empty();
        }
    }
}
