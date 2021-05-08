package Repository;

import Model.Partenaire;


import java.util.List;

public interface PartenaireRepository {

    List<Partenaire> getAll();
    Partenaire getById(int id);
    public int add(Partenaire p);


}
