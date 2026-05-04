public class PMWidgetCreator implements WidgetCreator{
    @Override
    public Widget createWidget(String widgetType, String name){
        switch(widgetType){
            case "Window" -> {return new PMWindow(name); }
            case "ScrollBar" -> {return new PMScrollBar(name); }
            case "Button" -> {return new PMButton(name); }
            default -> {return null; }
        }
    }
}