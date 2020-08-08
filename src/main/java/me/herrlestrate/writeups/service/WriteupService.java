package me.herrlestrate.writeups.service;

import me.herrlestrate.writeups.model.Writeup;

import java.util.List;

public interface WriteupService {

    List<Writeup> allWriteups();
    void create(Writeup writeup);
    Writeup getById(int id);
    void update(Writeup writeup);
    void delete(Writeup writeup);
}
