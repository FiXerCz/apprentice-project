package com.hella.apprentice.project.pojos;

import com.hella.apprentice.project.enums.Race;
import com.hella.apprentice.project.pojos.ability.AbilityInterface;
import org.jboss.resteasy.reactive.common.NotImplementedYet;

import java.util.Objects;

public class Hero implements HeroInterface {

    private final String name;
    private final Race race;
    private int currentHp;
    private final int maxHp;
    private final int attack;
    private final int defense;
    private final AbilityInterface ability;

    public Hero(Hero hero) {
        this.name = hero.name;
        this.race = hero.race;
        this.maxHp = hero.maxHp;
        this.currentHp = hero.currentHp;
        this.attack = hero.attack;
        this.defense = hero.defense;
        this.ability = hero.ability;
    }

    Hero(String name, Race race, int maxHp, int attack, int defense, AbilityInterface ability) {
        this.name = name;
        this.race = race;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.ability = ability;
    }

    /**
     * Reduce players currentHp. All multiplications/divisions dont use decimal points.
     * Rules:
     *  - if player has defense the same or higher as damage parameter, then subtract half of damage from the applied damage:
     *    damage - damage/2
     *  - if player has defense lower than damage parameter, then subtract third of damage from the applied damage:
     *    damage - damage/3
     *
     * @param damage value used for calculation
     * @return total applied damage
     */
    @Override
    public int receiveDamage(int damage) {
        throw new NotImplementedYet();
    }

    /**
     * Hero is alive of currentHp is not 0 or less.
     * @return
     */
    @Override
    public boolean isAlive() {
        throw new NotImplementedYet();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public void refreshCurrentHp() {
        this.currentHp = maxHp;
    }

    @Override
    public void addHp(int hp) {
        currentHp = Math.min(currentHp + hp, maxHp);
    }

    @Override
    public boolean hasAbility() {
        return ability!=null;
    }

    @Override
    public AbilityInterface getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", race=" + race +
                ", hp=" + maxHp +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(name, hero.name) && race == hero.race;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, race);
    }

    public static class HeroBuilder {
        private String name;
        private Race race;
        private int hp;
        private int attack;
        private int defense;
        private AbilityInterface ability;

        public HeroBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HeroBuilder setRace(Race race) {
            this.race = race;
            return this;
        }

        public HeroBuilder setHp(int hp) {
            this.hp = hp;
            return this;
        }

        public HeroBuilder setAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public HeroBuilder setDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public HeroBuilder setAbility(AbilityInterface ability) {
            this.ability = ability;
            return this;
        }

        public Hero build() {
            //todo: implement check of fields. We want all fields filled-in.
            // Validation should be done in different private method

            return new Hero(name,race,hp,attack,defense,ability);
        }

    }

}
