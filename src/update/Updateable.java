package update;

import render.Renderable;

import java.util.ArrayList;

public interface Updateable {
    public void update();
    public String getID();
    public Renderable getRenderable();
    public default Updateable isColliding(Renderable thisObject, String otherObjectID){
        ArrayList<Updateable> objects = Updater.getUpdateableObjects();
        for(Updateable object : objects){
            if(object.getID().equals(otherObjectID)){
                if(thisObject.getX() < object.getRenderable().getX() +object.getRenderable().getWidth() && thisObject.getX() + thisObject.getWidth() > object.getRenderable().getX()) {
                    if (thisObject.getY() < object.getRenderable().getY() + object.getRenderable().getHeight() && thisObject.getY() + thisObject.getHeight() > object.getRenderable().getY()) {
                        return object;
                    }
                }
            }
        }
        return null;
    }
}

