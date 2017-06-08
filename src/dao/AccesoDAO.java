/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import to.AccesoTO;

/**
 *
 * @author Joel
 */
public class AccesoDAO {
    public boolean Acceder(AccesoTO objAccesoTO) throws Exception{
        Connection con= conexion.ConSQL.getInstance().getConnection();
        String sql= "Select * from usuarios where username = ? and password = ?";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, objAccesoTO.getUsuario());
        pst.setString(2, objAccesoTO.getClave());
        ResultSet rs= pst.executeQuery();
        if(rs.next()){
            JOptionPane.showMessageDialog(null, "Usuario y Clave Coinciden.");
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Usuario y Clave Incorrectos.");
            return false;
        }
    }
    public void RegistrarEmpleado(AccesoTO objAccesoTO)throws Exception{
        Connection con= conexion.ConSQL.getInstance().getConnection();
        String sql="insert into usuarios values(?,?)";
        CallableStatement cs=con.prepareCall(sql);
        cs.setString(1, objAccesoTO.getUsuario());
        cs.setString(2, objAccesoTO.getClave());
        cs.execute();
    }
}
