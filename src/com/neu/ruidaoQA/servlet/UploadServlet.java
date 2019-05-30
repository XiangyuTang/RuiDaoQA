//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.neu.ruidaoQA.servlet;

import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.impl.UserServiceimpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet({"/UploadServlet"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    public UploadServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p1 = request.getParameter("user1");
        Part part1 = request.getPart("pic");
        String submittedFileName = part1.getSubmittedFileName().toString();
        long size = part1.getSize();
        String realPath = request.getServletContext().getRealPath("/images/avatar");
        File fileFolder = new File(realPath);
        if (!fileFolder.exists()) {
            fileFolder.mkdirs();
        }

        String fileFinalPath = fileFolder + File.separator + submittedFileName;
        UserServiceimpl us = new UserServiceimpl();
        String path = "images/avatar/" + submittedFileName;
        us.addHeadPhoto(Integer.parseInt(request.getSession().getAttribute("current_user_id").toString()), path);
        User u = us.getUser(Integer.parseInt(request.getSession().getAttribute("current_user_id").toString()));
        request.getSession().setAttribute("CurrentUser", u);
        part1.write(fileFinalPath);
        copyFile3(fileFinalPath, "C:\\Users\\18940\\eclipse-workspace\\RuiDaoQA\\WebContent\\images\\avatar" + submittedFileName);
        request.getRequestDispatcher("userinfo.jsp").forward(request, response);
    }

    private static void copyFile3(String srcPath, String destPath) throws IOException {
        FileInputStream fis = new FileInputStream(srcPath);
        FileOutputStream fos = new FileOutputStream(destPath);
//        int len = false;
        byte[] b = new byte[1024];

        int len;
        while((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }

        fos.close();
        fis.close();
    }
}