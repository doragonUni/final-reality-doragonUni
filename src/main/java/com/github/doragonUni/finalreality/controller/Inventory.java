package com.github.doragonUni.finalreality.controller;

import com.github.doragonUni.finalreality.model.weapon.IWeapon;

import javax.net.ssl.SSLEngineResult;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private HashMap<String, IWeapon> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public boolean isStored(IWeapon weapon){
        return items.containsValue(weapon);
    }

    public void putItem(String name, IWeapon weapon){
        items.put(name, weapon);
    }
    public IWeapon selectItem(String weaponName){
        return items.remove(weaponName);
    }

}
