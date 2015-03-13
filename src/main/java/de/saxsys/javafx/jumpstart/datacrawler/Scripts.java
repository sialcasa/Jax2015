package de.saxsys.javafx.jumpstart.datacrawler;

public class Scripts {

    static String eventsOnClasses = "$(document).click(function(event){"
            + "$(event.target).closest('div').each(function(){document.write($(this).html())}); return false;" + "});";

    static String script = "$(\"a\").click(function(event){" + "event.stopPropagation();"
            + "document.write(event.target);" + "var style = $(this).getStyleObject();" + "java.target(style);" + "});";

    static String getStyleObject = "$.fn.getStyleObject = function() {\n" + " var dom = this.get(0);\n"
            + " var style;\n" + " var returns = {};\n" + " if (window.getComputedStyle) {\n"
            + " var camelize = function(a, b) {\n" + " return b.toUpperCase();\n" + " }\n"
            + " style = window.getComputedStyle(dom, null);\n" + " for (var i = 0, l = style.length; i < l; i++) {\n"
            + " var prop = style[i];\n" + " var camel = prop.replace(/\\-([a-z])/, camelize);\n"
            + " var val = style.getPropertyValue(prop);\n" + " returns[camel] = val;\n" + " }\n" + " return returns;\n"
            + " }\n" + " if (dom.currentStyle) {\n" + " style = dom.currentStyle;\n" + " for ( var prop in style) {\n"
            + " returns[prop] = style[prop];\n" + " }\n" + " return returns;\n" + " }\n"
            + " if (style = dom.style) {\n" + " for ( var prop in style) {\n"
            + " if (typeof style[prop] != \'function\') {\n" + " returns[prop] = style[prop];\n" + " }\n" + " }\n"
            + " return returns;\n" + " }\n" + " return returns;\n" + "}\n" + "\n" + "\n" + "\n"
            + "$(document).click(function(event) {\n" + " $(event.target).closest(\'div\').each(function() {\n"
            + " var style = $(this).getStyleObject();\n" + " $(\'#emptyDiv\').css(style);\n" + " });\n"
            + " return false;\n" + "});\n" + "";

}
