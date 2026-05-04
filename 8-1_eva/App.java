import java.util.*;
import java.lang.Class;
import java.io.*;

public class App{
    private Map<String, List<Widget>> widgets;
    private String style;

    public App(){
        widgets = new LinkedHashMap<>();
        widgets.put("Window", new ArrayList<Widget>());
        widgets.put("ScrollBar", new ArrayList<Widget>());
        widgets.put("Button", new ArrayList<Widget>());

        this.style = "Motif";
    }

    public void setStyle(String style){
        this.style = style;
        for(Map.Entry<String, List<Widget>> entry : widgets.entrySet()){
            ListIterator<Widget> it = entry.getValue().listIterator();
            while(it.hasNext()){
                Widget currentWidget = it.next();
                if(!currentWidget.getClass().getName().startsWith(style)){
                    Widget newWidget = null;
                    if(style.equals("Motif")){
                        if(currentWidget instanceof Window) newWidget = new MotifWindow(currentWidget.getName());
                        else if(currentWidget instanceof ScrollBar) newWidget = new MotifScrollBar(currentWidget.getName());
                        else if(currentWidget instanceof Button) newWidget = new MotifButton(currentWidget.getName());
                    }else if(style.equals("PM")){
                        if(currentWidget instanceof Window) newWidget = new PMWindow(currentWidget.getName());
                        else if(currentWidget instanceof ScrollBar) newWidget = new PMScrollBar(currentWidget.getName());
                        else if(currentWidget instanceof Button) newWidget = new PMButton(currentWidget.getName());
                    }
                    if(newWidget != null){
                        it.set(newWidget);
                    }
                }
            }
        }
    }

    public void addWidget(String widgetType, String widgetName){
        if(widgetType.equals("Window")){
            if(this.style.equals("Motif")){
                widgets.get("Window").add(new MotifWindow(widgetName));
            }else if(this.style.equals("PM")){
                widgets.get("Window").add(new PMWindow(widgetName));
            }
        }else if(widgetType.equals("ScrollBar")){
            if(this.style.equals("Motif")){
                widgets.get("ScrollBar").add(new MotifScrollBar(widgetName));
            }else if(this.style.equals("PM")){
                widgets.get("ScrollBar").add(new PMScrollBar(widgetName));
            }   
        }else if(widgetType.equals("Button")){
            if(this.style.equals("Motif")){
                widgets.get("Button").add(new MotifButton(widgetName));
            }else if(this.style.equals("PM")){
                widgets.get("Button").add(new PMButton(widgetName));
            }
        }  
    }

    public void removeWidget(String widgetType, String widgetName){
        if(widgetType.equals("Window")){
            ListIterator<Widget> it = widgets.get("Window").listIterator();
            while(it.hasNext()){
                Widget currentWidget = it.next();
                if(currentWidget.getName().equals(widgetName)){
                    it.remove();
                    break;
                }
            }
        }else if(widgetType.equals("ScrollBar")){
            ListIterator<Widget> it = widgets.get("ScrollBar").listIterator();
            while(it.hasNext()){
                Widget currentWidget = it.next();
                if(currentWidget.getName().equals(widgetName)){
                    it.remove();
                    break;
                }
            }
        }else if(widgetType.equals("Button")){
            ListIterator<Widget> it = widgets.get("Button").listIterator();
            while(it.hasNext()){
                Widget currentWidget = it.next();
                if(currentWidget.getName().equals(widgetName)){
                    it.remove();
                    break;
                }
            }
        }          
    }

    public void display(){
        for(Map.Entry<String, List<Widget>> entry : widgets.entrySet()){
            for(Widget widget : entry.getValue()){
                widget.display();
            }
        }
    }
}