package com.bytes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bytes.service.WorkService;
import com.bytes.utils.Work;

@RestController
public class WorkController {

	@Autowired
	WorkService workService;

	@RequestMapping(value = "work", method = RequestMethod.POST)
	public String addWork(@RequestBody Work work) {
		workService.addWork(work);
		return "added";
	}
}
	