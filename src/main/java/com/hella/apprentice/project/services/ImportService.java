package com.hella.apprentice.project.services;

public interface ImportService {

    /**
     *  Method will try open file with data about {@link com.hella.apprentice.project.pojos.Hero}s and read.
     *  All that read data should be inserted into storage.
     * @return number of new records inserted
     */
    int importHeroesFromFile();

}
