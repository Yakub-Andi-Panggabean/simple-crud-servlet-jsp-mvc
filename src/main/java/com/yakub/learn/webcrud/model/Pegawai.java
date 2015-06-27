package com.yakub.learn.webcrud.model;

public class Pegawai {
  private String nama;
  private String alamat;

  public Pegawai() {
    super();
  }

  public Pegawai(String nama, String alamat) {
    super();
    this.nama = nama;
    this.alamat = alamat;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }


}
