package com.hella.apprentice.project.services;

import com.hella.apprentice.project.enums.Race;
import com.hella.apprentice.project.pojos.Hero;
import com.hella.apprentice.project.utils.Utils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Named
@ApplicationScoped
public class ImportServiceImpl implements ImportService {

    private static final String COMMA = ",";

    @ConfigProperty(name = "quarkus.heroes.import.file")
    String importFileName;

    @Inject Logger log;
    @Inject HeroService heroService;

    @Override
    public int importHeroesFromFile() {
        int numberOfNewRecords = 0;
        try {
            List<String> lines = readLinesFromFile();
            Hero hero;
            for (String line: lines){
                hero = parseLineFromFileIntoHero(line);
                if (hero!=null){
                    log.info("New hero imported. " + hero);
                    heroService.addHero(hero);
                    numberOfNewRecords++;
                }
            }
        } catch (FileNotFoundException e) {
            log.error("File for import was not found.",e);
        }
        return numberOfNewRecords;
    }

    private List<String> readLinesFromFile() throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        File file = Utils.getResourceAsFileByResourceName(importFileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }

        return lines;
    }

    private Hero parseLineFromFileIntoHero(String line){
        String[] parts = line.split(COMMA);
        // we expect 5 attributes on every line
        Race race;
        if (parts.length==5) {
            //check race (on second position)
            race = Race.byName(parts[1]);
            if (race!=null) {
                return new Hero.HeroBuilder()
                                .setName(parts[0])
                                .setRace(race)
                                .setHp(convertToInt(parts[2]))
                                .setAttack(convertToInt(parts[3]))
                                .setDefense(convertToInt(parts[4]))
                                .build();
            }
        }
        return null;
    }

    private int convertToInt(String str) {
        return Integer.parseInt(str);
    }

}
