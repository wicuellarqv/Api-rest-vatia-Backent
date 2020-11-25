package com.vatia.apirest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vatia.apirest.service.IpcIppService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/ipcipp")
public class IpcIppController {
	
	@Autowired
	private IpcIppService ipcIppService;

	@PostMapping("/updateIpcIpp")
	public void updateIpcIpp(@RequestBody Map<String, Object> request) {
		this.ipcIppService.updateIpcIpp(request);
	}
}
