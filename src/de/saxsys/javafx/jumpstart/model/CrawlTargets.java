package de.saxsys.javafx.jumpstart.model;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public enum CrawlTargets {

    XING("https://www.xing.com/search/members?advanced_form=&q[keywords]=%s");

    private static SimpleListProperty<CrawlTargets> values = new SimpleListProperty<>(
            FXCollections.observableArrayList(CrawlTargets.values()));

    private String url;

    private CrawlTargets(String url) {
        this.url = url;
    }

    public String getSearchUrl(String name) {
        return String.format(url, name);
    }

    public static SimpleListProperty<CrawlTargets> valuesProperty() {
        return values;
    }
}
