package de.saxsys.javafx.jumpstart.crawlresults;

import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.scene.web.WebView;

public class ResultView {

    @FXML
    private TitledPane tp_container;

    @FXML
    private WebView wv_display;

    @FXML
    public void initialize() {
        wv_display
                .getEngine()
                .loadContent(
                        "</div>\r\n        <a href=\"//stackoverflow.com\"\r\n           class=\"current-site-link site-link js-gps-track\"\r\n           data-id=\"1\"\r\n           data-gps-track=\"\r\n            site_switcher.click({ item_type:3 })\">\r\n            <div class=\"site-icon favicon favicon-stackoverflow\" title=\"Stack Overflow\"></div>\r\n            Stack Overflow\r\n        </a>\r\n                    </li>\r\n                    <li class=\"related-site\">\r\n                            <div class=\"L-shaped-icon-container\">\r\n            <span class=\"L-shaped-icon\"></span>\r\n        </div>");

    }
}
