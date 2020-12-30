package com.github.doragonUni.finalreality.controller;

import com.github.doragonUni.finalreality.controller.handlers.EnemyDeathHandler;
import com.github.doragonUni.finalreality.controller.handlers.IHandler;
import com.github.doragonUni.finalreality.controller.handlers.PlayerDeathHandler;
import com.github.doragonUni.finalreality.controller.handlers.TurnHandler;
import com.github.doragonUni.finalreality.controller.phases.*;
import com.github.doragonUni.finalreality.model.character.Enemy;
import com.github.doragonUni.finalreality.model.character.ICharacter;
import com.github.doragonUni.finalreality.model.character.player.*;
import com.github.doragonUni.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {
    private final int partyNum;
    private  final int enemyNum;
    private int playersAlive;
    private int enemyKilled;
    protected BlockingQueue<ICharacter> turns = new LinkedBlockingQueue<>();
    private String log = "";


    private HashMap<String, IWeapon> inventory;
    private final IHandler playerDeathHandler = new PlayerDeathHandler(this);
    private final IHandler enemyDeathHandler = new EnemyDeathHandler(this);
    private final IHandler characterTurnHandler = new TurnHandler(this);


    private ArrayList<IPlayerCharacter> party = new ArrayList<>();
    private ArrayList<Enemy> enemyParty = new ArrayList<>();
    private ICharacter actualCharacter;
    private Phase phase;
    private boolean beginTurnTaken = false;
    private boolean tryTurnTaken = false;




    /**
     * Creates a controller of the game
     */
    public GameController() {
        this.inventory = new HashMap<>();
        this.partyNum = 4; //para no perder la referencia
        this.enemyNum = 5; //new Random().nextInt( (9-1) + 1 ) + 1;
        this.playersAlive = partyNum; //contador editable
        this.enemyKilled = 0;
        setPhase(new LoadingPhase());

    }


    // characterCreator();

    /**
     * creates a BlackMage and is added to the party
     */
    public void blackMageCreator(String name, int hp, int def, int mana){
        if(phase.isSetUpPhase()) {
            BlackMage blackMage = new BlackMage(name, turns, hp, def, mana);
            addToParty(blackMage);
        }
    }

    /**
     * creates a whiteMageCreator and is added to the party
     */
    public void whiteMageCreator(String name, int hp, int def, int mana){
        if(phase.isSetUpPhase()) {
            WhiteMage whiteMage = new WhiteMage(name, turns, hp, def, mana);
            addToParty(whiteMage);
        }
    }

    /**
     * creates a engineer and is added to the party
     */
    public void engineerCreator(String name, int hp, int def){
        if(phase.isSetUpPhase()) {
            Engineer engineer = new Engineer(name, turns, hp, def);
            addToParty(engineer);
        }
    }

    /**
     * creates a thief and is added to the party
     */
    public void thiefCreator(String name, int hp, int def) {
        if (phase.isSetUpPhase()){
            Thief thief = new Thief(name, turns, hp, def);
            addToParty(thief);
        }
    }

    /**
     * creates a knight and is added to the party
     */
    public void knightCreator(String name, int hp, int def){
        if(phase.isSetUpPhase()) {
            Knight knight = new Knight(name, turns, hp, def);
            addToParty(knight);
        }
    }

    /**
     * creates an enemy and is added to the enemy's party
     */
    public void enemyCreator(String name, int weight, int hp, int def, int attack){
        if(phase.isSetUpPhase()) {
            Enemy enemy = new Enemy(name, turns, weight, hp, def, attack);
            addToEnemy(enemy);
        }

    }

    /**
     * adds an IPlayer to the Party
     */
    public void addToParty(IPlayerCharacter character){
        if(party.size() < partyNum){
            party.add(character);
            character.addDeathListener(playerDeathHandler);
            character.addTurnListener(characterTurnHandler);

        }

    }
    /**
     * adds an Enemy to the enemyParty
     */
    public void addToEnemy(Enemy enemy){
        if(enemyParty.size() < enemyNum){
            enemyParty.add(enemy);
            enemy.addDeathListener(enemyDeathHandler);
            enemy.addTurnListener(characterTurnHandler);


        }
    }



    /**
     * returns the entire party
     */
    public ArrayList<IPlayerCharacter> getParty(){
        return party;
    }

    /**
     * returns the enemy's entire party
     */
    public ArrayList<Enemy> getEnemyParty(){
        return enemyParty;
    }

    /**
     * get an specific playerChacter from the party
     */
    public IPlayerCharacter getFromParty( int pos){
        return party.get(pos);
    }
    /**
     * get an specific enemy from the enemy's party
     */
    public Enemy getFromEnemy( int pos){
        return enemyParty.get(pos);
    }

  //ITEM CREATOR----------------------------------------------//

    /**
     * create a Bow and is added to the inventory
     */
    public void bowCreator(String name, int damage, int weight){
        Bow bow = new Bow(name, damage, weight);
        putInventoryItem(bow);
    }

    /**
     * create a staff and is added to the inventory
     */
    public void staffCreator(String name, int damage, int weight, int magicDamage){
        Staff staff =  new Staff(name, damage, weight, magicDamage);
        putInventoryItem( staff);
    }

    /**
     * create an axe and is added to the inventory
     */
    public void axeCreator(String name, int damage, int weight){
        Axe axe = new Axe(name, damage, weight);
        putInventoryItem(axe);
    }

    /**
     * create a knife and is added to the inventory
     */
    public void knifeCreator(String name, int damage, int weight){
        Knife knife = new Knife(name, damage, weight);
        putInventoryItem( knife);
    }

    /**
     * create a sword and is added to the inventoryt
     */
    public void swordCreator(String name, int damage, int weight){
        Sword sword = new Sword(name, damage, weight);
        putInventoryItem(sword);
    }

//Character and enemy's info----------------------------------//

    /**
     * get any Character's name
     */
    public String getCharacterName(ICharacter character){
        return character.getName();
    }

    /**
     * get any Character's health points
     */
    public int getCharacterHp(ICharacter character){
        return character.getHp();
    }

    /**
     * get any Character's defense
     */
    public int getCharacterDef(ICharacter character){
        return character.getDef();
    }
    /**
     * get any Character's attack
     */
    public int getCharacterAttack(ICharacter character){
        return character.getAttack();
    }
    /**
     * get enemy's weight defense
     */
    public int getEnemyWeight(Enemy enemy){
        return enemy.getWeight();
    }

    /**
     * get only mage mana points
     */
    public int getMageMana(IMage mage){
        return mage.getMana();
    }

    /**
     * get IPlayerCharacter's equipped Weapon
     */
    public IWeapon getCharacterEquipWeapon(IPlayerCharacter character){
        return character.getEquippedWeapon();
    }

    /**
     * get the player's weapon name
     */
    public String getCharacterWeaponName(IPlayerCharacter character){return character.getWeaponName();}

//equip------------------------------//

    /**
     * equip's a Weapon directly from the inventory
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

    public void tryToEquip(IWeapon weapon, IPlayerCharacter pj){
        phase.tryEquip(weapon, pj);
    }


//attack--------------------//

    /**
     * the attacker attacks target lowering the target's health point
     * and calls the end of the turn
     */
    public void controllerAttack(ICharacter attacker, ICharacter target)  {
            attacker.attack(target);
            endTurn();



    }

//inventory-----------------------//

    /**
     * puts the weapon into the inventory
     */
    public void putInventoryItem(IWeapon weapon){
        if(!(weapon == null) && inventory.size()<10) {
            inventory.put(weapon.getName(), weapon);
        }
    }

    /**
     * selects an item from the inventory but it doesnt no remove it
     */
    public IWeapon selectInventoryItem(String itemName){
        return inventory.get(itemName);
    }

    /**
     * removes an item from the inventory
     */
    public void removeInventoryItem(String itemName) {
        inventory.remove(itemName);
    }

    /**
     * check if given the weapon's name is stored in the inventory
     */
    public boolean isItemInventory(String weaponName){
        return inventory.containsKey(weaponName);
    }

    /**
     * verify if the inventory is or not empty
     */
    public boolean isInventoryEmpty(){
        return inventory.isEmpty();
    }
//

    /**
     * notify every time a player is dead and announce if your entire party is dead
     */
    public void playerDeathNotification(IPlayerCharacter character){
        this.turns.remove(character);
        playersAlive--;

        if(looser()){
            phase.toLosePhase();

        }
    }

    /**
     * notify every time a enemy is dead and announce if the enemy's party is dead
     */
    public void enemyDeathNotification(Enemy enemy){
        this.turns.remove(enemy);
        enemyKilled++;

        if(winner()){
            phase.toWinPhase();

        }
    }

    /**
     * return true if the enemy party is all dead
     * false otherwise
     */
    public boolean winner(){
        return enemyKilled == enemyParty.size();
    }
    /**
     * return true if the party is all dead
     * false otherwise
     */
    public boolean looser(){
        return playersAlive == 0;
    }



//turns

    /**
     * puts everyone in the queue according to the weight
     */
    public void loadingGame()   {
        if(phase.isSetUpPhase()){
                for (var character : party ){
                    character.waitTurn();
                }
                for(var enemy : enemyParty){
                    enemy.waitTurn();
                }
            phase.toWaitingPhase();

        }


    }

    /**
     * return the action made by an Enemy when his turn arrive
     */
    public String getLog(){
        return log;
    }

    /**
     * the begin of a turn
     */
    public void characterTurn()  {

        if(phase.isTurnPhase() && !beginTurnTaken)  {
            beginTurnTaken = true;
            actualCharacter = turns.peek();
            phase.toSelectPhase();
            if (actualCharacter.isAlive()) {
                if (actualCharacter.getCharacter() == 0) {
                    IPlayerCharacter target = rngPlayerCharacter();
                    log = actualCharacter.getName() + " attacked " + target.getName();
                    tryToAttack(actualCharacter, target);
                } else if (actualCharacter.getCharacter() == 1) {

                }
            }
        }

    }


    /**
     * used when the actual character is an Enemy to select a random character from the player's party
     */
    public IPlayerCharacter rngPlayerCharacter(){

        int rng = new Random().nextInt( getParty().size() );
        while(true){

            IPlayerCharacter candidate = getFromParty(rng);
            if(candidate.isAlive()){
                return candidate;
            }
            rng = (rng+1)%getParty().size();
        }
    }

    /**
     * method used to verify if now is it possible to begin a new turn
     */
    public void tryToBeginTurn(){
        if(phase.isWaitingPhase() && !tryTurnTaken) {
            tryTurnTaken = true;
            phase.toTurnPhase();
            characterTurn();
        }
        else{
        }
    }

    /**
     * method used to verify if now the character can attack
     */
    public void tryToAttack(ICharacter attacker, ICharacter target){
        phase.tryAttack(attacker, target);
    }

    /**
     * called by controllerAttack
     * calls the end of the turn;
     *
     */
    public void endTurn()   {
            phase.toWaitingPhase();
            turns.poll();
            actualCharacter.waitTurn();
            beginTurnTaken = false;
            tryTurnTaken = false;
            if(!turns.isEmpty()){
                tryToBeginTurn();
            }



    }

    /**
     * getter for the popped character of the queue
     */
    public ICharacter getActualCharacter(){
        return actualCharacter;
    }


    /**
     * set's the current phase of the controller
     */
    public void setPhase(Phase phase){
        this.phase = phase;
        phase.setController(this);
    }


    /**
     * return the expected amount of party members
     */
    public int getPartyNum(){
        return partyNum;
    }

    /**
     * gets the amount of characters in the party
     */
    public int getPartySize(){
        return party.size();
    }

    /**
     * return the size of the inventory
     */
    public int getInventorySpace(){
        return inventory.size();
    }

    /**
     * return the inventory of the game
     */
    public HashMap<String, IWeapon> getInventory(){
        return inventory;
    }

    /**
     * return the enemy size
     */
    public int getEnemySize(){
        return enemyParty.size();
    }

    /**
     * used in the GUI
     * get the name of the actual cHaracter
     */
    public String getActualName(){
        if(actualCharacter == null){
            return "no name";
        }
        else{
            return actualCharacter.getName();
        }
    }

    /**
     * returns this controller current phase
     */
    public Phase getPhase(){
        return this.phase;
    }






    //
}
