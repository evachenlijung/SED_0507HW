public class MotifWidgetCreator implements WidgetCreator{
    @Override
    public Widget createWidget(String widgetType, String name){
        switch(widgetType){
            case "Window" -> {return new MotifWindow(name); }
            case "ScrollBar" -> {return new MotifScrollBar(name); }
            case "Button" -> {return new MotifButton(name); }
            default -> {return null; }
        }
    }
}