package me.herrlestrate.writeups.service;

import me.herrlestrate.writeups.dao.WriteupDAO;
import me.herrlestrate.writeups.model.Writeup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WriteupServiceImpl implements WriteupService{

    private WriteupDAO writeupDAO;

    @Autowired
    public void setWriteupDAO(WriteupDAO writeupDAO){
        this.writeupDAO = writeupDAO;
    }

    @Transactional
    public List<Writeup> allWriteups() {
        return writeupDAO.allWriteups();
    }

    @Transactional
    public void create(Writeup writeup) {
        writeupDAO.create(writeup);
    }

    @Transactional
    public Writeup getById(int id) {
        return writeupDAO.getById(id);
    }

    @Transactional
    public void update(Writeup writeup) {
        writeupDAO.update(writeup);
    }

    @Transactional
    public void delete(Writeup writeup) {
        writeupDAO.delete(writeup);
    }
}
