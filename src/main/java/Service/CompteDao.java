package Service;

import Model.Compte;
import Model.Partenaire;
import Repository.CompteRepository;
import Repository.JDBC.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Repository.CompteRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompteDao implements CompteRepository {
    private final DataSource dataSource;
    public CompteDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    private int ok;
    private ResultSet res;

    @Override
    public List<Compte> getAll() {
        List<Compte> comptes = new ArrayList<Compte>();
        String query="SELECT * FROM Compte";
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(query) ;
            while (res.next()){
                Compte e=new Compte();
                e.setIdC(res.getInt(1));
                e.setNumerCompte(res.getString(2));
                e.setSolde(res.getInt(3));
                PartenaireDao jdbcBasedPartenaireRepository=new PartenaireDao(dataSource);
                Partenaire partenaire =jdbcBasedPartenaireRepository.getById(res.getInt(4));
                e.setPartenaire(partenaire);

                comptes.add(e);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return comptes;
    }

    @Override
    public Compte getById(int idC) {
        Compte sc=new Compte();
        String query="SELECT * FROM Compte WHERE idC='"+idC+"'";
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(query) ;
            while (res.next()){
                sc.setIdC(res.getInt(1));
                sc.setNumerCompte(res.getString(2));
                sc.setSolde(res.getInt(3));
                PartenaireDao jdbcBasedPartenaireRepository=new PartenaireDao(dataSource);
                Partenaire partenaire =jdbcBasedPartenaireRepository.getById(res.getInt(4));
                sc.setPartenaire(partenaire);

                //comptes.add(e);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return sc;
    }

    @Override
    public List<Compte>  getByIdP(int idP) {
        List<Compte> comptes = new ArrayList<Compte>();

        String query="SELECT * FROM Compte WHERE idP='"+idP+"'";
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(query) ;
            while (res.next()){
                Compte sc=new Compte();
                sc.setIdC(res.getInt(1));
                sc.setNumerCompte(res.getString(2));
                sc.setSolde(res.getInt(3));
                PartenaireDao jdbcBasedPartenaireRepository=new PartenaireDao(dataSource);
                Partenaire partenaire =jdbcBasedPartenaireRepository.getById(res.getInt(4));
                sc.setPartenaire(partenaire);
                comptes.add(sc);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return comptes;
    }

    @Override
    public int add(Compte c) {
        String query="INSERT INTO Compte VALUES (NULL,?,?,?)";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement db = connection.prepareStatement(query);

            db.setString(1, c.getNumerCompte());
            db.setInt(2,c.getSolde());
            db.setInt(3,c.getPartenaire().getIdP());
            db.execute();
            return 1;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }



}
