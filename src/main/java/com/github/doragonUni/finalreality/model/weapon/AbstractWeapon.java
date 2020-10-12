package com.github.doragonUni.finalreality.model.weapon;


public abstract class AbstractWeapon implements IWeapon {

    private final String name;
    private final int damage;
    private final int weight;

    protected AbstractWeapon(String name, int damage, int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public int getDamage(){
        return this.damage;
    }
    @Override
    public int getWeight(){
        return this.weight;
    }



}
