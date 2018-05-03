package com.gag.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gag.model.User;

@Controller
public class FileController {

	private static final String FILE_PATH = "/Users/user1/Desktop/9gagImages/";

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFormUpload(@RequestParam("file") MultipartFile file, HttpSession session) {

		if (!file.isEmpty()) {
			byte[] bytes;
			String fileName = "9gag-" + ((User) session.getAttribute("user")).getLastName()
					+ file.getOriginalFilename();
			File serverFile = new File(FILE_PATH + fileName);
			try (FileOutputStream fo = new FileOutputStream(serverFile)) {
				bytes = file.getBytes();
				serverFile.createNewFile();
				fo.write(bytes);
				return "redirect:uploadSuccess";
			} catch (IOException e) {
				return "redirect:uploadFailure";
			}
		}

		return "redirect:uploadFailure";
	}

}