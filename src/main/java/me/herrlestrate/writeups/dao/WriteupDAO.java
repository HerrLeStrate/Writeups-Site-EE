package me.herrlestrate.writeups.dao;

import me.herrlestrate.writeups.model.Writeup;

import java.util.List;

public interface WriteupDAO {

    List<Writeup> allWriteups();
    void create(Writeup writeup);
    Writeup getById(int id);
    void update(Writeup writeup);
    void delete(Writeup writeup);
}
