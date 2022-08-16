package ru.netology.movies;

public class PostersRepository {

  private Posters[] posters = new Posters[0];

  public Posters[] findAll() {
    return posters;
  }

  public void save(Posters item) {
    int length = posters.length + 1;
    Posters[] tmp = new Posters[length];
    System.arraycopy(posters, 0, tmp, 0, posters.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    posters = tmp;
  }

  public Posters findById(int id) {
    for (Posters item : posters) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  public void removeById(int id) {
    int length = posters.length - 1;
    Posters[] tmp = new Posters[length];
    int index = 0;
    for (Posters item : posters) {
      if (item.getId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    posters = tmp;
  }

  public void removeAll() {
    posters = new Posters[0];
  }
}
