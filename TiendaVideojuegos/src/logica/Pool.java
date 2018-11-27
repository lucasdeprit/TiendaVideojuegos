package logica;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;


public class Pool {


    public DataSource dataSource;

    public String db = "fundacion";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "123";



    public Pool(){

        inicializaDataSource();

    }



    private void inicializaDataSource(){


        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxActive(50);


        dataSource = basicDataSource;

    }


}