package gameobjects;

import java.util.ArrayList;


public class GameObjectCollection {

    private static ArrayList<GameObject> gameObjects;
    public static ArrayList<Spawn> spawnPoints;


    public static void init() {
        gameObjects = new ArrayList<>();
        spawnPoints = new ArrayList<>();
    }


    public static void spawn(GameObject obj) {
        gameObjects.add(obj);
    }


    public static void destroy(GameObject obj) {
        gameObjects.remove(obj);
    }


    public static int numGameObjects() {
        return gameObjects.size();
    }


    public static GameObject getGameObject(int index) {
        return gameObjects.get(index);
    }

}
