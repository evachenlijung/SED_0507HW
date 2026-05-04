import java.util.*;
import java.lang.Class;
import java.io.*;

public class App{
    private Map<String, List<Widget>> widgets;
    private WidgetCreator widgetCreator;

    public App(){
        widgets = new LinkedHashMap<>();
        widgets.put("Window", new ArrayList<Widget>());
        widgets.put("ScrollBar", new ArrayList<Widget>());
        widgets.put("Button", new ArrayList<Widget>());

        this.widgetCreator = new MotifWidgetCreator();
    }

    public void setStyle(String style){
        switch(style){
            case "Motif" -> this.widgetCreator = new MotifWidgetCreator();
            case "PM" -> this.widgetCreator = new PMWidgetCreator();
            default -> System.out.println("unknown command");
        }
        
        for(Map.Entry<String, List<Widget>> entry : widgets.entrySet()){
            String widgetType = entry.getKey();
            ListIterator<Widget> it = entry.getValue().listIterator();
            while(it.hasNext()){
                Widget currentWidget = it.next();
                Widget newWidget = null;
                if(!currentWidget.getClass().getName().startsWith(style)){
                    newWidget = this.widgetCreator.createWidget(widgetType, currentWidget.getName());
                }
                if(newWidget != null){
                    it.set(newWidget);
                }
            }
        }
    }

    public void addWidget(String widgetType, String widgetName){
        widgets.get(widgetType).add(widgetCreator.createWidget(widgetType, widgetName));
    }

    public void removeWidget(String widgetType, String widgetName){
        this.widgets.get(widgetType).removeIf(widget -> widget.getName().equals(widgetName));  
    }

    public void display(){
        for(Map.Entry<String, List<Widget>> entry : widgets.entrySet()){
            for(Widget widget : entry.getValue()){
                widget.display();
            }
        }
    }
}