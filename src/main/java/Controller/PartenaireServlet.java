package Controller;

import Model.Partenaire;
import Repository.JDBC.DataSource;
import Repository.JDBC.MysqlDataSource;
import Service.PartenaireDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "PartenaireServlet", value = "/PartenaireServlet")
public class PartenaireServlet extends HttpServlet {
    PartenaireDao partenaireDao;
    DataSource dataSource= new MysqlDataSource();

    //public PartenaireServlet(DataSource dataSource) {
        //this.dataSource = dataSource;
    //}

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("BONJOUR ce que tu veux");
        Connection connection = dataSource.createConnection();
        String action = req.getParameter("action");
        partenaireDao = new PartenaireDao(dataSource);
        req.setAttribute("partners", partenaireDao.getAll());
        getServletContext().getRequestDispatcher("/WEB-INF/Partenaire.jsp").forward(req, resp);
        /*switch (action) {
            case "add":
                //List<Service> service=employeDao.findService();
                //req.setAttribute("partnersId",partenaireDao.getById());
                req.setAttribute("parners", partenaireDao.getAll());
                getServletContext().getRequestDispatcher("/WEB-INF/Partenaire.jsp").forward(req, resp);
                break;
        }*/

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String action = req.getParameter("action");
        Partenaire p = new Partenaire();
        req.setAttribute("partners", partenaireDao.add(p));
        getServletContext().getRequestDispatcher("/WEB-INF/Partenaire.jsp").forward(req, resp);
        /*switch (action) {
            case "add":
                req.setAttribute("partners", partenaireDao.add(p));
                getServletContext().getRequestDispatcher("/WEB-INF/Partenaire.jsp").forward(req, resp);
                break;


        }*/
        String action=req.getParameter("action");

                String ninea=req.getParameter("ninea");
                String prenom=req.getParameter("prenom");
                String nom=req.getParameter("nom");
                String email=req.getParameter("email");
                String telephone=req.getParameter("telephone");
                String adresse=req.getParameter("adresse");
                String raisonsociale=req.getParameter("raisonsociale");
                String statut=req.getParameter("statut");

                Partenaire p = new Partenaire(ninea,prenom,nom,telephone,email,adresse,raisonsociale,statut);
                //List<Service> service=employeDao.findService();
                //req.setAttribute("services",service);
                try {
                    partenaireDao.add(p);
                    req.setAttribute("partners",partenaireDao.add(p));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                getServletContext().getRequestDispatcher("/WEB-INF/Partenaire.jsp").forward(req,resp);

    }
}
