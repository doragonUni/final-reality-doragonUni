package com.github.doragonUni.finalreality.controller;

import com.github.doragonUni.finalreality.model.character.Enemy;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.*;
import com.github.doragonUni.finalreality.model.weapon.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class GameController {
    private final int partyNum;
    private  final int enemyNum;
    private int playersAlive;
    private int enemiesAlive;
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
    Inventory inventory;
    private final IDeathHandler playerDeathHandler = new PlayerDeathHandler(this);
    private final IDeathHandler enemyDeathHandler = new EnemyDeathHandler(this);
    private ArrayList<IPlayerCharacter> party = new ArrayList();
    private ArrayList<Enemy> enemyParty = new ArrayList();
    private ICharacter actualCharacter;

    /**
     * Creates a controller of the game
     * @param partyNum
     * @param enemyNum
     */
    public GameController(int partyNum, int enemyNum) {
        this.inventory = new Inventory();
        this.partyNum = partyNum; //para no perder la referencia
        this.enemyNum = enemyNum;
        this.playersAlive = partyNum; //visor contador editable
        this.enemiesAlive = enemyNum;

    }


    // characterCreator();

    /**
     * creates a BlackMage and is added to the party
     * @param name
     * @param hp
     * @param def
     * @param mana
     */
    public void blackMageCreator(String name, int hp, int def, int mana){
        BlackMage blackMage = new BlackMage(name, turns, hp, def, mana);
        blackMage.addDeathListener(playerDeathHandler);
        addToParty(blackMage);
    }

    /**
     * creates a whiteMageCreator and is added to the party
     * @param name
     * @param hp
     * @param def
     * @param mana
     */
    public void whiteMageCreator(String name, int hp, int def, int mana){
        WhiteMage whiteMage = new WhiteMage(name, turns, hp, def, mana);
        whiteMage.addDeathListener(playerDeathHandler);
        addToParty(whiteMage);
    }

    /**
     * creates a engineer and is added to the party
     * @param name
     * @param hp
     * @param def
     */
    public void engineerCreator(String name, int hp, int def){
        Engineer engineer = new Engineer(name, turns, hp, def);
        engineer.addDeathListener(playerDeathHandler);
        addToParty(engineer);
    }

    /**
     * creates a thief and is added to the party
     * @param name
     * @param hp
     * @param def
     */
    public void thiefCreator(String name, int hp, int def){
        Thief thief = new Thief(name, turns, hp, def);
        thief.addDeathListener(playerDeathHandler);
        addToParty(thief);
    }

    /**
     * creates a knight and is added to the party
     * @param name
     * @param hp
     * @param def
     */
    public void knightCreator(String name, int hp, int def){
        Knight knight = new Knight(name, turns, hp, def);
        knight.addDeathListener(playerDeathHandler);
        addToParty(knight);
    }

    /**
     * creates an enemy and is added to the enemy's party
     * @param name
     * @param weight
     * @param hp
     * @param def
     * @param attack
     */
    public void enemyCreator(String name, int weight, int hp, int def, int attack){

        Enemy enemy = new Enemy(name, turns, weight, hp, def, attack);
        enemy.addDeathListener(enemyDeathHandler);
        addToEnemy(enemy);

    }

    /**
     * given a IPlayerCharacter is added to the party if the limit is not reached
     * @param character
     */
    public void addToParty(IPlayerCharacter character){
        if (party.size() < partyNum){
            party.add(character);
        }
    }
    /**
     * given an enemy is added to the enemy's party if the limit is not reached
     * @param enemy
     */
    public void addToEnemy(Enemy enemy){
        if (enemyParty.size()< enemyNum){
            enemyParty.add(enemy);
        }
    }

    /**
     * returns the entire party
     * @return
     */
    public ArrayList<IPlayerCharacter> getParty(){
        return party;
    }

    /**
     * returns the enemy's entire party
     * @return
     */
    public ArrayList<Enemy> getEnemyParty(){
        return enemyParty;
    }

    /**
     * get an specific playerChacter from the party
     * @param pos
     * @return
     */
    public IPlayerCharacter getFromParty( int pos){
        return party.get(pos);
    }
    /**
     * get an specific enemy from the enemy's party
     * @param pos
     * @return
     */
    public Enemy getFromEnemy( int pos){
        return enemyParty.get(pos);
    }

  //ITEM CREATOR----------------------------------------------//

    /**
     * create a Bow and is added to the inventory
     * @param name
     * @param damage
     * @param weight
     */
    public void bowCreator(String name, int damage, int weight){
        Bow bow = new Bow(name, damage, weight);
        putInventoryItem(bow);
    }

    /**
     * create a staff and is added to the inventory
     * @param name
     * @param damage
     * @param weight
     * @param magicDamage
     */
    public void staffCreator(String name, int damage, int weight, int magicDamage){
        Staff staff =  new Staff(name, damage, weight, magicDamage);
        putInventoryItem( staff);
    }

    /**
     * create an axe and is added to the inventory
     * @param name
     * @param damage
     * @param weight
     */
    public void axeCreator(String name, int damage, int weight){
        Axe axe = new Axe(name, damage, weight);
        putInventoryItem(axe);
    }

    /**
     * create a knife and is added to the inventory
     * @param name
     * @param damage
     * @param weight
     */
    public void knifeCreator(String name, int damage, int weight){
        Knife knife = new Knife(name, damage, weight);
        putInventoryItem( knife);
    }

    /**
     * create a sword and is added to the inventory
     * @param name
     * @param damage
     * @param weight
     */
    public void swordCreator(String name, int damage, int weight){
        Sword sword = new Sword(name, damage, weight);
        putInventoryItem(sword);
    }

//Character and enemy's info----------------------------------//

    /**
     * get any Character's name
     * @param character
     * @return
     */
    public String getCharacterName(ICharacter character){
        return character.getName();
    }

    /**
     * get any Character's health points
     * @param character
     * @return
     */
    public int getCharacterHp(ICharacter character){
        return character.getHp();
    }

    /**
     * get any Character's defense
     * @param character
     * @return
     */
    public int getCharacterDef(ICharacter character){
        return character.getDef();
    }
    /**
     * get any Character's attack
     * @param character
     * @return
     */
    public int getCharacterAttack(ICharacter character){
        return character.getAttack();
    }
    /**
     * get enemy's weight defense
     * @param enemy
     * @return
     */
    public int getEnemyWeight(Enemy enemy){
        return enemy.getWeight();
    }

    /**
     * get only mage mana points
     * @param mage
     * @return
     */
    public int getMageMana(IMage mage){
        return mage.getMana();
    }

    /**
     * get IPlayerCharacter's equipped Weapon
     * @param character
     * @return
     */
    public IWeapon getCharacterEquipWeapon(IPlayerCharacter character){
        return character.getEquippedWeapon();
    }

//equip------------------------------//

    /**
     * equip's a Weapon directly from the inventory
     * @param weapon
     * @param pj
     */
    public void equipWeaponInventory(IWeapon weapon, IPlayerCharacter pj){
        IWeapon oldWeapon = pj.getEquippedWeapon();
        pj.equipWeapon(selectInventoryItem(weapon.getName()));
        removeInventoryItem(weapon.getName());
        if(pj.getEquippedWeapon() == null){
            putInventoryItem(weapon);
        }
        else if (!pj.getEquippedWeapon().equals(weapon)){
            putInventoryItem(weapon);
        }
        else{
            putInventoryItem(oldWeapon);
        }

    }


//attack--------------------//

    /**
     * the attacker attacks target lowering the target's healthpoint
     * @param attacker
     * @param target
     */
    public void controllerAttack(ICharacter attacker, ICharacter target){
        attacker.attack(target);
    }

//inventory-----------------------//

    /**
     * puts the weapon into the inventory
     * @param weapon
     */
    public void putInventoryItem(IWeapon weapon){
        if(!(weapon == null)) {
            inventory.putItem(weapon);
        }
    }

    /**
     * select's an item from the inventory but it doesnt no remove it
     * @param itemName
     * @return
     */
    public IWeapon selectInventoryItem(String itemName){
        return inventory.selectItem(itemName);
    }

    /**
     * removes an item from the inventory
     * @param itemName
     */
    public void removeInventoryItem(String itemName) {
        inventory.removeItem(itemName);
    }

    /**
     * check if given the weapon's name is stored in the inventory
     * @param weaponName
     * @return
     */
    public boolean isItemInventory(String weaponName){
        return inventory.isStored(weaponName);
    }

    /**
     * verify if the inventory is or not empty
     * @return
     */
    public boolean isInventoryEmpty(){
        return inventory.isEmpty();
    }
//

    /**
     * notify every time a player is dead and announce if your entire party is dead
     * @param character
     */
    public void playerDeathNotification(IPlayerCharacter character){
        System.out.println(character.getEquippedWeapon().getName());
        playersAlive--;
        if(looser()){
            System.out.println("u lost :/");
        }
    }
    /**
     * notify every time a enemy is dead and announce if the enemy's party is dead
     * @param enemy
     */
    public void enemyDeathNotification(Enemy enemy){
        System.out.println(enemy.getWeight());
        enemiesAlive--;
        if(winner()){
            System.out.println("u win :)");
        }

    }

    /**
     * return true if the enemy party is all dead
     * false otherwise
     * @return
     */
    public boolean winner(){
        return enemiesAlive == 0;
    }
    /**
     * return true if the party is all dead
     * false otherwise
     * @return
     */
    public boolean looser(){
        return playersAlive == 0;
    }


//turns

//
}
