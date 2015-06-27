package com.yakub.learn.webcrud.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yakub.learn.webcrud.Dao.PegawaiDao;
import com.yakub.learn.webcrud.Util.ConnectionUtil;
import com.yakub.learn.webcrud.model.Pegawai;

public class PegawaiDaoImpl implements PegawaiDao {

  private Connection connection;
  private ConnectionUtil util;

  private static final String TABLE_NAME = "pegawai.pegawai";
  private static final String INSERT = "insert into " + TABLE_NAME + "(nama, alamat) values(?,?)";
  private static final String UPDATE = "update " + TABLE_NAME + " set alamat=? where nama = ?";
  private static final String DELETE = "delete from " + TABLE_NAME + " where nama = ?";
  private static final String SELECT = "select * from " + TABLE_NAME;

  public void insert(Pegawai p) {
    // TODO Auto-generated method stub
    try {
      connection = ConnectionUtil.getConnection();
      PreparedStatement stm = connection.prepareStatement(INSERT);
      stm.setString(1, p.getNama());
      stm.setString(2, p.getAlamat());
      stm.execute();
      connection.close();
    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  public void update(Pegawai p) {
    // TODO Auto-generated method stub
    try {
      connection = ConnectionUtil.getConnection();
      PreparedStatement stm = connection.prepareStatement(UPDATE);
      stm.setString(1, p.getAlamat());
      stm.setString(2, p.getNama());
      stm.execute();
      connection.close();
    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  public void delete(String nama) {
    // TODO Auto-generated method stub
    try {
      connection = ConnectionUtil.getConnection();
      PreparedStatement stm = connection.prepareStatement(DELETE);
      stm.setString(1, nama);
      stm.execute();
      connection.close();
    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  public List<Pegawai> getAll() {
    // TODO Auto-generated method stub
    List<Pegawai> ls = new ArrayList<Pegawai>();
    Pegawai p = null;
    try {
      connection = ConnectionUtil.getConnection();
      PreparedStatement stm = connection.prepareStatement(SELECT);
      ResultSet set = stm.executeQuery();
      while (set.next()) {
        p = new Pegawai();
        p.setNama(set.getString("nama"));
        p.setAlamat(set.getString("alamat"));
        ls.add(p);
      }
      connection.close();
    } catch (Exception x) {
      x.printStackTrace();
    }
    return ls;
  }

  public List<Pegawai> findByCriteria(String criteria, String value) {
    // TODO Auto-generated method stub
    List<Pegawai> ls = new ArrayList<Pegawai>();
    Pegawai p = null;
    String SELECT_CRIT =
        SELECT.concat(" where criteria = ").concat(criteria).concat(" and value = ?");
    try {
      connection = ConnectionUtil.getConnection();
      PreparedStatement stm = connection.prepareStatement(SELECT_CRIT);
      ResultSet set = stm.executeQuery();
      while (set.next()) {
        p = new Pegawai();
        p.setNama(set.getString("nama"));
        p.setAlamat(set.getString("alamat"));
        ls.add(p);
      }
      connection.close();
    } catch (Exception x) {
      x.printStackTrace();
    }
    return ls;
  }

}
