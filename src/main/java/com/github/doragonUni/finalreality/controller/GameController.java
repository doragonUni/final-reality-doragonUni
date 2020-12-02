package com.github.doragonUni.finalreality.controller;

import com.github.doragonUni.finalreality.model.character.Enemy;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.*;
import com.github.doragonUni.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
    Inventory inventory;
    private final IDeathHandler playerDeathHandler = new PlayerDeathHandler(this);
    private final IDeathHandler enemyDeathHandler = new EnemyDeathHandler(this);
    private ArrayList<IPlayerCharacter> party = new ArrayList();
    private ArrayList<IPlayerCharacter> enemyParty = new ArrayList();
    //agregar party de enemy y character

    public GameController() {
        this.inventory = new Inventory();

    }


    // characterCreator();

    public BlackMage blackMageCreator(String name, int hp, int def, int mana){
        BlackMage blackMage = new BlackMage(name, turns, hp, def, mana);
        blackMage.addDeathListener(playerDeathHandler);
        return blackMage;
    }
    public WhiteMage whiteMageCreator(String name, int hp, int def, int mana){
        WhiteMage whiteMage = new WhiteMage(name, turns, hp, def, mana);
        whiteMage.addDeathListener(playerDeathHandler);
        return whiteMage;
    }
    public Engineer engineerCreator(String name, int hp, int def){
        Engineer engineer = new Engineer(name, turns, hp, def);
        engineer.addDeathListener(playerDeathHandler);
        return engineer;
    }
    public Thief thiefCreator(String name, int hp, int def){
        Thief thief = new Thief(name, turns, hp, def);
        thief.addDeathListener(playerDeathHandler);
        return thief;
    }
    public Knight knightCreator(String name, int hp, int def){
        Knight knight = new Knight(name, turns, hp, def);
        knight.addDeathListener(playerDeathHandler);
        return knight;
    }
    public Enemy enemyCreator(String name, int weight, int hp, int def, int attack){
        Enemy enemy = new Enemy(name, turns, weight, hp, def, attack);
        enemy.addDeathListener(enemyDeathHandler);
        return enemy;
    }


    //public void itemCreator();
    public Bow bowCreator(String name, int damage, int weight){
        return new Bow(name, damage, weight);
    }
    public Staff staffCreator(String name, int damage, int weight, int magicDamage){
        return new Staff(name, damage, weight, magicDamage);
    }
    public Axe axeCreator(String name, int damage, int weight){
        return new Axe(name, damage, weight);
    }
    public Knife knifeCreator(String name, int damage, int weight){
        return new Knife(name, damage, weight);
    }
    public Sword swordCreator(String name, int damage, int weight){
        return new Sword(name, damage, weight);
    }

//ICharacterinfo
    public String getCharacterName(ICharacter character){
        return character.getName();
    }
    public int getCharacterHp(ICharacter character){
        return character.getHp();
    }
    public int getCharacterDef(ICharacter character){
        return character.getDef();
    }
    public int getCharacterAttack(ICharacter character){
        return character.getAttack();
    }
    public int getEnemyWeight(Enemy enemy){
        return enemy.getWeight();
    }
    //public int getMana();
//
//equip
    public void equipWeaponInventory(IWeapon weapon, IPlayerCharacter pj){
        if(pj.getEquippedWeapon() != null){
            IWeapon oldWeapon = pj.getEquippedWeapon();
            putInventoryItem(oldWeapon.getName(), oldWeapon);
        }
        pj.equipWeapon(selectInventoryItem(weapon.getName())); //DUDA!!!
    }
//
//attack
    public void controllerAttack(ICharacter attacker, ICharacter target){
        attacker.attack(target);
    }
//
//inventory
    public void putInventoryItem(String name, IWeapon weapon){
        inventory.putItem(name, weapon);
    }

    public IWeapon selectInventoryItem(String itemName){
        return inventory.selectItem(itemName);
    }
    public boolean isItemInventory(IWeapon weapon){
        return inventory.isStored(weapon);
    }
    public boolean isInventoryEmpty(){
        return inventory.isEmpty();
    }
//


    public void playerDeathNotification(IPlayerCharacter character){
        System.out.println(character.getEquippedWeapon().getName());
    }

    public void enemyDeathNotification(Enemy enemy){
        System.out.println(enemy.getWeight());
    }

//turns

//
}
