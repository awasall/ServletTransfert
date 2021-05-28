package Controller;

import Model.Compte;
import Model.Partenaire;
import Repository.JDBC.DataSource;
import Repository.JDBC.MysqlDataSource;
import Service.CompteDao;
import Service.PartenaireDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "CompteServlet", value = "/CompteServlet")
public class CompteServlet extends HttpServlet {
    CompteDao compteDao;
    PartenaireDao partenaireDao;
    DataSource dataSource= new MysqlDataSource();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("BONJOUR ce que tu veux");
        Connection connection = dataSource.createConnection();
        String action = req.getParameter("action");
        compteDao = new CompteDao(dataSource);
        partenaireDao= new PartenaireDao(dataSource);

                //List<Service> service=employeDao.findService();
                //req.setAttribute("partnersId",partenaireDao.getById());
                req.setAttribute("comptes", compteDao.getAll());

                List<Partenaire> partenaires=partenaireDao.getAll();
                req.setAttribute("partenaires",partenaires);
                getServletContext().getRequestDispatcher("/WEB-INF/Compte.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

                String numerCompte=req.getParameter("numerCompte");
                String solde=req.getParameter("solde");
                int idp=Integer.parseInt(req.getParameter("part"));
                Partenaire s=new Partenaire();
                s.setIdP(idp);
                Compte e=new Compte(numerCompte,solde,s);
                //List<Service> service=employeDao.findService();
                //req.setAttribute("services",service);
                try {
                    compteDao.add(e);
                    req.setAttribute("comptes",compteDao.add(e));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                getServletContext().getRequestDispatcher("/WEB-INF/Compte.jsp").forward(req,resp);


    }
}
