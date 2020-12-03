package com.github.doragonUni.finalreality.controller;

import com.github.doragonUni.finalreality.model.weapon.IWeapon;

import javax.net.ssl.SSLEngineResult;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * creates an "Inventory" of IWeapons
 */
public class Inventory {

    private HashMap<String, IWeapon> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    /**
     * verify if the inventory is empty
     */
    public boolean isEmpty(){
        return items.isEmpty();
    }

    /**
     * verify if, given the weapon's name, is stored in the inventory
     * @param weaponName
     */
    public boolean isStored(String weaponName){
        return items.containsKey(weaponName);
    }

    /**
     * puts an IWeapon to the inventory
     * @param weapon
     */
    public void putItem(IWeapon weapon){
        items.put(weapon.getName(), weapon);
    }

    /**
     * selects an IWeapon from the inventory but it doesn't remove it
     * @param weaponName
     * @return
     */
    public IWeapon selectItem(String weaponName){ return items.get(weaponName); }

    /**
     * given the IWeapon's name, the method removes it
     * @param weaponName
     */
    public void removeItem(String weaponName) {
            items.remove(weaponName);
    }

}
