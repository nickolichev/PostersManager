package ru.netology.movies;

public class PostersManager {

  private Posters[] posters = new Posters[0];
  private int length;

  public PostersManager(int length) {
    this.length = length;
  }

  public PostersManager() {
    length = 10;
  }

  public void add(Posters poster) {
    Posters[] tmp = new Posters[posters.length + 1];
    for (int i = 0; i < posters.length; i++) {
      tmp[i] = posters[i];
    }
    tmp[tmp.length - 1] = poster;
    posters = tmp;
  }

  public Posters[] findLast() {
    Posters[] lastten;
    if (length < posters.length) {
      lastten = new Posters[length];
    } else {
      lastten = new Posters[posters.length];
    }
    for (int i = 0; i < length; i++) {
      int index = posters.length - i - 1;
      lastten[i] = posters[index];
    }
    return lastten;
  }

  public Posters[] findAll() {
    return posters;
  }
}
