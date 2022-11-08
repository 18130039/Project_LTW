package edu.controller;

import edu.beans.Account;
import edu.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.*;
import java.util.Base64;


@WebServlet(name = "SignUpControl", urlPatterns = "/signup")
public class SignUpControl extends HttpServlet {
    public static void generateKey(String user, HttpServletRequest request) throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA","SUN");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG","SUN");
        keyGen.initialize(1024,random);
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey priv = pair.getPrivate();
        PublicKey pub = pair.getPublic();

        //        save public key
        byte[] publicKey = pub.getEncoded();
        String publicKeyStr = Base64.getEncoder().encodeToString(publicKey);
        ProductEntity pe = new ProductEntity();
        pe.savePublicKey(user, publicKeyStr);

        //        send private key
        byte[] privateKey = priv.getEncoded();
        String prvStr = Base64.getEncoder().encodeToString(privateKey);
        request.setAttribute("privateKey", prvStr);
        System.out.println(prvStr);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        if(!pass.equals(re_pass)) {
            request.setAttribute("mess", "Mật khẩu nhập lại không khớp");
            request.getRequestDispatcher("signup.jsp").forward(request,response);
        } else {
            ProductEntity pe = new ProductEntity();
            Account a = pe.checkExist(user);
            if(a == null) {
                pe.signUp(user,pass);
                try {
                    generateKey(user, request);
                    a = pe.login(user,pass);
                    String publicKey = pe.getPublicKeyOfUser(a.getId());

                    HttpSession session = request.getSession();
                    session.setAttribute("acc",a);
                    session.setAttribute("publicKey", publicKey);
                } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("get-key.jsp").forward(request,response);
            } else {
                request.setAttribute("mess", "Email đã được sử dụng");
                request.getRequestDispatcher("signup.jsp").forward(request,response);
            }
        }
    }
}
