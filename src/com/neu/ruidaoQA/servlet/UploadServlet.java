package com.neu.ruidaoQA.servlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.zip.InflaterInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.neu.ruidaoQA.entity.User;
import com.neu.ruidaoQA.service.UserService;
import com.neu.ruidaoQA.service.impl.UserServiceimpl;

/**
 * (**重要**)
 * @MultipartConfig 注解   作用: 声明该servlet可以接受前台表单类型为multipart/form-data的所有数据
 * 如果不加这个   , 前台表单中的值  ,一个也接受不到
 */
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p1 = request.getParameter("user1");
		Part part1 = request.getPart("pic");// 使用part对象接受前台的file域中的对象
		String submittedFileName = part1.getSubmittedFileName().toString();//获取上传文件的名称     ***.jpg
//		int dianIndex = submittedFileName.indexOf(".");
//		String houzhui = submittedFileName.substring(dianIndex);//获取文件的类型
		long size = part1.getSize();//文件占用的字节数 
		
//		//解决文件重名问题
//		UUID randomUUID = UUID.randomUUID();
//		//为文件重新换一个名字
//		String newFileName=randomUUID+houzhui; 
//		
//		System.out.println(newFileName);
		
		//上传文件的操作
		//1. 先定义一个文件夹,判断如果该文件夹不存在,就创建一个文件夹
		String realPath = request.getServletContext().getRealPath("/images/avatar");
		File fileFolder = new File(realPath);
		if (!fileFolder.exists()) {
			fileFolder.mkdirs();
		}
		
		//1.1 (备份文件)将上述的文件夹再备份出来一个 ,备份到应用程序的平级目录上,稍微改个名字,以后想要找之前上传的图片,就在这里找,复制到upload文件夹下
//		String realPath2 = request.getServletContext().getRealPath(""); //获取应用程序的根目录
//		String webapps = realPath2.substring(0, realPath2.lastIndexOf("\\"));
//		String hahaha=webapps+"_hahaha\\";
//		File hahahaFolder = new File(hahaha);
//		if (!hahahaFolder.exists()) {
//			hahahaFolder.mkdirs();
//		}
		
		//2.拼接文件上传路径和文件名
		String fileFinalPath = fileFolder+File.separator+submittedFileName;
		UserServiceimpl us = new UserServiceimpl();
		String path = "images/avatar/"+submittedFileName;
		us.addHeadPhoto(Integer.parseInt(request.getSession().getAttribute("current_user_id").toString()),path);
		User u=us.getUser(Integer.parseInt(request.getSession().getAttribute("current_user_id").toString()));
		request.getSession().setAttribute("CurrentUser", u);
		//2.1 (备份文件)
//		String hahahaFinalPath = hahaha+File.separator+newFileName;
		
		//3. 上传
		part1.write(fileFinalPath);
		//3.1 (备份文件)
		copyFile3(fileFinalPath,"C:\\Users\\40947\\Documents\\Tencent Files\\409478176\\FileRecv\\ruidao 3\\ruidao\\WebContent\\images\\avatar\\"+submittedFileName);///Users/liyitong/eclipse-workspace/bookstore/WebContent/image/book.jpg
		
//		request.getSession().setAttribute("filename", path);
		request.getRequestDispatcher("userinfo.jsp").forward(request,response);
	}


	/**
	 * 
	 * @param srcPath  源文件位置 ,
	 * @param destPath 目标文件位置,
	 * @throws IOException
	 */
    private static void copyFile3(String srcPath, String destPath) throws IOException {
        
        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);
        
        // 读取和写入信息
        int len = 0;
        // 创建一个字节数组，当做缓冲区
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        
        // 关闭流  
        fos.close(); // 后开先关
        fis.close(); // 先开后关
        
    }
}
