/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaerlang;
/**
 *
 * @author maryza
 */


 import com.ericsson.otp.erlang.*;
import static org.junit.Assert.assertEquals;
public class ClientNode {
    public static void main (String[] _args) throws Exception{
        OtpSelf cNode = new OtpSelf("clientnode", "cookie");
        OtpPeer sNode = new OtpPeer("server@DESKTOP-NPKN4JP");
        OtpConnection connection = cNode.connect(sNode);
        OtpErlangObject[] args = new OtpErlangObject[]{
        new OtpErlangLong(6), new OtpErlangLong(6)};
        connection.sendRPC("mathserver", "add", args);
    // OtpErlangLong sum = (OtpErlangLong) connection.receiveRPC();
      //  assertEquals(3, sum.intValue());
    }

    


}




