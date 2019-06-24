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
public class ServerNode { 
    public static void main (String[] _args) throws Exception{ 
        OtpSelf sNode = new OtpSelf("servernode", "cookie");
        sNode.publishPort();
        OtpConnection connection = sNode.accept();
        while(true) try {
            OtpErlangTuple terms = (OtpErlangTuple) connection.receive();
            OtpErlangLong first = (OtpErlangLong) terms.elementAt(0);
            OtpErlangLong second = (OtpErlangLong) terms.elementAt(1); 
            long sum = first.longValue() + second.longValue();
            connection.send(connection.peer().node(),new OtpErlangLong(sum)); 
        }catch(OtpErlangExit e) {
            break;
        } sNode.unPublishPort();
        connection.close();
    } }
