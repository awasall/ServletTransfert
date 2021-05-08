package Repository;

import Model.Compte;


import java.util.List;

public interface CompteRepository {
    List<Compte> getAll();
    Compte getById(int id);
    List<Compte>  getByIdP(int id);
    public int add(Compte c);
}
