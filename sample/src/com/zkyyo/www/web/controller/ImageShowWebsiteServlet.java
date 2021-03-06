package com.zkyyo.www.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 该servlet用于处理显示与网站相关图片的请求
 */
@WebServlet(
        name = "ImageShowWebsiteServlet",
        urlPatterns = {"/image_show_website.do"}
)
public class ImageShowWebsiteServlet extends HttpServlet {
    /**
     * 存放讨论区文件的根目录
     */
    private String IMAGE_DIR;

    public void init() throws ServletException {
        IMAGE_DIR = (String) getServletContext().getAttribute("imageDir");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String relativePath = request.getParameter("relativePath"); //图片的相对路径
        String bathPath = getServletContext().getRealPath(IMAGE_DIR);
        String absolutePath = bathPath + relativePath; //图片在硬盘上的绝对路径
        File file = new File(absolutePath);

        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);
        fileInputStream.close();

        OutputStream outputStream = response.getOutputStream();
        response.setContentType("image/jpeg");
        outputStream.write(data);
        outputStream.flush();
        outputStream.close();
    }
}
