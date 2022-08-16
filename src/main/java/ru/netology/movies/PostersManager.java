package ru.netology.movies;

public class PostersManager {

  private PostersRepository repository;
  private int poster = 12;

  public PostersManager(PostersRepository repository) {
    this.repository = repository;
  }

  public PostersManager(PostersRepository repository, int poster) {
    this.repository = repository;
    if (poster >= 0) {
      this.poster = poster;
    }
  }

  public void add(Posters poster) {
    repository.save(poster);
  }
  public Posters[] findAll() {
    return repository.findAll();
  }

  public Posters[] findLast() {
    Posters[] posters = repository.findAll();
    int count = posters.length > this.poster ? this.poster : posters.length;
    Posters[] tmp = new Posters[count];
    for (int i = 0; i < count; i++) {
      int index = posters.length - i - 1;
      tmp[i] = posters[index];
    }
    return tmp;
  }
}