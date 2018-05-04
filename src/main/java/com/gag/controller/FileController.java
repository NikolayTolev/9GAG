package com.gag.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.gag.model.Post;
import com.gag.model.Section;
import com.gag.model.Tag;
import com.gag.model.User;
import com.gag.model.dao.PostDAO;
import com.gag.model.dao.TagDAO;

@Controller
@MultipartConfig
public class FileController {
	
	private static final String FILE_PATH = "/Users/user1/Desktop/uploads/";

//	@RequestMapping(value="/upload", method=RequestMethod.GET)
//	public String showUploadForm() {
//		return "upload";
//	}

	@RequestMapping(value="/upload/post", method=RequestMethod.POST)
	public String saveImage(Model m, HttpSession session, @RequestParam("file") MultipartFile uploadedFile,
			                         @RequestParam("description") String description,
			                         @RequestParam("tag") String tag,
			                         @RequestParam("section") Section sec) throws IOException {
//		String extension = FilenameUtils.getExtension(uploadedFile.getOriginalFilename());
		String fileName = "9gag-"+uploadedFile.getOriginalFilename();
		File serverFile = new File(FILE_PATH + fileName);
		Files.copy(uploadedFile.getInputStream(), serverFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		m.addAttribute("filename", fileName);
		Post p=new Post((User)session.getAttribute("user"));
		p.imageURL(fileName);
		Tag g =new Tag(tag);
		try {
		TagDAO.TAG_DAO.saveTag(g);
		} catch (SQLException e1) {
		}
		p.title(description);
		p.addTags(g);
		p.section(sec);
		try {
			PostDAO.POST_DAO.savePost(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping(value="/render/{filename:.+}", method=RequestMethod.GET)
	public void downloadFile(HttpServletResponse resp, @PathVariable("filename") String fileName) throws IOException {
		System.out.println(fileName);
		File serverFile = new File(FILE_PATH + fileName);
		Files.copy(serverFile.toPath(), resp.getOutputStream());
	}
}




//package com.gag.controller;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import org.springframework.web.multipart.MultipartFile;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import com.gag.model.User;
//
//@Controller
//public class FileController {
//
//	private static final String FILE_PATH = "/Users/user1/Desktop/9gagFiles/";
//
//	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	@ResponseBody
//	public String handleFormUpload(@RequestParam("file") MultipartFile file, HttpSession session) {
//
//		if (!file.isEmpty()) {
//			String fileName = "9gag-" + ((User) session.getAttribute("user")).getLastName()+ file.getOriginalFilename();
//			File serverFile = new File(FILE_PATH + fileName);
//			try (FileOutputStream fo = new FileOutputStream(serverFile)) {
//				byte[] bytes = file.getBytes();
//				serverFile.createNewFile();
//				fo.write(bytes);
//				return "The file was uploaded successfully!";
//			} catch (IOException e) {
//				return "Ooops! There was an error! Please, try again!";
//			}
//		}
//
//		return "Ooops! There was an error! Please, try again!";
//	}
//	
////	 @RequestMapping(value="/upload", method=RequestMethod.POST)
////	 public String saveImage(Model m, @RequestParam("file") MultipartFile
////	 uploadedFile) throws IOException {
////	 String fileName = "9gag-"+uploadedFile.getOriginalFilename();
////	 File serverFile = new File(FILE_PATH + fileName);
////	 Files.copy(uploadedFile.getInputStream(), serverFile.toPath(),
////	 StandardCopyOption.REPLACE_EXISTING);
////	 m.addAttribute("filename", fileName);
////	 return "upload";
////	 }
//
//	 @RequestMapping(value="/files/{filename:.+}", method=RequestMethod.GET)
//	 public void downloadFile(HttpServletResponse resp, @PathVariable("filename")
//	   String fileName) throws IOException {
//	    System.out.println(fileName);
//	 File serverFile = new File(FILE_PATH + fileName);
//	 Files.copy(serverFile.toPath(), resp.getOutputStream());
//	 }
//}