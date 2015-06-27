package com.yakub.learn.webcrud.Dao;

import java.util.List;

import com.yakub.learn.webcrud.model.Pegawai;

public interface PegawaiDao {

  public void insert(Pegawai p);

  public void update(Pegawai p);

  public void delete(String nama);

  public List<Pegawai> getAll();

  public List<Pegawai> findByCriteria(String criteria, String value);

}
