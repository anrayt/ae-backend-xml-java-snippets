package com.agileengine.antonratiy;


import com.agileengine.antonratiy.identity.IdentitySign;
import com.agileengine.antonratiy.entity.SearchResult;
import com.agileengine.antonratiy.processors.IdentityCheckProcessor;
import com.agileengine.antonratiy.processors.impl.IdentityCheckProcessorImpl;
import com.agileengine.antonratiy.util.Constants;
import com.agileengine.antonratiy.util.IdentitySignUtils;
import com.agileengine.antonratiy.util.JsoupUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class EntryPoint {

    private static Logger LOGGER = LoggerFactory.getLogger(EntryPoint.class);

    public static void main(String[] args) {
        Properties properties = extractArguments(args);

        File originFile = new File(properties.getProperty(Constants.ORIGIN_FILE_PATH));
        File sampleFile = new File(properties.getProperty(Constants.SAMPLE_FILE_PATH));
        String elementsId = properties.getProperty(Constants.ID);

        Optional<Element> optionalElement = JsoupUtils.getElementById(originFile, elementsId);
        Optional<Elements> optionalElements = JsoupUtils.getAllElements(sampleFile);

        if (optionalElement.isPresent() && optionalElements.isPresent()) {
            Element element = optionalElement.get();
            Elements elements = optionalElements.get();

            IdentityCheckProcessor<Element> identityCheckProcessor = new IdentityCheckProcessorImpl<>(element);
            List<IdentitySign<Element>> defaultIdentitySignsList = IdentitySignUtils.getDefaultIdentitySignsList();

            Optional<SearchResult<Element>> searchResultOptional = elements
                    .stream()
                    .map(el -> identityCheckProcessor.identify(el, defaultIdentitySignsList))
                    .filter(elementSearchResult -> elementSearchResult.getIdentityLevel() > 0)
                    .sorted((o1, o2) -> Integer.compare(o2.getIdentityLevel(), o1.getIdentityLevel()))
                    .findFirst();

            searchResultOptional.ifPresent(searchResult -> {
                LOGGER.info(Constants.Messages.EXECUTION_RESULT);
                LOGGER.info(Constants.Messages.FOUND_ELEMENT_SELECTOR + searchResult.getElement().cssSelector());
                LOGGER.info(Constants.Messages.FOUND_ELEMENT_MARKUP + searchResult.getElement().outerHtml());
                LOGGER.info(Constants.Messages.FOUND_ELEMENT_IDENTITY_SIGNS + searchResult.getIdentityDescriptions().toString());
                LOGGER.info(Constants.Messages.FOUND_ELEMENT_IDENTITY_LEVEL + searchResult.getIdentityLevel());
            });

        }
    }

    private static Properties extractArguments(String[] args) {
        if (args.length != Constants.ARGUMENTS_NUMBER) {
            LOGGER.error(Constants.Messages.ILLEGAL_NUMBER_OF_ARGUMENTS);
            throw new IllegalArgumentException(Constants.Messages.ILLEGAL_NUMBER_OF_ARGUMENTS);
        }
        String originFilePath = args[0];
        String sampleFilePath = args[1];
        String id = args[2];
        Properties result = new Properties();
        result.put(Constants.ORIGIN_FILE_PATH, originFilePath);
        result.put(Constants.SAMPLE_FILE_PATH, sampleFilePath);
        result.put(Constants.ID, id);
        return result;
    }
}
