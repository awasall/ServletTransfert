package Repository;

import Model.Utilisateur;

public interface UtilisateurRepository {
    Utilisateur[] getAll();
    Utilisateur getById(int id);
}
