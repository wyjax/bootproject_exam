package com.example.controller;

import com.example.model.Freeboard;
import com.example.service.FreeboardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FreeboardCotroller {
	
	private HttpSession session;
	
	@Autowired
	private FreeboardListService freeboardlistService;
	
	@GetMapping(value = "/freeboard")
	public String viewFreeboard(@RequestParam(value = "pageNum", defaultValue = "1")String pageNum) {
		List<Freeboard> freelist = freeboardlistService.freeboardList(pageNum);
		if(freelist == null) {
			return "freeboard";
		}
		session.setAttribute("boardList", freelist);
		
		return "freeboard";
	}
}