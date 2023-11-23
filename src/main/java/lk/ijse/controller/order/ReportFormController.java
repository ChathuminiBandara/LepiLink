package lk.ijse.controller.order;

import lk.ijse.db.DbConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ReportFormController {
//    InputStream resourceAsStream =
//            getClass().getResourceAsStream("/report/Blank_A4_6.jrxml");
//    JasperDesign load = JRXmlLoader.load(resourceAsStream);
//    JasperReport compileReport = JasperCompileManager.compileReport(load);
//    JasperPrint jasperPrint =
//            JasperFillManager.fillReport(
//                    compileReport, //compiled report
//                    null,
//                    DbConnection.getInstance().getConnection() //database connection
//            );
//JasperDesign load = JRXmlLoader.load("D:\\Final Project\\src\\main\\resources\\Report\\userReport.jrxml");
//    JasperReport compileReport = JasperCompileManager.compileReport(load);
//    JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport,null, DbConnection.getInstance().getConnection());


    public ReportFormController() throws SQLException, JRException {
    }
//                JasperViewer.viewReport(jasperPrint,false);
}
